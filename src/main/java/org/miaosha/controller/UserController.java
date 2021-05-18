package org.miaosha.controller;

import com.mysql.jdbc.log.Log;
import org.miaosha.controller.viewobject.UserVO;
import org.miaosha.model.UserModel;
import org.miaosha.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * @author tangssst@qq.com
 * @version 1.0.0
 * @ClassName userController.java
 * @Description TODO
 * @createTime 2021/05/18 10:47:00
 */
@Controller("user")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public UserVO getUser(@RequestParam(name = "id") Integer id){
        //调用service层获取对应id的对象
        UserModel userModel = userService.getUserById(id);
        return convertFromModel(userModel);
    }
    /**
     * 将核心领域模型用户对象转化为可供前端使用的viewobjext，相比前者省去了不必展示的registerMode、thirdPartyId、encrptPassword
     */
    private UserVO convertFromModel(UserModel userModel){
        if (userModel == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;
    }
}
