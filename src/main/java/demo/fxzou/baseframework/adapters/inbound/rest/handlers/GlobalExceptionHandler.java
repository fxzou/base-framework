package demo.fxzou.baseframework.adapters.inbound.rest.handlers;

import demo.fxzou.baseframework.domain.core.common.excpetions.DomainException;
import demo.fxzou.baseframework.domain.core.common.excpetions.EntityExistedException;
import demo.fxzou.baseframework.domain.core.common.excpetions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        return handleDomainException(ex, NOT_FOUND);
    }

    @ExceptionHandler({EntityExistedException.class})
    public ResponseEntity<Object> handleEntityExistedException(EntityExistedException ex) {
        return handleDomainException(ex, CONFLICT);
    }

    private ResponseEntity<Object> handleDomainException(DomainException ex, HttpStatus conflict) {
        return new ResponseEntity<>(Map.of("message", ex.getMessage()), new HttpHeaders(), conflict);
    }
}
