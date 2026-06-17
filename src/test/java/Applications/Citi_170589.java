package Applications;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseTest.Browser;

public class Citi_170589 extends Browser {
	
	
@Test	
public void Appaian_001() { 
	Select s = new Select(getDriver().findElement(By.cssSelector("#dropdown-class-example")));
	s.selectByIndex(3);
	System.out.println("Hello changed");
	System.out.println("hii hello");
}

	
	
}
