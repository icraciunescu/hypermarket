package ro.sda.hypermarket.core.dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Client;
import java.util.List;

public interface ClientDao {

    Session getCurrentSession();

    Client getById(Long id);

    List<Client> getAll();

    Client createClient(Client client);

    void updateClient(Client client);

    void deleteClient(Client client);

}
