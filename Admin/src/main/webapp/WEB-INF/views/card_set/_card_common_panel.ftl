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