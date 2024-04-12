package com.devsuperior.dscommerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomErrorDTO{
    private List<FieldMessage> fieldMessageList = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getFieldMessageList() {
        return fieldMessageList;
    }
    
    public void addFieldMessage(String fieldName, String message) {
        fieldMessageList.add(new FieldMessage(fieldName, message));
    }
}
