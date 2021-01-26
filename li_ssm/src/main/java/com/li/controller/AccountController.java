package com.li.controller;

import com.li.domain.Account;
import com.li.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @author LiHui
 * @create 2020--12--24--22:23
 * @date 2020/12/24--22:23
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;




    //保存
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account) throws IOException {

        accountService.save(account);
        return "保存成功";
    }


    //查询

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws IOException {
        List<Account> accountList = accountService.findAll();
        ModelAndView modelAndView=new ModelAndView();

        modelAndView.addObject("accountList",accountList);
        modelAndView.setViewName("accountList");
        return modelAndView;
    }
}
