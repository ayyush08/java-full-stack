package com.expense_service.consumer;

import com.expense_service.Dto.ExpenseDto;
import org.apache.kafka.common.serialization.Deserializer;
import tools.jackson.databind.ObjectMapper;

import java.util.Map;

public class ExpenseDeserializer implements Deserializer {


    @Override
    public ExpenseDto deserialize(String topic, byte[] data) {
        ObjectMapper objectMapper = new ObjectMapper();

        ExpenseDto expenseDto = null;

        try {
            expenseDto = objectMapper.readValue(topic, ExpenseDto.class);

        }
        catch (Exception e) {
            System.out.println("Error deserializing ExpenseDto");
            e.printStackTrace();
        }
        return expenseDto;
    }

}
