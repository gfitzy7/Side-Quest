<div>
    <#if (numCards == 1)>
        <p>There is 1 card in this set.</p>
    <#else>
        <p>There are ${numCards!0} cards in this set.</p>
    </#if>

    <div style="text-align:center;padding-bottom:20px">
        <a href="/card_set/overview?id=${set_id}" style="text-decoration:none;padding-right:10px">
            <button>Delete Set</button>
        </a>
        <a href="/card_set/new_card?id=${set_id}">
            <button>New Card</button>
        </a>
    </div>

    <table style="width:100%">
        <tr style="background-color:lightblue">
            <th width="12%">Name</th>
            <th width="12%">Set</th>
            <th width="6%">#</th>
            <th>Description</th>
        </tr>
        <#list cards as card>
            <tr style="text-align:center;background-color:lightgrey">
                <td><a href="/card_set/view_card?id=${card.id}">${card.name!""}</a></td>
                <td>${set_name!""}</td>
                <td>${card.card_set_card_number!""}</td>
                <td>${card.description!""}</td>
            </tr>
        </#list>
    </table>
</div>
