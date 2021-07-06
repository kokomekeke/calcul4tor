import javax.swing.*;
import java.awt.event.*;
import java.security.Key;
import java.util.ArrayList;

import static java.awt.event.ActionEvent.CTRL_MASK;
import static java.awt.event.ActionEvent.SHIFT_MASK;


public class GUI extends JFrame {

    private final JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10, jb11, jb12, jb13, jb14, jb15, jb16, jb17, jb18, jb19;
    private JLabel jl1;
    private Math math;
    private boolean isOperationOn = true;
    private boolean decimalPointBlock = false;
    private boolean finished = false;
    private boolean appLock = false;
    private boolean minusIsOn = false;
    private double result;
    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;


    public GUI () {
        math = new Math();
        math.setNull();

        jl1 = new JLabel(" ", JLabel.RIGHT);
        jl1.setBounds(0, 0, 290, 30);

        jb1 = new JButton("C");
        jb1.setBounds(0, 30, 75, 30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        jb1.getInputMap(IFW).put(KeyStroke.getKeyStroke("C"),"DELETE");
        jb1.getActionMap().put("DELETE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        jb2 = new JButton("+/-");
        jb2.setBounds(75, 30, 75, 30);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //resSet();
                if (!math.getBuf().isEmpty())
                math.addToList(math.getBuf());
                math.addToList("*");
                math.addToList("-1");
                result = math.calculate();
                math.setNull();
                math.addToList(String.valueOf(result));
                jl1.setText(String.valueOf(result));
                isOperationOn = false;
                appLock = true;
            }
        });
        jb3 = new JButton("%");
        jb3.setBounds(150, 30, 75, 30);
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                percent();
            }
        });
        jb3.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_5, SHIFT_MASK),"PERCENT");
        jb3.getActionMap().put("PERCENT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                percent();
            }
        });
        jb4 = new JButton("/");
        jb4.setBounds(225, 30, 75, 30);
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                divide();
            }
        });
        jb4.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_6, SHIFT_MASK),"DIVIDE");
        jb4.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SLASH, 0),"DIVIDE");
        jb4.getActionMap().put("DIVIDE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                divide();
            }
        });
        jb5 = new JButton("7");
        jb5.setBounds(0, 60, 75, 30);
        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb5);
            }
        });
        jb5.getInputMap(IFW).put(KeyStroke.getKeyStroke("7"),"SEVEN");
        jb5.getActionMap().put("SEVEN", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb5);
            }
        });
        jb6 = new JButton("8");
        jb6.setBounds(75, 60, 75, 30);
        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb6);
            }
        });
        jb6.getInputMap(IFW).put(KeyStroke.getKeyStroke("8"),"EIGHT");
        jb6.getActionMap().put("EIGHT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb6);
            }
        });
        jb7 = new JButton("9");
        jb7.setBounds(150, 60, 75, 30);
        jb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb7);
            }
        });
        jb7.getInputMap(IFW).put(KeyStroke.getKeyStroke("9"),"NINE");
        jb7.getActionMap().put("NINE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb7);
            }
        });
        jb8 = new JButton("*");
        jb8.setBounds(225, 60, 75, 30);
        jb8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiply();
            }
        });
        jb8.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.ALT_DOWN_MASK),"MULTIPLY");
        jb8.getInputMap(IFW).put(KeyStroke.getKeyStroke("*"),"MULTIPLY");
        jb8.getActionMap().put("MULTIPLY", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                multiply();
            }
        });
        jb9 = new JButton("4");
        jb9.setBounds(0, 90, 75, 30);
        jb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb9);
            }
        });
        jb9.getInputMap(IFW).put(KeyStroke.getKeyStroke("4"),"FOUR");
        jb9.getActionMap().put("FOUR", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb9);
            }
        });
        jb10 = new JButton("5");
        jb10.setBounds(75, 90, 75, 30);
        jb10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb10);
            }
        });
        jb10.getInputMap(IFW).put(KeyStroke.getKeyStroke("5"),"FIVE");
        jb10.getActionMap().put("FIVE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb10);
            }
        });
        jb11 = new JButton("6");
        jb11.setBounds(150, 90, 75, 30);
        jb11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb11);
            }
        });
        jb11.getInputMap(IFW).put(KeyStroke.getKeyStroke("6"),"SIX");
        jb11.getActionMap().put("SIX", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb11);
            }
        });
        jb12 = new JButton("-");
        jb12.setBounds(225, 90, 75, 30);
        jb12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minus();
            }
        });
        jb12.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0),"MINUS");
        jb12.getActionMap().put("MINUS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minus();
            }
        });
        jb13 = new JButton("1");
        jb13.setBounds(0, 120, 75, 30);
        jb13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb13);
            }
        });
        jb13.getInputMap(IFW).put(KeyStroke.getKeyStroke("1"),"ONE");
        jb13.getActionMap().put("ONE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb13);
            }
        });
        jb14 = new JButton("2");
        jb14.setBounds(75, 120, 75, 30);
        jb14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb14);
            }
        });
        jb14.getInputMap(IFW).put(KeyStroke.getKeyStroke("2"),"TWO");
        jb14.getActionMap().put("TWO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb14);
            }
        });
        jb15 = new JButton("3");
        jb15.setBounds(150, 120, 75, 30);
        jb15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb15);
            }
        });
        jb15.getInputMap(IFW).put(KeyStroke.getKeyStroke("3"),"THREE");
        jb15.getActionMap().put("THREE", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEvent(jb15);
            }
        });
        jb16 = new JButton("+");
        jb16.setBounds(225, 120, 75, 30);
        jb16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plus();
            }
        });
        jb16.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.SHIFT_DOWN_MASK),"PLUS");
        jb16.getActionMap().put("PLUS", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plus();
            }
        });
        jb17 = new JButton("0");
        jb17.setBounds(0, 150, 150, 30);
        jb17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zeroAdd();
            }
        });
        jb17.getInputMap(IFW).put(KeyStroke.getKeyStroke("0"),"ZERO");
        jb17.getActionMap().put("ZERO", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zeroAdd();
            }
        });
        jb18 = new JButton(".");
        jb18.setBounds(150, 150, 75, 30);
        jb18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dotAdd();
            }
        });
        jb18.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0),"DOT");
        jb18.getActionMap().put("DOT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dotAdd();
            }
        });
        jb19 = new JButton("=");
        jb19.setBounds(225, 150, 75, 30);
        jb19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res();
            }
        });
        jb19.getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),"RESULT");
        jb19.getActionMap().put("RESULT", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res();
            }
        });

        add(jl1);
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);
        add(jb6);
        add(jb7);
        add(jb8);
        add(jb9);
        add(jb10);
        add(jb11);
        add(jb12);
        add(jb13);
        add(jb14);
        add(jb15);
        add(jb16);
        add(jb17);
        add(jb18);
        add(jb19);


        setLayout(null);
        setBounds(100, 100, 310, 219);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public int resSet () {
        if (finished) {
            math.setNull();
            jl1.setText(String.valueOf(result));
            math.addToList(String.valueOf(result));
            finished = false;
            appLock = true;

            return 0;
        } else return -1;
    }

    public void buttonEvent (JButton jb) {
        if (!appLock) {
            jl1.setText(jl1.getText() + jb.getText());
            math.append(jb.getText());
            isOperationOn = false;
            minusIsOn = false;
        } else {
            jl1.setText(jb.getText());
            math.setNull();
            math.append(jb.getText());
            appLock = false;
            isOperationOn = false;
            minusIsOn = false;
        }
    }

    public void clear () {
        jl1.setText("");
        math.setNull();
        isOperationOn = false;
        appLock = false;
    }

    public void divide () {
        //resSet();
        if (!isOperationOn) {
            jl1.setText(jl1.getText() + jb4.getText());
            if (!math.getBuf().equals("")) {
                math.addToList(math.getBuf());
            }
            math.addToList(jb4.getText());
            isOperationOn = true;
            decimalPointBlock = false;
            appLock = false;
        }
    }

    public void multiply () {
        //resSet();
        if (!isOperationOn) {
            jl1.setText(jl1.getText() + jb8.getText());
            if (!math.getBuf().equals("")) {
                math.addToList(math.getBuf());
            }
            math.addToList(jb8.getText());
            isOperationOn = true;
            decimalPointBlock = false;
            appLock = false;
        }
    }

    public void minus () {
        if(!isOperationOn) {
            jl1.setText(jl1.getText() + jb12.getText());
            if (!math.getBuf().equals("")) {
                math.addToList(math.getBuf());
            }
            math.addToList(jb12.getText());
            isOperationOn = true;
            decimalPointBlock = false;
            appLock = false;
        } else if (math.getExp().size() <= 1) {
            math.append("-");
            jl1.setText(jl1.getText() + " -");
            minusIsOn = true;
        } else if (!minusIsOn){
            math.append("-");
            jl1.setText(jl1.getText() + " -");
            minusIsOn = true;
        }
    }


    public void plus () {
        if (!isOperationOn) {
            jl1.setText(jl1.getText() + jb16.getText());
            if (!math.getBuf().equals("")) {
                math.addToList(math.getBuf());
            }
            math.addToList(jb16.getText());
            isOperationOn = true;
            decimalPointBlock = false;
            appLock = false;
        }
    }

    public void zeroAdd () {
        if (!appLock) {
            jl1.setText(jl1.getText() + jb17.getText());
            math.append(jb17.getText());
            isOperationOn = false;
            minusIsOn = false;
        }
    }

    public void dotAdd () {
        //resSet();
        if (!isOperationOn && !decimalPointBlock && !appLock) {
            jl1.setText(jl1.getText() + jb18.getText());
            math.append(jb18.getText());
            isOperationOn = true;
            decimalPointBlock = true;
        }
    }

    public void res () {
        if (math.getExp().size() <= 1) {
            math.addToList(math.getBuf());
            result = Double.parseDouble(math.getExp().get(0));
            System.out.println("testres" + result);
            math.setNull();
            math.addToList(String.valueOf(result));
            math.printList();
        } else {
            math.addToList(math.getBuf());
            result = math.calculate();
            jl1.setText(String.valueOf(result));
            math.setNull();
            math.addToList(String.valueOf(result));
            math.printList();

            isOperationOn = false;
            finished = true;
            appLock = true;
        }

        //math.setResult(0);
        if (isOperationOn = true) {
            isOperationOn = false;
            decimalPointBlock = false;
        }
    }

    public void percent () {
        if (!math.getBuf().equals(""))
            math.addToList(math.getBuf());

        if (math.getExp().size() <= 1) {
            result = Double.parseDouble(math.getExp().get(0));
        } else {
            result = math.calculate();
        }
        result = result / 100;
        jl1.setText(String.valueOf(result));
        math.setNull();
        math.addToList(String.valueOf(result));
        math.printList();
    }
}



