package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage 
{
	WebDriver driver;
	
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//Search
	@FindBy(xpath="//*[text()=' Search']") WebElement btnSearch;
	@FindBy(xpath="//input[@class='form-control'][@id='un']") WebElement txt_existinguser;
	@FindBy(xpath="//select[@id='ut']") WebElement drp_existingusertype;
	@FindBy(xpath="//button[@name='Search']") WebElement btn_searchsave;
	
	//Add new admin
	@FindBy(xpath="(//a[@class='small-box-footer'])[1]") WebElement moreinfo;
	@FindBy(xpath="//*[text()=' New']") WebElement btn_Newuser;
	@FindBy(id="username") WebElement txt_newusername;
	@FindBy(id="password") WebElement txt_password;
	@FindBy(id="user_type")WebElement drpdwn_usertype;
	
	@FindBy(name="Create") WebElement btn_save;
	@FindBy(xpath="//*[text()=' Reset']") WebElement btn_mainReset;
	
	public void enterNewUsernameandpassword(String username,String password)
	{
		moreinfo.click();
		btn_Newuser.click();
		txt_newusername.sendKeys(username);
		txt_password.sendKeys(password);
		Select select=new Select(drpdwn_usertype);
		select.selectByVisibleText("Staff");
		btn_save.click();
		//return new LoginPage(driver);
	}
	
	//search
	public void searchUser(String username)
	{
		//moreinfo.click();
		btnSearch.click();
		txt_existinguser.sendKeys(username);
		Select select=new Select(drp_existingusertype);
		select.selectByVisibleText("Admin");
		btn_searchsave.click();
	}
	
	//Reset
	public void resetContact()
	{
		btn_mainReset.click();
	}
	
	//ManageNews
	@FindBy(xpath="(//*[text()='Manage News'])[1]") WebElement click_managenews;
	
	@FindBy(xpath="//*[text()=' New']") WebElement btn_addnewNews;
	@FindBy(xpath="//*[@id='news']") WebElement txt_addnewnews;
	@FindBy(xpath="//*[@name='create']")WebElement btn_saveNews;

	
	@FindBy(xpath="//*[text()=' Search']")WebElement btn_searchNews;
	@FindBy(xpath="//*[@class='col-sm-12 form-group']") WebElement input_newssearch;
	@FindBy(xpath="//*[@name='Search']")WebElement btn_search;
	
	@FindBy(xpath="//*[text()=' Reset']")WebElement btn_resetNews;
	
	public void addNews(String addnews)
	{
		click_managenews.click();
		btn_addnewNews.click();
		txt_addnewnews.sendKeys(addnews);
		btn_saveNews.click();
	}
	public void searchNews(String searchnews)
	{
		click_managenews.click();

		btn_searchNews.click();
		JavascriptExecutor js=(JavascriptExecutor) driver;

		js.executeScript("arguments[0].value='Wildlife';", input_newssearch);
		//input_newssearch.sendKeys(searchnews);
		btn_search.click();
		//btn_resetNews.click();

	}
	public void newsReset()
	{
		click_managenews.click();

		btn_resetNews.click();
	}
	
	

	//for assertion of add user that already exists
	@FindBy(xpath="//*[text()=' Alert!']") WebElement alert_existinguser;
	public boolean isexistingalertshowing()
	{
		return alert_existinguser.isDisplayed() ;
	}
	
	//Assertion for search contact
	@FindBy(xpath="//*[@class='table table-bordered table-hover table-sm']") WebElement userTable;
	public boolean methodforTable(String value)
	{
		List<WebElement> rows = userTable.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]"));
		for (WebElement row : rows) {
			if (row.getText().contains(value)) {
				return true; // Value found
			}
		}
	}
	
	//Assertion for news created
	@FindBy(xpath="//div[@class='col-sm-12']") WebElement alrt_Messageadded;
	public boolean isaddmsgalertshowing()
	{
		return alrt_Messageadded.isDisplayed();
	}
}

