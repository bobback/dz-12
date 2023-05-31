package dataproviders;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "menData")
    public static Object[][] menData(){
        return new Object[][]{
                {"Jonas", "Kahnwald", 23},
                {"Ulrich", "Nielsen", 25},
                {"Helge", "Doppler", 67}
        };
    }

    @DataProvider(name = "womenData")
    public static Object[][] womenData(){
        return new Object[][]{
                {"Regina", "Tiedemann", 21},
                {"Helene", "Albers", 29},
                {"Hannah", "Stone", 75}
        };
    }

    @DataProvider(name = "combinedData")
    public static Object[][] combinedData(){
        Object[][] men = menData();
        Object[][] women = womenData();

        int menLength = men.length;
        int womenLength = women.length;

        Object[][] combined = new Object[menLength * womenLength][6];
        int index = 0;

        for (Object[] menRow : men) {
            for (Object[] womenRow : women) {
                combined[index][0] = menRow[0]; // manFirstName
                combined[index][1] = menRow[1]; // manLastName
                combined[index][2] = menRow[2]; // manAge
                combined[index][3] = womenRow[0]; // womanFirstName
                combined[index][4] = womenRow[1]; // womanLastName
                combined[index][5] = womenRow[2]; // womanAge
                index++;
            }
        }

        return combined;
    }

}
