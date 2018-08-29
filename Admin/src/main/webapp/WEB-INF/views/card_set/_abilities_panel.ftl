<table>

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

        <td class="two-thirds">

        </td>
    </tr>

</table>