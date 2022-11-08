package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
  public static final int STRIKE_OUT = 3;
  public static void main(String[] args) {
      System.out.println("숫자 야구 게임을 시작합니다.");
      while(true){
          Judge judge = new Judge();
      }
  }

  public static void printMessage(int strike, int ball){
    if(strike != 0 && ball == 0){
      System.out.println(strike + "스트라이크");
    } else if (strike == 0 && ball != 0) {
      System.out.println(ball + "볼");
    } else if(strike != 0){
      System.out.println(ball + "볼 " + strike + "스트라이크");
    } else {
      System.out.println("낫싱");
    }
  }

}
