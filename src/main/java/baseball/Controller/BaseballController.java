package baseball.Controller;

import baseball.Domain.Baseball;
import baseball.Service.BaseballService;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballController {
    BaseballService baseballService = new BaseballService();
    public List<String> randomList = new ArrayList<>();
    private List<String> inputList = new ArrayList<>();
    public Baseball baseball = new Baseball(randomList, inputList);
    private static final int RESTART=1;
    private static final int STRIKE_MAX=3;
    private static final int STRIKE_MIN=0;
    private static final int BALL_MIN=0;


    public void runBaseballGame() {

        baseball.initBaseballGame();
        printStartMessage();

        randomList = baseballService.createRandomNumber();
        baseball.setComputerNumber(randomList);
        System.out.println(randomList);

        while(baseball.getStrike()!=STRIKE_MAX) {
            baseball.initBaseballGame();
            inputList = readInputNumber();
            baseball.setInputNumber(inputList);

            countStrikeOrBall(baseball.getComputerNumber(), baseball.getInputNumber());

            result(baseball.getStrike(), baseball.getBall());
        }

        int answer = Integer.parseInt(Console.readLine());

        gameExit(answer);
    }


    public List<String> readInputNumber() {
        printInputMessage();
        String inputNumber = Console.readLine();
        System.out.println(inputNumber);

        String[] numberToArray = inputNumber.split("");
        List<String> userNumber = new ArrayList<String>(Arrays.asList(numberToArray));
        baseballService.isValidInputSize(userNumber);
        baseballService.isValidInputRange(userNumber);

        return userNumber;
    }


    public void countStrikeOrBall(List<String> randomNumber, List<String> inputNumber) {
        for(String number: inputNumber) {
            countStrike(randomNumber, inputNumber, number);
            countBall(randomNumber, inputNumber, number);
        }
        System.out.println("스트라이크: "+baseball.getStrike()+ "볼: "+baseball.getBall());
    }



    public void countStrike(List<String> randomNumber, List<String> inputNumber, String number) {
        if (randomNumber.contains(number) && (randomNumber.indexOf(number) == inputNumber.indexOf(number))) {
            baseball.setStrike(countStrikeOrBall(baseball.getStrike()));
        }
    }


    public void countBall(List<String> randomNumber, List<String> inputNumber, String number) {
        if(randomNumber.contains(number) && (randomNumber.indexOf(number)!=inputNumber.indexOf(number))) {
            baseball.setBall(countStrikeOrBall(baseball.getBall()));
        }
    }


    public int countStrikeOrBall(int StrikeOrBall) {
        return StrikeOrBall+1 ;
    }


    public void result(int strike, int ball) {
        if (strike==STRIKE_MAX) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            printEndMessage();
        } else if (strike==STRIKE_MIN && ball==BALL_MIN) {
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


    public void gameExit(int number) {
        baseballService.isValidNumber(number);

        if (number==RESTART) {
            runBaseballGame();
        }
    }

}
