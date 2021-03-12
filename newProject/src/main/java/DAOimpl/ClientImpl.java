package DAOimpl;

import DAO.DAO;
import model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ClientImpl implements DAO<Client,Integer> {

    private final SessionFactory factory;

    public ClientImpl(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(Client client) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.save(client);
            session.beginTransaction();
        }
    }

    @Override
    public void update(Client client) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.update(client);
            session.beginTransaction();
        }
    }

    @Override
    public void delete(Client client) {
        try(Session session = factory.openSession()) {
            session.getTransaction();
            session.delete(client);
            session.beginTransaction();
        }
    }

    public Client read(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(Client.class,integer);
        }
    }

    public List<Client> findByAll() {
        try (Session session = factory.openSession()){
            Query<Client> query = session.createQuery("FROM Client");
            return query.list();
        }

    }
}
