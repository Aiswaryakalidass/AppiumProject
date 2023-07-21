import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    private AndroidDriver driver;

    @Before
    public void setUp() {
        // Set up desired capabilities for the Appium driver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 API 30");
        capabilities.setCapability("appium:appPackage", "com.sehc.fls.uat");
        capabilities.setCapability("appium:appActivity", "com.sehc.fls.MainActivity");

        // Create AndroidDriver instance
        String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        try {
            URL url = new URL(URL_STRING);
            driver = new AndroidDriver(url, capabilities);

            // Set implicit wait and other configurations
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // Handle the exception as needed (e.g., fail the test or throw an exception)
        }
    }

    @Test
   
    public void Login() throws Throwable {
        // Example: Find an element by ID and send keys
   Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@text='Login']")).click();
    }
    

    @After
    public void tearDown() {
        // Close the driver and quit the Appium session
        if (driver != null) {
            driver.quit();
        }
    }
}
