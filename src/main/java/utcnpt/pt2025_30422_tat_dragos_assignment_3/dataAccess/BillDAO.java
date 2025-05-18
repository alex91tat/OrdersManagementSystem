package utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Bill;

public class BillDAO extends AbstractDAO<Bill>{
    @Override
    public Bill update(Bill bill) {
        throw new UnsupportedOperationException("Bills cannot be updated.");
    }

    @Override
    public void delete(Bill bill) {
        throw new UnsupportedOperationException("Bills cannot be deleted.");
    }
}
