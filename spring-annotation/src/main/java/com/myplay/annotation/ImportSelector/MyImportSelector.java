package com.myplay.annotation.ImportSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportSelector的自定义实现
 *
 * @author baihe
 * @Date: 2018/11/7 11:10
 */
public class MyImportSelector implements ImportSelector {

    /**
     * AnnotationMetadata 正在被导入的标注了Configuration 的类的注解信息，不仅仅是import注解
     * 该方法不能返回null 后续会调用返回数组的length，返回null会报错
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.myplay.domain.importbean.Red"};
    }
}
