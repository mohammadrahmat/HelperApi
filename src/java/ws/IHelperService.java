package ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import models.Coordinates;
import models.Incident;
import models.ServiceResult;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface IHelperService {

    @WebMethod
    public ServiceResult AddIncident(Incident i);

    @WebMethod
    public ServiceResult UpdateIncidentStatus(int incidentId, boolean status);

    @WebMethod
    public List<Incident> GetActiveIncidentsByRadius(Coordinates location);
}
