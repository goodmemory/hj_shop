package com.hj.controller;

import com.hj.entity.Result;
import com.hj.entity.StatusCode;
import com.hj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * @param userId
     */
    @GetMapping("/getById")
    public Result getById(@RequestParam(value = "userId") Long userId) {
        return new Result(true, StatusCode.OK, "操作成功", userService.getById(userId));
    }
}
