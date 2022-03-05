package homework.homework5.tests;

import homework.homework5.TestBaseHomework;
import homework.homework5.pages.MainPageAudi;
import homework.homework5.pages.Task1;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1Test extends TestBaseHomework {
    @Test
    public void validationtask1() throws InterruptedException {
        MainPageAudi mainPageAudi=new MainPageAudi(driver);
        mainPageAudi.mainpagesearch();
        Task1 object=new Task1(driver);
        object.task1validation("2022 Audi Q5","$ 43,300","$ 48,300","$ 54,000");


    }
}
