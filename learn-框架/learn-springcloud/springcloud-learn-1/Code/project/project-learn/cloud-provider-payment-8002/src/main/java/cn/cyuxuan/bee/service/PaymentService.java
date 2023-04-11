package cn.cyuxuan.bee.service;

import cn.cyuxuan.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author cyuxuan
 * @date
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
