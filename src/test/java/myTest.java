import baseball.ComputerNumGenerator;
import baseball.Game;
import baseball.UserNumGenerator;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class myTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 컴퓨터_숫자가_정상적으로_생성되는지() {
        List<Integer> nums = new ComputerNumGenerator().NUMS;
        String num = nums.toString().replaceAll("[^1-9]","");
        boolean result = false;
        if (num.matches("[0-9]{3}") ) {
            result = true;
        }
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 유저_숫자_검증1() {
        assertThatThrownBy(() -> new UserNumGenerator("12324"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_숫자_검증2() {
        assertThatThrownBy(() -> new UserNumGenerator("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_숫자_검증3() {
        assertThatThrownBy(() -> new UserNumGenerator("111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_숫자가_정상일_때() {
        List<Integer> nums = new UserNumGenerator("153").NUMS;
        List<Integer> result = List.of(1, 5, 3);
        assertThat(result.toString()).isEqualTo(nums.toString());
    }

    @BeforeEach


    @Test
    void 게임_로직_검증1() {
        List<Integer> nums = new ComputerNumGenerator().NUMS;
        nums.removeAll(nums);
        nums.add(1);
        nums.add(5);
        nums.add(3);

        Game game = new Game(nums);
        InputStream in = generateUserInput("153");
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);

        String result = game.play();
        String answer = "0볼 3스트라이크";
        assertThat(result).isEqualTo(answer);

    }
}
