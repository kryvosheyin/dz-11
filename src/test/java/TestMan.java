import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.human.Man;
import test.human.Woman;

public class TestMan {

    private Man alex;
    private Woman jessica, laura;

    @BeforeClass(groups = "smoke")
    public void setUp() {
        alex = new Man("Alex", "Kryvosheyin", 35, false);
        jessica = new Woman("Jessica", "Simpson", 30, false);
        laura = new Woman("Laura", "Hoffman", 45, true);
    }

    @Test
    public void testRegisterPartnership() {
        if (alex.married) {
            alex.deregisterPartnership();
        }
        alex.registerPartner(jessica);
        Assert.assertTrue(alex.married && jessica.married);
        Assert.assertEquals(jessica.getFullName(), alex.getSpouseName());
    }

    @Test
    public void testCanGetMarried(){
        Assert.assertFalse(alex.canGetMarried(laura));
    }

    @Test
    public void testRetirement() {
        Assert.assertFalse(alex.isRetired());
    }

    @Test
    public void testDeregisterPartnership() {
        if (!alex.married) {
            alex.registerPartnership(jessica);
        }
        alex.deregisterPartnership();
        Assert.assertFalse(alex.married);
    }

    @Test(groups = "smoke")
    public void testGetFullName() {
        Assert.assertEquals(alex.getFullName(), "Alex Kryvosheyin");
    }

    @Test(groups = "smoke")
    public void testGetAge() {
        Assert.assertEquals(alex.getAge(), 35);
    }

    @Test(groups = "smoke")
    public void testSetAge() {
        alex.setAge(45);
        Assert.assertEquals(alex.getAge(), 45);
    }
}
