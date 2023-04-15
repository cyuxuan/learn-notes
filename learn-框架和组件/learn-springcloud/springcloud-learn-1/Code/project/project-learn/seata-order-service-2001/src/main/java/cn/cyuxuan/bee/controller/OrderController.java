package cn.cyuxuan.bee.controller;

import cn.cyuxuan.bee.domain.CommonResult;
import cn.cyuxuan.bee.domain.Order;
import cn.cyuxuan.bee.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author [cyuxuan]
 * @date [2021/7/15 0015 23:39]
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
