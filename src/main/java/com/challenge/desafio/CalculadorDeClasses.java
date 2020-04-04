package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Arrays;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object object) {
        return sumAnnotations(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return sumAnnotations(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return hasAnnotations(object) ?
                somar(object).subtract(subtrair(object)):
                BigDecimal.ZERO;
    }

    @SuppressWarnings("unchecked")
	private BigDecimal sumAnnotations(Object object, @SuppressWarnings("rawtypes") Class annotation) {

        BigDecimal value = BigDecimal.ZERO;
        for (Field field : object.getClass().getDeclaredFields()) {
            if(field.getDeclaredAnnotation(annotation) != null) {
                try {
                    String methodName = "get" + field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
                    if(field.getType().equals(BigDecimal.class)) {
                        BigDecimal bigDecimal = (BigDecimal) object.getClass()
                                .getDeclaredMethod(methodName).invoke(object);
                        value = value.add(bigDecimal);
                    } else {
                        value.add(BigDecimal.ZERO);
                    }

                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        return value;
    }

    private boolean hasAnnotations(Object object) {
        return Arrays.asList(object.getClass()
                .getDeclaredFields()).stream()
                .anyMatch(field -> field.getDeclaredAnnotations().length > 0);
    }

}