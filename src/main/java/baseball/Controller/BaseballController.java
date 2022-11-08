package baseball.Controller;

import baseball.Service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballController {

    private BaseballService baseballService;
//    private int matchCount=0;
    public static List<String> randomList = new ArrayList<>();
    private List<String> inputList = new ArrayList<>();

    //게임 시작
    public void startBaseballGame() {
        String strikeAndBallMessage;
        randomList = baseballService.createRandomNumber();
        inputList = readInputNumber();
        strikeAndBallMessage = countStrikeOrBall(randomList, inputList);
    }

    //유저가 입력한 숫자 받기
    public List<String> readInputNumber() {
        String inputNumber = Console.readLine();

        String[] numberToArray = inputNumber.split("");
        List<String> userNumber = new ArrayList<String>(Arrays.asList(numberToArray));

        return userNumber;
    }

    //스트라이크 또는 볼 판정
    public String countStrikeOrBall(List<String> randomNumber, List<String> inputNumber) {
        int strike=0;
        int ball=0;
        String outputMessage;

        for(String number: inputNumber) {
            strike = countStrike(randomNumber, inputNumber, number, strike);
            ball = countBall(randomNumber, inputNumber, number, ball);
        }
        outputMessage = result(strike, ball);

        return outputMessage;
    }


    //스트라이크 판정 및 카운트
    public int countStrike(List<String> randomNumber, List<String> inputNumber, String number, int strike) {
        int strikeCount=0;
        if (randomNumber.contains(number) && randomNumber.indexOf(number) == inputNumber.indexOf(number)) {
            strikeCount = countStrikeOrBall(strike);
        }
        return strikeCount;
    }

    //볼 판정 및 카운트
    public int countBall(List<String> randomNumber, List<String> inputNumber, String number, int ball) {
        int ballCount=0;
        if(randomNumber.contains(number) && randomNumber.indexOf(number)!=inputNumber.indexOf(number)) {
            ballCount = countStrikeOrBall(ball);
        }
        return ballCount;
    }

    //스트라이크 또는 볼 카운트 함수
    public int countStrikeOrBall(int StrikeOrBall) {
        return StrikeOrBall+1 ;
    }

    //스트라이크 볼 출력
    public String result(int strike, int ball) {
        String outputMessage="";
        if (strike==3) {
            outputMessage = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료";
            //게임이 종료되었다는 문구+게임 이대로 종료할지 재시작할지 입력받기
        } else if (strike==0 && ball==0) {
            outputMessage = "낫싱";
        } else {
            outputMessage = ball+"볼 "+strike+"스트라이크";
        }

        return outputMessage;
    }

}
