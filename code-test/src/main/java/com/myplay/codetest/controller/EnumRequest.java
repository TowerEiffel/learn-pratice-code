package com.myplay.codetest.controller;

import com.myplay.codetest.testenum.NumEnum;
import lombok.Data;

/**
 * @author bh
 * @Description:
 * @Date: 2018/10/11 17:12
 */
@Data
public class EnumRequest {
    private NumEnum numEnum;

    private String num;
}
