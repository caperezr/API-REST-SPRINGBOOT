package org.lesnobot.apirest.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/*Excepcion personalizada de status 401*/

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorizazed extends Exception{

    public ApiUnauthorizazed(String message) {
        super(message);
    }
}
