package baseball.Controller;

import baseball.Service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballController {

    private BaseballService baseballService;

    private int strike=0;
    private int matchCount=0;

    //게임 시작
    public void startBaseballGame() {

    }

    //유저가 입력한 숫자 받기
    public List<String> readInputNumber() {
        String inputNumber = Console.readLine();

        String[] numberToArray = inputNumber.split("");
        List<String> userNumber = new ArrayList<String>(Arrays.asList(numberToArray));

        return userNumber;
    }

    //스트라이크 판정
    public int checkStrike(List<String> randomNumber, List<String> inputNumber) {
        for(String number: inputNumber) {
            if(randomNumber.contains(number)) {
                if(randomNumber.indexOf(number)==inputNumber.indexOf(number)) {
                    strike+=1;
                }
            }
        }

        return strike;
    }

}
