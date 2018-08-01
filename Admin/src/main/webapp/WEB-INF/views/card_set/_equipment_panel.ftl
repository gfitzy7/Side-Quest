<table>

    <tr>
        <td class="third">
            <label for="class">Slot:</label>
            <br/>
            <select name="class" id="class">
                <#--<#list classes as class>-->
                    <#--<option value="${class}" <#if character_class?? && character_class?contains(class)>selected</#if>>${class}</option>-->
                <#--</#list>-->
            </select>
        </td>
        <td class="third">
            <label for="power">Damage:</label>
            <br/>
            <input type="number" name="power" id="power" min="1" <#if character_power??>value="${character_power}"<#else>value="5"</#if>/>
        </td>
        <td class="third">
            <label for="power">Spell Damage:</label>
            <br/>
            <input type="number" name="power" id="power" min="1" <#if character_power??>value="${character_power}"<#else>value="5"</#if>/>
        </td>
    </tr>

    <tr>
        <td class="third">

        </td>
        <td class="third">
            <label for="class">Armor:</label>
            <br/>
            <input type="number" name="bonusArmor" id="bonusArmor" min="0"/>
        </td>
        <td class="third">
            <label for="power">Health:</label>
            <br/>
            <input type="number" name="bonusHealth" id="bonusHealth" min="0" <#if character_power??>value="${character_power}"<#else>value="5"</#if>/>
        </td>
    </tr>

    <tr>
        <td class="third">
            <label for="attack">Burdensome:</label>
            <br/>
            <input type="checkbox" name="isBurdensome" id="isBurdensome"/>
        </td>
        <td class="third">
            <label for="attack">Battle-ready:</label>
            <br/>
            <input type="checkbox" name="isBattleReady" id="isBattleReady"/>
        </td>
        <td class="third">
            <label for="attack">Artifact:</label>
            <br/>
            <input type="checkbox" name="isArtifact" id="isArtifact"/>
        </td>
    </tr>

</table>