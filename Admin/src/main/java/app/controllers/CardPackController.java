package app.controllers;

import app.models.packs.CardPack;
import org.javalite.activeweb.annotations.GET;

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
        render("new_pack");
    }

}
