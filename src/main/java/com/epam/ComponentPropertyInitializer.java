package com.epam;

import com.epam.handlers.AnnotationHandler;
import com.epam.handlers.HandlerContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вадим on 04.07.2015.
 */
public class ComponentPropertyInitializer {

    private HandlerContainer handlerContainer;

    public ComponentPropertyInitializer(HandlerContainer handlerContainer) {
        this.handlerContainer = handlerContainer;
    }

    public List<ComponentBean> getInitializeComponents(List<Class<?>> classList) {
        List<ComponentBean> componentBeans = new ArrayList<ComponentBean>();
        if (classList != null) {
            for (Class<?> clazz : classList) {
                ComponentBean componentBean = new ComponentBean();
                componentBean.setComponentClass(clazz);
                handleClassAnnotations(clazz, componentBean);
                handleFieldAnnotations(clazz, componentBean);//todo add handling methods annotation. Decide whether preority should be given to methods or fields.
                componentBeans.add(componentBean);
            }
        }
        return componentBeans;
    }

    private void handleClassAnnotations(Class clazz, ComponentBean componentBean) {
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations != null) {
            for (Annotation annotation : annotations) {
                String annotationName = annotation.annotationType().getSimpleName();
                AnnotationHandler annotationHandler = handlerContainer.getAnnotationHandler(annotationName);
                annotationHandler.execute(componentBean, annotation);
            }
        }
    }

    private void handleFieldAnnotations(Class<?> clazz, ComponentBean componentBean) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                String annotationName = annotation.annotationType().getSimpleName();
                AnnotationHandler annotationHandler = handlerContainer.getAnnotationHandler(annotationName);
                annotationHandler.execute(componentBean, annotation);
            }
        }
    }

}
