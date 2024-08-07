package bank.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class TraceRecord {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime dateTime;
    private Long fromAccountNumber;
    private Long toAccountNumber;
    private String operation;
    private Double amount;

    public TraceRecord() {
    }

    public TraceRecord(LocalDateTime dateTime, Long fromAccountNumber, Long toAccountNumber, String operation, Double amount) {
        this.dateTime = dateTime;
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.operation = operation;
        this.amount = amount;
    }

    public TraceRecord(LocalDateTime dateTime, Long fromAccountNumber, String operation, Double amount) {
        this.dateTime = dateTime;
        this.fromAccountNumber = fromAccountNumber;
        this.operation = operation;
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Long getFromAccountNumber() {
        return fromAccountNumber;
    }

    public void setFromAccountNumber(Long fromAccountNumber) {
        this.fromAccountNumber = fromAccountNumber;
    }

    public Long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}

