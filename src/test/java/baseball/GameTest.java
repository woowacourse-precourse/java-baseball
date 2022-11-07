package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.Randoms;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GameTest {
  private Game game;

  private static ByteArrayOutputStream outContent;
  private static PrintStream originalOut;

  @BeforeEach
  public void setUp(){
    game = new Game("1");
  }

  //    String 상태로 내가 넣어준 테스트용 input을 바이트 코드로 바꾸어 준다.
  public static InputStream generateUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }
  public void generateNumberForTest(String input) {
    if (game.validateChecker(input)) {
      throw new IllegalArgumentException("1, 또는 2를 입력해야 합니다.");
    }
  }


  @Test
  @Order(1)
  @DisplayName("유효성 검사 1. Null 확인")
  public void generateNumberValidateIsStringNotNull() {
    Assertions.assertThatThrownBy(() -> {
      game.generateNumberTest("");
    }).isInstanceOf(IllegalArgumentException.class);
  }


  @Order(2)
  @DisplayName("유효성 검사 2. 유효한 값 1 확인")
  @ParameterizedTest(name ="{displayName}) {index} = {0} ")
  @ValueSource(strings = {"1", "2"})
  public void generateNumberValidateIsStringOne(String inputString) {
    InputStream in = generateUserInput(inputString);
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    assertThatThrownBy(() -> generateNumberForTest(scanner.toString()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("1, 또는 2를 입력해야 합니다.");
  }

  @Order(3)
  @DisplayName("유효성 검사 3. 유효하지 않은 값 확인")
  @ParameterizedTest(name ="{displayName}) {index} = {0} ")
  @ValueSource(strings = {"3", "4", "0"})
  public void generateNumberValidateIsStringUnavailable(String inputString) {
    InputStream in = generateUserInput(inputString);
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    assertThatThrownBy(() -> generateNumberForTest(scanner.toString()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("1, 또는 2를 입력해야 합니다.");
  }

  @Order(4)
  @DisplayName("유효성 검사 4. 기타 값 확인")
  @ParameterizedTest(name ="{displayName}) {index} = {0} ")
  @ValueSource(strings = {"a", "ㄱ" , "5", "6", "50", "hello"})
  public void generateNumberValidateRandomTest(String inputString) {
    InputStream in = generateUserInput(inputString);
    System.setIn(in);
    Scanner scanner = new Scanner(System.in);
    assertThatThrownBy(() -> generateNumberForTest(scanner.toString()))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("1, 또는 2를 입력해야 합니다.");

  }
}