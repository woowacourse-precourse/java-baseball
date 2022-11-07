package baseball.mvc.structure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.helper.factory.FrontControllerFactory;
import baseball.util.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class FrontControllerTest {

    private FrontController standardFrontController;

    @Nested
    @DisplayName("process 메소드는")
    class ProcessMethodTest {

        @Nested
        @DisplayName("만약 플레이어 입력 값이 정상적인 경우")
        class ProcessMethodValidPlayerInputTest {

            @Test
            @DisplayName("플레이어 입력 값과 GameStaus.START가 주어지면 GameStatus.PLAY를 반환한다.")
            void game_status_play_return_test() {
                standardFrontController = new FrontController();
                GameStatus gameStatus = standardFrontController.process(null, GameStatus.START);

                assertThat(gameStatus).isSameAs(GameStatus.PLAY);
            }

            @Nested
            @DisplayName("GameStatus.PLAY가 주어졌고")
            class ProcessMethodGameStatusPlayTest {

                private FrontController stubFrontController;

                @Test
                @DisplayName("플레이어 입력 값이 3스트라이크라면 GameStatus.END를 반환한다.")
                void game_status_end_return_test() {
                    stubFrontController = FrontControllerFactory.createStubFrontController(3L, 0L);
                    GameStatus gameStatus = stubFrontController.process("123", GameStatus.PLAY);

                    assertThat(gameStatus).isSameAs(GameStatus.END);
                }

                @ParameterizedTest
                @CsvSource(
                        value = {
                            "0:0",
                            "1:0",
                            "2:0",
                            "0:1",
                            "0:2",
                            "1:1",
                            "2:1",
                            "1:2"
                        },
                        delimiter = ':'
                )
                @DisplayName("플레이어 입력 값이 3스트라이크가 아니라면 GameStatus.PLAY를 반환한다.")
                void game_status_play_return_test(long strike, long ball) {
                    stubFrontController = FrontControllerFactory.createStubFrontController(strike, ball);
                    GameStatus gameStatus = stubFrontController.process("123", GameStatus.PLAY);

                    assertThat(gameStatus).isSameAs(GameStatus.PLAY);
                }
            }

            @Nested
            @DisplayName("GameStatus.END가 주어졌고")
            class ProcessMethodGameStatusEndTest {

                @Test
                @DisplayName("플레이어 입력 값이 1이라면 GameStatus.START를 반환한다.")
                void game_status_play_return_test() {
                    standardFrontController = new FrontController();
                    GameStatus gameStatus = standardFrontController.process("1", GameStatus.END);

                    assertThat(gameStatus).isSameAs(GameStatus.START);
                }

                @Test
                @DisplayName("플레이어 입력 값이 2라면 GameStatus.EXIT를 반환한다.")
                void game_status_end_return_test() {
                    standardFrontController = new FrontController();
                    GameStatus gameStatus = standardFrontController.process("2", GameStatus.END);

                    assertThat(gameStatus).isSameAs(GameStatus.EXIT);
                }
            }
        }

        @Nested
        @DisplayName("만약 플레이어 입력 값이 정상적이지 않다면")
        class ProcessMethodWrongPlayerInputTest {

            @ParameterizedTest
            @ValueSource(
                    strings = {
                        "012",
                        "12",
                        "1234",
                        "1a2",
                        "ab2",
                        "+1",
                        ""
                    }
            )
            @DisplayName("플레이어 입력 값과 GameStatus.PLAY가 주어지면 IllegalArgumentException 예외가 발생한다.")
            void game_status_play_exception_test(String wrongPlayerInput) {
                standardFrontController = new FrontController();

                assertThatThrownBy(() -> standardFrontController.process(wrongPlayerInput, GameStatus.PLAY))
                        .isInstanceOf(IllegalArgumentException.class);
            }

            @ParameterizedTest
            @ValueSource(
                    strings = {
                        "0",
                        "3",
                        "a",
                        "+",
                        ""
                    }
            )
            @DisplayName("플레이어 입력 값과 GameStatus.END가 주어지면 IllegalArgumentException 예외가 발생한다.")
            void game_status_end_exception_test(String wrongPlayerInput) {
                standardFrontController = new FrontController();

                assertThatThrownBy(() -> standardFrontController.process(wrongPlayerInput, GameStatus.END))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}