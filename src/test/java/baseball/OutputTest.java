package baseball;


import domain.ComputerNumberList;
import domain.Number;
import domain.UserInputNumberList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CompareNumber;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OutputTest {
    ComputerNumberList computerNumberList;
    UserInputNumberList userInputNumberList;
    CompareNumber compareNumber;

    @BeforeEach
    void createBaseBallGame() {
        computerNumberList = new ComputerNumberList();
        computerNumberList.generateNewComputerRandomNumber();
        List<Number> computerNumber = computerNumberList.getComputerNumber();
        userInputNumberList = new UserInputNumberList();
        compareNumber = new CompareNumber(computerNumber);
    }

    @Test
    void 볼이_1개_발생시_검증() {
        //given
        String computerInput;
        String userInput;
        String expectMsg = "1볼";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        computerInput = "123";
        userInput = "415";

        List<Number> computerList = Arrays.stream(computerInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());
        List<Number> userInputList = Arrays.stream(userInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());

        compareNumber.setComputerNumber(computerList);
        compareNumber.setUserNumber(userInputList);
        compareNumber.compare();
        //then
        Assertions.assertThat(expectMsg).isEqualTo(out.toString().trim());
    }

    @Test
    void 스트라이크_1개_발생시_검증() {
        //given
        String computerInput;
        String userInput;
        String expectMsg = "1스트라이크";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        computerInput = "123";
        userInput = "145";

        List<Number> computerList = Arrays.stream(computerInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());
        List<Number> userInputList = Arrays.stream(userInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());

        compareNumber.setComputerNumber(computerList);
        compareNumber.setUserNumber(userInputList);
        compareNumber.compare();
        //then
        Assertions.assertThat(expectMsg).isEqualTo(out.toString().trim());
    }

    @Test
    void 볼과_스트라이크가_각각_1개씩_발생시_출력_검증(){
        //given
        String computerInput;
        String userInput;
        String expectMsg = "1볼 1스트라이크";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        computerInput = "123";
        userInput = "142";

        List<Number> computerList = Arrays.stream(computerInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());
        List<Number> userInputList = Arrays.stream(userInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());

        compareNumber.setComputerNumber(computerList);
        compareNumber.setUserNumber(userInputList);
        compareNumber.compare();
        //then
        Assertions.assertThat(expectMsg).isEqualTo(out.toString().trim());
    }

    @Test
    void 아무것도_일치하지_않을떄_낫씽_출력(){
        //given
        String computerInput;
        String userInput;
        String expectMsg = "낫싱";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        computerInput = "123";
        userInput = "456";

        List<Number> computerList = Arrays.stream(computerInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());
        List<Number> userInputList = Arrays.stream(userInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());

        compareNumber.setComputerNumber(computerList);
        compareNumber.setUserNumber(userInputList);
        compareNumber.compare();
        //then
        Assertions.assertThat(expectMsg).isEqualTo(out.toString().trim());
    }
    @Test
    void 모두_일치할때_정답_여부_출력(){
        //given
        String computerInput;
        String userInput;
        String expectMsg = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        //when
        computerInput = "123";
        userInput = "123";

        List<Number> computerList = Arrays.stream(computerInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());
        List<Number> userInputList = Arrays.stream(userInput.split(""))
                .map(Number::new)
                .collect(Collectors.toList());

        compareNumber.setComputerNumber(computerList);
        compareNumber.setUserNumber(userInputList);
        compareNumber.compare();
        //then
        Assertions.assertThat(expectMsg).isEqualTo(out.toString().trim());
    }
}
