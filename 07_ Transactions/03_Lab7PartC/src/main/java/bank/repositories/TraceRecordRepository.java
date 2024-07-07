package bank.repositories;

import bank.domain.TraceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TraceRecordRepository extends JpaRepository<TraceRecord, Long> {
    @Transactional
    default void saveCustomer(TraceRecord traceRecord) {
        save(traceRecord);
    }
}
