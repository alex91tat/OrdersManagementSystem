package utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.validators;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Product;

public class StockValidator implements Validator<Product>{
    @Override
    public void validate(Product object) {
        if (object.getQuantity() < 0) {
            throw new IllegalArgumentException("Not enough stock for this product!");
        }
    }
}
