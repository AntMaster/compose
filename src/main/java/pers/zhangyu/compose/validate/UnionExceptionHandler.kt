package pers.zhangyu.compose.validate

import lombok.extern.slf4j.Slf4j
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.stream.Collectors.*

@Slf4j
@ResponseBody
@RestControllerAdvice
class UnionExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun validExceptionHandler(e: MethodArgumentNotValidException): String {
//        FieldError fieldError = e.getBindingResult().getFieldError();
//        assert fieldError != null;
//        log.error("校验参数不通过,field={},message={}", fieldError.getField(), fieldError.getDefaultMessage());
//        return fieldError.getDefaultMessage();
        return e.bindingResult.allErrors.stream().map { obj: ObjectError -> obj.defaultMessage }.collect(joining(";"))
    }
    /*
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public String handleValidError(HttpServletRequest req, HttpServletResponse rsp, BindException e) {
        System.out.println(rsp);
        String errorMsg = e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(";"));
        log.warn("参数校验不通过！url:{},详情：{}", req.getRequestURL(), errorMsg);
        return errorMsg;
    }
    */
}