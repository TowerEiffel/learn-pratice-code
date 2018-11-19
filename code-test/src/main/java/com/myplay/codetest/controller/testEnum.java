package com.myplay.codetest.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class testEnum {

    /**
     * 主要是想测试 把enum用在request中会是什么样的效果
     * 测试结论：http://localhost:8080/enum?num="1"&numEnum=ONE
     * numEnum: {@link com.myplay.codetest.testenum.NumEnum}
     * 在不改变spring参数转换的情况下 只有这一种方式可以得到请求，
     * 其他方式均为400 bad request
     * @param request {@link com.myplay.codetest.controller.EnumRequest}
     * @return
     */
    @RequestMapping(path = "/enum", method = RequestMethod.GET)
    public String queryUserOrder( EnumRequest request) {
        System.out.println(request);
        System.out.println("微信认证");
        return "ok";
    }

}
