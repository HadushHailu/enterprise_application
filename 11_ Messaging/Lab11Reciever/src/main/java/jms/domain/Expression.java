package jms.domain;

public class Expression {
    private String operation;
    private int value;

    public Expression() {
    }

    public Expression(String operation, int value) {
        this.operation = operation;
        this.value = value;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
