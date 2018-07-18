<div>
    <#if (numCardSets == 1)>
        <p>There is 1 card set.</p>
    <#else>
        <p>There are ${numCardSets!0} card sets.</p>
    </#if>

    <table style="width:100%">
        <tr style="background-color:lightblue">
            <th width="12%">Set Name</th>
            <th width="8%">Num Cards</th>
            <th>Description</th>
            <th width="10%">Release Date</th>
        </tr>
        <#list cardSets as set>
        <tr style="text-align:center;background-color:lightgrey">
            <td><a href="/card_set/overview?id=${set.id}">${set.set_name!""}</a></td>
            <td>${set.num_cards!""}</td>
            <td>${set.set_description!""}</td>
            <td>${set.set_release_date!""}</td>
        </tr>
        </#list>
    </table>
</div>
