import java.sql.*;

public class DBUtils {
    static DBUtils instance = null;
    private Connection conn;

    DBUtils() {
        init();
    }

    public static DBUtils getInstance() {
        if (instance == null)
            instance = new DBUtils();
        return instance;
    }

    void init() {
        try {

//            Class.forName("com.mysql.jdbc.Driver");
//            Class.forName("org.sqlite.JDBC");
//            String url = "jdbc:mysql://47.107.173.225:3306/demo";
//            String user = "root";
//            String password = "root";
//            conn = DriverManager.getConnection(url, user, password);
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/crack/demo");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Boolean verifyPasswd(String name, String passwd) {
        Statement stat = null;
        try {
            stat = conn.createStatement();
            ResultSet rs = null;
            String sql = "select * from user where name = " + "'" + name + "'";
            System.out.println(sql);
            rs = stat.executeQuery(sql);
            while (rs.next()) {
//                System.out.println(rs.getString("passwd"));
                if (rs.getString("passwd").equals(passwd)) {
                    System.out.println(passwd);
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}
