<@content for="js">
    <script type="text/javascript">

        $(function () {
            showSelectedOnly();
        });

        function showSelectedOnly(){
            var selectBox = $('#cardType')[0];
            var selected = selectBox.options[selectBox.selectedIndex].text.toLowerCase();

            $('#character').hide();
            $('#equipment').hide();
            $('#gambit').hide();
            $('#item').hide();

            $('#' + selected).show();
        };

        function updateDeckLimitField(){
            $('#deckLimit')[0].disabled = !$('#useDeckLimit')[0].checked;
        }

    </script>
</@content>

<div style="margin-top:20px">

    <h2>${header}</h2>

    <@form controller="card_set" action="${form_action}" method="post">

        <input type="hidden" name="set_id" value=${set_id} />
        <input type="hidden" name="id" value="${card_id!""}" />

        <div id="main" class="form-box">
            <@render partial="card_common_panel"/>
        </div>

        <div id="character" class="form-box">
            <@render partial="character_panel"/>
        </div>
        <div id="equipment" class="form-box">
            <@render partial="equipment_panel"/>
        </div>
        <div id="gambit" class="form-box">
            <@render partial="gambit_panel"/>
        </div>
        <div id="item">
            <@render partial="item_panel"/>
        </div>

        <div class="center">
            <@link_to class="btn-decline btn-medium" action="overview/${set_id}">Cancel</@link_to>
            <button class="btn-confirm btn-medium" type="submit">${form_submit_btn_text}</button>
        </div>
    </@form>

</div>
