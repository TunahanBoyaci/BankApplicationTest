package OpenNewAccountTest;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utilities.BaseDriver.driver;

public class OpenNewAccountTest extends ParameterDriver {
    @Test
    public void test2(){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        MyMethods.myWait(2);
        WebElement usernameInbox = driver.findElement(By.cssSelector("input[name='username']"));
        usernameInbox.sendKeys("john89");

        WebElement passwordInbox = driver.findElement(By.cssSelector("input[name='password']"));
        passwordInbox.sendKeys("789456John.");

        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        registerButton.click();

        WebElement openButton = driver.findElement(By.linkText("Open New Account"));
        openButton.click();

        MyMethods.myWait(1);
        WebElement accountTypeSelect = driver.findElement(By.cssSelector("select[id='type']"));
        Select select = new Select(accountTypeSelect);
        select.selectByValue("0");

        WebElement accountIDSelect = driver.findElement(By.cssSelector("select[id='fromAccountId']"));
        Select select2 = new Select(accountIDSelect);
        select2.selectByValue("20337");

        WebElement openButton3 = driver.findElement(By.cssSelector("input[value='Open New Account']"));
        openButton3.click();

        MyMethods.myWait(1);
        WebElement newAccountLink = driver.findElement(By.cssSelector("a[id='newAccountId']"));
        String newAccountNo = newAccountLink.getText();

        WebElement accountConfirmation = driver.findElement(By.xpath("//h1[text()='Account Opened!']"));

        Assert.assertTrue(accountConfirmation.getText().equals("Account Opened!"));

        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log Out']"));
        logoutButton.click();
    }
}
