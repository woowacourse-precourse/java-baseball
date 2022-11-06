package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    static final int SIZE = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;
    static final int RESTART = 1;
    static final int END = 2;
    Message message = new Message();

    public void init(){
        message.gameStartMsg();
    }

    public void run(){
        String randomNumber = startGame();
        playGame(randomNumber);
        endGame();
        restartGame();
    }

    public String startGame(){
        return Integer.toString(getRandomNumber());
    }

    public void endGame(){
        message.restartMsg();
    }

    public void playGame(String randomNumber){
        int strike = 0;
        while (strike != 3){
            message.numberInputMsg();
            String input = Console.readLine();
            inputValidator(input);
            strike = count(randomNumber, input);
        }
    }

    public int getRandomNumber() {
        int number = 0;
        for (int digit = 0; digit < SIZE; digit++) {
            number *= 10;
            number += Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        }
        return number;
    }

    public void inputValidator(String input) {
        // 세 자리수가 아닌 경우
        if (input.length() != SIZE) throw new IllegalArgumentException();
        // 서로 같은 숫자가 존재하는 경우
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2))
            throw new IllegalArgumentException();
        // 1~9 범위 외의 랜덤 숫자가 있는 경우
        for (int digit = 0; digit < input.length(); digit++) {
            if (input.charAt(digit) <= '0' && input.charAt(digit) >= '9') throw new IllegalArgumentException();
        }
    }

    public int count(String randomNumber, String input){
        int ball = 0;
        int strike = 0;

        for (int digit = 0; digit < SIZE; digit++){
            int inc = countStrike(randomNumber, input, digit);
            if (inc != 0){
                strike += inc;
            } else {
                ball += countBall(randomNumber, input, digit);
            }
        }
        message.countBallAndStrikeMsg(ball, strike);
        return strike;
    }

    public int countStrike(String randomNumber, String input, int index){
        int strike = 0;
        if (randomNumber.charAt(index) == input.charAt(index)) {
            strike++;
        }
        return strike;
    }

    public int countBall(String randomNumber, String input, int index){
        int ball = 0;
        if (randomNumber.contains(String.valueOf(input.charAt(index)))) {
            ball++;
        }
        return ball;
    }


    public void restartGame(){
        int input = Integer.parseInt(Console.readLine());

        if (input == 0 || input > END) throw new IllegalArgumentException();

        if (input == RESTART) run();
    }
}