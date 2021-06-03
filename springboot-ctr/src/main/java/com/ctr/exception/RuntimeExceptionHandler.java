package com.ctr.exception;

import com.ctr.enums.ResponseEnum;
import com.ctr.vo.ResponseVo;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

import static com.ctr.enums.ResponseEnum.ERROR;

@ControllerAdvice
public class RuntimeExceptionHandler {
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
////	@ResponseStatus(HttpStatus.FORBIDDEN)
//    public ResponseVo handle(RuntimeException e) {
//        return ResponseVo.error(ERROR, e.getMessage());
//    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public ResponseVo userLoginHandle(){
        return ResponseVo.error(ResponseEnum.NO_LOGIN);
    }
    // 统一表单验证
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseVo notValidExceptionHandle(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        return ResponseVo.error(ResponseEnum.PARAM_ERROR,
                Objects.requireNonNull(bindingResult.getFieldError()).getField() + " " + bindingResult.getFieldError().getDefaultMessage());
    }
}
