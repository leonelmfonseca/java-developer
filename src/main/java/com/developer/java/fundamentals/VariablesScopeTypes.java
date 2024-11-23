package com.developer.java.fundamentals;

public class VariablesScopeTypes {

  // Shared among all instances of the class.
  private static int staticVariable=100;

  //Each instance (object) of the class has its own copy of these variables.
  private int instanceVariable = 2001;


  public static void main(String[] args) {

    // instance1 and instance2 will be held in the stack,
    // as references to objects in the heap
    VariablesScopeTypes instance1 = new VariablesScopeTypes();
    VariablesScopeTypes instance2 = new VariablesScopeTypes();

    // Display initial values
    System.out.println("Initial Values:");
    System.out.println("Instance 1 - Instance Variable: " + instance1.instanceVariable);
    System.out.println("Instance 2 - Instance Variable: " + instance2.instanceVariable);
    System.out.println("Static Variable: " + VariablesScopeTypes.staticVariable);
    System.out.println();

    // Modify instance variables and static variable
    instance1.instanceVariable = 3001;
    instance2.instanceVariable = 4001;
    VariablesScopeTypes.staticVariable = 200;

    // Display modified values
    System.out.println("Modified Values:");
    System.out.println("Instance 1 - Instance Variable: " + instance1.instanceVariable);
    System.out.println("Instance 2 - Instance Variable: " + instance2.instanceVariable);
    System.out.println("Static Variable: " + VariablesScopeTypes.staticVariable);
    System.out.println();

    // Demonstrate local variables
    instance1.localVariableMethod();
    instance2.localVariableMethod();
  }

  void localVariableMethod() {

    // Only accessible within the method or block where they are declared
    int localVariable = 50;
    System.out.println("Local Variable in " + this + ": "+ localVariable);
  }

  // Prevents that default implementation of the toString() method from the Object class,
  // be executed, which is used when you print the instance using System.out.println().
  @Override
  public String toString() {
    return "VariablesScopeTypes instance";
  }

}


