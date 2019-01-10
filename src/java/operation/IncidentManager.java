package operation;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import models.Incident;
import models.ServiceResult;

public class IncidentManager extends BaseOperation {
    
    public static ServiceResult AddIncident(Incident i) {
        ServiceResult result = new ServiceResult();
        String SPName = "{call [dbo].[HELPER_INCIDENT_INSERT] (?, ?, ?, ?)}";
        try (CallableStatement cStmt = conn.prepareCall(SPName)) {
            cStmt.setFloat("LATITUDE", i.getLocation().getLatitude());
            cStmt.setFloat("LONGITUDE", i.getLocation().getLongitude());
            cStmt.setInt("STATUS", 0);
            cStmt.setString("DESCRIPTION", i.getDescription());
            cStmt.execute();
            
            ResultSet rs = cStmt.getGeneratedKeys();
            if (rs.next()) {
                LOGGER.log(Level.INFO, "Added Incident with ID: {0}", rs.getLong(1));
            }
        } catch (SQLException sqlException) {
            LOGGER.warning(sqlException.getMessage());
        }
        return result;
    }
}
