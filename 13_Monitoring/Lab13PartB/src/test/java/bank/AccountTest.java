package bank;

import bank.domain.Account;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AccountTest {
    @Test
    public void testDeposit(){
        Account account = new Account();
        account.deposit(100.0);
        assertThat( account.getBalance(), closeTo (100.0, 0.01));
    }

    @Test
    public void testWithdraw(){
        Account account =  new Account();
        account.withdraw(100.0);
        assertThat(account.getBalance(), closeTo(-100.0, 0.01));
    }

//    @Test
//    public void testTransferPositive(){
//        Account fromAccount =  new Account();
//        Account toAccount = new Account();
//        fromAccount.transferFunds(toAccount, 100.0, "");
//        assertThat(fromAccount.getBalance(), closeTo(-100.0, 0.01));
//        assertThat(toAccount.getBalance(), closeTo(100.0, 0.01));
//    }

}
