package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private String log;

    public TraceRecord(Date date, String log) {
        this.date = date;
        this.log = log;
    }

    public TraceRecord() {
    }
}
