package dev.jonatancalzadodiaz.membersbackend;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@SuperBuilder
public class HttpResponse {

    protected  String timeStamp;
    protected Integer statusCode;
    protected HttpStatus status;
    protected  String message;
    protected Map<?, ?> data;

}
