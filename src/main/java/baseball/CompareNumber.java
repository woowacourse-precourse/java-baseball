package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CompareNumber {

    private List<Integer> player;
    private List<Integer> computer;

    private int strike = 0;
    private int ball = 0;
    private boolean exit = false;
    ArrayList<Integer> playerLists = new ArrayList<>();
    ArrayList<Integer> computerLists = new ArrayList<>();


    public void startGame() {
        ResultGenerator result = new ResultGenerator();


        GenerateRandomNumber computerNumber = new GenerateRandomNumber();
        computerNumber.setRandomNumber();
        computer = computerNumber.getDigits();

        InputUserNumber userNumber = new InputUserNumber();

        do {
            userNumber.setDigits();
            player = userNumber.getDigits();






        resetScore();
        count();
        result.printResult();

            if (strike == 3) {
                result.inputExit();
                computerNumber.setRandomNumber();
                computer = computerNumber.getDigits();
            }


        } while (!exit);

    }



    private void resetScore() {
        strike = 0;
        ball = 0;
    }


    private void count() {

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

    //Test code

    public List<Integer> countTest(List<Integer> computerLists, List<Integer> playerLists) {

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

        List<Integer> check = Arrays.asList(strike, ball);

        return check;


    }

}