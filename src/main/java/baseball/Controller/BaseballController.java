package baseball.Controller;

import baseball.Domain.Baseball;
import baseball.Service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballController {

    private BaseballService baseballService;
    public Baseball baseball;

    public static List<String> randomList = new ArrayList<>();
    private List<String> inputList = new ArrayList<>();
    private int strike = 0;
    private int ball = 0;

    //게임 시작
    public void startBaseballGame() {

        baseball = new Baseball(randomList, inputList, strike, ball);

        printStartMessage();

        randomList = baseballService.createRandomNumber();
        baseball.setComputerNumber(randomList);

        while(baseball.getStrike()!=3) {
            inputList = readInputNumber();
            baseball.setInputNumber(inputList);

            countStrikeOrBall(randomList, inputList);

            result(baseball.getStrike(), baseball.getBall());
        }

        result(baseball.getStrike(), baseball.getBall());

        gameExit(Integer.parseInt(Console.readLine()));
    }

    //유저가 입력한 숫자 받기
    public List<String> readInputNumber() {
        printInputMessage();
        String inputNumber = Console.readLine();

        String[] numberToArray = inputNumber.split("");
        List<String> userNumber = new ArrayList<String>(Arrays.asList(numberToArray));

        return userNumber;
    }

    //스트라이크 또는 볼 판정
    public void countStrikeOrBall(List<String> randomNumber, List<String> inputNumber) {

        for(String number: inputNumber) {
            strike = countStrike(randomNumber, inputNumber, number, baseball.getStrike());
            ball = countBall(randomNumber, inputNumber, number, baseball.getBall());
        }

        baseball.setStrike(strike);
        baseball.setBall(ball);
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
    public void result(int strike, int ball) {
        if (strike==3) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            //게임이 종료되었다는 문구+게임 이대로 종료할지 재시작할지 입력받기
            printEndMessage();
        } else if (strike==0 && ball==0) {
            System.out.println("낫싱");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");

        }
    }

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void printEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

    //프로그램 재시작 or 완전히 종료
    public void gameExit(int number) {

        if (number!=1 && number!=2) {
            throw new IllegalArgumentException();
        }

        if (number==1) {
            startBaseballGame();
        }

        if (number==2) {

        }
    }

}
