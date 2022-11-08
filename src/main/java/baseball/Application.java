package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
  public static final int RESTART = 1;
  public static final int EXIT = 2;
  public static final int STRIKE_OUT = 3;
  public static void main(String[] args) {
      System.out.println("숫자 야구 게임을 시작합니다.");
      while(true){
          Judge judge = new Judge();
      }
  }
}
