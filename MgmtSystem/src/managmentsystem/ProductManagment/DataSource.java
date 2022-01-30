package managmentsystem.ProductManagment;

import java.sql.Connection;
import managmentsystem.DatabaseHandler;

public interface DataSource {
    void createConnection();
    Connection getConnection();
}
