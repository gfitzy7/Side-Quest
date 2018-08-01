<table>

    <tr>
        <td class="third">
            <label for="equipmentSlot">Slot:</label>
            <br/>
            <select name="equipmentSlot" id="equipmentSlot">
                <#list equipmentSlots as slot>
                    <option value="${slot}" <#if equipment_slot??  &&  "${equipment_slot}"?contains(slot)>selected="selected"</#if>>${slot.displayName}</option>
                </#list>
            </select>
        </td>
        <td class="third">
            <label for="bonus_damage">Damage:</label>
            <br/>
            <input type="number" name="bonus_damage" id="bonus_damage" min="0" <#if bonus_damage??>value="${bonus_damage}"<#else>value="0"</#if>/>
        </td>
        <td class="third">
            <label for="bonus_spell_damage">Spell Damage:</label>
            <br/>
            <input type="number" name="bonus_spell_damage" id="bonus_spell_damage" min="0" <#if bonus_spell_damage??>value="${bonus_spell_damage}"<#else>value="0"</#if>/>
        </td>
    </tr>

    <tr>
        <td class="third">

        </td>
        <td class="third">
            <label for="bonus_armor">Armor:</label>
            <br/>
            <input type="number" name="bonus_armor" id="bonus_armor" min="0" <#if bonus_armor??>value="${bonus_armor}"<#else>value="0"</#if>/>
        </td>
        <td class="third">
            <label for="bonus_health">Health:</label>
            <br/>
            <input type="number" name="bonus_health" id="bonus_health" min="0" <#if bonus_health??>value="${bonus_health}"<#else>value="0"</#if>/>
        </td>
    </tr>

    <tr>
        <td class="third">
            <input type="checkbox" name="isBurdensome" id="isBurdensome" <#if isBurdensome?? && isBurdensome>checked</#if>/>
            <label for="isBurdensome">Burdensome</label>
            <br/>
            <br/>
            <input type="checkbox" name="isBattleReady" id="isBattleReady" <#if isBattleReady?? && isBattleReady>checked</#if>/>
            <label for="isBattleReady">Battle-ready</label>
            <br/>
            <br/>
            <input type="checkbox" name="isArtifact" id="isArtifact" <#if isArtifact?? && isArtifact>checked</#if>/>
            <label for="isArtifact">Artifact</label>
        </td>
        <td class="third">

        </td>
        <td class="third">

        </td>
    </tr>

</table>