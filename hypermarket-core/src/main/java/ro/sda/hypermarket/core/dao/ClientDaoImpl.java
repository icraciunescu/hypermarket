package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Client;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

    private List<Client> clients = new ArrayList<>();

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Client getById(Long id) {
        return getCurrentSession().byId(Client.class).getReference(id);
    }

    @Override
    public List<Client> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Client> criteriaQuery = session.getCriteriaBuilder().createQuery(Client.class);
        criteriaQuery.from(Client.class);
        List<Client> allClients = session.createQuery(criteriaQuery).getResultList();
        return allClients;
    }

    @Override
    public Client createClient(Client client) {
        getCurrentSession().save(client);
        return client;
    }

    @Override
    public Client updateClient(Client client) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Client client1 = getById(client.getId());
        sessionFactory.getCurrentSession().merge(client1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return  client1;
    }

    @Override
    public void deleteClient(Client client) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Client client1 = getById(client.getId());
        sessionFactory.getCurrentSession().delete(client1);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
