package guo.ping.seckill.controller.user;

import guo.ping.seckill.result.CodeMsg;
import guo.ping.seckill.result.ServerResponse;
import guo.ping.seckill.service.UserService;
import guo.ping.seckill.vo.LoginInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @description: 用户登录Controller
 * @author: guoping wang
 * @email: Kingdompin@163.com
 * @date: 2019/5/3 12:30 AM
 * @project: seckill
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public ServerResponse<Boolean> doLogin(@Valid LoginInfoVo loginInfoVo) {
        // 打印用户输入信息日志
        logger.info(loginInfoVo.toString());
        // 登录，出错会抛出全局异常，并被捕获处理
        userService.login(loginInfoVo);
        // 直接返回true即可
        return ServerResponse.success(true);
    }


}
