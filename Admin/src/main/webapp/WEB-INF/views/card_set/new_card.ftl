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

    <h2>Add a card to set ${set_name}</h2>

    <@form controller="card_set" action="create_new_card" method="post">

        <input type="hidden" name="set_id" value=${set_id} />

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

        <div class="row margin-top-30">
            <div>
                <@link_to action="overview/${set_id}">Cancel</@link_to>
            </div>

            <button type="submit">Create</button>
        </div>
    </@form>

</div>
