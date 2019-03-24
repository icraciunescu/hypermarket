package ro.sda.hypermarket.core.service;

import ro.sda.hypermarket.core.entity.Client;
import java.util.List;

public interface ClientService {

    Client getById(Long id);
    List<Client> getAll();
    Client createClient(Client client, boolean useHibernate);
    Client updateClient(Client client);
    void deleteClient(Client client);

}
