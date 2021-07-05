import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class GUI extends JFrame {

    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10, jb11, jb12, jb13, jb14, jb15, jb16, jb17, jb18, jb19, jb20;
    private JLabel jl1;
    private Math math;
    private boolean isOperationOn = true;
    private boolean decimalPointBlock = false;
    private boolean finished = false;
    private boolean appLock = false;
    private boolean minusIsOn = false;
    private double result;

    public GUI () {
        //UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
        math = new Math();
        math.setNull();

        jl1 = new JLabel(" ", JLabel.RIGHT);
        jl1.setBounds(0, 0, 290, 30);

        jb1 = new JButton("C");
        jb1.setBounds(0, 30, 75, 30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText("");
                math.setNull();
                isOperationOn = false;
                appLock = false;
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
        });

        jb4 = new JButton("/");
        jb4.setBounds(225, 30, 75, 30);
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        });
        jb5 = new JButton("7");
        jb5.setBounds(0, 60, 75, 30);
        jb5.addActionListener(new ActionListener() {
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
        jb7 = new JButton("9");
        jb7.setBounds(150, 60, 75, 30);
        jb7.addActionListener(new ActionListener() {
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
        });
        jb9 = new JButton("4");
        jb9.setBounds(0, 90, 75, 30);
        jb9.addActionListener(new ActionListener() {
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
        jb11 = new JButton("6");
        jb11.setBounds(150, 90, 75, 30);
        jb11.addActionListener(new ActionListener() {
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
        });
        jb13 = new JButton("1");
        jb13.setBounds(0, 120, 75, 30);
        jb13.addActionListener(new ActionListener() {
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
        jb15 = new JButton("3");
        jb15.setBounds(150, 120, 75, 30);
        jb15.addActionListener(new ActionListener() {
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
        });

        jb17 = new JButton("0");
        jb17.setBounds(0, 150, 150, 30);
        jb17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!appLock) {
                    jl1.setText(jl1.getText() + jb17.getText());
                    math.append(jb17.getText());
                    isOperationOn = false;
                    minusIsOn = false;
                }
            }
        });

        jb18 = new JButton(".");
        jb18.setBounds(150, 150, 75, 30);
        jb18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //resSet();
                if (!isOperationOn && !decimalPointBlock && !appLock) {
                    jl1.setText(jl1.getText() + jb18.getText());
                    math.append(jb18.getText());
                    isOperationOn = true;
                    decimalPointBlock = true;
                }

            }
        });
        jb19 = new JButton("=");
        jb19.setBounds(225, 150, 75, 30);
        jb19.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
}



