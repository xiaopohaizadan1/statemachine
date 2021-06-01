package com.statemachine.demo.service;

import com.statemachine.demo.entity.Order;
import com.statemachine.demo.enums.OrderState;
import com.statemachine.demo.enums.OrderStateChangeEvent;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

/**
 * @author geweijian
 * @data 2021-05-28
 */
@Component("orderStateListener")
@WithStateMachine(name = "orderStateMachine")
public class OrderStateListener {

    @OnTransition(source = "WAIT_PAYMENT", target = "WAIT_DELIVER")
    public boolean payTransition(Message<OrderStateChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderState.WAIT_DELIVER);
        System.out.println("支付，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_DELIVER", target = "WAIT_RECEIVE")
    public boolean deliverTransition(Message<OrderStateChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderState.WAIT_RECEIVE);
        System.out.println("发货，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }

    @OnTransition(source = "WAIT_RECEIVE", target = "FINISH")
    public boolean receiveTransition(Message<OrderStateChangeEvent> message) {
        Order order = (Order) message.getHeaders().get("order");
        order.setStatus(OrderState.FINISH);
        System.out.println("收货，状态机反馈信息：" + message.getHeaders().toString());
        return true;
    }


}
