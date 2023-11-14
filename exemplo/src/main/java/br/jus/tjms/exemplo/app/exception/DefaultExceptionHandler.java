package br.jus.tjms.exemplo.app.exception;

import br.jus.tjms.exemplo.infra.exception.RegisterAlreadyExists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ExceptionHandler(RegisterAlreadyExists.class)
    public ResponseEntity<RestError> capturarRegisterAlreadyExists(Exception ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.unprocessableEntity().body(new RestError(
            "00001", "Não é possível processar o seu pedido")
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestError> capturarMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(), ex);
        String texto = ex.getBindingResult().getFieldError() == null ? "Texto" : ex.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseEntity.badRequest().body(new RestError(
            "00002", texto)
        );
    }

    protected record RestError(String code, String message) {}
}
