package com.statemachine.demo.enums;

/**
 * @author geweijian
 * @data 2021-05-28
 */
public enum OrderState {
    // 待支付，待发货，待收货，已完成
    WAIT_PAYMENT,
    WAIT_DELIVER,
    WAIT_RECEIVE,
    FINISH;
}
