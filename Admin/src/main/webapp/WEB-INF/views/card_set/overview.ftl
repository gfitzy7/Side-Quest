<div>
    <div class="title">${set_name}
        <#if (numCards == 1)>
             (1 card)
        <#else>
             (${numCards!0} cards)
        </#if>
    </div>

    <div style="text-align:center;padding-bottom:20px">
        <a href="/card_set/overview?id=${set_id}" style="text-decoration:none;padding-right:10px">
            <button>Delete Set</button>
        </a>
        <a href="/card_set/new_card?id=${set_id}" style="text-decoration:none;padding-right:10px">
            <button>New Card</button>
        </a>
        <a href="/card_set/refresh_order?id=${set_id}" style="text-decoration:none;padding-right:10px">
            <button>Refresh Order</button>
        </a>
    </div>

    <table style="width:100%">
        <tr style="background-color:lightblue">
            <th width="12%">Name</th>
            <th width="9%">Card Type</th>
            <th width="9%">Rarity</th>
            <th width="5%">#</th>
            <th>Description</th>
            <th width="14%">Actions</th>
        </tr>
        <#list cards as card>
            <tr>
                <td>${card.name!""}</a></td>
                <td>${card.type!""}</td>
                <td>${card.rarity.name!""}</td>
                <td>${card.card_set_card_number!""}</td>
                <td>${card.description!""}</td>
                <td>
                    <@link_to class="button-red" action="delete_card/${card.cardId}" confirm="Are you sure you want to delete this card?">Delete</@>
                    <@link_to class="button-green" action="edit_card/${card.cardId}">Edit</@>
                </td>
            </tr>
        </#list>
    </table>
</div>
