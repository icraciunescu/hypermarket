package ro.sda.hypermarket.core.dao;


import ro.sda.hypermarket.core.entity.Client;

import java.util.List;

public interface ClientDao {

    Client getById(Long id);

    List<Client> getAll();

    Client createClient(Client client);

    void deleteClient(Client client);

    Client updateClient(Client client);


}
