import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;

public class Math {

    private double result = 0;
    private String buf = "";
    private ArrayList<String> exp;
    private ArrayList<String> eq = new ArrayList<>();

    public double plus (double a, double b) {
        return a + b;
    }

    public double minus (double a, double b) {
        return a - b;
    }

    public double multiply (double a, double b) {
        return a * b;
    }

    public double divide (double a, double b) {
        try {
            return a / b;
        } catch (ArithmeticException ee) {
            System.out.println("Error: " + ee.getMessage());
        }
        return -1;
    }

    public String getBuf() {
        return buf;
    }

    public void setBuf(String a) {
        this.buf = a;
    }

    public void setExp (int i, String s) {
        if (exp.size() < i) {
            exp.add(s);
        } else exp.set(i, s);


    }

    public void append (String a) {
        buf += a;
    }

    public double getResult () {
        return result;
    }

    public void setResult (double a) {
        result = a;
    }

    public void addToList (String expr) {
        //if (expr != null) {
            exp.add(expr);
            buf = "";
        //}
    }

    public void printList () {
        int i = 0;
        System.out.println("-------");
        for (String s : exp) {
            System.out.println(i + ": " + s);
            i ++;
        }
    }

    public ArrayList<String> getExp() {
        return exp;
    }

    public void expReset () {
        exp = new ArrayList<>();
    }

    public String getExpElement (int i) {
        return exp.get(i);
    }

    public void setNull () {
        buf = "";
        exp = new ArrayList<>();
    }

    public double calculate () {

        /*if (!buf.equals("")) {
            addToList(buf);
        }
         */
        printList();
        System.out.println("size" + exp.size());
        /*for (int i = 0; i < exp.size(); i ++) {
            if (exp.get(i).equals(null)) {
                exp.remove(i);
            }
        }

         */

        if (exp.size() == 1) { System.out.println("Eredmény: " + result);
            return result;
        }

        for (int i = 1; i < exp.size() - 1; i += 2) {
            if (exp.get(i).contains("*")) {
                System.out.println("szorzás");
                result = multiply(Double.parseDouble(exp.get(i - 1)),Double.parseDouble(exp.get(i + 1)));
                exp.remove(i + 1);
                exp.remove(i);
                exp.remove(i - 1);
                exp.add(i - 1, Double.toString(result));
                calculate();
            } else if (exp.get(i).contains("/")) {
                System.out.println("osztás");
                result = divide(Double.parseDouble(exp.get(i - 1)),Double.parseDouble(exp.get(i + 1)));
                exp.remove(i + 1);
                exp.remove(i);
                exp.remove(i - 1);
                exp.add(i - 1, Double.toString(result));
                calculate();
            }
        }
        //printList();

        for (int i = 1; i < exp.size() - 1; i += 2) {
            if (exp.get(i).equals("+")) {
                System.out.println("összeadás");

                result = plus(Double.parseDouble(exp.get(i - 1)),Double.parseDouble(exp.get(i + 1)));
                exp.remove(i + 1);
                exp.remove(i);
                exp.remove(i - 1);
                exp.add(i - 1, Double.toString(result));
                calculate();
            } else if (exp.get(i).equals("-")){
                System.out.println("kivonás");

                result = minus(Double.parseDouble(exp.get(i - 1)),Double.parseDouble(exp.get(i + 1)));
                exp.remove(i + 1);
                exp.remove(i);
                exp.remove(i - 1);
                exp.add(i - 1, Double.toString(result));
                calculate();
            } else System.out.println("vmi szar");
        }


        return result;
    }

}