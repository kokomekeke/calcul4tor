import java.util.ArrayList;

public class Math {

    private double total = 0;
    private String buf = "";
    private ArrayList<String> exp;
    private ArrayList<String> eq = new ArrayList<>();

    public double plus (double a, double b) {
        total += a + b;
        return a + b;
    }

    public double minus (double a, double b) {
        total += a - b;
        return a - b;
    }

    public double multiply (double a, double b) {
        total += a * b;
        return a * b;
    }

    public double divide (double a, double b) {
        try {
            total += a / b;
            return a / b;
        } catch (ArithmeticException ee) {
            System.out.println("Error: " + ee.getMessage());
        }
        return -1;
    }

    public String getBuf() {
        return buf;
    }

    public void setBuf(double a) {
        this.buf = buf;
    }


    public void append (String a) {
        buf += a;
    }

    public double getTotal () {
        return total;
    }

    public void setTotal (double a) {
        total = a;
    }

    public void addToList (String expr) {
        exp.add(expr);
        buf = "";
    }

    public ArrayList<String> getExp() {
        return exp;
    }

    public String getExpElement (int i) {
        return exp.get(i);
    }

    public void setNull () {
        buf = "";
        exp = new ArrayList<>();
    }

    public double calculate () {
        for (int i = 0; i < exp.size(); i ++) {
            switch (exp.get(i)) {
                case "+":
                    total += plus(Double.parseDouble(exp.get(i - 1)), Double.parseDouble(exp.get(i + 1)));
                    break;
                case "-":
                    total += minus(Double.parseDouble(exp.get(i - 1)), Double.parseDouble(exp.get(i + 1)));
                    break;
                case "*":
                    total += multiply(Double.parseDouble(exp.get(i - 1)), Double.parseDouble(exp.get(i + 1)));
                    break;
                case "/":
                    total += divide(Double.parseDouble(exp.get(i - 1)), Double.parseDouble(exp.get(i + 1)));
                    break;
                default:
                    if (i > 1 && i < exp.size()-1) {
                        if ((!exp.get(i - 1).equals("*") && !exp.get(i + 1).equals("*")) || (!exp.get(i - 1).equals("/") && !exp.get(i + 1).equals("/"))) {
                            eq.add(exp.get(i));
                        }
                    }
            }
        }
        System.out.println("-------");
        for (int i = 0; i < eq.size(); i ++) {
            System.out.println(eq.get(i));
        }


        return 0;
    }
}
