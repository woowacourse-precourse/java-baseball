package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StrikeBallNothingResultGenerator {

    private static final String BALL_STR = "볼";
    private static final String STRIKE_STR = "스트라이크";
    private static final String NOTHING = "낫싱";

    private int[] player;
    private int[] computer;

    private int strike = 0;
    private int ball = 0;

    private boolean exit = false;
    ArrayList<Integer> playerLists = new ArrayList<>();
    ArrayList<Integer> computerLists = new ArrayList<>();



    public void Match() {

    }

    public void startGame() {
        GenerateRandomNumber computerNumber = new GenerateRandomNumber();
        computerNumber.setRandomNumber();
        computer = computerNumber.getDigits();
        InputUserNumber playerNumber = new InputUserNumber();





    do{
        playerNumber.UserInputValue();
        player = playerNumber.getDigits();




        for (int i = 0; i < 3; i++) {
            this.playerLists.add(player[i]);
            this.computerLists.add(computer[i]);
        }




        resetScore();
        countStrike();
        printResult();

        if(strike == 3) {
            inputExit();
            computerNumber.setRandomNumber();
            computer = computerNumber.getDigits();
        }


        } while(!exit);
    }

    private void resetScore() {
        strike = 0;
        ball = 0;
    }
    public void countStrike() {

        for (int position = 0; position < 3; position++) {

            if (computerLists.contains(playerLists.get(position))) {

                if (computerLists.indexOf(playerLists.get(position)) == position) {

                    strike++;
                    //strike 상황
                } else if (computerLists.indexOf(playerLists.get(position)) != position) {

                    ball++;
                    //ball 상황
                }

            }

        }


    }
    public void printResult() {
        System.out.println(getResultString());
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    private String getResultString() {
        if(strike == 0 && ball == 0) {
            return NOTHING;
        }
        StringBuilder stringMaker = new StringBuilder();
        if(ball > 0 ) {
            stringMaker.append(ball).append(BALL_STR);
        }
        if(strike > 0) {
            stringMaker.append(strike).append(STRIKE_STR);
        }
        return stringMaker.toString();
    }


    private void inputExit() {
    ExcepetionCase exception = new ExcepetionCase();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if(!exception.oneOrTwo(input)) {
            throw new IllegalArgumentException();
        }
        if("2".equals(input)) {
            exit = true;
        }
    }

}
