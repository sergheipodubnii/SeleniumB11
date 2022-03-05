package homework.homework5.tests;

import homework.homework5.TestBaseHomework;
import homework.homework5.pages.MainPageAudi;
import homework.homework5.pages.Task2;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2Test extends TestBaseHomework {
    @Test
            public void task2test() throws InterruptedException {
        MainPageAudi AUDI = new MainPageAudi(driver);
        AUDI.mainpagesearch();
        Task2 object=new Task2(driver);
        object.validationtask2();
       // Assert.assertEquals(object.validationmsrp(),43300);
        //Assert.assertEquals(object.validateadditionaloptions(),595);
        //Assert.assertEquals(object.validatedestinationscharge(),1195);
        //Assert.assertEquals(object.validatetotalprice(),45090);
        object.closemsrp();

    }
}
