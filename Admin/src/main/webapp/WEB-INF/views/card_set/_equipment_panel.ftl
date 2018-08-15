<table>

    <tr>
        <td class="third">
            <label for="equipmentSlot">Slot:</label>
            <br/>
            <select name="equipmentSlot" id="equipmentSlot">
                <#if equipmentSlots??>
                    <#list equipmentSlots as slot>
                        <option value="${slot}" <#if equipment_slot??  &&  "${equipment_slot}"?contains(slot)>selected="selected"</#if>>${slot.displayName}</option>
                    </#list>
                </#if>
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
            <input type="checkbox" name="is_burdensome" id="is_burdensome" <#if is_burdensome?? && is_burdensome>checked</#if>/>
            <label for="is_burdensome">Burdensome</label>
            <br/>
            <br/>
            <input type="checkbox" name="is_battle_ready" id="is_battle_ready" <#if is_battle_ready?? && is_battle_ready>checked</#if>/>
            <label for="is_battle_ready">Battle-ready</label>
            <br/>
            <br/>
            <input type="checkbox" name="is_artifact" id="is_artifact" <#if is_artifact?? && is_artifact>checked</#if>/>
            <label for="is_artifact">Artifact</label>
        </td>
        <td class="third">

        </td>
        <td class="third">

        </td>
    </tr>

    <tr style="margin-top:55px">
        <td class="third">
            <label for="abilities">Abilities:</label>
            <br/>
            <select id="abilities">
                <#if abilities??>
                    <#list abilities as ability>
                        <option value="${ability}">${ability.name}</option>
                    </#list>
                </#if>
            </select>
        </td>

        <td class="third">

        </td>

        <td class="third">

        </td>
    </tr>

</table>