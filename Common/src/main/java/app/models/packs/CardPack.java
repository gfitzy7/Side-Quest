package app.models.packs;

import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.Model;

import java.util.*;

/**
 * @author shanef on 7/27/18.
 */
public class CardPack extends Model {

    public static void main(String[] args){
        Base.open();
        try{
            ((CardPack) CardPack.findById(2)).getRarityOdds();
        }
        finally {
            Base.close();
        }
    }

    public HashMap<Rarity, String> getRarityOdds(){
        List<PackConfig> configs = PackConfig.findAllFromCardPack(this.getLongId());
        configs.sort((config1, config2) ->
                config2.getRarity().getPriority() - config1.getRarity().getPriority()
        );

        TreeNode rootNode = new TreeNode(null, 1.00, 0, 0);
        ArrayList<ArrayList<PackConfig>> groups = findGroupings(configs);
        generatePath(rootNode, groups);

        List<Rarity> rarities = Rarity.findAll();
        HashMap<Rarity, String> odds = new HashMap<>();
        for(Rarity rarity : rarities){
            odds.put(rarity, rootNode.findNumCardsByRarity(rarity));
        }

        return odds;
    }

    private void generatePath(TreeNode root, List<ArrayList<PackConfig>> groups){
        if(groups.isEmpty()){
            return;
        }

        int totalFreq = 0;
        for(PackConfig config : groups.get(0)){
            totalFreq += config.getFrequency();
        }

        for(PackConfig config : groups.get(0)){
            double pct = root.getPct() * (((double) config.getFrequency()) / totalFreq);
            int num = Math.max(config.getNumber() - root.getTotal(), 0);
            TreeNode child = root.findChildWithNum(num);

            if(child != null){
                child.addPct(pct);
            }
            else{
                root.addChild(config.getRarity(), pct, num, root.getTotal() + num);
            }
        }

        for(TreeNode child : root.getChildren()){
            generatePath(child, groups.subList(1, groups.size()));
        }
    }

    public ArrayList<ArrayList<PackConfig>> findGroupings(List<PackConfig> configs){
        ArrayList<ArrayList<PackConfig>> groups = new ArrayList<>();

        while(!configs.isEmpty()){
            ArrayList<PackConfig> group = new ArrayList<>();

            for(PackConfig config : configs){
                if(config.getRarity().getPriority() == configs.get(0).getRarity().getPriority()){
                    group.add(config);
                }
            }

            groups.add(group);

            configs.removeAll(group);
        }

        return groups;
    }

    class TreeNode{
        private Rarity rarity;
        private double pct;
        private int num;
        private int total;

        private TreeNode parent;
        private List<TreeNode> children = new ArrayList<>();

        public TreeNode(Rarity rarity, double pct, int num, int total){
            this.rarity = rarity;
            this.pct = pct;
            this.num = num;
            this.total = total;
        }

        public TreeNode addChild(Rarity rarity, double pct, int num, int total){
            TreeNode child = new TreeNode(rarity, pct, num, total);
            child.setParent(this);
            children.add(child);

            return child;
        }

        public Rarity getRarity(){
            return rarity;
        }

        public double getPct(){
            return pct;
        }

        public void addPct(double pct){
            this.pct += pct;
        }

        public int getTotal(){
            return total;
        }

        public int getNum(){
            return num;
        }

        public List<TreeNode> getChildren(){
            return children;
        }

        public void setParent(TreeNode parent){
            this.parent = parent;
        }

        public TreeNode findChildWithNum(int num){
            for(TreeNode child : children){
                if(child.getNum() == num) return child;
            }

            return null;
        }

        public String findNumCardsByRarity(Rarity rarity){
            ArrayList<TreeNode> nodes = new ArrayList<>();
            nodes.addAll(children);

            double numCards = 0;
            while(!nodes.isEmpty()){
                TreeNode node = nodes.remove(0);
                nodes.addAll(node.children);

                if(node.getRarity().getPriority() == rarity.getPriority()){
                    numCards += (node.getNum() * node.getPct());
                }
            }

            return String.format("%.3f", numCards);
        }
    }
}
