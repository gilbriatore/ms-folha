package br.edu.up.folha;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class FuncionarioNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(FuncionarioNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String employeeNotFoundHandler(FuncionarioNotFoundException ex) {
    return ex.getMessage();
  }
}