

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Inventory extends JLabel {
    ArrayList<Slot> slots = new ArrayList<Slot>();

    final String METH = "Assets\\meth.png";
    String selectedItem = "";
    Slot selectedSlot;
    int slotsFree;
    int methInInventory;

    void create(Scenes display){
        this.setBounds((display.getWidth() / 2) - (70), this.getHeight(), 200, 50 );
        GridLayout layout = new GridLayout(1, 4);
        layout.setVgap(1);
        layout.setHgap(1);
        this.setLayout(layout);


        for(int i = 0; i<4; i++){
            Slot slot = new Slot();
            slots.add(slot);
            this.add(slot);
            revalidate();
        }

    }

    void addItem(String path){
        ImageIcon icon = new ImageIcon(path);
        slotsFree = 0;

        for(int i = 0; i< slots.size(); i++){
           if(slots.get(i).getIcon() == null){
               slotsFree++;
           }
        }
        switch(slotsFree){
            case 4:
                slots.get(0).setIcon(icon);
                break;
            case 3:
                slots.get(1).setIcon(icon);
                break;
            case 2:
                slots.get(2).setIcon(icon);
                break;
            case 1:
                slots.get(3).setIcon(icon);
                break;
            default:
                break;
        }

        if(path.equals(METH)){
            if(methInInventory < 4){
                methInInventory++;
            }
        }
    }

    public void clear(){

        for(int i = 0; i< slots.size(); i++){
            slots.get(i).setIcon(null);
        }
        methInInventory = 0;
        slotsFree = 4;
    }

    void deselectSlots(){
        for(int i = 0; i< slots.size(); i++){
            slots.get(i).setBackground(Color.LIGHT_GRAY);
        }
    }

    void checkForMeth(Slot s){
        if(s.getIcon() == null){
            selectedItem = "Nothing";
            System.out.println(selectedItem);
            return;
        }

       if(s.getIcon().toString()==METH){
            selectedItem = "Meth";
           System.out.println(selectedItem);
       }
    }

    void checkForSelectedSlot(int index) {
        deselectSlots();
        slots.get(index).setBackground(Color.RED);
        selectedSlot = slots.get(index);
        checkForMeth(selectedSlot);
    }






}
