//package com.gestorturnos.gestor.exception;
//
//import com.gestorturnos.gestor.dto.ErrorDto;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class ErrorRestExceptionHandler {
//
//    @ExceptionHandler
//    public ResponseEntity<ErrorDto> usuarioNotFound (UsuarioException exc){
//
//        ErrorDto error = new ErrorDto();
//        error.setMsg(exc.getMessage() + " Usuario no encontrado.");
//        error.setStatus(400);
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<ErrorDto> clienteNotFound (UsuarioException exc){
//
//        ErrorDto error = new ErrorDto();
//        error.setMsg(exc.getMessage() + " Cliente no encontrado.");
//        error.setStatus(400);
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<ErrorDto> turnoNotFound (UsuarioException exc){
//
//        ErrorDto error = new ErrorDto();
//        error.setMsg(exc.getMessage() + " Turno no encontrado.");
//        error.setStatus(400);
//
//        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
//
//    }
//}
