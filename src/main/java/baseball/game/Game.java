package baseball.game;

import baseball.dataStorage.DataStorage;
import baseball.tool.AnswerHandler;
import baseball.tool.RandomGenerator;
import baseball.tool.Signal;
import baseball.tool.TextPrinter;
import baseball.tool.TextScanner;

public class Game {

  AnswerHandler answerHandler = new AnswerHandler();
  RandomGenerator randomGenerator = new RandomGenerator();


  public Signal tryGame() throws IllegalArgumentException {
    DataStorage.resetResult();
    randomGenerator.makeRandomNumber();  //랜덤한 숫자를 생성한다.
    while (!answerHandler.isStrike()) {  //확인한다.
      TextPrinter.printGetAnswer();
      TextScanner.scanAnswer();     //input을 받는다.
      answerHandler.calcResult();   //게임 결과를 계산한다.
      TextPrinter.printResult();    //게임 결과를 출력한다.
    }
    TextPrinter.printGetSignal();
    return TextScanner.scanSignal();
  }

}
