

import javax.swing.*;

public class Structure extends JLabel {

    Structure(){

    }

    void create(MainScene d, int x, int width, int height){
        this.setBounds(x, d.getHeight()- 227, width, height);
    }

    void setState(String path){
        ImageIcon imageIcon = new ImageIcon(path);
        this.setIcon(imageIcon);
    }

}
