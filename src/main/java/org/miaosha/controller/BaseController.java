package org.miaosha.controller;

import org.miaosha.error.BusinessException;
import org.miaosha.error.EmBusinessError;
import org.miaosha.response.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用的控制层代码:异常处理
 * Created by tangssst@qq.com on 2021/05/20
 */
public class BaseController {

    /**
     *定义exceptionHandler解决未被controller层吸收的exception.
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex){
        Map<String,Object> responseData =  new HashMap<>();

        if (ex instanceof BusinessException){
            BusinessException businessException = (BusinessException)ex;
            responseData.put("errorCode",businessException.getErrorCode());
            responseData.put("errMsg",businessException.getErrorMsg());

        }else {
            responseData.put("errorCode", EmBusinessError.UNKNOWN_ERROR.getErrorCode());
            responseData.put("errMsg",EmBusinessError.UNKNOWN_ERROR.getErrorMsg());

        }
        return CommonReturnType.creat(responseData,"fail");

    }
}
