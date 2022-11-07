package baseball.Controller;

import baseball.Service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballController {

    private BaseballService baseballService;

    private int strike=0;
    private int ball=0;
//    private int matchCount=0;
    public static List<String> randomList = new ArrayList<>();
    private List<String> inputList = new ArrayList<>();

    //게임 시작
    public void startBaseballGame() {
        randomList = baseballService.createRandomNumber();
        inputList = readInputNumber();
    }

    //유저가 입력한 숫자 받기
    public List<String> readInputNumber() {
        String inputNumber = Console.readLine();

        String[] numberToArray = inputNumber.split("");
        List<String> userNumber = new ArrayList<String>(Arrays.asList(numberToArray));

        return userNumber;
    }

    //스트라이크 판정 및 카운트
    public void isNumberStrike(List<String> randomNumber, List<String> inputNumber, String number) {
        if (randomNumber.contains(number) && randomNumber.indexOf(number) == inputNumber.indexOf(number)) {
            strike = countStrikeOrBall(strike);
        }
    }

    //볼 판정 및 카운트
    public void isNumberBall(List<String> randomNumber, List<String> inputNumber, String number) {
        if(randomNumber.contains(number) && randomNumber.indexOf(number)!=inputNumber.indexOf(number)) {
            ball = countStrikeOrBall(ball);
        }
    }

}
