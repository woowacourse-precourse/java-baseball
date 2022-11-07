package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Game {
    static final int NUMBER_LENGTH = 3;
    String STRING_BALL = "볼";
    String STRING_STRIKE = "스트라이크";
    String STRING_NOTHING = "낫싱";
    String INPUT_RESTART = "1";
    String INPUT_QUIT = "2";
    String OUTPUT_START = "숫자 야구 게임을 시작합니다.";
    String OUTPUT_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String OUTPUT_RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int strike;
    private int ball;
    private int randomNumber;
    private int userNumber;
    private boolean quit = false;
    public String input;
    public List<String> inputArrList;
    private Computer computer;
    private List<String> randomDigits;
    private List<String> userDigits;

    public Game() {
    }

    // method for test code only
    public void setInput(String input) {
        this.input = input;
        getValidation();
    }

    public void play() {
        computer = new Computer();
        User user = new User();

        System.out.println(OUTPUT_START);

        computer.setRandomNumber();
        randomNumber = computer.getRandomNumber();

        while(!quit) {
            user.setUserNumber();
            userNumber = user.getUserNumber();
            setDigits();


            initializeBallCount();
            calculateStrike();
            calculateBall();
            printOutResult();

            if(strike == NUMBER_LENGTH) {
                System.out.println(OUTPUT_SUCCESS);
                System.out.println(OUTPUT_RESTART_OR_QUIT);
                setInput();
                handleQuit();
                handleRestart();
            }
        }
    }

    private void handleRestart() {
        if(input.equals(INPUT_RESTART)) {
            computer.setRandomNumber();
            randomNumber = computer.getRandomNumber();
        }
    }

    private void handleQuit() {
        if(input.equals(INPUT_QUIT)) {
            quit = true;
        }
    }

    private void setInput() {
        input = Console.readLine();
        getValidation();
    }

    private void getValidation() {
        // validation
        String[] inputArr = {"1","2"};
        inputArrList = Arrays.asList(inputArr);
        boolean inputValidation = inputArrList.contains(input);
        if(!inputValidation) {
            throw new IllegalArgumentException();
        }
    }

    private void printOutResult() {
        String result = "";
        if (ball == 0 && strike == 0) {
            result = STRING_NOTHING;
        }else if (ball == 0 && strike > 0) {
            result = strike + STRING_STRIKE;
        }else if (ball > 0 && strike == 0) {
            result = ball + STRING_BALL;
        }else if (ball > 0 && strike > 0){
            result = ball + STRING_BALL + " " + strike + STRING_STRIKE;
        }
        System.out.println(result);
    }

    private void setDigits() {
        randomDigits = getSplitList(randomNumber);
        userDigits = getSplitList(userNumber);
    }

    private void calculateBall() {
        for(String userDigit: userDigits) {
            boolean isContained = randomDigits.contains(userDigit);
            boolean isBall = randomDigits.indexOf(userDigit) != userDigits.indexOf(userDigit);
            if(isBall && isContained) {
                ball++;
            }
        }
    }

    private void calculateStrike() {
        for(String userDigit: userDigits) {
            boolean isContained = randomDigits.contains(userDigit);
            boolean isStrike = randomDigits.indexOf(userDigit) == userDigits.indexOf(userDigit);
            if(isStrike && isContained) {
                strike++;
            }
        }
    }

    private List<String> getSplitList(int number) {
        return Arrays.asList(String.valueOf(number).split(""));
    }

    private void initializeBallCount() {
        strike = 0;
        ball = 0;
    }
}


