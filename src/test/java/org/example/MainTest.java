package org.example;

public class MainTest {

    private static int testsPassed = 0;
    private static int testsFailed = 0;

    public static void main(String[] args) {
        System.out.println("Running tests...");
        System.out.println("----------------------------------------");

        testAddInt();
        testSubtractInt();
        testMultiplyInt();
        testDivideInt();
        testDivideIntByZero();

        testAddLong();
        testSubtractLong();
        testMultiplyLong();
        testDivideLong();
        testDivideLongByZero();

        testAddShort();
        testSubtractShort();
        testMultiplyShort();
        testDivideShort();
        testDivideShortByZero();

        testAddFloat();
        testSubtractFloat();
        testMultiplyFloat();
        testDivideFloat();
        testDivideFloatByZero();

        testAddDouble();
        testSubtractDouble();
        testMultiplyDouble();
        testDivideDouble();
        testDivideDoubleByZero();

        testMainMethod();

        System.out.println("----------------------------------------");
        System.out.println("Test run finished.");
        System.out.println("Passed: " + testsPassed + ", Failed: " + testsFailed);

        if (testsFailed > 0) {
            System.exit(1);
        }
    }

    private static void check(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
            testsPassed++;
        } else {
            System.out.println("[FAIL] " + testName);
            testsFailed++;
        }
    }

    static void testAddInt() {
        check("Integer addition", Main.add(2, 3) == 5);
        check("Integer addition (negative)", Main.add(-2, 1) == -1);
    }

    static void testSubtractInt() {
        check("Integer subtraction", Main.subtract(3, 2) == 1);
        check("Integer subtraction (negative)", Main.subtract(-2, 1) == -3);
    }

    static void testMultiplyInt() {
        check("Integer multiplication", Main.multiply(2, 3) == 6);
        check("Integer multiplication (negative)", Main.multiply(-2, 1) == -2);
    }

    static void testDivideInt() {
        check("Integer division", Main.divide(6, 3) == 2);
        check("Integer division (negative)", Main.divide(-6, 3) == -2);
    }

    static void testDivideIntByZero() {
        try {
            Main.divide(1, 0);
            check("Integer division by zero", false); // Should not be reached
        } catch (IllegalArgumentException e) {
            check("Integer division by zero", e.getMessage().equals("Cannot divide by zero"));
        }
    }

    static void testAddLong() {
        check("Long addition", Main.add(2L, 3L) == 5L);
    }

    static void testSubtractLong() {
        check("Long subtraction", Main.subtract(3L, 2L) == 1L);
    }

    static void testMultiplyLong() {
        check("Long multiplication", Main.multiply(2L, 3L) == 6L);
    }

    static void testDivideLong() {
        check("Long division", Main.divide(6L, 3L) == 2L);
    }

    static void testDivideLongByZero() {
        try {
            Main.divide(1L, 0L);
            check("Long division by zero", false);
        } catch (IllegalArgumentException e) {
            check("Long division by zero", e.getMessage().equals("Cannot divide by zero"));
        }
    }

    static void testAddShort() {
        check("Short addition", Main.add((short) 2, (short) 3) == (short) 5);
    }

    static void testSubtractShort() {
        check("Short subtraction", Main.subtract((short) 3, (short) 2) == (short) 1);
    }

    static void testMultiplyShort() {
        check("Short multiplication", Main.multiply((short) 2, (short) 3) == (short) 6);
    }

    static void testDivideShort() {
        check("Short division", Main.divide((short) 6, (short) 3) == (short) 2);
    }

    static void testDivideShortByZero() {
        try {
            Main.divide((short) 1, (short) 0);
            check("Short division by zero", false);
        } catch (IllegalArgumentException e) {
            check("Short division by zero", e.getMessage().equals("Cannot divide by zero"));
        }
    }

    static void testAddFloat() {
        check("Float addition", Math.abs(Main.add(2.2f, 3.3f) - 5.5f) < 0.0001);
    }

    static void testSubtractFloat() {
        check("Float subtraction", Math.abs(Main.subtract(3.3f, 2.2f) - 1.1f) < 0.0001);
    }

    static void testMultiplyFloat() {
        check("Float multiplication", Math.abs(Main.multiply(2.2f, 3.3f) - 7.26f) < 0.0001);
    }

    static void testDivideFloat() {
        check("Float division", Math.abs(Main.divide(3.3f, 2.2f) - 1.5f) < 0.0001);
    }

    static void testDivideFloatByZero() {
        check("Float division by zero", Float.isNaN(Main.divide(1.0f, 0.0f)));
    }

    static void testAddDouble() {
        check("Double addition", Math.abs(Main.add(2.2, 3.3) - 5.5) < 0.0001);
    }

    static void testSubtractDouble() {
        check("Double subtraction", Math.abs(Main.subtract(3.3, 2.2) - 1.1) < 0.0001);
    }

    static void testMultiplyDouble() {
        check("Double multiplication", Math.abs(Main.multiply(2.2, 3.3) - 7.26) < 0.0001);
    }

    static void testDivideDouble() {
        check("Double division", Math.abs(Main.divide(3.3, 2.2) - 1.5) < 0.0001);
    }

    static void testDivideDoubleByZero() {
        check("Double division by zero", Double.isNaN(Main.divide(1.0, 0.0)));
    }

    static void testMainMethod() {
        try {
            Main.main(new String[]{});
            check("Main method execution", true);
        } catch (Exception e) {
            check("Main method execution", false);
        }
    }
}
