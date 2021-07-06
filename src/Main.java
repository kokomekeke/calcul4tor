import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
    static GUI gui;

    public static void main(String[] args) throws Exception{
        SwingUtilities.invokeAndWait(new Runnable (){
            @Override
            public void run() {
                gui = new GUI();
            }
        });
    }
}

