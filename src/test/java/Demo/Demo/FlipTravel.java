package Demo.Demo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipTravel {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static void main(String[] args) throws InterruptedException {
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait=new WebDriverWait(driver,Duration.ofSeconds(100));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://www.flipkart.in");
		
		driver.findElement(By.linkText("Travel")).click();

		String FromCity="Hyderabad";
		String ToCity="Mumbai";
		
		//Select Departure From City
		driver.findElement(By.xpath("//input[@name=\"0-departcity\"]")).click();
		
		driver.findElement(By.xpath("(//div[@class=\"_98hP1j\"]//div/div/span[text()=\"" + FromCity + "\"])[1]")).click();
	    
		//Select Arrival To City
	    driver.findElement(By.xpath("//input[@name=\"0-arrivalcity\"]")).click();
	    
	    driver.findElement(By.xpath("(//div[@class=\"_98hP1j\"]//div/div/span[text()=\"" + ToCity + "\"])[2]")).click();
	    
	    //Select Departure Date
	    dateSetter("JUNE",25,"0-datefrom");

	    //Select Return Date
	    dateSetter("OCTOBER",29,"0-dateto");
	    
	    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@class=\"v2VFa- k2khBy rOnAcM z2D4XG\"]")));
	    
	    //Thread.sleep(1000);
	    int adno=3;
	    int chno=3;
	    int inno=1;
	    
	    WebElement tc=driver.findElement(By.xpath("//input[@name='0-travellerclasscount']"));
	    tc.click();
	    
	    travelcount("increase",2,"adult");
	    travelcount("increase",3,"child");
	    travelcount("increase",1,"infant");
	    
	    //driver.quit();
	}

	public static void dateSetter(String tmonth,int tdate,String idate) throws InterruptedException {
		
		List<String> allMonths = Arrays.asList("JANUARY", "FEBRAURY", "MARCH", "APRIL", "MAY", "JUNE", 
                "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER");

		Month currentmonth=LocalDate.now().getMonth();
		
		String currentmonthstr=currentmonth.name();
		
		int x=allMonths.indexOf(currentmonthstr);

		//Date Input Box
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name=\"" + idate + "\"]"))).click();
	    
	    System.out.println("Current month is:"+currentmonth+" Current month index is:"+x);
		
		while (true) {
            System.out.println("Currently at: " + allMonths.get(x));

            // Check if we have reached the target month
            if (allMonths.get(x).equals(tmonth)) {
                System.out.println("Reached the target month: " + tmonth + " X: " + x);
                              
                break;
                
            } else {
          
            	driver.findElement(By.xpath("(//button[@class=\"R0r93E\"])[2]")).click();
                     	 
            }

            // Move to the next month (simulate circular traversal)
            x = (x + 1) % allMonths.size();  // Use modulo operator to wrap around the list
        }

		//Date
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='RYl+NW']//tr//td//button[text()=\"" + tdate + "\"]"))).click();
   	    
   	    String valx=driver.findElement(By.xpath("//input[@name=\"" + idate + "\"]")).getAttribute("value");
	    System.out.println("Date Selected is: " + valx);
	}
	
	public static void travelcount(String option, int ct, String people) {
		String ibox;
		int no;
		if (option=="increase") {
			    ibox="0 0 12 12";
	 	} else {
				ibox="0 0 12 2";
		}
		
		if(people=="adult") {
			no=1;
		} else if(people=="child") {
			no=2;
		} else {
			no=3;
		}
	
		WebElement trav=driver.findElement(By.xpath("(//*[local-name()='svg' and @viewBox=\"" + ibox + "\"]/*[local-name()='path'])[" + no + "]"));
			
	    for (int i=1;i<=ct;i++) {
	    		trav.click();
	    }
		
	}

	
}