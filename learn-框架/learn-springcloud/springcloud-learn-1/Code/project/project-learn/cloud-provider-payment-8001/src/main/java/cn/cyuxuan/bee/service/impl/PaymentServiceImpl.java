package cn.cyuxuan.bee.service.impl;

import cn.cyuxuan.bee.dao.PaymentDao;
import cn.cyuxuan.entities.Payment;
import cn.cyuxuan.bee.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}
