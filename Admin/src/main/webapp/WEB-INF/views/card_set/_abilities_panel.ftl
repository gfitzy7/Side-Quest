<@content for="js">
    <script type="text/javascript">

        var cardAbilities = [];

        $(function () {
            showDescription();

            <#if card_traits??>
                <#list card_traits as card_trait>
                    var abilityName = "${card_trait.abilityName}";
                    var level = "${card_trait.level}";
                    var maxLevel = "${card_trait.maxLevel}";
                    var paramName = 'ability_' + "${card_trait.abilityId}";

                    loadAbilityIntoTable(abilityName, paramName, level, maxLevel);
                </#list>
            </#if>
        });

        function showDescription() {
            var selectedAbility = getSelectedAbility();
            <#if abilities??>
                <#list abilities as ability>
                    var abilityName = "${ability.name}";
                    if(abilityName === selectedAbility){
                        $('#abilityDescription').text("${ability.description!''}");
                    }
                </#list>
            </#if>
        }

        function addNewAbility() {
            var max = 100;
            var paramName = 'ability_';
            <#if abilities??>
                <#list abilities as ability>
                        var abilityName = "${ability.name}";
                        if(abilityName === getSelectedAbility()){
                            max = "${ability.max_level!100}";
                            paramName += "${ability.id}"
                        }
                </#list>
            </#if>

            loadAbilityIntoTable(getSelectedAbility(), paramName, 1, max);
        }

        function loadAbilityIntoTable(rawAbilityName, paramName, level, maxLevel) {
            var parsedAbilityName = rawAbilityName.replace(' ', '_');
            if(!cardAbilities[parsedAbilityName]){
                cardAbilities[parsedAbilityName] = 1;
                var table = document.getElementById("abilitiesTable");
                var row = table.insertRow(0);

                var numberId = parsedAbilityName + '-level';

                var cell0 = row.insertCell(0);
                cell0.innerHTML = (
                        '<div id=' + parsedAbilityName + '_row>' +
                        '<button class="btn-minus" type="button" onclick="removeAbility(\'' + parsedAbilityName + '\')">-</button>' +
                        '<label for=' + numberId + '>' + rawAbilityName + ':  </label>' +
                        '<input style="width:15%" type="number" name=' + paramName + ' id=' + numberId + ' value=' + level + ' max=' + maxLevel + ' min="1"/>' +
                        '</div>'
                );
            }
        }

        function removeAbility(ability) {
            var row = document.getElementById(ability + '_row');
            if(row) {
                cardAbilities[ability] = 0;
                row.parentNode.removeChild(row);
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
            <button class="btn-plus" type="button" onclick="addNewAbility()">+</button>
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