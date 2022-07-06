

import javax.swing.*;

public class Scenes extends JLabel {
    Heisenberg heisnberg;
    Gus gus;
    Inventory inventory;
    CoinLabel coinLabel;

    Scenes(){
        heisnberg = new Heisenberg();
        inventory = new Inventory();
        gus = new Gus();
        coinLabel = new CoinLabel(0, null);
    }

    public Inventory getInventory(){
        return inventory;
    }
    public Heisenberg getHeisnberg(){
        return heisnberg;
    }

    public Gus getGus(){
        return gus;
    }

    public CoinLabel getCoinLabel(){
        return coinLabel;
    }

    void checkForRightBorderCollision(Character c){

        int xLocation = c.getX();

        //checks for collision for the X axis
        if(xLocation > this.getWidth() - (c.getWidth())){
            c.setLocation(this.getWidth() - (c.getWidth()), c.getY());
        }

    }

    void checkForLeftBorderCollision(Character c){
        int xLocation = c.getX();

        if(xLocation < 0){
            c.setLocation(0, c.getY());
        }
    }

}
