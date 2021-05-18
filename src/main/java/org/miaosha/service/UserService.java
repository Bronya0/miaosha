package org.miaosha.service;

import org.miaosha.model.UserModel;

/**
 * @author tangssst@qq.com
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description TODO
 * @createTime 2021/05/18 10:56:00
 */
public interface UserService {
    //通过用户id获取用户对象
    UserModel getUserById(Integer id);

}
