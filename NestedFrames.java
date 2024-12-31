package firstauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // 1. Open the URL
            driver.get("http://the-internet.herokuapp.com/nested_frames");

            // Switch to top frame
            driver.switchTo().frame("frame-top");

            // Switch to left frame and verify text
            driver.switchTo().frame("frame-left");
            String leftText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Left Frame Text: " + leftText);
            driver.switchTo().parentFrame();

            // Switch to middle frame and verify text
            driver.switchTo().frame("frame-middle");
            String middleText = driver.findElement(By.id("content")).getText();
            System.out.println("Middle Frame Text: " + middleText);
            driver.switchTo().parentFrame();

            // Switch to right frame and verify text
            driver.switchTo().frame("frame-right");
            String rightText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Right Frame Text: " + rightText);
            driver.switchTo().parentFrame();

            // Switch to bottom frame
            driver.switchTo().defaultContent(); // Return to the main page
            driver.switchTo().frame("frame-bottom");
            String bottomText = driver.findElement(By.tagName("body")).getText();
            System.out.println("Bottom Frame Text: " + bottomText);

            // Verify title
            String pageTitle = driver.getTitle();
            if (pageTitle.equals("Frames")) {
                System.out.println("Page title verified: Frames.");
            } else {
                System.out.println("Page title verification failed!");
            }

        } finally {
            // Close the browser
            driver.quit();
        }
	}

}
