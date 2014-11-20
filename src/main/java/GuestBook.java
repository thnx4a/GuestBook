import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by demo3 on 20.11.14.
 */
public class GuestBook implements GuestBookController {
    @Override
    public void addRecord(String message) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
        PreparedStatement pst = conn.prepareStatement("INSERT INTO posts (postDate,postMessage) VALUES (?,?)");
        pst.setDate(1, new Date(System.currentTimeMillis()));
        pst.setString(2, message);
        pst.execute();
        conn.close();
    }

    @Override
    public List<Record> getRecords() throws ClassNotFoundException, SQLException {
        List<Record> recordsList = new ArrayList<Record>();
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT ID, postDate, postMessage from posts");
        while(rs.next()){
            
            String postMessage = rs.getString("postMessage");
            System.out.println(postMessage);
        }
    }
}
