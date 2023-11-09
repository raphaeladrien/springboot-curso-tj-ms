package br.jus.tjms.exemplo.app.exception;

import br.jus.tjms.exemplo.infra.exception.RegisterAlreadyExists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(RegisterAlreadyExists.class)
    public ResponseEntity<RestError> capturarRegisterAlreadyExists(Exception ex) {
        return ResponseEntity.unprocessableEntity().body(new RestError(
            "00001", "Não é possível processar o seu pedido")
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity capturarRuntimeException(Exception ex) {
        return ResponseEntity.internalServerError().body(
            "Por favor, entre em contato com o suporte (67) 9123-2332"
        );
    }

    protected record RestError(String code, String message) {}
}
