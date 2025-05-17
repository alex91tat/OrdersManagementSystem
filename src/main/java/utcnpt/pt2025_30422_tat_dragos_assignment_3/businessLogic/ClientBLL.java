package utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.validators.EmailValidator;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.validators.Validator;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess.ClientDAO;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    public ClientBLL() {
        validators = new ArrayList<>();
        validators.add(new EmailValidator());

        clientDAO = new ClientDAO();
    }

    public Client findStudentById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return client;
    }

}
