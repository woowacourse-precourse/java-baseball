package baseball;

public class Exception {
  // 길이가 3이 아니면 - 추후 전역상수로 바꾸는게..
  public static boolean isRightLength(String userNumber) {
    if (userNumber.length() != 3)
      throw new IllegalArgumentException();
    return true;
  }
}
