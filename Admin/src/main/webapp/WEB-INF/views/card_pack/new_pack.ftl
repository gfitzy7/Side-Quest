<#--Configs-->
<div>

    <h2>Create New Pack</h2>

    <@form controller="card_pack" action="save" method="post">

        <table class="cenetered-70">
            <tr>

                <td class="form-box-left">
                    <div id="left-panel">

                        <label for="cardSet">Card Set:</label>
                        <br/>
                        <select name="cardSet" id="cardSet" style="max-width:100px;width:50%;margin-bottom:24px">
                            <#list publishedSets as publishedSet>
                                <option value="${publishedSet}">${publishedSet.name}</option>
                            </#list>
                        </select>

                        <br/>

                        <label for="numCards">Number of Cards:</label>
                        <br/>
                        <input type="number" name="numCards" id="numCards" value="8" style="max-width:100px;width:50%;margin-bottom:24px"/>

                        <br/>

                        <label for="packName">Card Pack Name:</label>
                        <input type="text" name="packName" id="packName" style="margin-bottom:24px"/>

                        <br/>

                        <label for="packDescription">Description:</label>
                        <input type="text" name="packDescription" id="packDescription" style="margin-bottom:24px"/>

                        <br/>

                        <div style="text-align:right">
                            <button class="btn-decline btn-medium" type="button">Cancel</button>
                            <button class="btn-confirm btn-medium" type="button" onclick="setUpConfigs()">Continue</button>
                        </div>

                    </div>
                </td>

                <td class="form-box-right">
                    <div id="right-panel" hidden>

                    </div>
                </td>

            </tr>
        </table>

    </@form>

</div>
