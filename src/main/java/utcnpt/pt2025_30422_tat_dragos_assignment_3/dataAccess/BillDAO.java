package utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.connection.ConnectionFactory;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.model.Bill;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO extends AbstractDAO<Bill>{
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

    @Override
    public Bill insert(Bill bill) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO Bill VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            Field[] fields = Bill.class.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                Object value = fields[i].get(bill);
                preparedStatement.setObject(i + 1, value);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(preparedStatement);
        }

        return bill;
    }

    @Override
    public List<Bill> findAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Bill> bills = new ArrayList<>();
        try {
            connection = ConnectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Bill", Statement.RETURN_GENERATED_KEYS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Bill bill = new Bill(
                        resultSet.getInt("id"),
                        resultSet.getInt("orderId"),
                        resultSet.getDouble("totalPrice")
                );
                bills.add(bill);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionFactory.close(connection);
            ConnectionFactory.close(preparedStatement);
            ConnectionFactory.close(resultSet);
        }

        return bills;
    }
}
