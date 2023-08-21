package OpenNewAccountTest;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import Utilities.ParameterDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegisterNewAccountTest extends ParameterDriver {
    @Test
    public void test1(){
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        WebElement registerButton = driver.findElement(By.xpath("//a[text()='Register']"));
        registerButton.click();

        MyMethods.myWait(1);

        WebElement firstNameInbox = driver.findElement(By.cssSelector("input[id='customer.firstName']"));
        firstNameInbox.sendKeys("John");

        WebElement lastNameInbox = driver.findElement(By.cssSelector("input[id='customer.lastName']"));
        lastNameInbox.sendKeys("Smith");

        WebElement addresInbox = driver.findElement(By.cssSelector("input[id='customer.address.street']"));
        addresInbox.sendKeys("269 W 12th");

        WebElement cityInbox = driver.findElement(By.cssSelector("input[id='customer.address.city']"));
        cityInbox.sendKeys("New York");

        WebElement stateInbox = driver.findElement(By.cssSelector("input[id='customer.address.state']"));
        stateInbox.sendKeys("New York");

        WebElement zipcodeInbox = driver.findElement(By.cssSelector("input[id='customer.address.zipCode']"));
        zipcodeInbox.sendKeys("10011");

        WebElement phoneInbox = driver.findElement(By.cssSelector("input[id='customer.phoneNumber']"));
        String phoneNumber = MyMethods.generateRandomPhoneNumber();
        phoneInbox.sendKeys(phoneNumber);

        WebElement ssnInbox = driver.findElement(By.cssSelector("input[id='customer.ssn']"));
        ssnInbox.sendKeys("789456121");

        WebElement userNameInbox = driver.findElement(By.cssSelector("input[id='customer.username']"));
        userNameInbox.sendKeys("john89");

        WebElement passwordInbox = driver.findElement(By.cssSelector("input[id='customer.password']"));
        passwordInbox.sendKeys("789456John.");

        WebElement repasswordInbox = driver.findElement(By.cssSelector("input[id='repeatedPassword']"));
        repasswordInbox.sendKeys("789456John.");

        WebElement registerButton2 = driver.findElement(By.cssSelector("input[value='Register']"));
        registerButton2.click();
    }
}
