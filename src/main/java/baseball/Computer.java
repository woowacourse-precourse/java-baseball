package baseball;

import baseball.constant.InGameMessages;
import baseball.constant.InGameTerms;
import baseball.io.MessagePrinter;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
  public List<Integer> generateRandomNumber() {
    List<Integer> computer = new ArrayList<>();
    while (computer.size() < 3) {
      int randomNumber = Randoms.pickNumberInRange(1, 9);
      if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
      }
    }
    return computer;
  }

  public void printScore(int strikeCount, int ballCount) {
    MessagePrinter printer = new MessagePrinter();
    StringBuilder builder = new StringBuilder();
    String strikeMessage = InGameTerms.STRIKE.getTerm();
    String ballMessage = InGameTerms.BALL.getTerm();

    if(strikeCount == 3) {
      printer.printlnMessage(builder.append(strikeCount).append(strikeMessage).toString());
      printer.printlnMessage(InGameMessages.GAME_END.getMessage());
    } else if (ballCount > 0 && strikeCount > 0) {
      printer.printlnMessage(builder.append(ballCount).append(ballMessage).append(" ").append(strikeCount).append(strikeMessage).toString());
    } else if (ballCount > 0) {
      printer.printlnMessage(builder.append(ballCount).append(ballMessage).toString());
    } else if (strikeCount > 0) {
      printer.printlnMessage(builder.append(strikeCount).append(strikeMessage).toString());
    } else {
      printer.printlnMessage(InGameTerms.NOTHING.getTerm());
    }
  }
}
