<div style="text-align:center;margin-top:20px">

    <h3>Create a new card set!</h3>

    <@form controller="cardSet" action="create_new_set" method="post" html_id="new_set_form">
        <label for="name">Set Name:</label>
        <input type="text" name="name">

        <br/>

        <label for="description">Set Description:</label>
        <textarea rows="3" cols="40" style="resize:none;" name="description" placeholder="Set description..."></textarea>

        <br/>

        <button type="submit" value="Submit" name="submit">Submit</button>
        <button type="submit" value="Reset" name="cancel">Cancel</button>
    </@>

    <#--<form action="/card_set/create_new_set" method="post">-->
        <#--<label for="set_name">Set Name:</label>-->
        <#--<input type="text" id="set_name" placeholder="Enter the name of the set..."/>-->

        <#--<br>-->

        <#--<div style="vertical-align:middle">-->
            <#--<label for="set_description">Set Description:</label>-->
            <#--<textarea rows="3" cols="40" style="resize:none;" id="set_description" placeholder="Set description..."></textarea>-->
        <#--</div>-->

        <#--<button type="submit" value="Submit">Submit</button>-->
        <#--<button type="submit" value="Reset">Cancel</button>-->
    <#--</form>-->

</div>
