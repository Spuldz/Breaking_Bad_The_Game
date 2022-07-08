import javax.swing.*;

public class Scene3 extends Scenes{
    ImageIcon motel;
    Scene3(){
        this.setLayout(null);
        motel = new ImageIcon("Assets\\motel.png");
        this.setIcon(motel);
        this.setBounds(0, 0, 1000, 700);
        heisnberg.create(this, 100);

        this.setVisible(false);
    }
}
