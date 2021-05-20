package org.miaosha.error;

import org.miaosha.response.CommonReturnType;

/**
 * 枚举类,
 * Created by tangssst@qq.com on 2021/05/19
 */
public enum EmBusinessError implements CommonError {
    /**
     * 定义错误码.
     * 10001为通用错误类型, 2000开头为用户错误信息
     * 通用错误码避免定义许多各种错误码.
     */
    PARAMETER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOWN_ERROR(10002,"未知错误"),

    USER_NOT_EXIST(20001,"用户不存在"),

    ;
    private int errCode;
    private String errMsg;
    private EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    @Override
    public int getErrorCode() {
        return this.errCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
