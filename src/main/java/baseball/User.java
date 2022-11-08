package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

  public String input;
  static String INPUT_ASKING = "숫자를 입력해주세요 :";
  static String NOTICE_RESTART = "게임을 새로 시작하려면 1, "
                                + "종료하려면 2를 입력하세요.";

  public void inputFortheGame(){
    System.out.println(INPUT_ASKING);
    this.input = readLine();
  }

  public void inputThrowsException(){
    if(input.length() != 3){
      throw new IllegalArgumentException();
    }else if(!input.matches("[1-9]+")){
      throw new IllegalArgumentException();
    }else if(input.charAt(0) == input.charAt(1)
        || input.charAt(1) == input.charAt(2)
        || input.charAt(2) == input.charAt(0)){
      throw new IllegalArgumentException();
    }
  }

  public void inputRestartOption(){
    System.out.println(NOTICE_RESTART);
    this.input = readLine();
  }

  public void optionThrowsException(){
    if(!input.equals("1") && !input.equals("2")){
      throw new IllegalArgumentException();
    }
  }
}
