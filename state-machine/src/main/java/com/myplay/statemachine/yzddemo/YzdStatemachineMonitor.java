package com.myplay.statemachine.yzddemo;

import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

/**
 * Yzd事件监听类
 *
 * @author baihe
 * @Date: 2018/11/12 17:31
 */
@WithStateMachine(id = "turnstileStateMachine")
public class YzdStatemachineMonitor {
    @OnTransition
    public void anyTransition() {
        System.out.println("--- OnTransition --- init");
    }

    @OnTransition(source= "Draft",target = "Pending")
    public void toState1() {
        System.out.println("--- Draft ---> Pending");
    }

    @OnStateChanged(source= "Draft",target = "Pending")
    public void fromState1() {
        System.out.println("--- OnTransition --- fromState1");
    }
}
