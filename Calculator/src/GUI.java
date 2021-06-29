import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {

    private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7, jb8, jb9, jb10, jb11, jb12, jb13, jb14, jb15, jb16;
    private JLabel jl1;
    private Math math;
    private boolean isOperationOn = true;
    private boolean decimalPointBlock = false;

    public GUI () {
        math = new Math();
        math.setNull();

        jl1 = new JLabel(" ", JLabel.RIGHT);
        jl1.setBounds(0, 0, 290, 30);

        jb1 = new JButton("7");
        jb1.setBounds(0, 30, 75, 30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb1.getText());
                math.append(jb1.getText());
                isOperationOn = false;
            }
        });
        jb2 = new JButton("8");
        jb2.setBounds(75, 30, 75, 30);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb2.getText());
                math.append(jb2.getText());
                isOperationOn = false;
            }
        });
        jb3 = new JButton("9");
        jb3.setBounds(150, 30, 75, 30);
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb3.getText());
                math.append(jb3.getText());
                isOperationOn = false;
            }
        });
        jb4 = new JButton("/");
        jb4.setBounds(225, 30, 75, 30);
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperationOn) {
                    jl1.setText(jl1.getText() + jb4.getText());
                    math.addToList(math.getBuf());
                    math.addToList(jb4.getText());
                    isOperationOn = true;
                    decimalPointBlock = false;
                }
            }
        });

        jb5 = new JButton("4");
        jb5.setBounds(0, 60, 75, 30);
        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb5.getText());
                math.append(jb5.getText());
                isOperationOn = false;
            }
        });
        jb6 = new JButton("5");
        jb6.setBounds(75, 60, 75, 30);
        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb6.getText());
                math.append(jb6.getText());
                isOperationOn = false;
            }
        });
        jb7 = new JButton("6");
        jb7.setBounds(150, 60, 75, 30);
        jb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb7.getText());
                math.append(jb7.getText());
                isOperationOn = false;
            }
        });
        jb8 = new JButton("*");
        jb8.setBounds(225, 60, 75, 30);
        jb8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperationOn) {
                    jl1.setText(jl1.getText() + jb8.getText());
                    math.addToList(math.getBuf());
                    math.addToList(jb8.getText());
                    isOperationOn = true;
                    decimalPointBlock = false;
                }
            }
        });

        jb9 = new JButton("1");
        jb9.setBounds(0, 90, 75, 30);
        jb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb9.getText());
                math.append(jb9.getText());
                isOperationOn = false;
            }
        });
        jb10 = new JButton("2");
        jb10.setBounds(75, 90, 75, 30);
        jb10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb10.getText());
                math.append(jb10.getText());
                isOperationOn = false;
            }
        });
        jb11 = new JButton("3");
        jb11.setBounds(150, 90, 75, 30);
        jb11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb10.getText());
                math.append(jb11.getText());
                isOperationOn = false;
            }
        });
        jb12 = new JButton("-");
        jb12.setBounds(225, 90, 75, 30);
        jb12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isOperationOn) {
                    jl1.setText(jl1.getText() + jb12.getText());
                    math.addToList(math.getBuf());
                    math.addToList(jb12.getText());
                    isOperationOn = true;
                    decimalPointBlock = false;
                }
            }
        });

        jb13 = new JButton("0");
        jb13.setBounds(0, 120, 75, 30);
        jb13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jl1.setText(jl1.getText() + jb13.getText());
                math.append(jb13.getText());
                isOperationOn = false;
            }
        });
        jb14 = new JButton(".");
        jb14.setBounds(75, 120, 75, 30);
        jb14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperationOn && !decimalPointBlock) {
                    jl1.setText(jl1.getText() + jb14.getText());
                    math.append(jb14.getText());
                    isOperationOn = true;
                    decimalPointBlock = true;
                }
            }
        });
        jb15 = new JButton("+");
        jb15.setBounds(150, 120, 75, 30);
        jb15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isOperationOn) {
                    jl1.setText(jl1.getText() + jb15.getText());
                    math.addToList(math.getBuf());
                    math.addToList(jb15.getText());
                    isOperationOn = true;
                    decimalPointBlock = false;
                }
            }
        });
        jb16 = new JButton("=");
        jb16.setBounds(225, 120, 75, 30);
        jb16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                math.addToList(math.getBuf());
                testArray();
                math.calculate();
                math.setNull();
                jl1.setText("");
                math.setTotal(0);
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

        setLayout(null);
        setBounds(100, 100, 310, 189);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void testArray () {
        for (String a : math.getExp()) {
            System.out.println(a);
        }
    }
}
