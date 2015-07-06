package com.epam;

import com.epam.annotations.AnnotatedObject;
import com.epam.handlers.AnnotationHandler;
import com.epam.handlers.HandlerContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
                handleFieldAnnotations(clazz, componentBean);
                handleMethodAnnotations(clazz, componentBean);
                componentBeans.add(componentBean);
            }
        }
        return componentBeans;
    }

    private void handleClassAnnotations(Class<?> clazz, ComponentBean componentBean) {
        Annotation[] annotations = clazz.getAnnotations();
        if (annotations != null) {
            parseAnnotations(annotations, componentBean);
        }
    }

    private void handleFieldAnnotations(Class<?> clazz, ComponentBean componentBean) {
        Field[] fields = clazz.getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                Annotation[] annotations = field.getAnnotations();
                parseAnnotations(annotations, componentBean, field);
            }
        }
    }

    private void handleMethodAnnotations(Class<?> clazz, ComponentBean componentBean) {
        Method[] methods = clazz.getDeclaredMethods();
        if (methods != null) {
            for (Method method : methods) {
                Annotation[] annotations = method.getAnnotations();
                parseAnnotations(annotations, componentBean, method);
            }
        }
    }

    private void parseAnnotations(Annotation[] annotations, ComponentBean componentBean, AccessibleObject accessibleObject) {
        for (Annotation annotation : annotations) {
            AnnotatedObject annotatedObject = new AnnotatedObject();
            annotatedObject.setAnnotation(annotation);
            String annotationName = annotation.annotationType().getSimpleName();
            AnnotationHandler annotationHandler = handlerContainer.getAnnotationHandler(annotationName);
            annotationHandler.execute(componentBean, annotatedObject);
        }
    }

    private void parseAnnotations(Annotation[] annotations, ComponentBean componentBean) {
        for (Annotation annotation : annotations) {
            AnnotatedObject annotatedObject = new AnnotatedObject();
            annotatedObject.setAnnotation(annotation);
            String annotationName = annotation.annotationType().getSimpleName();
            AnnotationHandler annotationHandler = handlerContainer.getAnnotationHandler(annotationName);
            annotationHandler.execute(componentBean, annotatedObject);
        }
    }

}
