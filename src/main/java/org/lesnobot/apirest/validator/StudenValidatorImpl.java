package org.lesnobot.apirest.validator;

import org.lesnobot.apirest.dto.StudenRequest;
import org.lesnobot.apirest.utils.exceptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

@Component
public class StudenValidatorImpl implements StudenValidator{
    @Override
    public void validator(StudenRequest request) throws ApiUnprocessableEntity {
        if (request.getFname() == null || request.getFname().isEmpty()) {
            this.message("El nombre es obligatorio");
        }
        if (request.getFname().length() < 3) {
            this.message("El nombre es muy corto debe tener mínimo 3 caracteres");
        }
        if (request.getLname() == null || request.getLname().isEmpty()) {
            this.message("El apellido es obligatorio");
        }
        if (request.getLname().length() < 3) {
            this.message("El apellido es muy corto debe tener mínimo 3 caracteres");
        }
        if (request.getUsername() == null || request.getUsername().isEmpty()) {
            this.message("El nombre de usuario es obligatorio");
        }
        if (request.getUsername().length() < 6) {
            this.message("El nombre de usuario es muy corto debe tener mínimo 3 caracteres");
        }
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            this.message("La contraseña es obligatoria");
        }
        if (request.getPassword().length() < 6) {
            this.message("El contraseña es muy corta minimo es 6 caracteres");
        }
    }

    private void message(String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
