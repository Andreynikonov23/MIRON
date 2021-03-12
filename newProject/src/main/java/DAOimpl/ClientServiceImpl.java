package DAOimpl;

import DAO.DAO;
import model.ClientService;
import model.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ClientServiceImpl implements DAO<ClientService, Integer> {
    private final SessionFactory factory;

    public ClientServiceImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void create(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.save(clientService);
            session.beginTransaction();

        }
    }

    @Override
    public void update(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.update(clientService);
            session.beginTransaction();

        }
    }

    @Override
    public void delete(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.delete(clientService);
            session.beginTransaction();

        }
    }

    @Override
    public ClientService read(Integer integer) {
        try (Session session = factory.openSession()){
            return session.get(ClientService.class, integer);
        }
    }

    @Override
    public List<ClientService> findByAll() {
        try (Session session = factory.openSession()){
            Query<ClientService> query = session.createQuery("From clientservice");
            return query.list();

        }
    }
}
