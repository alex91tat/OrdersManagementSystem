package utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Orders;

public class OrderDAO extends AbstractDAO<Orders>{
    @Override
    public Orders update(Orders order) {
        throw new UnsupportedOperationException("Orders cannot be updated.");
    }

    @Override
    public Orders findByName(String name) {
        throw new UnsupportedOperationException("Orders cannot be searched by name.");
    }
}
