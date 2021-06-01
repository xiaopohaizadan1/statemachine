package com.statemachine.demo.entity;

import com.statemachine.demo.enums.OrderState;
import lombok.Data;

/**
 * @author geweijian
 * @data 2021-05-28
 */
@Data
public class Order {
    private int id;
    private OrderState status;
}
