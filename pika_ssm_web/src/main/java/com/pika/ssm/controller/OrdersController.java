package com.pika.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.pika.ssm.domain.Orders;
import com.pika.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    // 查询全部订单--未分页
//    @RequestMapping("findAll")
////    public ModelAndView findAll(){
////        ModelAndView mv = new ModelAndView();
////        List<Orders> orders = ordersService.findAll();
////        mv.addObject("ordersList", orders);
////        mv.setViewName("orders-list");
////        return mv;
////    }

    // 查询全部订单--分页
    @RequestMapping("findAll")
    public ModelAndView findAll(@RequestParam(value = "page", required = true, defaultValue = "1")int page, @RequestParam(value = "size", required = true, defaultValue = "4")int size){
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = ordersService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    // 订单详情
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name="id", required = true)String id){
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
