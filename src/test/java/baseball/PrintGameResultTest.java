package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.util.InputValueValidation;
import baseball.view.GameMessage;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PrintGameResultTest {
    @Nested
    class GetStrikeCountResultTest {
        @Test
        void case1() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.STRIKE, 1);
                }
            };
            assertThat(gameMessage.getStrikeCountResult(result.get(BaseballScore.STRIKE))).isEqualTo("1스트라이크");
        }

        @Test
        void case2() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.STRIKE, 3);
                }
            };
            assertThat(gameMessage.getStrikeCountResult(result.get(BaseballScore.STRIKE))).isEqualTo("3스트라이크");
        }

        @Test
        void case3() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.STRIKE, 0);
                }
            };
            assertThat(gameMessage.getStrikeCountResult(result.get(BaseballScore.STRIKE))).isEqualTo("");
        }
    }

    @Nested
    class GetBallCountResultTest {
        @Test
        void case1() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.BALL, 1);
                }
            };
            assertThat(gameMessage.getBallCountResult(result.get(BaseballScore.BALL))).isEqualTo("1볼");
        }

        @Test
        void case2() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.BALL, 3);
                }
            };
            assertThat(gameMessage.getBallCountResult(result.get(BaseballScore.BALL))).isEqualTo("3볼");
        }

        @Test
        void case3() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.BALL, 0);
                }
            };
            assertThat(gameMessage.getBallCountResult(result.get(BaseballScore.BALL))).isEqualTo("");
        }
    }

    @Nested
    class GetNothingCountResultTest {
        @Test
        void case1() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.NOTHING, 1);
                }
            };
            assertThat(gameMessage.getNothingResult(result.get(BaseballScore.NOTHING))).isEqualTo("");
        }

        @Test
        void case2() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.NOTHING, 3);
                }
            };
            assertThat(gameMessage.getNothingResult(result.get(BaseballScore.NOTHING))).isEqualTo("낫싱");
        }

        @Test
        void case3() {
            GameMessage gameMessage = new GameMessage();
            Map<BaseballScore, Integer> result = new HashMap<>() {
                {
                    put(BaseballScore.NOTHING, 0);
                }
            };
            assertThat(gameMessage.getNothingResult(result.get(BaseballScore.NOTHING))).isEqualTo("");
        }
    }
}
