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
    
    // adiciona novos erros a nossa lista de erros
    public void addFieldMessage(String fieldName, String message) {
        // remove os erros com o mesmo nome, evita duplicidade de erros. 
        fieldMessageList.removeIf(x -> x.getFieldName().equals(fieldName));
        fieldMessageList.add(new FieldMessage(fieldName, message));
    }
}
