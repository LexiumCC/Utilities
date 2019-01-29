package cc.lexium.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * The reflector class is for access to classes in Runtime.
 */

public class Reflector {

    public static void displayClassInfo(Class<?> clazz, boolean ignoreUnpacked) {
        System.out.print("class name: " + clazz.getSimpleName() + "\n");

        for (Field f : clazz.getFields()) {
            System.out.print("field: " + f.getName() + "\n");
        }

        for (Method m : clazz.getMethods()) {
            System.out.print("method: " + m.getName() + "\n");
            if (m.getParameters().length > 1) {
                System.out.print(" » parameters: " + "\n");
                for (Parameter p : m.getParameters()) {
                    System.out.print("    " + p.getName() + " : " + p.getParameterizedType().getTypeName() + "\n");
                }
            }
            if (m.getAnnotations().length > 1) {
                System.out.print(" » annotations: " + "\n");
                for (Annotation a : m.getAnnotations()) {
                    System.out.print("    " + a.annotationType().getSimpleName() + "\n");
                }
            }
        }
    }

    public static void listenForChanges(Class<?> clazz, Field field)
    {

    }

    public static void listenForExecution(Class<?> clazz, Method method)
    {

    }

    public static void replaceParameter(Method method, Parameter parameter, Parameter substitute)
    {
        ArrayUtil.replace(method.getParameters(), parameter, substitute);
    }

    public static void invokeMethod(Class<?> clazz, String methodName, Object arguments) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException
    {
        if (ArrayUtil.exists(getMethod(clazz, methodName).getAnnotations(), Protected.class)) {throw new Error("the method is protected.");}
        getMethod(clazz, methodName).invoke(arguments);
    }

    public static void addAnnotation(Annotation annotation, Method target)
    {
        target.getDeclaredAnnotations()[target.getDeclaredAnnotations().length] = annotation;
    }


    public static void replaceField(Class<?> clazz, String fieldName, Field substitute) throws NoSuchFieldException, IllegalAccessException
    {
        System.out.print(getField(clazz, fieldName).getName());
    }

    /**
     * Getters.
     */

    public static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException
    {
        return clazz.getField(fieldName);
    }

    public static Parameter[] getParameters(Method method)
    {
        return method.getParameters();
    }

    public static Method getMethod(Class<?> clazz, String methodName) throws NoSuchMethodException
    {
        return clazz.getMethod(methodName);
    }



}
