package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDao;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.repository.ClientRepository;
import java.util.List;

@Service("clientService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client getById(Long id) {
        return clientDao.getById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientDao.getAll();
    }

    @Override
    @Transactional
    public Client createClient(Client client, boolean useHibernate) {
        if (useHibernate) {
            return clientDao.createClient(client);
        }
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    @Override
    public void deleteClient(Client client) {

    }
}
