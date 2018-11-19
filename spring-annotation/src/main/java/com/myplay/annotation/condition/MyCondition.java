package com.myplay.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Condition 实现类
 *
 * @author baihe
 * @Date: 2018/11/2 18:38
 */
public class MyCondition implements Condition {

    /**
     *
     * @param context 判断条件可以使用的上下文环境
     * @param metadata 被标注的信息 可能是类,也可能是方法
     * @return  是否匹配
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        return false;
    }
}
