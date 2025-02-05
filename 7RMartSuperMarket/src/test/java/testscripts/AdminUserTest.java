package testscripts;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.AdminUserPage;
import pages.LoginPage;

public class AdminUserTest extends BaseClass
{
	AdminUserPage adminuserpage;
	
  @Test(priority = 1)
  public void createNewUser() 
  {
	  LoginPage loginpage=new LoginPage(driver);
	 
	  loginpage.enterCorrectUsernameandIncorrectpassword("admin", "1234");
	  loginpage.enterIncorrectUsernameandCorrectpassword("123", "admin");
	  loginpage.enterIncorrectUsernameandpassword("123", "123");
	  loginpage.entercorrectUsernamePassword("admin", "admin");
	  
	  adminuserpage=new AdminUserPage(driver);
	  adminuserpage.enterNewUsernameandpassword("Reshma", "reshma");
	 
	  boolean testAlert=adminuserpage.isexistingalertshowing();
	  Assert.assertTrue(testAlert);

  }
  @Test(priority = 2)
  public void searchuser()
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.entercorrectUsernamePassword("admin", "admin");
	  
	  adminuserpage=new AdminUserPage(driver);
	  adminuserpage.searchUser("reshma");
	  adminuserpage.resetContact();

 }
  /*@Test(priority = 3)
  public void contactReset()
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.entercorrectUsernamePassword("admin", "admin");
	  
	  adminuserpage=new AdminUserPage(driver);
	  adminuserpage.resetContact();

  }*/
  @Test(priority = 4)
  public void manageNewsAdd()
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.entercorrectUsernamePassword("admin", "admin");
	  adminuserpage=new AdminUserPage(driver);
      adminuserpage.addNews("Wildlife Conservation");
	  
      boolean testaddmsgalert=adminuserpage.isaddmsgalertshowing();
      Assert.assertTrue(testaddmsgalert, "Message not added");
  }
  @Test(priority = 5)
  public void manageNewsSearch()
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.entercorrectUsernamePassword("admin", "admin");
	  adminuserpage=new AdminUserPage(driver);

	  adminuserpage.searchNews("Athirapilly elephant rescue");
  }
  @Test(priority = 6)
  public void manageNewsReset()
  {
	  LoginPage loginpage=new LoginPage(driver);
	  loginpage.entercorrectUsernamePassword("admin", "admin");
	  adminuserpage=new AdminUserPage(driver);

	  adminuserpage.newsReset();
  }

}
