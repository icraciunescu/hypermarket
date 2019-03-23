package Dao;

import org.hibernate.Session;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.entity.Supplier;

import java.util.List;

public interface ClientDaoImpl {

    Session getCurrentSession();

    ClientDao getById(Long id);
    List<ClientDao> getAll();
    ClientDao createClientDao(ClientDao clientDao);
    void updateClientDao(ClientDao clientDao);
    void deleteClientDao(ClientDao clientDao);

}
