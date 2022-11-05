package baseball;

import java.util.ArrayList;

public class Judge {
  private Computer computer;
  private Player player;
  private static final int MAX_SIZE = 3;
  public Judge(){
    this.player = new Player();
    this.computer = new Computer();
    System.out.println("숫자 야구 게임을 시작합니다.");
  }

  public int compareBalls(){
    ArrayList<Integer> playerNumbers = this.player.decideNumbers();
    ArrayList<Integer> computerNumbers = this.computer.getNumbers();
    int strike = 0;
    int ball = 0;
    for(int i = 0; i < MAX_SIZE; i++){
      if(playerNumbers.get(i).equals(computerNumbers.get(i))) {
        strike ++;
      } else if (computerNumbers.contains(playerNumbers.get(i))) {
        ball++;
      }
    }
    return strike;
  }
}
