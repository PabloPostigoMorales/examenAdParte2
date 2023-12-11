package cesur.examen.domain.car;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno: Pablo Postigo Morales
 * Fecha:
 */

@Log
public class CarDAO implements DAO<Car> {
    SessionFactory sessionFactory;

    public CarDAO(SessionFactory s) {
        sessionFactory = s;
    }

    @Override
    public Car save(Car car) {

        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.persist(car);
            transaction.commit();

        }

        return car;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    public List<Car> getAllByManufacturer(String manufacturer){
        var out = new ArrayList<Car>();


        /* Implement method here */

        return out;
    }



}
