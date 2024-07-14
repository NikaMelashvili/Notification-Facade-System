package com.melashvili.userend.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SmsRequestDTO {
    private String to;
    private String message;
}
