package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Feat4Test {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out); // 원상복귀
    }

    @Test
    void 스트라이크_출력_검사(){
        GameService gameService = new GameService();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNUmber = new ArrayList<>(Arrays.asList(1, 2, 6));
        Integer strike = gameService.countStrike(randomNumber, userNUmber);
        Integer ball = gameService.countBall(randomNumber, userNUmber);
        gameService.printResult(strike, ball);
        assertThat(outputMessage.toString()).contains("2스트라이크");
    }

    @Test
    void 볼_출력_검사(){
        GameService gameService = new GameService();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNUmber = new ArrayList<>(Arrays.asList(2, 3, 1));
        Integer strike = gameService.countStrike(randomNumber, userNUmber);
        Integer ball = gameService.countBall(randomNumber, userNUmber);
        gameService.printResult(strike, ball);
        assertThat(outputMessage.toString()).contains("3볼");
    }

    @Test
    void 볼_스트라이크_출력_검사(){
        GameService gameService = new GameService();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNUmber = new ArrayList<>(Arrays.asList(1, 3, 2));
        Integer strike = gameService.countStrike(randomNumber, userNUmber);
        Integer ball = gameService.countBall(randomNumber, userNUmber);
        gameService.printResult(strike, ball);
        assertThat(outputMessage.toString()).contains("2볼 1스트라이크");
    }

    @Test
    void 낫싱_출력_검사(){
        GameService gameService = new GameService();

        List<Integer> randomNumber = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNUmber = new ArrayList<>(Arrays.asList(4, 5, 6));
        Integer strike = gameService.countStrike(randomNumber, userNUmber);
        Integer ball = gameService.countBall(randomNumber, userNUmber);
        gameService.printResult(strike, ball);
        assertThat(outputMessage.toString()).contains("낫싱");
    }
}
