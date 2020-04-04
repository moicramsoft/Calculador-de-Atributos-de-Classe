package com.challenge.desafio;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        System.out.println("Soma: " + new CalculadorDeClasses().somar(new ClasseTeste()));
        System.out.println("Subtração: " + new CalculadorDeClasses().subtrair(new ClasseTeste()));
        System.out.println("Total: " + new CalculadorDeClasses().totalizar(new ClasseTeste()));
    }

}