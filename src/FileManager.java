import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private BufferedReader in;

    public void insert (String s) {
        try {
            PrintStream out = new PrintStream(new FileOutputStream("log.txt", true));
            out.print(s);
            out.close();
            JOptionPane.showMessageDialog(null, "Adatok sikeresen kiírva!", "Program üzenet", 1);
        } catch (FileNotFoundException ee) {
            JOptionPane.showMessageDialog(null, "Hiba: " + ee.getMessage(), "Program üzenet", 0);
        } catch (IOException ee) {
            JOptionPane.showMessageDialog(null, "Hiba: " + ee.getMessage(), "Program üzenet", 0);
        }
    }

    public String readFile () {
        String a = "";
        try {
            in = new BufferedReader(new FileReader("log.txt"));

            String s = in.readLine();
            a += s;
            while (s != null) {
                s = in.readLine();
                if (s != null)
                a += "\n" + s;
            }
            in.close();
        } catch (FileNotFoundException ee) {
            JOptionPane.showMessageDialog(null, "Hiba: " + ee.getMessage(), "Program üzenet", 0);
        } catch (IOException ee) {
            JOptionPane.showMessageDialog(null, "Hiba: " + ee.getMessage(), "Program üzenet", 0);
        }

        System.out.println("1" + a);
        return a;
    }
}
