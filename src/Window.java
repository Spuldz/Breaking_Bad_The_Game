

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener{
    //constructor
    Character heisnberg;
    Gus gus;
    Van van;
    JLabel reachHitbox;
    MainScene mainScene;
    Inventory inventory;
    CoinLabel coinLabel;

    final String HEISENBERG_STANDING_RIGHT = "Assets\\heisenberg_standing_right.png";
    final String HEISENBERG_STANDING_LEFT = "Assets\\heisenberg_standing_left.png";
    final String HEISENBERG_WALKING_RIGHT = "Assets\\heisenberg_walking_right.png";
    final String HEISENBERG_WALKING_LEFT = "Assets\\heisenberg_walking_left.png";
    final String VAN = "Assets\\van.png";
    final String VAN_COOKING = "Assets\\van_cooking.png";
    final String METH = "Assets\\meth.png";


    Window(){

        mainScene = new MainScene();
        reachHitbox = Character.getReachHitbox();
        heisnberg = mainScene.getHeisnberg();
        gus = mainScene.getGus();
        van = mainScene.getVan();
        inventory = mainScene.getInventory();
        coinLabel = mainScene.getCoinLabel();


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
            heisnberg.checkForBorderCollision(mainScene);
            heisnberg.checkVanForReachHitboxCollision(van);
            heisnberg.checkForGusReachHitboxCollision(gus);
            heisnberg.checkForReachHitboxDirection(mainScene);

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
                    for(int i = 0; i<inventory.methInInventory; i++){
                        coinLabel.addCoins(100);
                    }
                    inventory.clear();
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

}
