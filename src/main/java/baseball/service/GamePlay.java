package baseball.service;

import baseball.game.Game;

public class GamePlay {

  public static void start(Class<Game> gameClazz) {
    Game game = getGameInstance(gameClazz);
    game.play();
  }

  private static Game getGameInstance(Class<Game> gameClazz) {
    try {
      return gameClazz.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
      throw new IllegalArgumentException("잘못된 게임 클래스입니다.");
    }
  }
}
