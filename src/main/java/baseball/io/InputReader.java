package baseball.io;

import camp.nextstep.edu.missionutils.Console;

public class InputReader {

  InputValidator playingInputValidator;
  InputValidator replayOrEndInputValidator;

  public InputReader() {
    playingInputValidator = new PlayingInputValidator();
    replayOrEndInputValidator = new ReplayOrEndInputValidator();
  }

  public String readPlayingInput() {
    String input = Console.readLine();
    playingInputValidator.validate(input);
    return input;
  }

  public String readRestartOrEndInput() {
    String input = Console.readLine();
    replayOrEndInputValidator.validate(input);
    return input;
  }
}
