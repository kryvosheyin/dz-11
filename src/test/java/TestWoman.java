import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.human.Man;
import test.human.Woman;

public class TestWoman {

    private Man tim, scott;
    private Woman rachel;

    @BeforeClass(groups = "smoke")
    public void setUp(){
        tim = new Man("Tim", "Faden", 65, true);
        rachel= new Woman("Rachel", "Green", 62, false);
        scott = new Man("Scott", "Honor", 33, false);
    }

    @Test(groups = {"smoke"})
    public void testGetName(){
        Assert.assertEquals(rachel.getFullName(), "Rachel Green");
    }

    @Test(groups = {"smoke"})
    public void testGetAge(){
        Assert.assertEquals(rachel.getAge(), 62);
    }

    @Test(groups = {"smoke"})
    public void testSetAge(){
        rachel.setAge(65);
        Assert.assertEquals(rachel.getAge(), 65);
    }

    @Test
    public void testIsRetired(){
        Assert.assertTrue(rachel.isRetired());
    }

    @Test
    public void testCanGetMarried(){
        Assert.assertFalse(rachel.canGetMarried(tim));
    }

    @Test
    public void testRegisterPartnership(){
        if(rachel.married){
            rachel.deregisterPartnership();
        }
        rachel.registerPartnership(scott);
        Assert.assertTrue(rachel.married && scott.married);
        Assert.assertEquals(rachel.getLastNAme(), scott.getLastNAme());
    }

    @Test
    public void testDeregisterPartnership(){
        if(!rachel.married){
            rachel.registerPartner(scott);
        }
        rachel.deregisterPartnership();
        Assert.assertFalse(rachel.married);
        Assert.assertEquals(rachel.getLastNAme(), rachel.getOriginalLastName());
    }

}
