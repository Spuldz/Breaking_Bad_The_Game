import javax.swing.*;

public class Scene2 extends Scenes{
    ImageIcon desert_dunes;
    Scene2(){
        this.setLayout(null);
        desert_dunes = new ImageIcon("Assets\\desert_dunes.png");
        this.setIcon(desert_dunes);
        this.setBounds(0, 0, 1000, 700);
        this.setVisible(false);
    }
}
