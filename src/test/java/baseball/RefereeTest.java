package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Test
    void scoring_위치가_다른_일치하는_수가_1개면_1볼() {
        Referee referee = new Referee();
        TestableGame game = new TestableGame();
        game.setAnswer(List.of(new Integer[]{1, 2, 3}));

        String decision = referee.scoring(game.getAnswer(), List.of(new Integer[]{2, 4, 5}));

        assertThat(decision).isEqualTo("1볼");
    }

    @Test
    void scoring_위치가_같은_일치하는_수가_1개면_1스트라이크() {
        Referee referee = new Referee();
        TestableGame game = new TestableGame();
        game.setAnswer(List.of(new Integer[]{1, 2, 3}));

        String decision = referee.scoring(game.getAnswer(), List.of(new Integer[]{4, 2, 5}));

        assertThat(decision).isEqualTo("1스트라이크");
    }

    @Test
    void scoring_1볼_1스트라이크() {
        Referee referee = new Referee();
        TestableGame game = new TestableGame();
        game.setAnswer(List.of(new Integer[]{1, 2, 3}));

        String decision = referee.scoring(game.getAnswer(), List.of(new Integer[]{4, 2, 1}));

        assertThat(decision).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void scoring_낫싱() {
        Referee referee = new Referee();
        TestableGame game = new TestableGame();
        game.setAnswer(List.of(new Integer[]{1, 2, 3}));

        String decision = referee.scoring(game.getAnswer(), List.of(new Integer[]{4, 5, 6}));

        assertThat(decision).isEqualTo("낫싱");
    }

    @Test
    void scoring_정답() {
        Referee referee = new Referee();
        TestableGame game = new TestableGame();
        game.setAnswer(List.of(new Integer[]{1, 2, 3}));

        String decision = referee.scoring(game.getAnswer(), List.of(new Integer[]{1, 2, 3}));

        assertThat(decision).isEqualTo("3스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}

class TestableGame extends Game {

    public void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }
}
