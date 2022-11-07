package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class PlayerTest {
  Player player;

  @BeforeEach
  void setUp(){
    player = new Player();
  }

  @ParameterizedTest
  @DisplayName("잘못된 입력이 들어왔을 때 IllegalArgumentException예외 테스트")
  @ValueSource(strings = {"abc", "122", "a12", "133", "1224"})
  void testWithValueSource(String stringArg){
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      player.decideNumbers(stringArg);
    });
  }
}
