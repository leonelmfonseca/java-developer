package com.developer.java.fundamentals.variables.conversion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Animal {

  @Override
  public String toString() {
    return "I'm an animal";
  }
}

class Dog extends Animal {
  @Override
  public String toString() {
    return super.toString() + " namely a Dog";
  }
}

public class VariableConversion {

  public static void main(String[] args) {
    wideningConversion();
    narrowingConversion();
    lowerTypePromotion();
    upcastingConversion();
    downcastingConversion();
    stringToPrimitiveConversion();
    primitiveToStringConversion();
    boxingConversion();
    autoboxingConversion();
    unboxingConversion();
    objectConversion();
    arrayConversion();
  }

  // A smaller primitive data type is converted to a larger primitive data type.
  // This does not lead to data loss and is done automatically by the compiler.
  public static void wideningConversion() {
    int intValue = 100;
    long longValue = intValue; // Widening conversion

    performConversion("Widening", intValue, longValue);
  }

  // A larger primitive data type is converted to a smaller primitive data type.
  // ** WARNING **
  //    This can lead to data loss and must be explicitly handled in the code using casting.
  public static void narrowingConversion() {
    double doubleValue = 9.78;
    int intValue = (int) doubleValue; // Narrowing conversion (casting)

    performConversion("Narrowing(Cast)", doubleValue, intValue);
  }

  // When performing arithmetic operations with different types (like adding an int to a short),
  // Java automatically promotes the lower type to the higher type before performing the operation.
  public static void lowerTypePromotion() {
    short shortValue = 10;
    int intValue = 20;
    int result = shortValue + intValue; // `shortValue` is promoted to `int`

    performConversion("Lower Type Promotion", shortValue, intValue, result);
  }

  // Converting between different reference types (like class instances).
  // In object-oriented programming (OOP), polymorphism allows objects of different types (such as
  // Dog and Cat)
  // to be treated as instances of a common superclass (such as Animal).
  public static void upcastingConversion() {

    printTitle("Upcasting");

    Animal animal = new Dog(); // Upcasting ( is implicit)
    System.out.println("Dog -> Animal, allowed by polymorphism");
    System.out.println(animal);
  }

  // The cast (Dog) tells the compiler that you are explicitly treating the animal reference as a
  // Dog reference,
  // even though it is of type Animal.
  // Downcasting can be risky, and it only works if the object is indeed an instance of the subclass
  // (Dog).
  // If you try to cast an object to a subclass that it doesn't belong to, you will get a
  // ClassCastException at runtime
  public static void downcastingConversion() {
    printTitle("Downcasting");
    Animal animal = new Dog();
    System.out.println("Animal -> Dog, using explicit cast");
    Dog dog = (Dog) animal; // Downcasting ( is explicit)
    System.out.println(dog);
  }

  // Convert a String that represents a numeric value into a primitive int
  // using methods like Integer.parseInt().
  public static void stringToPrimitiveConversion() {
    String numStr = "123";
    int num = Integer.parseInt(numStr); // String to int conversion
    printTitle("String to Primitive Conversion thru parsing or type conversion");
    System.out.println(numStr.getClass().getSimpleName() + " -> " + getPrimitiveName(num));
    System.out.println("Converted String into Primitive: " + num);
  }

  // Converting int to String: This is simply a type conversion (also called type casting).
  public static void primitiveToStringConversion() {

    int intValue = 10;
    String newNumStr = String.valueOf(intValue); // int to String conversion
    printTitle("Primitive to String Conversion thru type casting");
    printTableHeader();
    System.out.println(getPrimitiveName(intValue) + " -> " + newNumStr.getClass().getSimpleName());
    System.out.println("Converted primitive into String: " + newNumStr);
  }

  // Manual process of converting a primitive type to its corresponding wrapper class.
  // This process involves explicitly creating an object that wraps the primitive value.
  public static void boxingConversion() {

    printTitle("Boxing");
    printTableHeader();
    int primitiveInt = 10;
    Integer boxedInt = Integer.valueOf(primitiveInt); // Manually boxing

    System.out.println("Primitive int: " + primitiveInt);
    System.out.println("Boxed Integer: " + boxedInt);
  }

  // Automatic conversion performed by the Java compiler when it sees that a primitive value needs
  // to be converted
  // into a wrapper class. J
  // Java automatically "boxes" the primitive type into its corresponding wrapper class,
  // without requiring you to explicitly create an object.
  public static void autoboxingConversion() {

    printTitle("Autoboxing");
    printTableHeader();
    int primitiveInt = 10;
    Integer autoboxedInt = primitiveInt; // Autoboxing happens automatically
    System.out.println("Primitive int: " + primitiveInt);
    System.out.println("Autoboxed Integer: " + autoboxedInt);
  }

