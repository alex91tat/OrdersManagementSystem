package utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess.OrderDAO;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Order;

import java.util.List;

public class OrderBLL extends AbstractBLL<Order> {
    public OrderBLL() {
        super(new OrderDAO(), List.of());
    }
}
