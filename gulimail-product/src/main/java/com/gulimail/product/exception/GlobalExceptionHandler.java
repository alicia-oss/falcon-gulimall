package com.gulimail.product.exception;

import com.gulimail.common.utils.R;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice(basePackages = "com.gulimail.product.controller")
public class GlobalExceptionHandler {
  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public R handleVaildException(MethodArgumentNotValidException e){
    BindingResult result = e.getBindingResult();
    HashMap<String, String> map = new HashMap<String, String>();
    result.getFieldErrors().forEach(item -> {
      map.put(item.getField(), item.getDefaultMessage());
    });
    return R.error(400, "提交数据不合法").put("data", map);
  }
}
