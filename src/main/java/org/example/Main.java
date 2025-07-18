package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        System.out.println("Calculator Demo");
        System.out.println("---------------");

        System.out.println("\nInteger Operations:");
        int intSum = add(10, 5);
        System.out.println("10 + 5 = " + intSum);

        int intDifference = subtract(10, 5);
        System.out.println("10 - 5 = " + intDifference);

        int intProduct = multiply(10, 5);
        System.out.println("10 * 5 = " + intProduct);

        int intQuotient = divide(10, 5);
        System.out.println("10 / 5 = " + intQuotient);

        System.out.println("\nDouble Operations:");
        double doubleSum = add(10.5, 5.2);
        System.out.println("10.5 + 5.2 = " + doubleSum);

        double doubleDifference = subtract(10.5, 5.2);
        System.out.println("10.5 - 5.2 = " + doubleDifference);

        double doubleProduct = multiply(10.5, 5.2);
        System.out.println("10.5 * 5.2 = " + doubleProduct);

        double doubleQuotient = divide(10.5, 5.2);
        System.out.println("10.5 / 5.2 = " + doubleQuotient + " (rounded to 4 decimal places)");

        System.out.println("\nTesting Division by Zero:");
        try {
            divide(5, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Integer division by zero: " + e.getMessage());
        }

        double doubleDivByZero = divide(5.0, 0.0);
        System.out.println("Double division by zero: " + doubleDivByZero);
    }

    public static int add(int a, int b) { return a + b; }
    public static int subtract(int a, int b) { return a - b; }
    public static int multiply(int a, int b) { return a * b; }
    public static int divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Cannot divide by zero");
        return a / b;
    }

    public static long add(long a, long b) { return a + b; }
    public static long subtract(long a, long b) { return a - b; }
    public static long multiply(long a, long b) { return a * b; }
    public static long divide(long a, long b) {
        if (b == 0) throw new IllegalArgumentException("Cannot divide by zero");
        return a / b;
    }

    public static short add(short a, short b) { return (short) (a + b); }
    public static short subtract(short a, short b) { return (short) (a - b); }
    public static short multiply(short a, short b) { return (short) (a * b); }
    public static short divide(short a, short b) {
        if (b == 0) throw new IllegalArgumentException("Cannot divide by zero");
        return (short) (a / b);
    }

    public static float add(float a, float b) { return roundFloat(a + b); }
    public static float subtract(float a, float b) { return roundFloat(a - b); }
    public static float multiply(float a, float b) { return roundFloat(a * b); }
    public static float divide(float a, float b) {
        if (b == 0) return Float.NaN;
        return roundFloat(a / b);
    }

    public static double add(double a, double b) { return roundDouble(a + b); }
    public static double subtract(double a, double b) { return roundDouble(a - b); }
    public static double multiply(double a, double b) { return roundDouble(a * b); }
    public static double divide(double a, double b) {
        if (b == 0) return Double.NaN;
        return roundDouble(a / b);
    }

    private static float roundFloat(float value) {
        BigDecimal bd = new BigDecimal(Float.toString(value));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.floatValue();
    }

    private static double roundDouble(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(4, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
