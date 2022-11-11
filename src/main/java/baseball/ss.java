package baseball;


import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;


public class ss {

    private List<Integer> player;
    private List<Integer> computer;

    private int strike = 0;
    private int ball = 0;

    ArrayList<Integer> playerLists = new ArrayList<>();
    ArrayList<Integer> computerLists = new ArrayList<>();


    public void startGames() {
        GenerateRandomNumber computerNumber = new GenerateRandomNumber();

        computerNumber.setRandomNumber();
        computer = computerNumber.getDigits();





        InputUserNumber userNumber = new InputUserNumber();

        userNumber.setDigits();
        player = userNumber.getDigits();




        resetScore();
        count();

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


}