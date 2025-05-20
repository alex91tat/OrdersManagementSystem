package utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic;

import utcnpt.pt2025_30422_tat_dragos_assignment_3.businessLogic.validators.Validator;
import utcnpt.pt2025_30422_tat_dragos_assignment_3.dataAccess.AbstractDAO;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractBLL<T> {
    private final Class<T> type;
    private AbstractDAO<T> dao;
    private List<Validator<T>> validators;

    @SuppressWarnings("unchecked")
    public AbstractBLL(AbstractDAO<T> dao, List<Validator<T>> validators) {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.dao = dao;
        this.validators = validators;
    }

    public List<T> getAll() {
        return dao.findAll();
    }

    public T insert(T object) {
        this.validators.forEach(validator -> validator.validate(object));
        return dao.insert(object);
    }

    public T update(T object) {
        this.validators.forEach(validator -> validator.validate(object));
        return dao.update(object);
    }

    public void delete(T object) {
        dao.delete(object);
    }

    public T findById(int id) {
        T object = dao.findById(id);
        if (object == null) {
            throw new IllegalArgumentException("No object with id " + id + " exists!");
        }

        return object;
    }

    public T findByName(String name) {
        T object = dao.findByName(name);
        if (object == null) {
            throw new IllegalArgumentException("No object with name " + name + " exists!");
        }

        return object;
    }

}
