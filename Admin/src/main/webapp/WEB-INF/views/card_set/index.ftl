<div>

    <div class="title">Card Sets
        <#if (numCardSets == 1)>(1 set)
        <#else>(${numCardSets!0} sets)
        </#if>
    </div>

    <div class="center" style="padding-bottom:20px">
        <@link_to class="btn-confirm" action="new_set">Create Set</@>
    </div>

    <table>
        <tr class="styled-blue" >
            <th class="styled-blue" width="12%">Set Name</th>
            <th class="styled-blue" width="8%">Num Cards</th>
            <th class="styled-blue">Description</th>
            <th class="styled-blue" width="10%">Release Date</th>
            <th class="styled-blue" width="10%">Actions</th>
        </tr>
        <#list cardSets as set>
        <tr class="styled-blue center" >
            <td><a href="/card_set/overview?id=${set.id}">${set.set_name!""}</a></td>
            <td>${set.num_cards!""}</td>
            <td>${set.set_description!""}</td>
            <td>${set.release_date!""}</td>
            <td>
                <#if !set.release_date??><@link_to class="btn-confirm" action="publish/${set.id}">Publish</@></#if>
            </td>
        </tr>
        </#list>
    </table>

</div>
