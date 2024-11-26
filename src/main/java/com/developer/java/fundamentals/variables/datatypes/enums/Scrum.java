package com.developer.java.fundamentals.variables.datatypes.enums;

import java.util.Arrays;

public class Scrum {

  /**
   * Enum advantages: - makes the code more readable - allow for compile-time checking - document
   * the list of accepted values upfront - avoid unexpected behavior due to invalid values being
   * passed in - Comes with many useful methods that we would otherwise need to write if we were
   * using traditional public static final constants
   */
  public enum StoryStatus {
    BACKLOG("Backlog", "Has not yet been selected for development"),
    TODO(
        "Todo",
        "Has been selected for the current sprint during the Sprint Planning meeting but work has not yet started on it"),
    IN_PROGRESS("In Progress", "The team is actively working on it"),
    IN_REVIEW(
        "In Review",
        "Completed from a development perspective but is under review (e.g., code review, QA testing) to ensure it meets the acceptance criteria."),
    DONE(
        "Done",
        "Fully completed, meets the definition of done, and is accepted by the Product Owner");

    public String getDescription() {
      return description;
    }

    public String getName() {
      return name;
    }

    private final String name;
    private final String description;

    StoryStatus(String name, String description) {
      this.name = name;
      this.description = description;
    }

    private static StoryStatus getStatusByOrdinal(int ordinal) {
      if (ordinal < 0) {

        return Arrays.stream(StoryStatus.values()).findFirst().orElse(null);
      }

      if (ordinal > StoryStatus.values().length - 1) {
        return Arrays.stream(StoryStatus.values()).reduce((first, second) -> second).orElse(null);
      }

      return StoryStatus.values()[ordinal];
    }

    public static StoryStatus getNextState(
        StoryStatus currentState, boolean isCompletedSuccessfully) {
      return isCompletedSuccessfully
          ? getStatusByOrdinal(currentState.ordinal() + 1)
          : getStatusByOrdinal(currentState.ordinal() - 1);
    }
  }
}
