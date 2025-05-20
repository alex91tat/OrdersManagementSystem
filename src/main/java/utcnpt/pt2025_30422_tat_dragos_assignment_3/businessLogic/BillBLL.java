package utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess.BillDAO;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Bill;

import java.util.List;

public class BillBLL extends AbstractBLL<Bill>{
    public BillBLL() {
        super(new BillDAO(), List.of());
    }

    @Override
    public Bill update(Bill bill) {
        throw new UnsupportedOperationException("Bills cannot be updated.");
    }

    @Override
    public void delete(Bill bill) {
        throw new UnsupportedOperationException("Bills cannot be deleted.");
    }

    @Override
    public Bill findByName(String name) {
        throw new UnsupportedOperationException("Bills cannot be searched by name.");
    }
}
