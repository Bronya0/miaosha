package org.miaosha.response;

/**
 * @author tangssst@qq.com
 * @version 1.0.0
 * @Description 对数据进行一层封装,添加status变量
 * @createTime 2021/05/19 08:53:00
 */
public class CommonReturnType {
    private String status;    //表示对应请求的返回结果,"success"或"fail", success则返回json, fail返回错误格式
    private Object data; //用于存储传进来的数据

    /**
     *定义一个通用的创建方法,如果不带status那么默认就是success,再执行下一步
     * 如果带status,创建一个commonreturntyoe对象,传入status和data
     */
    public static CommonReturnType creat(Object result){
        return CommonReturnType.creat(result,"success");
    }
    public static CommonReturnType creat(Object result,String status){
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
