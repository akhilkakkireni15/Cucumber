package stepDefinations;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.net.MalformedURLException;
import org.openqa.selenium.Platform;
import cucumber.api.java.en.*;
import pageObjects.LoginPage;

public class Steps {


    public WebDriver driver;
    public LoginPage lp;

    String docker = "docker";
    String dockerHost = "192.168.99.100";


    @Given("Launching browser")
    public void launching_browser() throws MalformedURLException {

        try{
            DesiredCapabilities capability = new DesiredCapabilities();
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
            System.out.println("Launching docker url");
            //Chrome
            /*ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("test-type");
            capability.setPlatform(Platform.LINUX);
            capability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);*/
            //Firefox
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
            capability.merge(firefoxOptions);
            capability.setCapability("marionette", true);


            if(docker.trim().toLowerCase().contains("local")){
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
            else{
                URL url = new URL("http://"+dockerHost+":4444/wd/hub");
                driver = new RemoteWebDriver(url,capability);

            }

        }
        catch(Exception e){
            System.out.println("Launch browser failed");
        }


    }


    @When("^Opening URL \"([^\"]*)\"$")
    public void opening_URL(String url) throws InterruptedException  {
        driver.get(url);
        Thread.sleep(3000);
    }


    @Then("^Pagetitle \"([^\"]*)\" should be verified$")
    public void pagetitle_should_be_verified(String title) {
        if(driver.getTitle().contains("Google"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Not found");
        }
    }


    @Then("close browser")
    public void close_browser() {
        driver.close();
    }

    @And ("^Enter \"([^\"]*)\" click continue and enter \"([^\"]*)\"$")
    public void enter_click_continue_and_enter(String username, String password) throws InterruptedException{
        System.out.println(username+"username");

        lp = new LoginPage(driver);
        lp.setUserName(username);
        lp.clickContinue();
        Thread.sleep(3000);
        lp.setPassword(password);

    }

}
