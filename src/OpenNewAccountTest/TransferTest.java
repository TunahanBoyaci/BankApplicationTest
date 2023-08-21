package OpenNewAccountTest;

import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferTest extends ParameterDriver {
    @Test
    public void test3(){
        MyMethods.myWait(2);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        MyMethods.myWait(2);
        WebElement usernameInbox = driver.findElement(By.cssSelector("input[name='username']"));
        usernameInbox.sendKeys("john89");

        WebElement passwordInbox = driver.findElement(By.cssSelector("input[name='password']"));
        passwordInbox.sendKeys("789456John.");

        WebElement registerButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        registerButton.click();

        WebElement fundsButton = driver.findElement(By.linkText("Transfer Funds"));
        fundsButton.click();

        MyMethods.myWait(1);
        WebElement amountInbox = driver.findElement(By.cssSelector("input[id='amount']"));
        amountInbox.sendKeys("100");

        WebElement fromSelect = driver.findElement(By.cssSelector("select[id='fromAccountId']"));
        Select select5 = new Select(fromSelect);
        select5.selectByValue("14454");

        WebElement toSelect = driver.findElement(By.cssSelector("select[id='toAccountId']"));
        Select select6 = new Select(toSelect);
        select6.selectByValue("14454");

        WebElement transferButton = driver.findElement(By.cssSelector("input[value='Transfer']"));
        transferButton.click();

        WebElement transferConfirmation = driver.findElement(By.xpath("//h1[text()='Transfer Complete!']"));
        Assert.assertTrue(transferConfirmation.getText().equals("Transfer Complete!"));

        waitAndQuit();
    }
}
