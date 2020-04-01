
import static org.junit.Assert.assertEquals;
import org.junit.*;
import com.revature.exception.DuplicateUsernameException;
import com.revature.exception.InvalidBalanceException;
import com.revature.exception.InvalidOpeningBalanceException;
import com.revature.exception.PasswordNotLongEnoughException;
import com.revature.model.Account;
import static com.revature.service.AccountFunctionality.*;

public class WithdrawalTest {

  public static Account withdrawal;
  
  @Before
  public void startUp( ) throws DuplicateUsernameException, PasswordNotLongEnoughException,InvalidOpeningBalanceException{
    withdrawal = new Account("username","password","all","100.50");
   }
  
  @After
  public void closing() {
    withdrawal = null;
  }
  
  @Test
  public void withdrawalOfFiftyDollarsRemainingBalanceFifty() throws InvalidBalanceException {
  withdrawal(50.50);
    assertEquals("50.0", "50.0");
    }
  
  @Test 
  public void withdrawalOfSeventyFiveAndTwentyFiveCentTest() throws InvalidBalanceException {
    withdrawal(75.25);
    assertEquals("25.25", "25.25");
  }

 @Test
 public void withdrawalOfHundrendAndThirtyThreeDollarsTest() throws InvalidBalanceException{
  withdrawal(100.33);
  assertEquals(".17",".17");
 }
 
 
 @Test(expected = InvalidBalanceException.class)
 public void invalidBalanceWhenWithdrawing()throws InvalidBalanceException{
  withdrawal(200.00);
 }
 
}
