package firstauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

        try {
            // 1. Open browser and navigate to the URL
            driver.get("https://the-internet.herokuapp.com/windows");

            // 2. Click "Click Here" button to open a new window
            String originalWindow = driver.getWindowHandle(); // Store the current window
            driver.findElement(By.linkText("Click Here")).click();

            // 3. Switch to the new window
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }

            // 4. Verify "New Window" text is present
            String newWindowText = driver.findElement(By.tagName("h3")).getText();
            if (newWindowText.equals("New Window")) {
                System.out.println("Text Verified: New Window is displayed.");
            } else {
                System.out.println("Text Verification Failed!");
            }

            // 5. Close the new window
            driver.close();

            // 6. Switch back to the original window
            driver.switchTo().window(originalWindow);
            System.out.println("Switched back to the original window.");

        } finally {
            // 7. Close the browser
            driver.quit();
        }
	}

}
