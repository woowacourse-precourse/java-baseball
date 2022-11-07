package baseball.game;

import baseball.dto.GameInputNumber;
import java.util.List;

public class BaseballGame {

  private final List<Integer> computerNumbers;

  public BaseballGame(List<Integer> numbers) {
    this.computerNumbers = numbers;
  }


  public GameResult start(GameInputNumber gameInputNumber){

    List<Integer> userNumbers = gameInputNumber.getNumbers();
    int strikeCount =  countStrike(userNumbers);

    return new GameResult(strikeCount, 0);
  }

  private int countStrike(List<Integer> userNumbers){
   int count = 0 ;
   for(int i = 0; i < 3; i++){
     if(computerNumbers.get(i).equals(userNumbers.get(i))){
       count++;
     }
   }
   return count;
  }

}
