package utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.validators.StockValidator;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess.ProductDAO;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Product;

import java.util.List;

public class ProductBLL extends AbstractBLL<Product>{
    public ProductBLL() {
        super(new ProductDAO(), List.of(new StockValidator()));
    }

    public double calculateTotalPrice(int productId, int quantity) {
        return findById(productId).getPrice() * quantity;
    }
}
