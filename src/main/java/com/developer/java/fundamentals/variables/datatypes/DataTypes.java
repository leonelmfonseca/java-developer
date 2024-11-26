package com.developer.java.fundamentals.variables.datatypes;

public class DataTypes {

  // Boolean
  private static boolean bl;

  // Numeric(signed)
  private static long lg; // Integral -> Integer
  private static int ig; // Integral -> Integer
  private static short st; // Integral -> Integer
  private static byte bt; // Integral -> Integer
  private static float fl; // Integral -> Floating-point
  private static double d; // Integral -> Floating-point

  public static void main(String[] args) {
    printPrimitivesMaxSize();
    System.out.println();
    printPrimitivesDefaultValues();
    System.out.println();
    printDataTypesComparisonTable();
  }

  private static void printPrimitivesMaxSize(){
    System.out.println("Primitives MAX size");
    System.out.println("Boolean does not have a MAX_VALUE because it represents a simple binary state: true or false");

    // Numeric (signed)
    System.out.println("Max char value: " + (int) Character.MAX_VALUE); // 65535
    System.out.println("Max long value: " + Long.MAX_VALUE); // 9223372036854775807
    System.out.println("Max int value: " + Integer.MAX_VALUE); // 2147483647
    System.out.println("Max short value: " + Short.MAX_VALUE); // 32767
    System.out.println("Max byte value: " + Byte.MAX_VALUE); // 127
    System.out.println("Max float value: " + Float.MAX_VALUE); // 3.4028235E38
    System.out.println("Max double value: " + Double.MAX_VALUE); // 1.7976931348623157E308
  }

  private static void printPrimitivesDefaultValues() {
    System.out.println("Primitives Default Values");
    System.out.println("Default boolean value: " + bl);
    System.out.println("Default char value as text: [\\u0000]"); // Char default is the null character
    System.out.println("Default long value: " + lg);
    System.out.println("Default int value: " + ig);
    System.out.println("Default short value: " + st);
    System.out.println("Default byte value: " + bt);
    System.out.println("Default float value: " + fl);
    System.out.println("Default double value: " + d);
  }

  private static void printDataTypesComparisonTable() {
    System.out.println("+-------------------+--------------------------------------------------------+---------------------------------------------------+");
    System.out.println("| Feature           | Primitive Types                                         | Non-Primitive Types (Reference Types)             |");
    System.out.println("+-------------------+--------------------------------------------------------+---------------------------------------------------+");
    System.out.println("| Definition        | Basic data types built into the language.              | Data types based on classes and arrays.           |");
    System.out.println("| Examples          | int, char, float, double, boolean, byte, short, long.  | String, Array, Class, Object, user-defined classes|");
    System.out.println("| Storage           | Stored in stack memory.                                | Stored in heap memory.                            |");
    System.out.println("| Size              | Fixed size (e.g., int is 32 bits).                     | Variable size.                                    |");
    System.out.println("| Value             | Directly holds the value.                              | Holds a reference or address pointing to the value|");
    System.out.println("| Operations        | Supports arithmetic and logical operations directly.   | Requires method calls for operations.             |");
    System.out.println("+-------------------+--------------------------------------------------------+---------------------------------------------------+");

  }
}


