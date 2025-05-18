package utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.validators.EmailValidator;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess.ClientDAO;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Client;

import java.util.List;

public class ClientBLL extends AbstractBLL<Client>{
    public ClientBLL() {
        super(new ClientDAO(), List.of(new EmailValidator()));
    }
}
