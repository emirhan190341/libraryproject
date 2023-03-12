package com.emirhanarici.Library.exception;

import com.emirhanarici.Library.entity.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericException extends RuntimeException {

    private HttpStatus httpStatus;
    private ErrorCode errorCode;
}
