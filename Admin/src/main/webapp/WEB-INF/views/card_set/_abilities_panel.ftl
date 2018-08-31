<@content for="js">
    <script type="text/javascript">

        var cardAbilities = [];

        $(function () {
            showDescription();
        });

        function showDescription() {
            var selectedAbility = getSelectedAbility();
            <#list abilities as ability>
                var abilityName = "${ability.name}";
                if(abilityName === selectedAbility){
                    $('#abilityDescription').text("${ability.description!''}");
                }
            </#list>
        }

        function addAbility() {
            var ability = getSelectedAbility();
            if(!cardAbilities[ability]){
                cardAbilities[ability] = 1;
                var table = document.getElementById("abilitiesTable");
                var row = table.insertRow(0);

                var numberId = ability.replace(' ', '_') + '-level';

                var cell0 = row.insertCell(0);
                cell0.innerHTML = ('<button class="btn-minus" type="button" onclick="removeAbility(getSelectedAbility())">-</button>' +
                        '<label for=' + numberId + '>' + ability + ':  </label>' +
                        '<input style="width:15%" type="number" id=' + numberId + ' value="1"/>');

                // var cell1 = row.insertCell(1);
                // cell1.innerHTML = '<button class="btn-minus" type="button" onclick="removeAbility(getSelectedAbility())">-</button>';
            }
        }

        function getSelectedAbility() {
            return $('#abilities').find(":selected").text();
        }

    </script>
</@content>

<table>

    <tr style="margin-top:55px">
        <td class="third">
            <label for="abilities">Abilities:</label>
            <br/>
            <select onchange="showDescription()" id="abilities">
                <#if abilities??>
                    <#list abilities as ability>
                        <option description="${ability.description!''}" value="${ability}">${ability.name}</option>
                    </#list>
                </#if>
            </select>
            <button class="btn-plus" type="button" onclick="addAbility()">+</button>
        </td>

        <td class="two-thirds">
            <p id="abilityDescription"></p>
        </td>
    </tr>

    <tr>
        <table id="abilitiesTable">

        </table>
    </tr>

</table>