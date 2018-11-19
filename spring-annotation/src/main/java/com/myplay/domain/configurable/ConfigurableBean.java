package com.myplay.domain.configurable;

import com.myplay.domain.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * ConfigurableBean test
 *
 * @author baihe
 * @Date: 2018/11/7 13:46
 */
@Configurable
public class ConfigurableBean {
    @Autowired
    private Person person;

    public Person isConfigurable(){
        return this.person;
    }
}
