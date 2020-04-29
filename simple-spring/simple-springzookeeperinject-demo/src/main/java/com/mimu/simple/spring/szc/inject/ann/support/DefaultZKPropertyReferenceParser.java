package com.mimu.simple.spring.szc.inject.ann.support;

import com.mimu.simple.spring.szc.inject.ann.ZKReference;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;

import java.lang.reflect.AnnotatedElement;

/**
 author: mimu
 date: 2020/4/29
 */
public class DefaultZKPropertyReferenceParser implements ZKPropertyReferenceParser {
    @Override
    public ZKPropertyAttribute parseZKReferenceAnnotation(AnnotatedElement element) {
        AnnotationAttributes annotationAttributes = AnnotatedElementUtils.findMergedAnnotationAttributes(element, ZKReference.class, false, false);
        if (annotationAttributes != null) {
            DefaultZKPropertyAttribute attribute = new DefaultZKPropertyAttribute(annotationAttributes.getString("key"), annotationAttributes.getString("value"));
            return attribute;
        }
        return null;
    }
}