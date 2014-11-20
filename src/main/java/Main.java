import java.sql.*;
import java.util.List;

/**
 * Created by demo3 on 20.11.14.
 */
public class Main {
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
        Statement st = conn.createStatement();
        st.execute("drop table posts");
        st.execute("CREATE TABLE IF NOT EXISTS posts(ID INT PRIMARY KEY auto_increment, postDate DATE, postMessage VARCHAR(255))");
        PreparedStatement pst = conn.prepareStatement("INSERT INTO posts (postDate,postMessage) VALUES (?,?)");
        pst.setDate(1, Date.valueOf("2014-10-01"));
        pst.setString(2, "Helo!");
        pst.execute();
        ResultSet rs = st.executeQuery("SELECT * from posts");
        while(rs.next()){
            String postMessage = rs.getString("postMessage");
            System.out.println(postMessage);
        }
        conn.close();

    }
}
