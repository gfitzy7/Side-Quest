<div>
    <div class="title">${set_name}
        <#if (numCards == 1)>
             (1 card)
        <#else>
             (${numCards!0} cards)
        </#if>
    </div>

    <div style="text-align:center;padding-bottom:20px">
        <a <#if !card_set.release_date??>href="/card_set/overview?id=${set_id}"</#if> style="text-decoration:none;padding-right:10px">
            <button <#if card_set.release_date??>disabled</#if>>Delete Set</button>
        </a>
        <a <#if !card_set.release_date??>href="/card_set/new_card?id=${set_id}"</#if> style="text-decoration:none;padding-right:10px">
            <button <#if card_set.release_date??>disabled</#if>>New Card</button>
        </a>
        <a <#if !card_set.release_date??>href="/card_set/refresh_order?id=${set_id}"</#if> style="text-decoration:none;padding-right:10px">
            <button <#if card_set.release_date??>disabled</#if>>Refresh Order</button>
        </a>
    </div>

    <table style="width:100%">
        <tr style="background-color:lightblue">
            <th class="styled-blue" width="12%">Name</th>
            <th class="styled-blue" width="9%">Card Type</th>
            <th class="styled-blue" width="9%">Rarity</th>
            <th class="styled-blue" width="5%">#</th>
            <th class="styled-blue">Description</th>
            <th class="styled-blue" width="14%">Actions</th>
        </tr>
        <#list cards as card>
            <tr class="styled-blue center">
                <td>${card.name!""}</a></td>
                <td>${card.type!""}</td>
                <td>${card.rarity.name!""}</td>
                <td>${card.card_set_card_number!""}</td>
                <td>${card.description!""}</td>
                <td align="center">
                    <#if !card_set.release_date??>
                        <@link_to class="btn-decline" action="delete_card/${card.cardId}" confirm="Are you sure you want to delete this card?">Delete</@>
                    </#if>
                    <@link_to class="btn-confirm" action="edit_card/${card.cardId}">Edit</@>
                </td>
            </tr>
        </#list>
    </table>
</div>
