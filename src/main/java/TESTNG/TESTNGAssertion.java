package TESTNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TESTNGAssertion {
    // CREATE PNE METHOD THAT TAKES TWO PARAMETER AND
    //RETURN MULTIPLICATION OF THESE NUMBER
    public double getMULTI(double a ,double b){

        return a*b;
    }
    @Test
    public void validateMULTIplication(){
        double Actualresult=getMULTI(5,6);
    double Expected=30;
    Assert.assertEquals(Actualresult,Expected,"My number are 5 and 6");

    }
    public double getDivision(double number1 ,double number2){
        if(number1>=number2){
            return number1/number2;
        }return number2/number1;
    }

    public int substraction(int number1,int number2){
        if(number1>=number2){
            return number1-number2;
        }return number2-number1;
    }

    @Test
    public  void validatedivision(){
        double actualresult=getDivision(8,2);
        double expectedresult=4;
        Assert.assertEquals(actualresult,expectedresult);

    }
    @Test
    public void validatesubstraction(){
        int actualresult=substraction(64,43);
        int expectedResult=21;
        Assert.assertEquals(actualresult,expectedResult);
        double actualResultofDivision=getDivision(6,3);
        double expectedResultofDivision=2;
        Assert.assertEquals(actualResultofDivision,expectedResultofDivision);

    }




}
