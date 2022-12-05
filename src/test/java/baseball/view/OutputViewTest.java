package baseball.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("OutputView 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class OutputViewTest {

    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
    }


    @Test
    public void 시작_문구_출력(){
        String expect = "숫자 야구 게임을 시작합니다." + "\n";
        String actual = outputView.printStart();

        assertEquals(expect, actual);
    }

}