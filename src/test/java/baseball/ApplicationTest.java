package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void computerSelectThreeNumbers_서로_다른_3개의_정수가_생성되는지_확인() {
        Game game = new Game();
        game.computerSelectThreeNumbers();
        assertThat(game.numbersPickedByComputer).containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(game.numbersPickedByComputer.size()).isEqualTo(3);
        assertThat(game.numbersPickedByComputer.get(0)).isNotEqualTo(game.numbersPickedByComputer.get(1));
        assertThat(game.numbersPickedByComputer.get(0)).isNotEqualTo(game.numbersPickedByComputer.get(2));
        assertThat(game.numbersPickedByComputer.get(1)).isNotEqualTo(game.numbersPickedByComputer.get(2));
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
