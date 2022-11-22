package testsuite;

import Utility.Utility;
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends Utility {

    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }


    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials() {
//* Enter “tomsmith” username
        sendTextToElement(By.xpath("//input[@id='username']"), "tomsmith");
//* Enter “SuperSecretPassword!” password
        sendTextToElement(By.xpath("//input[@id='password']"), "SuperSecretPassword!");
        //* Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[normalize-space()='Login']")).click();
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
        driver.findElement(By.xpath("//a[@class='close']"));

        //Verifying
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        String actualText = verifyText(By.xpath("//div[@id='flash']"));
        Assert.assertEquals( expectedMessage, actualText);
//
    }

    @After
    public void close() {

    }

}
