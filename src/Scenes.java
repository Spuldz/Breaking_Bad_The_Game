

import javax.swing.*;
import java.awt.*;

public class Scenes extends JLabel {
    Heisenberg heisnberg;
    Gus gus;
    Inventory inventory;
    CoinLabel coinLabel;

    Scenes(){
        heisnberg = new Heisenberg();
        inventory = new Inventory();
        gus = new Gus();
        coinLabel = new CoinLabel(0, null);
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

    public CoinLabel getCoinLabel(){
        return coinLabel;
    }

}
