package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UnitTest {

    // 2. Print the game start message test
    @Test
    void printTheGameStartMessageTest() {
        String message = Application.printTheGameStartMessage();
        Assertions.assertThat(message).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    // 3. Get random number
    @Test
    void getRandomNumberTest() {
        String number = Application.getRandomNumber();
        int count = 0;

        char firstDigit = number.charAt(0);
        char secondDigit = number.charAt(1);
        char thirdDigit = number.charAt(2);

        if (firstDigit != secondDigit) {
            count += 1;
        }
        if (firstDigit != thirdDigit) {
            count += 1;
        }
        if (secondDigit != thirdDigit) {
            count += 1;
        }

        Assertions.assertThat(count).isEqualTo(3);
    }

    // 6. Get score of the current turn
    @Test
    void getScoreOfTheCurrentTurnTest() {
        String scoreOne = Application.getScoreOfTheCurrentTurn("123", "456");
        String scoreTwo = Application.getScoreOfTheCurrentTurn("123", "123");
        String scoreThree = Application.getScoreOfTheCurrentTurn("143", "351");

        Assertions.assertThat(scoreOne).isEqualTo("0 0");
        Assertions.assertThat(scoreTwo).isEqualTo("0 3");
        Assertions.assertThat(scoreThree).isEqualTo("2 0");
    }

    // 7. Judge strike
    @Test
    void judgeStrikeTest() {
        int caseOne = Application.judgeStrike("1", "1", "123");
        int caseTwo = Application.judgeStrike("1", "0", "230");

        Assertions.assertThat(caseOne).isEqualTo(1);
        Assertions.assertThat(caseTwo).isEqualTo(0);
    }

    // 8. Judge ball
    @Test
    void judgeBallTest() {
        int caseOne = Application.judgeBall("1", "2", "213");
        int caseTwo = Application.judgeBall("1", "0", "230");

        Assertions.assertThat(caseOne).isEqualTo(1);
        Assertions.assertThat(caseTwo).isEqualTo(0);
    }

    // 9. Get the result of the current turn
    @Test
    void getResultOfTheCurrentTurnTest() {
        String caseOne = Application.getResultOfTheCurrentTurn("0 0");
        String caseTwo = Application.getResultOfTheCurrentTurn("0 3");
        String caseThree = Application.getResultOfTheCurrentTurn("0 1");
        String caseFour = Application.getResultOfTheCurrentTurn("1 0");
        String caseFive = Application.getResultOfTheCurrentTurn("1 1");

        Assertions.assertThat(caseOne).isEqualTo("낫싱");
        Assertions.assertThat(caseTwo).isEqualTo("3스트라이크");
        Assertions.assertThat(caseThree).isEqualTo("1스트라이크");
        Assertions.assertThat(caseFour).isEqualTo("1볼");
        Assertions.assertThat(caseFive).isEqualTo("1볼 1스트라이크");

    }
}
