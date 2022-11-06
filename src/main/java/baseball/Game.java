package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    static final int NUMBER_LENGTH = 3;
    String STRING_BALL = "볼";
    String STRING_STRIKE = "스트라이크";
    String STRING_NOTHING = "낫싱";
    String INPUT_QUIT = "2";
    String OUTPUT_START = "숫자 야구 게임을 시작합니다.";
    String OUTPUT_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    String OUTPUT_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int strike;
    private int ball;
    private int randomNumber;
    private int userNumber;
    private boolean quit = false;

    public Game() {
    }
    public void play() {
        Computer computer = new Computer();
        User user = new User();

        System.out.println(OUTPUT_START);

        computer.setRandomNumber();
        randomNumber = computer.getRandomNumber();

        while(!quit) {
            user.setUserNumber();
            userNumber = user.getUserNumber();

            initializeBallCount();
            calculateStrike();
            calculateBall();
            printOutResult();

            if(strike == NUMBER_LENGTH) {
                System.out.println(OUTPUT_SUCCESS);
                System.out.println(OUTPUT_QUIT);
                String input = Console.readLine();
                if(input.equals(INPUT_QUIT)) {
                    quit = true;
                    break;
                }
                computer.setRandomNumber();
                randomNumber = computer.getRandomNumber();
            }

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

    private void calculateBall() {
        String[] randomNumberArr = String.valueOf(randomNumber).split("");
        String[] userNumberArr = String.valueOf(userNumber).split("");
        for(int i=0; i<NUMBER_LENGTH; i++) {
            // calculate ball
            for (int k = 0; k < NUMBER_LENGTH; k++) {
                if (randomNumberArr[i].equals(userNumberArr[k]) && i != k) {
                    ball++;
                }
            }
        }
    }

    private void calculateStrike() {
        String[] randomNumberArr = String.valueOf(randomNumber).split("");
        String[] userNumberArr = String.valueOf(userNumber).split("");
        for(int i=0; i<NUMBER_LENGTH; i++) {
            // calculate strike
            if(randomNumberArr[i].equals(userNumberArr[i])) {
                strike++;
            }
        }
    }

    private void initializeBallCount() {
        strike = 0;
        ball = 0;
    }
}


