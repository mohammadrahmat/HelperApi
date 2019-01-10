package ws;

import java.util.List;
import javax.jws.WebService;
import models.Coordinates;
import models.Incident;
import models.ServiceResult;
import operation.IncidentManager;

@WebService(endpointInterface = "ws.IHelperService")
public class HelperServiceImpl implements IHelperService {

    @Override
    public ServiceResult AddIncident(Incident i) {
        return IncidentManager.AddIncident(i);
    }

    @Override
    public ServiceResult UpdateIncidentStatus(Incident i, boolean status) {
        return null;
    }

    @Override
    public List<Incident> GetActiveIncidentsByRadius(Coordinates location) {
        return null;
    }

}
