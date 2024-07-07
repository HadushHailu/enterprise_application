package bank.repositories;



import org.antlr.v4.runtime.misc.ObjectEqualityComparator;
import org.springframework.data.jpa.repository.JpaRepository;
import bank.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    default void saveCustomer(Customer customer) {
        throw new RuntimeException("could not save customer");
//        save(customer);
    }

//    @Override
//    default Object save(Customer customer) {
//        throw new RuntimeException("could not save customer");
////        save(customer);
//    }
}




