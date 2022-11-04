package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    static final int NUMBER_LENGTH = 3;
    String STRING_BALL = "볼";
    String STRING_STRIKE = "스트라이크";
    String STRING_NOTHING = "낫싱";
    private int strike;
    private int ball;
    private int randomNumber;
    private int userNumber;
    private boolean quit = false;

    public Game() {
    }
    public void play() {
        RandomNumber computer = new RandomNumber();
        UserNumber user = new UserNumber();

        System.out.println("숫자 야구 게임을 시작합니다.");

        // get random number from computer
        computer.setRandomNumber();
        randomNumber = computer.getRandomNumber();

        while(!quit) {
            // get user number from user
            user.setUserNumber();
            userNumber = user.getUserNumber();

            initializeBallCount();
            calculateStrike();
            calculateBall();

            // paint result
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

            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String input = Console.readLine();
                if(input.equals("2")) {
                    computer.setRandomNumber();
                    quit = true;
                }
            }

        }
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


