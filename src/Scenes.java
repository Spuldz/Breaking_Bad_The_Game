import javax.swing.*;

public class Scenes extends JLabel {
    Heisenberg heisnberg;
    Gus gus;
    Inventory inventory;
    Coins coinLabel;
    JLabel reachHitbox;
    Scenes scene2;
    Scenes mainScene;
    Scenes currentScene;
    int width = 1000;
    int height = 700;
    Van van;

    Scenes(){
        heisnberg = new Heisenberg();
        gus = new Gus();
        inventory = new Inventory();
        coinLabel = new Coins(0, null);
        reachHitbox = Character.getReachHitbox();
        scene2 = Window.getScene2();
        van = new Van();
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

    public Coins getCoinLabel(){
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

    void changeScene(){

    }


    public Van getVan() {
        return van;
    }
}