package DAOimpl;

import DAO.DAO;
import model.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GenderImpl implements DAO<Gender, Integer> {
    private final SessionFactory factory;

    public GenderImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(Gender gender) {
        try (Session session = factory.openSession() ){
            session.getTransaction();
            session.save(gender);
            session.beginTransaction();

        }
    }

    @Override
    public void update(Gender gender) {
        try (Session session = factory.openSession() ){
            session.getTransaction();
            session.update(gender);
            session.beginTransaction();

        }
    }

    @Override
    public void delete(Gender gender) {
        try (Session session = factory.openSession() ){
            session.getTransaction();
            session.delete(gender);
            session.beginTransaction();

        }
    }

    @Override
    public Gender read(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Gender.class, integer);

        }
    }

    @Override
    public List<Gender> findByAll() {
        try (Session session = factory.openSession()){
            Query<Gender> query = session.createQuery("From gender");
            return query.list();

        }
    }
}
