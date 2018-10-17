package app.controllers;

import app.models.cards.CardSet;
import app.models.packs.CardPack;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;

import java.util.List;

/**
 * @author shanef on 7/30/18.
 */
public class CardPackController extends AbstractAppController {

    @GET
    public void index(){
        List<CardPack> packs = CardPack.findAll();

        view("packs", packs);
    }

    @GET
    public void newPack() {
        List<CardSet> publishedSets = CardSet.getPublishedCardSets();
        if(publishedSets.isEmpty()) {
            flash("error", "There are no published card sets to build a pack with!");
            redirectToReferrer();
        }
        else {
            view("publishedSets", publishedSets);
            render("new_pack");
        }
    }

    @POST
    public void save() {

    }

}
