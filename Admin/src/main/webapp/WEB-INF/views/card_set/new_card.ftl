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

    <h2>Add a card to set ${set_name}</h2>

    <@form controller="card_set" action="create_new_card" method="post">

        <input type="hidden" name="set_id" value=${set_id} />

        <div id="main" class="form-box">

            <table>
                <tr>
                    <table>
                        <tr>
                            <td class="half">
                                <label for="cardType">Card Type:</label>
                                <select name="cardType" id="cardType" onchange="showSelectedOnly()">
                                    <option value="character">Character</option>
                                    <option value="equipment">Equipment</option>
                                    <option value="gambit">Gambit</option>
                                    <option value="item">Item</option>
                                </select>
                            </td>
                            <td class="half">
                                <label for="cardName">Card Name:</label>
                                <input type="text" name="cardName" id="cardName" placeholder="Enter card name..." required/>
                            </td>
                        </tr>
                    </table>
                </tr>
                <tr>
                    <td class="full">
                        <label for="cardDescription">Card Description:</label>
                        <input type="textarea" name="cardDescription" id="cardDescription" placeholder="Enter card description..."/>
                    </td>
                </tr>
                <tr>
                    <table>
                        <tr>
                            <td class="third">
                                <label for="manaCost">Mana Cost:</label>
                                <br/>
                                <input type="number" name="manaCost" id="manaCost" value="0"/>
                            </td>
                            <td class="third">
                                <label for="useDeckLimit">Limited Number Per Deck?</label>
                                <input type="checkbox" name="useDeckLimit" id="useDeckLimit" onchange="updateDeckLimitField()"/>
                                <br/>
                                <input type="number" name="deckLimit" id="deckLimit" value="4" disabled/>
                            </td>
                            <td class="third">

                            </td>
                        </tr>
                    </table>
                </tr>
            </table>



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
        <div id="item" class="form-box">
            <@render partial="item_panel"/>
        </div>

        <div class="row margin-top-30">
            <div>
                <@link_to action="overview/${set_id}">Cancel</@link_to>
            </div>
            <button type="submit">Create</button>
            <#--<div class="col-xs-4">-->
                <#--<@link_to class="btn btn-green-c btn-lg width230" action="create_new_card/${set_id}">Create</@link_to>-->
            <#--</div>-->
        </div>
    </@form>

</div>
