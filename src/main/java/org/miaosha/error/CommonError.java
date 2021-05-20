package org.miaosha.error;

/**
 * Created by tangssst@qq.com on 2021/05/19
 */
public interface CommonError {
    public int getErrorCode();//获取error代码
    public String getErrorMsg();//获取error信息
    public CommonError setErrMsg(String errMsg);//设置错误信息

}
