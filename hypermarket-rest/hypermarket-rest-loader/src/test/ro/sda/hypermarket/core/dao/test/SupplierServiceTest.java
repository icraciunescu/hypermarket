package ro.sda.hypermarket.core.dao.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.Supplier;
import ro.sda.hypermarket.core.service.SupplierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class SupplierServiceTest {

    @Autowired
    private SupplierService supplierService;

    @Test
    @Rollback(false)
    public void testCreate() {
        Supplier suppplier = new Supplier();
        suppplier.setName("india");
        suppplier.setCity("podu iloaie");
        suppplier.setContact_no("034332323");
        supplierService.createSupplier(suppplier, false);
        Assert.assertNotNull(suppplier);
    }

    @Test
    @Rollback(false)
    public void testRead() {
        Supplier sup = supplierService.getById(1L, false);
        Long actual = sup.getId();
        Long expected = 1L;
        System.out.println(sup.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testUpdate() {
        Supplier fromDb = supplierService.getById(1L, false);
        fromDb.setName("india");
        Supplier sup = supplierService.updateSupplier(fromDb);
        System.out.println("Update " + sup + " to:");
        sup.setName("china");
        supplierService.updateSupplier(sup);
        Supplier expected = supplierService.updateSupplier(sup);
        Supplier actual = sup;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    @Rollback(false)
    public void testDelete() {
        Supplier supplier = supplierService.getById(1L, false);
        supplierService.deleteSupplier(supplier);
        Assert.assertNotNull(supplier);
    }
}
