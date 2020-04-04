package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class ClasseTeste {

    @Somar
    static final BigDecimal value1 = new BigDecimal(10.0);

    @Somar
    Double value = 100.0;

    @Somar
    BigDecimal value2 = new BigDecimal(20.0);

    @Subtrair
    BigDecimal value3 = new BigDecimal(5.0);

    @Subtrair
    BigDecimal value4 = new BigDecimal(3.0);

    public static BigDecimal getValue1() {
        return value1;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public BigDecimal getValue2() {
        return value2;
    }

    public void setValue2(BigDecimal value2) {
        this.value2 = value2;
    }

    public BigDecimal getValue3() {
        return value3;
    }

    public void setValue3(BigDecimal value3) {
        this.value3 = value3;
    }

    public BigDecimal getValue4() {
        return value4;
    }

    public void setValue4(BigDecimal value4) {
        this.value4 = value4;
    }
}