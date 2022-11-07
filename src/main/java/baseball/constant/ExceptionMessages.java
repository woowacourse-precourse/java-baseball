package baseball.constant;

public enum ExceptionMessages {
  INPUT_IS_NOT_UNIQUE("The input value contains a duplicate number."),
  INPUT_IS_NOT_DIGIT("The input value isn't between 1 and 9."),
  INPUT_LENGTH_IS_NOT_THREE("The length of the input is not 3."),
  INPUT_IS_NOT_1_OR_2("Input value is not 1 or 2.");

  private String message;

  ExceptionMessages(String message) {
    this.message = message;
  }

  public String getExceptionMessage() {
    return message;
  }
}
