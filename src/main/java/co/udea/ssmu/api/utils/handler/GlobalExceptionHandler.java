package co.udea.ssmu.api.utils.handler;

import co.udea.ssmu.api.utils.common.StandardResponse;
import co.udea.ssmu.api.utils.exception.DataDuplicatedException;
import co.udea.ssmu.api.utils.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<?> handleDataNotFoundException(DataNotFoundException ex) {
        return new ResponseEntity<>(new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(DataDuplicatedException.class)
    protected ResponseEntity<?> handleDataDuplicatedException(DataDuplicatedException ex) {
        return new ResponseEntity<>(new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ResponseEntity<>(new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Throwable.class)
    protected ResponseEntity<?> handleThrowable(Throwable ex) {
        return new ResponseEntity<>(new StandardResponse<>(StandardResponse.StatusStandardResponse.ERROR, "No se ha podido procesar su solicitud. Contacte al administrdor."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
