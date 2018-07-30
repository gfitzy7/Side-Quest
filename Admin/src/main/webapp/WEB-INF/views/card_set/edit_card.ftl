<@content for="style">
<style>

    html{
        background-color: lightgrey;
    }

    label{
        font-weight: bold;
    }

    h2{
        text-align: center;
    }

    table{
        width: 100%;
    }

    td.third{
        width: 33%;
    }

    td.half{
        width: 50%;
    }

    td.full{
        width: 100%;
    }

    input:not([type=checkbox]), select{
        width: 100%;
        padding: 8px 12px;
        margin: 8px 0 16px;
        display: inline-block;
        border: 1px solid #000;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type=number]{
        width:35%;
        padding: 8px 0px 8px 12px;
    }

    select{
        width:80%;
    }

    div.form-box{
        background-color: lightsteelblue;
        margin-left:15%;
        margin-right:15%;
        border: 1px solid;
        padding:15px;
        margin-bottom:15px
    }

</style>
</@content>

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

    <h2>Edit Card</h2>

    <@form controller="card_set" action="save_card" method="post">

        <input type="hidden" name="set_id" value=${set_id} />
        <input type="hidden" name="id" value=${card_id} />

        <div id="main" class="form-box">
            <@render partial="card_common_panel"/>
        </div>

        <div id="character"  class="form-box">
            <@render partial="character_panel"/>
        </div>
        <div id="equipment"  class="form-box">
            <@render partial="equipment_panel"/>
        </div>
        <div id="gambit" class="form-box">
            <@render partial="gambit_panel"/>
        </div>
        <div id="item" >
            <@render partial="item_panel"/>
        </div>

        <div class="row margin-top-30">
            <div>
                <@link_to action="overview/${set_id}">Cancel</@link_to>
            </div>

            <button type="submit">Save</button>
        </div>
    </@form>

</div>
