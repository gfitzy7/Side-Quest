<@content for="js">

</@content>

<table>

    <tr>
        <td class="half">
            <label for="class">Class:</label>
            <br/>
            <select name="class" id="class">
                <#list classes as class>
                    <option value="${class}">${class}</option>
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
                    <input type="number" name="power" id="power" value="5" min="1"/>
                </td>
                <td class="half">
                    <label for="health">HP:</label>
                    <br/>
                    <input type="number" name="health" id="health" value="15" min="1"/>
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
                    <input type="number" name="attack" id="attack" value="5" min="0"/>
                </td>
                <td class="half">
                    <label for="defense">Defense:</label>
                    <br/>
                    <input type="number" name="defense" id="defense" value="1" min="0"/>
                </td>
            </tr>
        </table>
    </tr>

</table>