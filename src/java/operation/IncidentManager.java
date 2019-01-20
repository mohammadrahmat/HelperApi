package operation;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import models.Coordinates;
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
    
    public static ServiceResult UpdateIncidentStatus(int incidentId, boolean status) {
        ServiceResult result = new ServiceResult();
        String SPName = "{call [dbo].[HELPER_INCIDENT_STATUS_UPDATE] (?, ?)}";
        try (CallableStatement cStmt = conn.prepareCall(SPName)) {
             cStmt.setInt("INCIDENT_ID", incidentId);
             cStmt.setBoolean("STATUS", status);
             cStmt.execute();
             
             LOGGER.log(Level.INFO, "Update Incident with ID: {0}", incidentId);
        } catch (SQLException sqlException) {
            LOGGER.warning(sqlException.getMessage());
        }
        return result;
    }
    
    public static List<Incident> GetActiveIncidentsByRadius(Coordinates location) {
        return null;
    }
}
