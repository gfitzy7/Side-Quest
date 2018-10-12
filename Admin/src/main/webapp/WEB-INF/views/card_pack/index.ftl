<div>

    <div style="text-align:center;padding-bottom:20px">
        <@link_to class="btn-confirm" action="new_pack">Create Pack</@>
    </div>

    <#--<table style="width:100%">-->
        <#--<tr style="background-color:lightblue">-->
            <#--<th width="12%">Set Name</th>-->
            <#--<th width="8%">Num Cards</th>-->
            <#--<th>Description</th>-->
            <#--<th width="10%">Release Date</th>-->
        <#--</tr>-->
        <#--<#list cardSets as set>-->
        <#--<tr style="text-align:center;background-color:lightgrey">-->
            <#--<td><a href="/card_set/overview?id=${set.id}">${set.set_name!""}</a></td>-->
            <#--<td>${set.num_cards!""}</td>-->
            <#--<td>${set.set_description!""}</td>-->
            <#--<td>${set.release_date!""}</td>-->
        <#--</tr>-->
        <#--</#list>-->
    <#--</table>-->

    <#if (flasher.error) ??>
        <script type="text/javascript">
            $(function() {
                window.toastr.options.positionClass = 'toast-bottom-right';
                window.toastr.info('${flasher.error}');
            });
        </script>
    </#if>

</div>
