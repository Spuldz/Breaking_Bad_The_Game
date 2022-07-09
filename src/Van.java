import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Van extends Structure{
    boolean cooking = false;
    boolean cooked = false;
    final String VAN_COOKING = "Assets\\van_cooking.png";
    final String VAN = "Assets\\van.png";
    final String VAN_COOKED = "Assets\\van_cooked.png";
    int seconds = 10;
    JLabel timerLabel = new JLabel();
    Scenes mainScene;
    Van van;
    Van(){

    }

    void createTimerLabel(){
        timerLabel.setText(seconds + "");

        //van.create(this, 600, 287, 227);
        timerLabel.setBounds(600, 550, 287, 40);
        timerLabel.setBackground(Color.GREEN);
        timerLabel.setOpaque(true);
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setText(seconds + "");
    }

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            timerLabel.setText(seconds + "");
        }
    });

    void startTimer(){
        createTimerLabel();
        timer.start();
    }

    void stopTimer(){
        timer.stop();
    }



    Timer cookTimer = new Timer(10000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            cooking = false;
            cooked = true;
            stopCooking();
        }
    });

    void startCooking(){
        startTimer();
        cookTimer.start();
        this.setState(VAN_COOKING);
        cooking = true;
    }

    void stopCooking(){
        cookTimer.stop();
        stopTimer();
        this.setState(VAN_COOKED);
    }




}

