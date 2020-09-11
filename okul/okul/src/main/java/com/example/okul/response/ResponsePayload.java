package com.example.okul.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Payload;
import java.time.ZonedDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePayload implements Payload {
    private ZonedDateTime timestamp;
    private String message;
    private Object data;

    public ResponsePayload(ZonedDateTime timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }
}
