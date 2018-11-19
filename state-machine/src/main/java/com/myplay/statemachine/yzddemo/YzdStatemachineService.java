package com.myplay.statemachine.yzddemo;

import com.myplay.statemachine.springstatemachine.TurnstileEvents;
import com.myplay.statemachine.springstatemachine.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

/**
 * service中使用
 *
 * @author baihe
 * @Date: 2018/11/13 10:40
 */
@Service
public class YzdStatemachineService {
    @Autowired
    private StateMachinePersister<YzdStates, YzdEvents, Integer> stateMachinePersist;
    @Autowired
    private StateMachineFactory<YzdStates, YzdEvents> stateMachineFactory;

    public void execute(Integer businessId, YzdEvents event, Map<String, Object> context) {
        // 利用随记ID创建状态机，创建时没有与具体定义状态机绑定
        StateMachine<YzdStates, YzdEvents> stateMachine = stateMachineFactory.getStateMachine(UUID.randomUUID());

        stateMachine.start();
        try {
            // 在BizStateMachinePersist的restore过程中，绑定turnstileStateMachine状态机相关事件监听
            stateMachinePersist.restore(stateMachine, businessId);
            // 本处写法较为繁琐，实际为注入Map<String, Object> context内容到message中
            MessageBuilder<YzdEvents> messageBuilder = MessageBuilder
                    .withPayload(event)
                    .setHeader("BusinessId", businessId);
            if (context != null) {
                context.entrySet().forEach(p -> messageBuilder.setHeader(p.getKey(), p.getValue()));
            }
            Message<YzdEvents> message = messageBuilder.build();

            // 发送事件，返回是否执行成功
            boolean success = stateMachine.sendEvent(message);
            if (success) {
                stateMachinePersist.persist(stateMachine, businessId);
            } else {
                System.out.println("状态机处理未执行成功，请处理，ID：" + businessId + "，当前context：" + context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stateMachine.stop();
        }
    }

}
