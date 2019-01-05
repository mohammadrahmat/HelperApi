package models;

import Util.IncidentStatus;
import java.util.Date;

public class Incident {

    private int incidentId;
    private Coordinates location;
    private IncidentStatus status;
    private String description;
    private Date incidentTime;
    private Date lastUpdateTime;
    
    public Incident() {}

    public Incident(int incidentId, Coordinates location, IncidentStatus status,
            String description, Date incidentTime, Date lastUpdateTime) {
        this.incidentId = incidentId;
        this.location = location;
        this.status = status;
        this.description = description;
        this.incidentTime = incidentTime;
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getIncidentId() {
        return incidentId;
    }

    public Coordinates getLocation() {
        return location;
    }

    public IncidentStatus getIncidentStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public Date getIncidentTime() {
        return incidentTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
