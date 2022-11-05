package baseball;

public class ContinueOrStop {
  public static boolean choice(String num) {
    if (Exception.isValidButton(num)) {
      if (num.contains("1")) // 얘두 전역변수로?
        return true;
      else if (num.contains("2"))
        return false;
    }
    throw new IllegalArgumentException();
  }
}
