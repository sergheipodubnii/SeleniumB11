package TESTNG;

import org.testng.annotations.DataProvider;

public class DataForNames {
    @DataProvider(name="FullNameTest")

    public Object[][] getData(){
        return new Object[][]{
                {"ahmet","baldir","ahmet baldir"},
                {"serg","serghei","serg serghei"},
                {"eric","eric2","eric eric2"},
                {"eric1","eric3","eric1 eric3"},
                {"ivan","ivanova","ivan ivanova"},
                {"george","serghei","george serghei"}

        };
    }
}
