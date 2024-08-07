package accounts.repository;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class AccountRepositoryTests {

    @Autowired
    public EntityManager entityManager;
    @Autowired
    public AccountRepository accountRepository;

    @Test
    public void whenFindByAccountHolder_thenReturnAccount(){
        // given
        Account frank = new Account("BOA123-456", 300.0, "Frank");
        entityManager.persist(frank);
        entityManager.flush();
        // when
        Account found = accountRepository.findByAccountHolder(frank.getAccountHolder());
        // then
        assertThat(found.getAccountHolder(), equalTo(frank.getAccountHolder()));
        assertThat(found.getBalance(), equalTo(frank.getBalance()));
        assertThat(found.getAccountNumber(), equalTo(frank.getAccountNumber()));
    }

}