  // An object of a wrapper class is converted back into a primitive type
  public static void unboxingConversion() {
    Integer boxedInt = 10; // Boxing (autoboxing)

    // Unboxing: converting Integer to primitive int
    int primitiveInt = boxedInt; // Unboxing happens automatically
    printTitle("Unboxing");
    printTableHeader();

    System.out.println("Boxed Integer: " + boxedInt);
    System.out.println("Primitive int: " + primitiveInt);
  }

  // Creates a list of objects and attempts to cast each element to a String.
  // It handles the ClassCastException by checking the type of each object before casting
  // to avoid errors when the list contains non-string elements.
  public static void objectConversion() {
    printTitle("Object Conversion (List<Object> to List<String>)");
    printTableHeader();

    // Create a List of Objects
    List<Object> objectList = new ArrayList<>();
    objectList.add("Hello");
    objectList.add("World");
    objectList.add(123); // Integer object

    // Convert List<Object> to List<String> (using String.valueOf for safe conversion)
    List<String> stringList = convertListToStringList(objectList);
    System.out.println("Converted List<Object> to List<String>: " + stringList);
  }

  // To convert an int[] to an Integer[], you must manually box each element
  // since primitive types can't be stored in arrays of wrapper types.
  // This involves iterating over the int[] and using Integer.valueOf(int) to create an Integer
  // object for each element.
  // The result is an array of Integer objects that mirrors the original int[].
  public static void arrayConversion() {
    printTitle("Array Conversion (int[] to Integer[])");
    printTableHeader();

    // Create an int array
    int[] intArray = {1, 2, 3, 4, 5};

    // Convert int[] to Integer[] (manually)
    Integer[] integerArray = convertIntArrayToIntegerArray(intArray);

    System.out.println("Converted int[] to Integer[]: ");
    for (Integer num : integerArray) {
      System.out.println(num);
    }
  }

  // Helper method to convert int[] to Integer[]
  public static Integer[] convertIntArrayToIntegerArray(int[] intArray) {
    Integer[] integerArray = new Integer[intArray.length];
    for (int i = 0; i < intArray.length; i++) {
      integerArray[i] = Integer.valueOf(intArray[i]); // Boxing each int element
    }
    return integerArray;
  }

  // Helper method to convert List<Object> to List<String>
  public static List<String> convertListToStringList(List<Object> objectList) {
    List<String> stringList = new ArrayList<>();
    for (Object obj : objectList) {
      // Convert any object to String using String.valueOf, which handles nulls safely
      stringList.add(
          String.valueOf(obj)); // Converts non-String objects to their String representation
    }
    return stringList;
  }

  public static String getPrimitiveName(Object obj) {
    if (obj instanceof Integer) {
      return "int";
    } else if (obj instanceof Double) {
      return "double";
    } else if (obj instanceof Long) {
      return "long";
    } else if (obj instanceof Boolean) {
      return "boolean";
    } else if (obj instanceof Character) {
      return "char";
    } else if (obj instanceof Byte) {
      return "byte";
    } else if (obj instanceof Short) {
      return "short";
    } else if (obj instanceof Float) {
      return "float";
    }
    return "Unknown"; // If the object is not a primitive wrapper
  }

  public static void performConversion(String title, Number... values) {
    printTitle(title);
    printTableHeader();
    System.out.println(buildNumberTypeMapping(values));
    System.out.println();
    Stream.of(values).forEach(VariableConversion::printWithLeadingZeros);
  }

  // Builds a mapping of types in "type1 -> type2 -> ..." format
  public static String buildNumberTypeMapping(Number... values) {
    return Stream.of(values)
        .map(value -> value.getClass().getSimpleName())
        .collect(java.util.stream.Collectors.joining(" -> "));
  }

  // Prints a numeric value with leading zeros or formatted as needed
  public static <T extends Number> void printWithLeadingZeros(T value) {
    String typeName = value.getClass().getSimpleName();
    int maxDigits =
        switch (typeName) {
          case "Integer" -> Integer.toString(Integer.MAX_VALUE).length();
          case "Long" -> Long.toString(Long.MAX_VALUE).length();
          case "Short" -> Short.toString(Short.MAX_VALUE).length();
          case "Byte" -> Byte.toString(Byte.MAX_VALUE).length();
          case "Float" -> Float.toString(Float.MAX_VALUE).length();
          case "Double" -> Double.toString(Double.MAX_VALUE).length();
          default -> throw new IllegalStateException("Unexpected value: " + typeName);
        };

    // Print formatted value
    if (typeName.equals("Float") || typeName.equals("Double")) {
      System.out.printf("%-15s %0" + maxDigits + ".2f%n", typeName, value);
    } else {
      System.out.printf("%-15s %0" + maxDigits + "d%n", typeName, value.longValue());
    }
  }

  // Prints the table header for the output
  private static void printTableHeader() {
    System.out.println("Data Type Name       Value");
    System.out.println("------------------------------");
  }

  // Prints the title with formatting
  public static void printTitle(String title) {
    System.out.println("\n\n===================================");
    System.out.println(title);
    System.out.println("===================================");
  }
}
