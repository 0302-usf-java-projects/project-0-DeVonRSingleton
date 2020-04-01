
import static org.junit.Assert.assertEquals;
import org.junit.*;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;
import com.revature.model.Account;

public class LoginTest {
  public static Account bankAccount ;
  
  
  @Before
  public void startUp() throws DuplicateUsernameException,PasswordNotLongEnoughException, InvalidOpeningBalanceException {
  System.out.println("Starting test");
  bankAccount =  new Account("username","password","all","100.50");
  }
  
  @After
  public void closeDown() {
    bankAccount = null;
    
    System.out.println("After test");
  }
  
  @Test
  public void loginPasswordWrongTest() {
    bankAccount.authenticate("username", "passww");
   assertEquals(false, false);
  }
  
  @Test
  public void loginPasswordWrongCaseSensitiveTest() {
    bankAccount.authenticate("username", "PASSWORD");
    assertEquals(false,false);
  }
  
  @Test
  public void failLoginUsernameWrongTest() {
    bankAccount.authenticate("usernam", "password");
    assertEquals(false,false);
  }
  @Test
  public void loginUsernameWrongCaseSensitiveTest() {
    bankAccount.authenticate("USERNAME", "password");
    assertEquals(false,false);
  }
  
  

  }
