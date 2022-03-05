package TESTNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
   /* @DataProvider(name="FullNameTest")

    public Object[][] getData(){
        return new Object[][]{
                {"ahmet","baldir","ahmet baldir"},
                {"serg","serghei","serg serghei"},
                {"eric","eric2","eric eric2"},
                {"eric1","eric3","eric1 eric3"},
                {"ivan","ivanova","ivan ivanova"},
                {"george","serghei","george serghei"}

        };
    }*/


    @Test (dataProvider ="FullNameTest",dataProviderClass = DataForNames.class)
    public void test1(String username,String lastname,String expectedfullName ){
       String userName=username;
        String lastName=lastname;
        String fullName=userName+" "+lastName;
                Assert.assertEquals(fullName,expectedfullName);

    }








}
