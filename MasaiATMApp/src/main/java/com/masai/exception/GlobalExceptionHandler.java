package com.masai.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import javax.security.auth.login.LoginException;
import java.time.DateTimeException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandler(UserException se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDescription(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandler(AccountException se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDescription(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandler(BankException se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDescription(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);

    }
	

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MyErrorDetails> myMNVEHandler(MethodArgumentNotValidException me) {

        MyErrorDetails err= new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage("Validation Error");
        err.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MyErrorDetails> otherExceptionHandler(Exception se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDescription(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MyErrorDetails> notFoundExceptionHandler(NotFoundException ne, WebRequest req){

        MyErrorDetails err=new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(ne.getMessage());
        err.setDescription(req.getDescription(false));
        return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDescription(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<MyErrorDetails> dateTimeExceptionHandler(DateTimeException se, WebRequest req){

        MyErrorDetails err= new MyErrorDetails();
        err.setTime(LocalDateTime.now());
        err.setMessage(se.getMessage());
        err.setDescription(req.getDescription(false));

        return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

    }


   
}
