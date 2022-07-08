
import javax.swing.*;

public class Scenes extends JLabel {
    Heisenberg heisnberg;
    Gus gus;
    Inventory inventory;
    CoinLabel coinLabel;
    JLabel reachHitbox;
    Scenes scene2;
    Scenes mainScene;
    Scenes currentScene;
    int width = 1000;
    int height = 700;

    Scenes(){
        heisnberg = new Heisenberg();
        inventory = new Inventory();
        gus = new Gus();
        coinLabel = new CoinLabel(0, null);
        reachHitbox = Character.getReachHitbox();
        scene2 = Window.getScene2();
        mainScene = Window.getMainScene();
        currentScene = Window.getCurrentScene();
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