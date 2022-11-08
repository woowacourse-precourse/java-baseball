package baseball.domain.game;

import baseball.domain.player.Computer;
import baseball.domain.player.User;
import baseball.domain.score.Result;
import baseball.domain.score.Score;

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
    score.compareTwoNumber(computerPlayer.getNumberList(), userPlayer.getNumberList());
  }

  @Override
  public void GameResult(){
    Result result = new Result(score.getStrikeCount(), score.getBallCount());
    System.out.println(result.getResults());
  }

  @Override
  public void GameContinuity(){
    GameContinuity continuity = new GameContinuity();
    if(continuity.getContinuity()) {
      GameReady();
      return;
    }
    this.flag = false;
  }

  @Override
  public boolean GameFlag(){
    return this.flag;
  }

  @Override
  public boolean isStrike(){
    return this.score.getStrikeCount() == 3;
  }
}
