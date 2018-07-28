<@content for="js">
    <script type="text/javascript">

        function updateUseVariableManaCostField(){
            $('#variableManaCost')[0].disabled = !$('#useVariableManaCost')[0].checked;
        }

    </script>
</@content>

<table>
    <tr>
        <table>
            <tr>
                <td class="half">
                    <label for="useVariableManaCost">Use Variable Mana Cost?</label>
                    <input type="checkbox" name="useVariableManaCost" id="useVariableManaCost" onchange="updateUseVariableManaCostField()"/>
                    <br/>
                    <input type="number" name="variableManaCost" id="variableManaCost" value="1" min="1" disabled/>
                </td>
                <td class="half">

                </td>
            </tr>
        </table>
    </tr>
</table>