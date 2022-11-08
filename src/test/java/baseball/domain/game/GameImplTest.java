package baseball.domain.game;

import static baseball.domain.game.GameContinuity.USER_INPUT_ERROR_MESSAGE;
import static baseball.domain.player.Computer.COMPUTER_NUMBER_SIZE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameImplTest {
  private static GameImpl baseballGame;
  private static final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.";
  private final Integer RESTART = 1;
  private final Integer CLOSE = 2;

  @BeforeAll
  static void test_init() {
    baseballGame = new GameImpl();
  }

  @Test
  @DisplayName("게임이 시작되면 정해진 게임 시작 문구를 출력한다.")
  void game_init_test(){
    assertEquals(INIT_MESSAGE, baseballGame.GameInit(),
        () -> "게임 초기 단계에서 게임 시작 문구를 출력해야합니다.");
  }

  @Test
  @DisplayName("컴퓨터 플레이어가 랜덤 세 자리수를 생성하며 게임을 준비한다.")
  void game_ready_test_1(){
    baseballGame.GameReady();
    int computerPlayerNumberSize = baseballGame.computerPlayer.getNumberList().size();
    assertEquals(COMPUTER_NUMBER_SIZE, computerPlayerNumberSize,
        ()-> "게임 준비 단계에서 컴퓨터 플레이어가 세 자리수를 생성해야합니다.");
  }

  @Test
  @DisplayName("유저 플레이어는 숫자를 입력 받을 준비를 하며 게임을 준비한다.")
  void game_ready_test_2(){
    baseballGame.GameReady();
    assertNotNull(baseballGame.userPlayer,
        () -> "게임 준비 단계에서 유저 플레이어의 인스턴스가 생성되어야합니다.");
  }


  @ParameterizedTest(name = "[{index}] input={0}")
  @ValueSource(ints = { 0, 3, 4 })
  @DisplayName("게임 지속의 1과 게임 종료의 2가 아닌 다른 수를 입력했을 때 오류가 발생한다.")
  void game_continuity_test(final Integer input){
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new GameContinuity(input));
    assertEquals(USER_INPUT_ERROR_MESSAGE, exception.getMessage());
  }
}
