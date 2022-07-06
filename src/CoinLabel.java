

import javax.swing.*;
import java.awt.*;

public class CoinLabel extends JLabel {
    Integer coins;
    ImageIcon coinImage;
    JLabel coinImageContainer;
    JLabel coinCountContainer;

    CoinLabel(int coins, ImageIcon coinImage){
        this.coins = coins;
        this.coinImage = coinImage;
    }

    void create(){
        this.setBounds(0,0, 150, 30);
        this.setBackground(Color.YELLOW);
        this.setOpaque(true);

        coinImageContainer = new JLabel();
        coinImageContainer.setBounds(0, 0, 30, 30);
        coinImageContainer.setBackground(Color.RED);
        coinImageContainer.setOpaque(true);

        coinCountContainer = new JLabel();
        coinCountContainer.setBounds(30,0, this.getWidth() - coinImageContainer.getWidth(), 30);
        coinCountContainer.setBackground(Color.GREEN);
        coinCountContainer.setOpaque(true);
        updateCoins();

        this.add(coinImageContainer);
        this.add(coinCountContainer);
    }

   public void addCoins(int amount){
        this.coins += 100;
        updateCoins();
    }

    private void updateCoins(){
        coinCountContainer.setText(this.coins + "");
    }

    void payout(Inventory inventory){
        for(int i = 0; i<inventory.methInInventory; i++){
            addCoins(100);
        }
        inventory.clear();
    }


}
