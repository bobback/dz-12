package ManWoman;

import com.bobak.people.Man;
import com.bobak.people.Woman;
import dataproviders.TestDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanTests {

    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        this.softAssert = new SoftAssert();
    }

    @Test(dataProvider = "combinedData", dataProviderClass = TestDataProvider.class)
    public void testGetPartner(String manFirstName, String manLastName, int manAge, String womanFirstName, String womanLastName, int womanAge){

        Man man = new Man(manFirstName, manLastName, manAge);
        Woman woman = new Woman(womanFirstName, womanLastName, womanAge);

        softAssert.assertNull(woman.getPartner());

        woman.registerPartnership(man);

        softAssert.assertEquals(woman.getPartner(), man);

        woman.deregisterPartnership(false);

        softAssert.assertNull(woman.getPartner());
    }

    @Test(dataProvider = "combinedData", dataProviderClass = TestDataProvider.class)
    public void testSetPartner(String manFirstName, String manLastName, int manAge, String womanFirstName, String womanLastName, int womanAge){
        Man manJack = new Man("Jack", "Jones", 45);

        Man man = new Man(manFirstName, manLastName, manAge);
        Woman woman = new Woman(womanFirstName, womanLastName, womanAge);

        softAssert.assertNull(woman.getPartner());

        woman.setPartner(man);

        softAssert.assertEquals(woman.getPartner(), man);

        woman.setPartner(manJack);

        softAssert.assertEquals(woman.getPartner(), manJack);
        softAssert.assertNull(man.getPartner());
    }

    @Test(dataProvider = "combinedData", dataProviderClass = TestDataProvider.class)
    public void testRegisterPartnership(String manFirstName, String manLastName, int manAge, String womanFirstName, String womanLastName, int womanAge){

        Man man = new Man(manFirstName, manLastName, manAge);
        Woman woman = new Woman(womanFirstName, womanLastName, womanAge);

        woman.registerPartnership(man);

        softAssert.assertEquals(woman.getPartner(), man);
        softAssert.assertEquals(woman.getLastName(), man.getLastName());
    }

    @Test(dataProvider = "combinedData", dataProviderClass = TestDataProvider.class)
    public void testDeregisterPartnership_ReturnToPreviousLastName(String manFirstName, String manLastName, int manAge, String womanFirstName, String womanLastName, int womanAge){

        Man man = new Man(manFirstName, manLastName, manAge);
        Woman woman = new Woman(womanFirstName, womanLastName, womanAge);

        woman.registerPartnership(man);

        softAssert.assertEquals(woman.getLastName(), man.getLastName());

        woman.deregisterPartnership(true);

        softAssert.assertNull(woman.getPartner());
        softAssert.assertNull(man.getPartner());
        softAssert.assertEquals(woman.getLastName(), woman.getLastName());
    }

    @Test(dataProvider = "combinedData", dataProviderClass = TestDataProvider.class)
    public void testDeregisterPartnership_DoNotReturnToPreviousLastName(String manFirstName, String manLastName, int manAge, String womanFirstName, String womanLastName, int womanAge){

        Man man = new Man(manFirstName, manLastName, manAge);
        Woman woman = new Woman(womanFirstName, womanLastName, womanAge);

        woman.registerPartnership(man);

        softAssert.assertEquals(woman.getLastName(), man.getLastName());

        woman.deregisterPartnership(false);

        softAssert.assertNull(woman.getPartner());
        softAssert.assertNull(man.getPartner());
        softAssert.assertEquals(woman.getLastName(), woman.getLastName());

    }

}
