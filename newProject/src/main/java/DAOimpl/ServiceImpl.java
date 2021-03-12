package DAOimpl;

import DAO.DAO;
import model.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ServiceImpl implements DAO<Service,Integer> {
      private final SessionFactory factory;

    public ServiceImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Service service) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.save(service);
            session.beginTransaction();

        }
    }

    @Override
    public void update(Service service) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.update(service);
            session.beginTransaction();

        }
    }

    @Override
    public void delete(Service service) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.delete(service);
            session.beginTransaction();

        }
    }

    @Override
    public Service read(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Service.class, integer);

        }
    }

    @Override
    public List<Service> findByAll() {
        try(Session session = factory.openSession()){
            Query<Service> query = session.createQuery("From service");
            return query.list();
        }
    }
}
