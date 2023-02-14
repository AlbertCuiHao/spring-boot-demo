package com.albert.common.web.handler;


import com.albert.common.web.exception.ApiException;
import com.albert.common.web.result.ApiModel;
import com.albert.common.web.result.ApiStatus;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     * ApiException
     */
    @ExceptionHandler(value = ApiException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiModel<String> apiExceptionHandler(ApiException e) {
        logger.error(e.getMessage(), e);
        return ApiModel.fail(e.getMessage(), e);
    }

    /**
     * 参数绑定
     * BindException
     */
    @ExceptionHandler(value = ValidationException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiModel<String> validationExceptionHandler(ValidationException e) {
        logger.error(e.getMessage(), e);
        return ApiModel.fail(e.getMessage(), ApiStatus.VALIDATION);
    }

    /**
     * NullPointerException
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiModel<String> nullPointerExceptionHandler(NullPointerException e) {
        logger.error(e.getMessage(), e);
        return ApiModel.fail(e.getMessage(), ApiStatus.NULL_POINTER_EXCEPTION);
    }

    /**
     * Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiModel<String> exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return ApiModel.fail(e.getMessage(), ApiStatus.ERROR);
    }

}
