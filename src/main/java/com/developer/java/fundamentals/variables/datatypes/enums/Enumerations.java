package com.developer.java.fundamentals.variables.datatypes.enums;

import com.developer.java.fundamentals.variables.datatypes.enums.Scrum.StoryStatus;
import java.util.OptionalInt;
import java.util.Random;
import java.util.stream.IntStream;

public class Enumerations {

  private static final Random random = new Random();

  private static final int TRANSITIONS = 10;

  public static void main(String[] args) {

    System.out.println("-- Multiple single transitions --");
    singleTransitonSimulations();
    System.out.println();
    System.out.println("-- End to End transitions --");
    endToEndStatusTransitions(StoryStatus.BACKLOG);
  }

  private static void singleTransitonSimulations() {
    for (int i = 0; i < TRANSITIONS; i++) {
      StoryStatus currentStatus = getRandomStoryStatus();
      boolean isCompletedSuccessfully = random.nextBoolean();
      StoryStatus nextStoryStatus =
          StoryStatus.getNextState(currentStatus, isCompletedSuccessfully);
      prettyPrint(currentStatus, isCompletedSuccessfully, nextStoryStatus);
    }
  }

  private static void prettyPrint(
      StoryStatus currentStatus, boolean isCompletedSuccessfully, StoryStatus nextStoryStatus) {
    System.out.println();
    System.out.println("Currently story is in " + currentStatus.getName() + " status, ");
    System.out.println(currentStatus.getDescription());
    System.out.println(
        isCompletedSuccessfully
            ? "and as we are on track, we can now go to next status"
            : "but things went south, we have to take a step back");
    System.out.println(
        "Next status will be "
            + nextStoryStatus.getName()
            + " status ("
            + currentStatus.getName().toUpperCase()
            + " -> "
            + nextStoryStatus.getName().toUpperCase()
            + ")");
    System.out.println();
  }

  private static void endToEndStatusTransitions(StoryStatus currentStatus) {

    if (currentStatus != StoryStatus.DONE) {
      boolean isCompletedSuccessfully = random.nextBoolean();
      StoryStatus nextStoryStatus =
          StoryStatus.getNextState(currentStatus, isCompletedSuccessfully);
      prettyPrint(currentStatus, isCompletedSuccessfully, nextStoryStatus);

      endToEndStatusTransitions(nextStoryStatus);
    }
  }

  private static StoryStatus getRandomStoryStatus() {

    int numberOfStoryStatus = StoryStatus.values().length;
    OptionalInt randomOrdinalStatus =
        IntStream.range(0, 1).map(i -> random.nextInt(numberOfStoryStatus - 1)).findFirst();

    return StoryStatus.values()[randomOrdinalStatus.orElse(0)];
  }
}
