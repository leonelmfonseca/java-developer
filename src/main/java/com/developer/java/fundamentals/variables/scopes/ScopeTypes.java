package com.developer.java.fundamentals.variables.scopes;

interface Displayable {
  void display();

  void modifyVariables(int delta);
}

enum VariableType {
  STATIC,
  INSTANCE,
  LOCAL
}

public class ScopeTypes implements Displayable {

  // Shared among all instances of the class.
  private static int staticVariable = 100;

  // Each instance (object) of the class has its own copy of these variables.
  private int instanceVariable = 2001;

  public static void main(String[] args) {

    // instance1 and instance2 will be held in the stack,
    // as references to objects in the heap
    ScopeTypes instance1 = new ScopeTypes();
    ScopeTypes instance2 = new ScopeTypes();

    // Display initial values
    System.out.println("Initial Values:");
    instance1.display();
    instance2.display();
    System.out.println("Static Variable: " + ScopeTypes.staticVariable);
    System.out.println();

    // Modify instance variables and static variable
    instance1.modifyVariables(1000);
    instance2.modifyVariables(2000);
    modifyStaticVariable(15);

    // Display modified values
    System.out.println("Modified Values:");
    instance1.display();
    instance2.display();
    System.out.println("Static Variable: " + ScopeTypes.staticVariable);
    System.out.println();

    // Demonstrate local variables and Enums
    instance1.localVariableMethod();
    instance2.localVariableMethod();

    // Demonstrate Enum usage
    for (VariableType type : VariableType.values()) {
      System.out.println("VariableType: " + type);
    }

    // Demonstrate Arrays
    System.out.println();
    System.out.println("Array of Instance Variables:");
    ScopeTypes[] instances = {instance1, instance2};
    for (ScopeTypes instance : instances) {
      instance.display();
    }
  }

  @Override
  public void display() {
    System.out.println("Instance Variable: " + instanceVariable);
  }

  @Override
  public void modifyVariables(int delta) {
    this.instanceVariable += delta; // Modify instance variable
  }

  public static void modifyStaticVariable(int delta) {
    staticVariable += delta;
  }

  void localVariableMethod() {
    // Only accessible within the method or block where they are declared
    int localVariable = 50;
    System.out.println("Local Variable in " + this.toString() + ": " + localVariable);
  }

  // Prevents that default implementation of the toString() method from the Object class,
  // be executed, which is used when you print the instance using System.out.println().
  @Override
  public String toString() {
    return "VariablesScopeTypes instance";
  }
}
