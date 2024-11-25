package com.developer.java.fundamentals;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class PassByValueNotByReference {

  private static Map<Owner, Car> carOwnerCollection = new HashMap<>();

  public static void main(String... args) {

    carOwnerCollection.put(Owner.ANGELINA, new Car(CarBrand.FERRARI));
    carOwnerCollection.put(Owner.CLINT, new Car(CarBrand.VOLVO));
    carOwnerCollection.put(Owner.UMA, new Car(CarBrand.RENAULT));

    printFormatted("Original drivers and respective cars:", false, true);
    printCarCollection();

    carReferenceSwapping(Owner.ANGELINA, Owner.CLINT);
    printCarCollection();

    carValueSwap(Owner.CLINT, Owner.UMA);
    printFormatted("Final list:", false, true);
    printCarCollection();
  }

  public static void carReferenceSwapping(Owner owner1, Owner owner2) {

    Car car1 = carOwnerCollection.get(owner1);
    Car car2 = carOwnerCollection.get(owner2);
    printFormatted("Example 1) ", true, false);
    printFormatted("========== ", false, true);
    printFormatted(
        "Java uses pass-by-value for method parameters, meaning the method receives ", true, false);
    printFormatted(
        "a copy of the reference to the object, not the original reference itself.", false, true);

    printFormatted(
        "Let's swap "
            + owner1.getName()
            + "'s "
            + car1.getMaker().getBrandName()
            + " with "
            + owner2.getName()
            + " "
            + car2.getMaker().getBrandName(),
        false,
        true);

    printFormatted(
        "\tswap(" + car1.getMaker().getBrandName() + "," + car2.getMaker().getBrandName() + ");");
    swap(car1, car2);
  }

  public static void printCarCollection() {

    PassByValueNotByReference.carOwnerCollection.forEach(
        (owner, car) -> {
          printFormatted("\t" + owner.getName() + " drives a " + car.getMaker().getBrandName());
        });
  }

  private static void swap(Car car1, Car car2) {

    printFormatted("\tvoid swap(Car car1, Car car2){");
    printFormatted("\t\tCar temp = car1;");
    printFormatted("\t\tcar1 = car2;");
    printFormatted("\t\tcar2 = temp;");
    printFormatted("\t\t...", false, true);

    Car temp = car1;
    car1 = car2;
    car2 = temp;

    printFormatted(
        " As you can see the results bellow, reassigning the reference itself does not affect the original reference: ",
        false,
        true);
  }

  private static void carValueSwap(Owner owner1, Owner owner2) {

    Car car1 = carOwnerCollection.get(owner1);
    Car car2 = carOwnerCollection.get(owner2);
    printFormatted("Example 2) ", true, false);
    printFormatted("========== ", false, true);
    printFormatted(
        "However, modifying the object's state (via its methods or fields) affects the original object",
        true,
        true);

    printFormatted(
        "Let's set  "
            + owner1.getName()
            + "'s car brand "
            + car1.getMaker().getBrandName()
            + " with "
            + owner2.getName()
            + " "
            + car2.getMaker().getBrandName(),
        false,
        true);

    changeValue(car1, car2);
  }

  private static void changeValue(Car car1, Car car2) {

    printFormatted("\tvoid changeValue(Car car1, Car car2){");
    printFormatted("\t\tcar1.setMaker(car2.getMaker());", true, true);
    printFormatted("\t\t...", false, true);

    printFormatted("car1 is a copy of the reference pointing to the original  object.");
    printFormatted(
        "This modifies the maker of the object referenced by car1("
            + car1.getMaker().getBrandName()
            + "), setting it to the maker of car2("
            + car2.getMaker().getBrandName()
            + ") ");

    car1.setMaker(car2.getMaker());
    printFormatted("In fact, we can check the changes: ", false, true);
    printCarCollection();

    printFormatted("Example 3) ", true, false);
    printFormatted("========== ", false, true);

    printFormatted(
        "Let's create a new Car object with CarBrand.FERRARI and reassign the local reference car1 to this new object.",
        true,
        true);
    printFormatted("\tvoid changeValue(Car car1, Car car2){");
    printFormatted("\t\tcar1.setMaker(car2.getMaker());");
    printFormatted("\t\tcar1 = new Car(CarBrand.FORD);");
    printFormatted("\t\t...", false, true);
    car1 = new Car(CarBrand.FORD);

    printFormatted("This does not affect the original reference outside the method, ", true, false);
    printFormatted("because you are only reassigning the local copy of the reference.");
    printFormatted("Example 4) ", true, false);
    printFormatted("========== ", false, true);
    printFormatted(
        "Last example, continuing from previous case, at this point, car1 current maker is:"
            + car1.getMaker().getBrandName(),
        true,
        true);

    printFormatted("And our car collection list is:", false, true);
    printCarCollection();
    printFormatted(
        "Let's create a new Car object with CarBrand.MERCEDES and reassign the local reference car1 to this new object.",
        true,
        true);
    printFormatted("\tvoid changeValue(Car car1, Car car2){");
    printFormatted("\t\tcar1.setMaker(car2.getMaker());");
    printFormatted("\t\tcar1 = new Car(CarBrand.FORD);");
    printFormatted("\t\tcar1.setMaker(CarBrand.MERCEDES);");
    printFormatted("\t\t...", false, true);
    car1.setMaker(CarBrand.MERCEDES);
    printFormatted(
        "This has no effect on the original object outside the method because car1 now points to the new Car object.",
        false,
        true);
  }

  public static void printFormatted(String message) {
    System.out.println(message);
  }

  public static void printFormatted(
      String message, boolean linebreakPrefix, boolean linebreakSuffix) {
    Consumer<Boolean> lineBreak =
        shouldBreak -> {
          if (Boolean.TRUE.equals(shouldBreak)) System.out.println();
        };

    lineBreak.accept(linebreakPrefix);
    PassByValueNotByReference.printFormatted(message);
    lineBreak.accept(linebreakSuffix);
  }
}

class Car {

  private CarBrand maker;

  public void setMaker(CarBrand maker) {
    this.maker = maker;
  }

  public CarBrand getMaker() {
    return maker;
  }

  public Car(CarBrand maker) {

    this.maker = maker;
  }
}

enum CarBrand {
  VOLVO("Volvo"),
  MERCEDES("Mercedes"),
  FORD("Ford"),
  FERRARI("Ferrari"),
  RENAULT("Renault");

  public String getBrandName() {
    return brandName;
  }

  private final String brandName;

  CarBrand(String brandName) {
    this.brandName = brandName;
  }
}

enum Owner {
  JOHN("John Travolta"),
  UMA("Uma Thurman"),
  ANGELINA("Angelina Jolie"),
  JOSH("Josh Brolin"),
  CLINT("Clint Eastwood");

  private final String name;

  Owner(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
