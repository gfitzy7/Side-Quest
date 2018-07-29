/**
 * Created by gleb on 1/21/15.
 */

/*
 Copyright 2009-2010 Igor Polevoy

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

/*
 This file is a collection of unobtrusive JS that binds to link_to generated anchors typical for Ajax calls.

 author: Igor Polevoy
 */

$(function() {
    $('a[data-link]').on('click', function() {
        return awLinkClick($(this));
    });
});

function awLinkClick(anchor) {
    //cancelling submit
    var cancelled = false;
    var oldCancelSubmitFunction = $.fn.cancelSubmit;
    $.fn.cancelSubmit = function() {
        cancelled = true;
    };

    try {
        anchor.trigger("aw-before-submit");
    } finally {
        $.fn.cancelSubmit = oldCancelSubmitFunction;
    }

    if(cancelled) {
        return false;
    }

    var confirmMessage = anchor.attr("data-confirm");

    if(confirmMessage != null ){
        if(!confirm(confirmMessage)){
            return false;
        }
    }

    return awLinkSubmit(anchor);
}

function awLinkSubmit(anchor) {
    var destination = anchor.attr("data-destination");
    var formId = anchor.attr("data-form");
    var href = anchor.attr("href");
    var _method = anchor.attr("data-method");
    var before = anchor.attr("data-before");
    var after = anchor.attr("data-after");
    var beforeArg = anchor.attr("data-before-arg");
    var afterArg = anchor.attr("data-after-arg");
    var error = anchor.attr("data-error");

    //not Ajax
    if(destination == null && before == null && after == null && (_method == null || _method.toLowerCase() == "get")){
        return true;
    }

    if (_method == null) {
        _method = "get";
    }
    var type;
    if (_method.toLowerCase() == "get") {
        type = "get";
    } else if (_method.toLowerCase() == "post"
        || _method.toLowerCase() == "put"
        || _method.toLowerCase() == "delete") {
        type = "post";
    }

    if(before != null){
        eval(before)(beforeArg);
    }

    var data = "_method=" + _method;
    if (formId != null) {
        data += "&" + $("#" + formId).serialize();
    }

    var awSubmitSuccess = anchor.data("aw-submit-success");
    var awSubmitError = anchor.data("aw-submit-error");
    var awSubmitComplete = anchor.data("aw-submit-complete");

    $.ajax({url: href, data: data, type:type,
        success: function(data) {
            if (destination != null)
                $("#" + destination).html(data);
            if (after != null)
                eval(after)(afterArg, data);
            if (awSubmitSuccess) awSubmitSuccess();
        },
        error: function(xhr) {
            if (awSubmitError) awSubmitError();
            if(error != null){
                eval(error)(xhr.status, xhr.responseText );
            }
        },
        complete: function() {
            if (awSubmitComplete) awSubmitComplete();
        }
    });
    return false;
}