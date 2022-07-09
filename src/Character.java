import javax.swing.*;
import java.awt.*;

public class Character extends JLabel {
    static JLabel reachHitbox;
    final String HEISENBERG_WALKING_LEFT = "Assets\\heisenberg_walking_left.png";
    final String HEISENBERG_STANDING_LEFT = "Assets\\heisenberg_standing_left.png";
    public boolean touchingVan = false;
    public boolean touchingGus = false;
    private boolean t;

    Character(){

    }

    void create(Scenes d, int x){
        this.setBounds(x, d.getHeight()- 140, 70, 140);

    }





    void characterAction(String path){
        ImageIcon imageIcon = new ImageIcon(path);
        this.setIcon(imageIcon);
    }




    public void checkVanForReachHitboxCollision(Structure s){

        if(reachHitbox.getBounds().intersects(s.getBounds())){
            touchingVan = true;
        }else{
            touchingVan = false;
        }


    }

    public void checkForGusReachHitboxCollision(Character c){
        if(reachHitbox.getBounds().intersects(c.getBounds())){
            touchingGus = true;
        }else{
            touchingGus = false;
        }
    }

       void addReachHitbox(Scenes d){
        reachHitbox = new JLabel();
        reachHitbox.setBackground(Color.BLUE);
        reachHitbox.setOpaque(true);
        reachHitbox.setBounds(this.getWidth() / 2 + 10, (d.getHeight() - this.getHeight()) + 30, 20, 2);

        d.add(reachHitbox);


    }

    void removeReachHitbox(Scenes s){
        s.remove(reachHitbox);
    }

    void reachHitboxBringToFront(Scenes s){
        s.setComponentZOrder(reachHitbox, 0);
    }

    public static JLabel getReachHitbox(){
        return reachHitbox;
    }

    void checkForReachHitboxDirection(Scenes d){
        int x = this.getX();
        int y = this.getY();

        if(this.getIcon().toString()==HEISENBERG_WALKING_LEFT){
            reachHitbox.setLocation(x - (-4), y + 30);
        }else if(this.getIcon().toString()==HEISENBERG_STANDING_LEFT){
            reachHitbox.setLocation(x - (-4), y + 30);
        }else{
            reachHitbox.setLocation(x + 46, y + 30);
        }
    }





}