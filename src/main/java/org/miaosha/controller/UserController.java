package org.miaosha.controller;

import com.alibaba.druid.wall.violation.ErrorCode;
import org.miaosha.controller.viewobject.UserVO;
import org.miaosha.error.BusinessException;
import org.miaosha.error.EmBusinessError;
import org.miaosha.model.UserModel;
import org.miaosha.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.miaosha.response.CommonReturnType;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tangssst@qq.com
 * @version 1.0.0
 * @ClassName userController.java
 * @Description controller做了到前端viewobject的透传,保证了ui只使用了只需要的字段
 * @createTime 2021/05/18 10:47:00
 */
@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        //调用service层获取对应id的对象
        UserModel userModel = userService.getUserById(id);

        //若获取的用户信息不存在那么throw出去BusinessException
        if (userModel == null){
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = convertFromModel(userModel);

        //封装一层数据,添加status变量
        return CommonReturnType.creat(userVO);
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
