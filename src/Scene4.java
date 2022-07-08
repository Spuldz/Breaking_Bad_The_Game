import javax.swing.*;

public class Scene4 extends Scenes{
    ImageIcon losPollosHermanos;
    Scene4(){
        this.setLayout(null);
        losPollosHermanos = new ImageIcon("Assets\\los_pollos_hermanos.png");
        this.setIcon(losPollosHermanos);
        this.setBounds(0, 0, 1000, 700);
        heisnberg.create(this, 100);

        this.setVisible(false);
    }
}
