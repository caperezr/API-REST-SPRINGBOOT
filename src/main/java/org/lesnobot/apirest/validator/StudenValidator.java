package org.lesnobot.apirest.validator;

import org.lesnobot.apirest.dto.StudenRequest;
import org.lesnobot.apirest.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;
/*Interface para la validacion de los datos recibidos para la creación de estudiantes*/
@Service
public interface StudenValidator {

    void validator(StudenRequest request) throws ApiUnprocessableEntity;
}
