<@content for="style">
<style>

    html{
        background-color: lightgrey;
    }

    table{
        background-color: grey;
    }

    th{
        background-color: cornflowerblue;
    }

    tr{
        background-color: lightsteelblue;
        text-align:center;
    }

    .title{
        font-size: 28px;
        text-align: center;
        margin-bottom: 16px;
    }

    .button-red, .button-green {
        font: bold 11px Arial;
        text-decoration: none;
        background-color: #EE000038;
        color: #333333;
        padding: 2px 6px 2px 6px;
        margin: 4px;
        border: 1px solid #CCCCCC;
        border-right-color: #333333;
        border-bottom-color: #333333;
    }

    .button-green {
        background-color: #00EE0038;
    }

</style>
</@content>

<div onload="before">
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
        <a href="/card_set/new_card?id=${set_id}">
            <button>New Card</button>
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
                    <@link_to class="button-red" action="delete_card/${card.id}" confirm="Are you sure you want to delete this card?">Delete</@>
                    <@link_to class="button-green" action="edit_card/${card.id}">Edit</@>
                </td>
            </tr>
        </#list>
    </table>
</div>
