package com.abhiraj.module2.advices;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
@JsonPropertyOrder({ "status", "message", "subErrors" })
public class ApiError {

    public HttpStatus status;

    public String message;

    public List<String> subErrors;
}
