package baseball.view;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static baseball.view.InputView.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class viewTest {
    @Test
    void startProgramViewTest(){
        startProgramView();
    }

    @Test
    void inputNumbersViewTest(){
        Scanner scanner = new Scanner("111");
        assertThat(inputNumbersView(scanner)).isEqualTo("111");
    }

    @Test
    void inputRestartViewTest(){
        Scanner scanner = new Scanner("111");
        assertThat(inputRestartView(scanner)).isEqualTo("111");
    }
}
