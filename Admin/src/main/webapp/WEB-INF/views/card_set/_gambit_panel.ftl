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
                    <input type="checkbox" name="useVariableManaCost" id="useVariableManaCost" onchange="updateUseVariableManaCostField()" <#if gambit_variable_mana_cost?? && (gambit_variable_mana_cost > 0)>checked</#if>/>
                    <br/>
                    <input type="number" name="variableManaCost" id="variableManaCost" min="1" <#if gambit_variable_mana_cost?? && (gambit_variable_mana_cost > 0)>value="${gambit_variable_mana_cost}"<#else>value="1" disabled</#if>/>
                </td>
                <td class="half">

                </td>
            </tr>
        </table>
    </tr>
</table>