import java.sql.*;

public class DbMethods {
    private Statement s = null;
    private Connection c = null;
    private ResultSet rs = null;

    public void reg (){
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Sikeres driver regisztráció");
        } catch (ClassNotFoundException e) {
            System.out.println("Hibas driver regisztráció!" + e.getMessage());
        }
    }

    public void connect () {
        try {
            String url = "jdbc:sqlite:C:/Users/Csőri Kornél/IdeaProjects/Calculator/calculator.db";
            c = DriverManager.getConnection(url);
            System.out.println("Connection OK!");
        } catch (SQLException e) {
            System.out.println("JDBC Connect: " + e.getMessage());
        }
    }

    public void disconnect () {
        try {
            c.close();
            System.out.println("Disconnection OK!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int insert (String date, String exp) {
        System.out.println("date: " + date + ", exp: " + exp);
        String sqlp = "insert into log values('" + date + "', '" + exp + "');";

        try {
            connect();
            s = c.createStatement();
            s.execute(sqlp);
            System.out.println("Insert ok!");
            disconnect();
            return 0;
        } catch (SQLException ee) {
            System.out.println("JDBC insert: " + ee.getMessage());
            return -1;
        }

    }
}
