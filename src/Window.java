
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener{
    //constructor
    Character heisnberg;
    Gus gus;
    Van van;
    JLabel reachHitbox;
    static MainScene mainScene;
    Inventory inventory;
    Coins coins;
    static Scenes scene2;
    static Scenes scene3;
    static Scenes scene4;
    static Scenes currentScene;

    final String HEISENBERG_STANDING_RIGHT = "Assets\\heisenberg_standing_right.png";
    final String HEISENBERG_STANDING_LEFT = "Assets\\heisenberg_standing_left.png";
    final String HEISENBERG_WALKING_RIGHT = "Assets\\heisenberg_walking_right.png";
    final String HEISENBERG_WALKING_LEFT = "Assets\\heisenberg_walking_left.png";
    final String VAN = "Assets\\van.png";
    final String VAN_COOKING = "Assets\\van_cooking.png";
    final String METH = "Assets\\meth.png";
    String t = "Main";


    public static Scenes getScene2(){
        return scene2;
    }

    public static Scenes getMainScene(){
        return mainScene;
    }

    public static Scenes getCurrentScene(){
        return currentScene;
    }

    Window(){

        mainScene = new MainScene();
        scene2 = new Scene2();
        scene3 = new Scene3();
        scene4 = new Scene4();
        reachHitbox = Character.getReachHitbox();
        heisnberg = mainScene.getHeisnberg();
        gus = scene4.getGus();
        van = mainScene.getVan();
        inventory = mainScene.getInventory();
        coins = mainScene.getCoinLabel();
        currentScene = mainScene;


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1012, 739);
        this.setLayout(null);
        this.setResizable(false);
        this.add(mainScene);
        this.addKeyListener(this);
        this.setTitle("Breaking Bad the Game");

        this.setVisible(true);

        //GAME LOOP
        while(true){
            scene2.checkForLeftBorderCollision(heisnberg);
            mainScene.checkForRightBorderCollision(heisnberg);

            checkForCurrentScene(heisnberg, this);

            heisnberg.checkVanForReachHitboxCollision(van);
            heisnberg.checkForReachHitboxDirection(mainScene);
            heisnberg.checkForGusReachHitboxCollision(gus);
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //
        MoveControls(e);
        //
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(heisnberg.getIcon().toString() == HEISENBERG_WALKING_RIGHT){
            heisnberg.characterAction(HEISENBERG_STANDING_RIGHT);
        }

        if(heisnberg.getIcon().toString() == HEISENBERG_WALKING_LEFT){
            heisnberg.characterAction(HEISENBERG_STANDING_LEFT);
        }
    }

    void MoveControls(KeyEvent e){
        int speed = 10;

        switch(e.getKeyCode()){
            case 65: heisnberg.setLocation(heisnberg.getX() -speed, heisnberg.getY());
                heisnberg.characterAction(HEISENBERG_WALKING_LEFT);
                reachHitbox.setLocation(reachHitbox.getX() - speed, reachHitbox.getY());
                break;
            case 68:
                heisnberg.setLocation(heisnberg.getX() + speed, heisnberg.getY());
                heisnberg.characterAction(HEISENBERG_WALKING_RIGHT);
                reachHitbox.setLocation(reachHitbox.getX() + speed, reachHitbox.getY() );
                break;
            case 69:

                if(van.cooking && heisnberg.touchingVan){
                    van.cooking = false;
                    van.setState(VAN);
                    inventory.addItem(METH);
                    return;
                }

                if (heisnberg.touchingVan) {
                    van.setState(VAN_COOKING);
                    van.cooking = true;
                }

                if(heisnberg.touchingGus){
                     coins.payout(inventory);
                }

                break;
            case 49:
                inventory.checkForSelectedSlot(0);
                break;
            case 50:
                inventory.checkForSelectedSlot(1);
                break;
            case 51:
                inventory.checkForSelectedSlot(2);
                break;
            case 52:
                inventory.checkForSelectedSlot(3);
                break;
        }

    }

    void changeScene(Scenes current_scene, Scenes new_scene, Window w, String direction){
        if(direction == "left"){
            heisnberg.removeReachHitbox(current_scene);
            w.remove(current_scene);
            w.add(new_scene);
            new_scene.add(heisnberg);
            new_scene.add(inventory);
            new_scene.add(coins);
            heisnberg.addReachHitbox(new_scene);
            heisnberg.create(new_scene, new_scene.getWidth() - heisnberg.getWidth());
            new_scene.setVisible(true);


        }

        if (direction == "right") {
            heisnberg.removeReachHitbox(current_scene);
            w.remove(current_scene);
            w.add(new_scene);
            new_scene.add(heisnberg);
            new_scene.add(inventory);
            new_scene.add(coins);
            heisnberg.addReachHitbox(new_scene);
            heisnberg.create(new_scene, 0);
            new_scene.setComponentZOrder(heisnberg, 0);
            heisnberg.reachHitboxBringToFront(new_scene);
            new_scene.setVisible(true);

        }


    }

    void checkForCurrentScene(Character c, Window w){
        System.out.println();
        int xLocation = c.getX();
        if(xLocation < 0 && currentScene == mainScene){
            changeScene(currentScene, scene2, w, "left");
            currentScene.setVisible(false);
            currentScene = scene2;
            return;
        }

        if(xLocation < 0 && currentScene == scene2){
            changeScene(currentScene, scene3, w, "left");
            currentScene.setVisible(false);
            currentScene = scene3;
            return;
        }

        if(xLocation < 0 && currentScene == scene3){
            changeScene(currentScene, scene4, w, "left");
            currentScene.setVisible(false);
            currentScene = scene4;
            return;
        }


        if(xLocation > scene4.getWidth() - (c.getWidth()) && currentScene == scene4){
            changeScene(currentScene, scene3, w, "right");
            currentScene.setVisible(false);
            currentScene = scene3;
            return;
        }

        if(xLocation > scene3.getWidth() - (c.getWidth()) && currentScene == scene3){
            changeScene(currentScene, scene2, w, "right");
            currentScene.setVisible(false);
            currentScene = scene2;
            return;
        }

        if(xLocation > scene2.getWidth() - (c.getWidth()) && currentScene == scene2){
            changeScene(currentScene, mainScene, w, "right");
            currentScene.setVisible(false);
            currentScene = mainScene;
            return;
        }


    }




}