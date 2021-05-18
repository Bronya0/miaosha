package org.miaosha.service.impl;

import com.sun.org.apache.bcel.internal.generic.IFNONNULL;
import org.miaosha.dao.UserDOMapper;
import org.miaosha.dao.UserPasswordDOMapper;
import org.miaosha.dataobject.UserDO;
import org.miaosha.dataobject.UserPasswordDO;
import org.miaosha.model.UserModel;
import org.miaosha.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tangssst@qq.com
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2021/05/18 10:57:00
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;

    @Override
    public UserModel getUserById(Integer id) {
        //通过id获取用户信息
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        if (userDO == null) {
            return null;
        }
        //通过用户id获取密码
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(userDO.getId());
        if (userPasswordDO == null){
            return null;
        }
        return convertFormDataObject(userDO,userPasswordDO);
    }

    /**
     *将UserDO和UserPasswordDO组装成UserModel返回
     */
    private UserModel convertFormDataObject(UserDO userDO, UserPasswordDO userPasswordDO){
        if (userDO == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userDO,userModel);
        //不能再用copy，因为id重复了
        userModel.setEncrptPassword(userPasswordDO.getEncrptPassword());
        return userModel;
    }
}
