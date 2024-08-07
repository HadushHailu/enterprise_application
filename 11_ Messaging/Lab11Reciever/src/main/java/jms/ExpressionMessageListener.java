package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import jms.domain.Expression;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ExpressionMessageListener {
    private double result;

    public ExpressionMessageListener(){
        this.result = 0;
    }

    public void performCalculation(String operation, int value){
        switch (operation.charAt(0)){
            case '+':
                result += value;
                break;
            case '*':
                result *= value;
                break;
            case '-':
                result -= value;
                break;
            case '/':
                result /= value;
                break;
            default:
                System.out.println("The operation is not valid!");
        }
    }
    @JmsListener(destination = "calculation")
    public void receiveMessage(final String expressionAsString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Expression expression = objectMapper.readValue(expressionAsString, Expression.class);
            System.out.println("JMS receiver received message:" + expression.getOperation()+" "+expression.getValue());
            this.performCalculation(expression.getOperation(), expression.getValue());
            System.out.println("[+] Current value of result is: " + this.result);

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + expressionAsString+" to an Expression object" + e.getMessage());
        }
     }
}

