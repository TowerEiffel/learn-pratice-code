package com.myplay.annotation.componentscan;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * 自定义@ComponentScan 中 Filter中的过滤规则
 *
 * @author baihe
 * @Date: 2018/11/2 14:10
 */
public class MyTypeFilter  implements TypeFilter {


    /**
     * metadataReader: 读取到的类
     * metadataReaderFactory 可以获取到其他的类
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();//获取注解信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();//获取类信息
        Resource resource = metadataReader.getResource();//获取资源信息 类路径等
        String className = classMetadata.getClassName();
        System.out.println("----->"+ className);
        return true;
    }
}
