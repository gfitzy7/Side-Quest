<#--Card Set-->
<#--Name-->
<#--Description-->
<#--Number of Cards-->

<#--Configs-->
<div>

    <h2>Create New Pack</h2>

    <@form controller="card_pack" action="save" method="post">

        <table class="cenetered-70">
            <tr>

                <td class="form-box-left">
                    <div>

                    </div>
                </td>

                <td class="form-box-right">
                    <div>

                    </div>
                </td>

            </tr>
        </table>

        <#--<input type="hidden" name="set_id" value=${set_id} />-->
        <#--<input type="hidden" name="id" value="${card_id!""}" />-->

        <#--<div id="main" class="form-box">-->
            <#--<@render partial="card_common_panel"/>-->
        <#--</div>-->

        <#--<div id="character" class="form-box">-->
            <#--<@render partial="character_panel"/>-->
        <#--</div>-->
        <#--<div id="equipment" class="form-box">-->
            <#--<@render partial="equipment_panel"/>-->
        <#--</div>-->
        <#--<div id="gambit" class="form-box">-->
            <#--<@render partial="gambit_panel"/>-->
        <#--</div>-->
        <#--<div id="item" class="form-box">-->
            <#--<@render partial="item_panel"/>-->
        <#--</div>-->
        <#--<div id="abilities" class="form-box">-->
            <#--<@render partial="abilities_panel"/>-->
        <#--</div>-->

        <#--<div class="center">-->
            <#--<@link_to class="btn-decline btn-medium" action="overview/${set_id}">Cancel</@link_to>-->
            <#--<button class="btn-confirm btn-medium" type="submit">${form_submit_btn_text}</button>-->
        <#--</div>-->
    </@form>

</div>
