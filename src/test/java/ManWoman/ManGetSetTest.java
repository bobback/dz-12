package ManWoman;

import com.bobak.people.Man;
import com.bobak.people.Woman;
import dataproviders.TestDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManGetSetTest {

        private SoftAssert softAssert;


    @BeforeMethod
        public void setUp() {
            this.softAssert = new SoftAssert();

    }

        @Test(dataProvider = "combinedData", dataProviderClass = TestDataProvider.class)
        public void testGetPartner(String manFirstName, String manLastName, int manAge, String womanFirstName, String womanLastName, int womanAge){

        Man man = new Man(manFirstName, manLastName, manAge);
            Woman woman = new Woman(womanFirstName, womanLastName, womanAge);

            softAssert.assertNull(man.getPartner());

            man.registerPartnership(woman);

            softAssert.assertEquals(man.getPartner(), woman);

            man.deregisterPartnership(false);

            softAssert.assertNull(man.getPartner());
        }

        @Test(dataProvider = "combinedData", dataProviderClass = TestDataProvider.class)
        public void testSetPartner(String manFirstName, String manLastName, int manAge, String womanFirstName, String womanLastName, int womanAge){
            Woman womanSarah = new Woman("Sarah", "Johnson", 21);

            Man man = new Man(manFirstName, manLastName, manAge);
            Woman woman = new Woman(womanFirstName, womanLastName, womanAge);

            softAssert.assertNull(man.getPartner());

            man.setPartner(woman);

            softAssert.assertEquals(man.getPartner(), woman);

            man.setPartner(womanSarah);

            softAssert.assertEquals(man.getPartner(), womanSarah);
            softAssert.assertNull(woman.getPartner());
        }
}
