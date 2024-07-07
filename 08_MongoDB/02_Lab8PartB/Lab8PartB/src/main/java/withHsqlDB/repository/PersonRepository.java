package withHsqlDB.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import withHsqlDB.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
