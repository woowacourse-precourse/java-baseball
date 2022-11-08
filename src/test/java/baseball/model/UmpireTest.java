package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UmpireTest {

    @Test
    @DisplayName("3개의 숫자를 모두 맞추었다. 3Strike")
    void decideCount_3Strike() {
        Computer computer = new Computer();
        User user = new User();
        Umpire umpire = new Umpire();

        String answer = getComputerNumber(computer);
        user.addUserNumbers(answer);

        umpire.decideCount(computer.getNumbers(), user.getNumbers());

        assertThat(umpire.getStrikeCount()).isEqualTo(3);
        assertThat(umpire.is3Strike()).isTrue();
    }

    @Test
    @DisplayName("3개의 숫자를 모두 맞추지 못하였다.")
    void decideCount_Not3Strike() {
        Computer computer = new Computer();
        User user = new User();
        Umpire umpire = new Umpire();

        String userInput = getUserInputNot3Strike(computer.getNumbers());
        user.addUserNumbers(userInput);

        umpire.decideCount(computer.getNumbers(), user.getNumbers());

        assertThat(umpire.getStrikeCount()).isNotEqualTo(3);
        assertThat(umpire.is3Strike()).isFalse();
    }

    private String getComputerNumber(Computer computer) {
        List<Integer> computerNumbers = computer.getNumbers();
        StringBuilder sb = new StringBuilder();
        for (Integer computerNumber : computerNumbers) {
            sb.append(computerNumber);
        }
        return sb.toString();
    }

    private String getUserInputNot3Strike(List<Integer> computerNumbers) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            List<Integer> userNumbers = generateNumbers();
            if (!userNumbers.equals(computerNumbers)) {
                for (Integer userNumber : userNumbers) {
                    sb.append(userNumber);
                }
                break;
            }
        }
        return sb.toString();
    }

    private List<Integer> generateNumbers() {
        List<Integer> userNumbers = new ArrayList<>();
        while (userNumbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (userNumbers.contains(number)) {
                continue;
            }
            userNumbers.add(number);
        }
        return userNumbers;
    }
}