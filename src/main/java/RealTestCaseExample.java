import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealTestCaseExample {
    ////  Test Case - Open Godaddy.com and validate it's Page title and the url.
    ////    Steps to Automate:
    ////            1. Launch browser of your choice say., Firefox, chrome etc.
    ////            2. Open this URL - https://www.godaddy.com/
    ////            3. Maximize or set size of browser window.
    ////4. Get Title of page and validate it.
    ////4. Get URL of current page and validate it.
    ////            5. Close browser.


    public static void main(String[] args) {




        WebDriver driver = new ChromeDriver();
        driver.get("https://www.godaddy.com/");
        driver.manage().window().maximize();

        String title1=driver.getTitle();

        System.out.println(title1);
        String actual="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if(title1.equals(actual)){
            System.out.println("Passed");
        }else{
            System.out.println("not passed");
        }
        String URL1=driver.getCurrentUrl();
        String url2="https://www.godaddy.com/";
        if(URL1.equals(url2)){
            System.out.println("passed");
        }else{
            System.out.println("not passed");
        }

        driver.close();







    }


}
