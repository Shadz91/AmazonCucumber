/*package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class Hi {

	public static boolean main(String[] args) {
		
		boolean retryingFindClick() {
			
		    boolean result = false;
		    int attempts = 0;
		    WebDriver driver;
		    
		    while(attempts < 2) {
		       
		    	try {
		            driver.findElement(by).click();
		            result = true;
		            break;
		        } catch(StaleElementReferenceException e) {
		        }
		    	
		        attempts++;
		        
		    }
		    return result;
		    
		}

	}

}
*/