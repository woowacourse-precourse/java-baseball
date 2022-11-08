package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {

  public String input;
  static String INPUT_ASKING = "숫자를 입력해주세요 :";

  public void inputFortheGame(){
    System.out.println(INPUT_ASKING);
    this.input = readLine();
  }

  public void inputThrowsException(){
    if(input.length() != 3){
      throw new IllegalArgumentException();
    }
  }

}
