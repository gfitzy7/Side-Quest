<table>

    <tr>
        <table>
            <tr>
                <td class="half">
                    <label for="cardType">Card Type:</label>
                    <br/>
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
                <td class="half">
                    <label for="rarity">Rarity:</label>
                    <br/>
                    <select name="rarity" id="rarity">
                        <#list rarity_names as rarityName>
                            <option value="${rarityName}">${rarityName}</option>
                        </#list>
                    </select>
                </td>
                <td class="half">
                    <label for="rarityWeight">Rarity Weight:</label>
                    <br/>
                    <input type="number" name="rarityWeight" id="rarityWeight" value="100"/>
                </td>
            </tr>
        </table>
    </tr>

    <tr>
        <table>
            <tr>
                <td class="half">
                    <label for="manaCost">Mana Cost:</label>
                    <br/>
                    <input type="number" name="manaCost" id="manaCost" value="0"/>
                </td>
                <td class="half">
                    <label for="useDeckLimit">Limited Number Per Deck?</label>
                    <input type="checkbox" name="useDeckLimit" id="useDeckLimit" onchange="updateDeckLimitField()"/>
                    <br/>
                    <input type="number" name="deckLimit" id="deckLimit" value="4" disabled/>
                </td>
            </tr>
        </table>
    </tr>

</table>