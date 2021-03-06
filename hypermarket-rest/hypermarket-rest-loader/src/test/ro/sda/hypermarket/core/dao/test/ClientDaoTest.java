package ro.sda.hypermarket.core.dao.test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDao;
import ro.sda.hypermarket.core.entity.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class ClientDaoTest {

    @Autowired
    private ClientDao clientDao;


    @Test
    @Rollback(false)
    public void testCreate(){
        Client client = new Client();
        client.setName("Vasile");
        clientDao.createClient(client);
        Assert.assertNotNull(client);
    }

    @Test
    @Rollback(false)
    public void testRead(){
        Client cli = clientDao.getById(8L);
        Long actual = cli.getId();
        Long expected = 8L;
        System.out.println(cli.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate(){
        Client fromDb = clientDao.getById(8L);
        fromDb.setName("Vasile");
        Client cli = clientDao.updateClient(fromDb);
        System.out.println("Update " + cli + " to:");
        cli.setName("Ionut");
        clientDao.updateClient(cli);
        Client expected = clientDao.updateClient(cli);
        Client actual = cli;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Client client = clientDao.getById(3L);
        clientDao.deleteClient(client);
        Assert.assertNotNull(client);
    }
}
