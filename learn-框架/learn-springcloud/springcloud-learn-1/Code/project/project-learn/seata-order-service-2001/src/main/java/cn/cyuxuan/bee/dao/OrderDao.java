package cn.cyuxuan.bee.dao;

import cn.cyuxuan.bee.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author [cyuxuan]
 * @date [2021/7/15 0015 23:39]
 */
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}