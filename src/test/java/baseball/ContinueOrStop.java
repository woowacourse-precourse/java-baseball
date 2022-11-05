package baseball;

public class ContinueOrStop {
  public static boolean choice(String num) {
    if (num.contains("1"))
      return true;
    else if (num.contains("2"))
      return false;
    else
      throw new IllegalArgumentException();
  }
}
