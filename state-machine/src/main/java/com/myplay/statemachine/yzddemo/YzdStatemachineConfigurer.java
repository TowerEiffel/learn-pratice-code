package com.myplay.statemachine.yzddemo;

import com.myplay.statemachine.springstatemachine.BizStateMachinePersist;
import com.myplay.statemachine.springstatemachine.TurnstileEvents;
import com.myplay.statemachine.springstatemachine.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;

import java.util.EnumSet;

/**
 * 状态机配置
 *
 * @author baihe
 * @Date: 2018/11/12 17:09
 */
@Configuration
@EnableStateMachine
public class YzdStatemachineConfigurer extends EnumStateMachineConfigurerAdapter<YzdStates, YzdEvents> {

   /* @Autowired
    private BizStateMachinePersist bizStateMachinePersist;

    @Bean
    public StateMachinePersister<TurnstileStates, TurnstileEvents, Integer> stateMachinePersist() {
        return new DefaultStateMachinePersister<>(bizStateMachinePersist);
    }*/


    @Override
    public void configure(StateMachineStateConfigurer<YzdStates, YzdEvents> states)
            throws Exception {
        states.withStates()
                // 初识状态：Locked
                .initial(YzdStates.Draft)
                .states(EnumSet.allOf(YzdStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<YzdStates, YzdEvents> transitions)
            throws Exception {
        transitions.withExternal()
                .source(YzdStates.Draft).target(YzdStates.Pending)
                .event(YzdEvents.ImgDown)
                .event(YzdEvents.StoreOver).action(draftToPending())
                .and()
                .withExternal()
                .source(YzdStates.Pending).target(YzdStates.Agree)
                .event(YzdEvents.ImgDown).event(YzdEvents.StoreOver).action(pendingToAgree());
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<YzdStates, YzdEvents> config)
            throws Exception {
        config.withConfiguration()
                .machineId("turnstileStateMachine1");
    }

    public Action<YzdStates, YzdEvents> pendingToAgree() {
        return context -> System.out.println("待受理到同意" );
    }

    public Action<YzdStates, YzdEvents> draftToPending() {
        return context -> System.out.println("草稿到待受理" );
    }

}
