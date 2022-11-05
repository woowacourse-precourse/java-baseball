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

    public void run(){
        startGame();
        endGame();
    }

    public void init(){
        message.setGameStartMsg();
    }

    public void startGame(){
        String randomNumber = Integer.toString(getRandomNumber());
        playGame(randomNumber);
    }

    public void endGame(){
        message.setRestartMsg();
        inputRestartOrEnd();
    }

    public void playGame(String randomNumber){
        int strike = 0;
        while (strike != 3){
            String input = inputNumber();
            inputValidator(input);
            strike = countBallAndStrike(randomNumber, input);
        }
    }

    public int getRandomNumber() {
        int number = 0;

        for (int i = 0; i < SIZE; i++) {
            number *= 10;
            number += Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        }

        return number;
    }

    public String inputNumber() {
        message.setNumberInputMsg();
        return Console.readLine();
    }

    public void inputValidator(String input) {
        // 세 자리수가 아닌 경우
        if (input.length() != SIZE) throw new IllegalArgumentException();
        // 서로 같은 숫자가 존재하는 경우
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2))
            throw new IllegalArgumentException();
        // 1~9 범위 외의 랜덤 숫자가 있는 경우
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) <= '0' && input.charAt(i) >= '9') throw new IllegalArgumentException();
        }
    }

    public int countBallAndStrike(String randomNumber, String input){
        int ball = 0;
        int strike = 0;

        // 자리 & 숫자 모두 일치
        if (randomNumber.equals(input)) {
            strike = 3;
            message.countBallAndStrikeMsg(ball, strike);
            return strike;
        }

        // 볼, 스트라이크 개수 세기
        for (int i =0; i< SIZE; i++){
            if (randomNumber.charAt(i) == input.charAt(i)) {
                strike++;
            }
            else if (randomNumber.contains(String.valueOf(input.charAt(i)))) {
                ball++;
            }
        }
        message.countBallAndStrikeMsg(ball, strike);
        return strike;
    }



    public void inputRestartOrEnd(){
        int input = Integer.parseInt(Console.readLine());

        if (input == 0 || input > END) throw new IllegalArgumentException();

        if (input == RESTART) run();
    }
}