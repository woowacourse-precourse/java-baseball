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
    private static final int END=2;
    private static final int STRIKE_MAX=3;
    private static final int STRIKE_MIN=0;
    private static final int BALL_MIN=0;


    public void runBaseballGame() {
        baseball.initBaseballGame();
        printStartMessage();
        startGame();
        endGame();
    }

    public void startGame() {
        randomList = baseballService.createRandomNumber();
        baseball.setComputerNumber(randomList);
        while(baseball.getStrike()!=STRIKE_MAX) {
            baseball.initBaseballGame();
            inputList = readInputNumber();
            baseball.setInputNumber(inputList);

            countStrikeOrBall(baseball.getComputerNumber(), baseball.getInputNumber());

            result(baseball.getStrike(), baseball.getBall());
        }
    }

    public void endGame() {
        int answer = Integer.parseInt(Console.readLine());
        System.out.println(answer);
        gameExit(answer);
    }


    public List<String> readInputNumber() {
        printInputMessage();
        String input = Console.readLine();

        String[] numberToArray = input.split("");
        List<String> inputNumber = new ArrayList<String>(Arrays.asList(numberToArray));
        checkExceptions(inputNumber);

        return inputNumber;
    }

    public void checkExceptions(List<String> inputList) {
        baseballService.isValidInputSize(inputList);
        baseballService.isValidInputRange(inputList);
        baseballService.isInputDuplicate(inputList);
    }


    public void countStrikeOrBall(List<String> randomNumber, List<String> inputNumber) {
        for(String number: inputNumber) {
            countStrike(randomNumber, inputNumber, number);
            countBall(randomNumber, inputNumber, number);
        }
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

    public void gameExit(int number) {
        baseballService.isValidNumber(number);

        if (number==RESTART) {
            runBaseballGame();
        }
        gameExitException(number);
    }

    public void gameExitException(int number) {
        if (number!=RESTART && number!=END) {
            throw new IllegalArgumentException();
        }
    }

    public void result(int strike, int ball) {
        if (strike==STRIKE_MAX) {
            System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            printEndMessage();
        } else if (strike==STRIKE_MIN && ball==BALL_MIN) {
            System.out.println("낫싱");
        } else {
            printResultMessage(strike, ball);
        }
    }

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void printResultMessage(int strike, int ball) {
        if (strike==0 && ball!=0) {
            System.out.println(ball+"볼 ");
        }

        if (strike!=0 && ball==0) {
            System.out.println(strike+"스트라이크");
        }

        if (strike!=0 && ball!=0) {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    public void printEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

}
