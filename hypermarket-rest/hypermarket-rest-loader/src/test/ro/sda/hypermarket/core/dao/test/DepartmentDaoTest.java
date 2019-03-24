package ro.sda.hypermarket.core.dao.test;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.ClientDao;
import ro.sda.hypermarket.core.dao.DepartmentDao;
import ro.sda.hypermarket.core.entity.Client;
import ro.sda.hypermarket.core.entity.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
@Transactional
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    public void testCreate(){

        Department department= new Department();
        department.setName("financiar");
        departmentDao.createDepartment(department);
        Assert.assertNotNull(department);
    }

    @Test
    public void testRead(){
        Department dep = departmentDao.getById(8L);
        Long actual = dep.getId();
        Long expected = 8L;
        System.out.println(dep.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdate(){
        Department fromDb = departmentDao.getById(8L);
        fromDb.setName("financiar");
        Department dep = departmentDao.updateDepartment(fromDb);
        System.out.println("Update " + dep + " to:");
        dep.setName("Ionut");
        departmentDao.updateDepartment(dep);
        Department expected = departmentDao.updateDepartment(dep);
        Department actual = dep;
        System.out.println(expected.toString());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDelete(){
        Department department = departmentDao.getById(3L);
        departmentDao.deleteDepartment(department);
        Assert.assertNotNull(department);
    }
}

