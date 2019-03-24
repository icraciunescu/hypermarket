package ro.sda.hypermarket.core.dao.test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.SupplierDao;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Supplier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierDaoTest {

    @Autowired
    private SupplierDao supplierDao;


    @Test
    @Rollback(false)
    public void testCreate(){
        Supplier suppplier = new Supplier();
        suppplier.setName("india");
       supplierDao.createSupplier(suppplier);
        Assert.assertNotNull(suppplier);
    }

    @Test
    @Rollback(false)
    public void testRead(){
        Supplier sup = supplierDao.getById(8L);
        Long actual = sup.getId();
        Long expected = 8L;
        System.out.println(sup.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate(){
        Supplier fromDb = supplierDao.getById(8L);
        fromDb.setName("india");
        Supplier sup = supplierDao.updateSupplier(fromDb);
        System.out.println("Update " + sup + " to:");
        sup.setName("china");
        supplierDao.updateSupplier(sup);
        Supplier expected = supplierDao.updateSupplier(sup);
        Supplier actual = sup;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testDelete(){
        Supplier supplier = supplierDao.getById(3L);
        supplierDao.deleteSupplier(supplier);
        Assert.assertNotNull(supplier);
    }
}
