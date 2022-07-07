import javax.swing.*;
import java.awt.*;

public class MainScene extends Scenes {

    ImageIcon Desert;
    Van van;
    final String HEISENBERG_STANDING_RIGHT = "Assets\\heisenberg_standing_right.png";
    final String VAN = "Assets\\van.png";
    final String VAN_COOKING = "Assets\\van_cooking.png";

    MainScene(){
        this.setLayout(null);
        Desert = new ImageIcon("Assets\\desert_image.png");


        this.setIcon(Desert);

        this.setBounds(0, 0, 1000, 700);
        this.setOpaque(true);
        this.setBackground(Color.RED);

        heisnberg.create(this, 0);
        heisnberg.characterAction(HEISENBERG_STANDING_RIGHT);
        heisnberg.addReachHitbox(this);

        van = new Van();
        van.create(this, 600, 287, 227);
        van.setState(VAN);


        inventory.create(this);

        coinLabel.create();



        this.add(heisnberg);
        this.add(van);
        this.add(inventory);
        this.add(gus);
        this.add(coinLabel);



    }


    public Van getVan(){
        return van;
    }



}