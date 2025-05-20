package utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess.OrderDAO;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Orders;

import java.util.List;

public class OrderBLL extends AbstractBLL<Orders> {
    public OrderBLL() {
        super(new OrderDAO(), List.of());
    }

    @Override
    public Orders update(Orders order) {
        throw new UnsupportedOperationException("Orders cannot be updated.");
    }

    @Override
    public Orders findByName(String name) {
        throw new UnsupportedOperationException("Orders cannot be searched by name.");
    }
}
