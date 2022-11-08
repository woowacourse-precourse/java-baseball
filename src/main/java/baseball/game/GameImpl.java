package baseball.game;

import baseball.player.Computer;
import baseball.player.User;
import baseball.score.Result;
import baseball.score.Score;

public class GameImpl implements Game{
  public Computer computerPlayer;
  public User userPlayer;
  public Score score;
  public Boolean flag = true;

  @Override
  public void GameInit() {
    final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.";
    System.out.println(INIT_MESSAGE);
  }

  @Override
  public void GameReady() {
    computerPlayer = new Computer();
    userPlayer = new User();
  }

  @Override
  public void GameStart() {
    final String START_MESSAGE = "숫자를 입력해주세요 : ";
    System.out.print(START_MESSAGE);
    userPlayer.createUserInput();
  }

  @Override
  public void GameScore() {
    score = new Score();
    score.compareTwoNumber(computerPlayer.getComputerNumberList(), userPlayer.getUserNumberList());
  }
}
