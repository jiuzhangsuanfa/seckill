package com.jiuzhang.seckill.mapper;

import com.jiuzhang.seckill.entity.Order;
import com.jiuzhang.seckill.util.SnowFlake;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMapTest {

    @Resource
    OrderMapper orderMapper;

    @Test
    void testInsert() {
        Order order = new Order();
        order.setId(new SnowFlake(1, 1).nextId() + "");
        order.setActivityId(2L);
        order.setUserId((long) 12345);
        order.setOrderAmount(new BigDecimal(123456.34));
        order.setOrderStatus(1);
        order.setCreateTime(LocalDateTime.now());
        Assertions.assertEquals(1, orderMapper.insert(order));
    }

}