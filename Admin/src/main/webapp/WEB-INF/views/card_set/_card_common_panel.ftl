<table>

    <tr>
        <table>
            <tr>
                <td class="half">
                    <label for="cardType">Card Type:</label>
                    <br/>
                    <select name="cardType" id="cardType" onchange="showSelectedOnly()" <#if isEdit??>disabled</#if>>
                        <option value="character" <#if card_type??  &&  "${card_type}"?contains("Character")> selected="selected"</#if>>Character</option>
                        <option value="equipment" <#if card_type??  &&  "${card_type}"?contains("Equipment")> selected="selected"</#if>>Equipment</option>
                        <option value="gambit" <#if card_type??  &&  "${card_type}"?contains("Gambit")> selected="selected"</#if>>Gambit</option>
                        <option value="item" <#if card_type??  &&  "${card_type}"?contains("Item")> selected="selected"</#if>>Item</option>
                    </select>
                </td>
                <td class="half">
                    <label for="cardName">Card Name:</label>
                    <input type="text" name="cardName" id="cardName" placeholder="Enter card name..." required <#if card_name??>value="${card_name}"</#if>/>
                </td>
            </tr>
        </table>
    </tr>

    <tr>
        <td class="full">
            <label for="cardDescription">Card Description:</label>
            <input type="textarea" name="cardDescription" id="cardDescription" placeholder="Enter card description..." <#if card_name??>value="${card_description}"</#if> />
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
                            <option value="${rarityName}" <#if card_rarity??  &&  "${rarityName}"?contains("${card_rarity}")> selected="selected"</#if>>${rarityName}</option>
                        </#list>
                    </select>
                </td>
                <td class="half">
                    <label for="rarityWeight">Rarity Weight:</label>
                    <br/>
                    <input type="number" name="rarityWeight" id="rarityWeight" <#if card_rarity_weight??>value="${card_rarity_weight}"<#else>value="100"</#if>/>
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
                    <input type="number" name="manaCost" id="manaCost" <#if card_mana_cost??>value="${card_mana_cost}"<#else>value="0"</#if>/>
                </td>
                <td class="half">
                    <label for="useDeckLimit">Limited Number Per Deck?</label>
                    <input type="checkbox" name="useDeckLimit" id="useDeckLimit" onchange="updateDeckLimitField()" <#if card_deck_limit?? && (card_deck_limit > 0)>checked</#if>/>
                    <br/>
                    <input type="number" name="deckLimit" id="deckLimit" min="0" <#if card_deck_limit?? && (card_deck_limit > 0)>value="${card_deck_limit}"<#else>value="4" disabled</#if> />
                </td>
            </tr>
        </table>
    </tr>

</table>