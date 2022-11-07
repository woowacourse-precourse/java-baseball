package baseball;

public class ContinueOrStop {
  public static boolean choice(String num) {
    if (InputValidator.isValidButton(num)) {
      if (num.contains(Constant.CONTINUE_BUTTON)) {
        return true;
      }
      else if (num.contains(Constant.STOP_BUTTON)) {
        return false;
      }
    }
    throw new IllegalArgumentException(); //InputException 안으로
  }
}
