package baseball.view;
import baseball.view.ScoreResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class ScoreResultViewTest {

    ScoreResultView scoreResultView;

    @BeforeEach
    void initializeClass(){
        scoreResultView = new ScoreResultView();
    }

//    @Test
//    void 스트라이크와_볼이_0일때_참(){
//        scoreResultView.setBallCount(0);
//        scoreResultView.setStrikeCount(0);
//        assertThat(scoreResultView.isNothing()).isTrue();
//    }
//
//    @Test
//    void 스트라이크가_0일때_참(){
//        scoreResultView.setBallCount(3);
//        scoreResultView.setStrikeCount(0);
//        assertThat(scoreResultView.isOnlyBall()).isTrue();
//    }
//
//    @Test
//    void 볼이_0일때_참(){
//        scoreResultView.setBallCount(0);
//        scoreResultView.setStrikeCount(3);
//        assertThat(scoreResultView.isOnlyStrike()).isTrue();
//    }

    @Test
    void 스트라이크와_볼이_0일때_낫싱_반환(){
        scoreResultView.setBallCount(0);
        scoreResultView.setStrikeCount(0);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        scoreResultView.printScore();
        assertThat(out.toString()).isEqualTo("낫싱\n");
    }

    @Test
    void 스트라이크가_0일때_볼만_반환(){
        scoreResultView.setBallCount(3);
        scoreResultView.setStrikeCount(0);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        scoreResultView.printScore();
        assertThat(out.toString()).isEqualTo("3볼 \n");
    }

    @Test
    void 볼이_0일때_스트라이크만_반환(){
        scoreResultView.setBallCount(0);
        scoreResultView.setStrikeCount(2);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        scoreResultView.printScore();
        assertThat(out.toString()).isEqualTo("2스트라이크\n");
    }

    @Test
    void 그외에는_둘다_반환(){
        scoreResultView.setBallCount(2);
        scoreResultView.setStrikeCount(1);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        scoreResultView.printScore();
        assertThat(out.toString()).isEqualTo("2볼 1스트라이크\n");
    }
}
