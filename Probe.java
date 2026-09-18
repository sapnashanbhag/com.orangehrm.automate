import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class Probe {
  public static void main(String[] args) {
    ChromeOptions opt = new ChromeOptions();
    opt.addArguments("--headless=new");
    opt.addArguments("--window-size=1440,1200");
    WebDriver d = new ChromeDriver(opt);
    try {
      d.get("https://opensource-demo.orangehrmlive.com");
      d.findElement(By.name("username")).sendKeys("Admin");
      d.findElement(By.name("password")).sendKeys("admin123");
      d.findElement(By.xpath("//button[@type='submit']")).click();
      WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Admin']")));
      d.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
      Thread.sleep(1500);
      System.out.println("URL=" + d.getCurrentUrl());
      System.out.println("Admin header present=" + d.findElements(By.xpath("//h6[normalize-space()='Admin']")).size());
      System.out.println("Job span count=" + d.findElements(By.xpath("//span[normalize-space()='Job']")).size());
      for (int i=0;i<d.findElements(By.xpath("//span[normalize-space()='Job']")).size();i++) {
        WebElement e = d.findElements(By.xpath("//span[normalize-space()='Job']")).get(i);
        System.out.println("JOB span " + i + ": text='" + e.getText() + "' displayed=" + e.isDisplayed() + " tag=" + e.getTagName());
      }
      System.out.println("Job link count=" + d.findElements(By.xpath("//a[normalize-space()='Job Titles']")).size());
      for (int i=0;i<d.findElements(By.xpath("//a[normalize-space()='Job Titles']")).size();i++) {
        WebElement e = d.findElements(By.xpath("//a[normalize-space()='Job Titles']")).get(i);
        System.out.println("JOBTITLE anchor " + i + ": text='" + e.getText() + "' displayed=" + e.isDisplayed());
      }
      String page = d.getPageSource();
      int idx = page.indexOf("Admin");
      System.out.println("SNIPPET:\n" + page.substring(Math.max(0, idx-200), Math.min(page.length(), idx+1200)));
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      d.quit();
    }
  }
}