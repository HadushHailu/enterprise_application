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
    private String accountNumber;
    private String operation;
    private Double amount;

    public TraceRecord() {
    }

    public TraceRecord(LocalDateTime dateTime, String accountNumber, String operation, Double amount) {
        this.dateTime = dateTime;
        this.accountNumber = accountNumber;
        this.operation = operation;
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

