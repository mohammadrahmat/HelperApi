package operation;

import db.ConnectionManager;
import java.sql.Connection;
import java.util.logging.Logger;

public class BaseOperation {

    public static final Logger LOGGER = Logger.getLogger("OperationLogger");
    public static Connection conn = ConnectionManager.getDBConnection();
}
