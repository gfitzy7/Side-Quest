<@content for="js">

</@content>

<table>

    <tr>
        <td class="half">
            <label for="class">Class:</label>
            <br/>
            <select name="class" id="class">
                <#list classes as class>
                    <option value="${class}" <#if character_class?? && character_class?contains(class)>selected</#if>>${class}</option>
                </#list>
            </select>
        </td>
        <td class="half">

        </td>
    </tr>

    <tr>
        <table>
            <tr>
                <td class="half">
                    <label for="power">Card Power:</label>
                    <br/>
                    <input type="number" name="power" id="power" min="1" <#if character_power??>value="${character_power}"<#else>value="5"</#if>/>
                </td>
                <td class="half">
                    <label for="health">HP:</label>
                    <br/>
                    <input type="number" name="health" id="health" min="1" <#if character_health??>value="${character_health}"<#else>value="15"</#if>/>
                </td>
            </tr>
        </table>
    </tr>

    <tr>
        <table>
            <tr>
                <td class="half">
                    <label for="attack">Attack:</label>
                    <br/>
                    <input type="number" name="attack" id="attack" min="0" <#if character_attack??>value="${character_attack}"<#else>value="5"</#if>/>
                </td>
                <td class="half">
                    <label for="defense">Defense:</label>
                    <br/>
                    <input type="number" name="defense" id="defense" min="0" <#if character_defense??>value="${character_defense}"<#else>value="1"</#if>/>
                </td>
            </tr>
        </table>
    </tr>

</table>