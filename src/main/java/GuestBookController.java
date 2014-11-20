import java.sql.SQLException;
import java.util.List;

/**
 * Created by demo3 on 20.11.14.
 */
public interface GuestBookController{

    void addRecord(String message) throws ClassNotFoundException, SQLException;

    List<Record> getRecords() throws ClassNotFoundException, SQLException; //Record {id, postDate, message}

}