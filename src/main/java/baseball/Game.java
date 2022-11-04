package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    static final int SIZE = 3;
    static final int START_INCLUSIVE = 1;
    static final int END_INCLUSIVE = 9;
    static final String BALL_MSG = "볼";
    static final String STRIKE_MSG = "스트라이크";
    static final String NOTHING_MSG = "낫싱";
    static final String VICTORY_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public int getRandomNumber() {
        int number = 0;

        for (int i = 0; i < SIZE; i++) {
            number *= 10;
            number += Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        }

        return number;
    }

    public void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
    }

    public void inputValidator(String input) {
        // 세 자리수가 아닌 경우
        if (input.length() != SIZE) throw new IllegalArgumentException();
        // 서로 같은 숫자가 존재하는 경우
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2))
            throw new IllegalArgumentException();
        // 1~9 범위 외의 랜덤 숫자가 있는 경우
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') throw new IllegalArgumentException();
        }
    }

    public void countBallAndStrike(String randomNumber, String input){
        int ball = 0;
        int strike = 0;

        // 자리 & 숫자 모두 일치
        if (randomNumber.equals(input)) {
            strike = 3;
            printCountMsg(ball, strike);
            return;
        }

        // 볼, 스트라이크 개수 세기
        for (int i =0; i< SIZE; i++){
            if (randomNumber.charAt(i) == input.charAt(i)) strike++;
            else if (randomNumber.contains(String.valueOf(input.charAt(i)))) ball++;
        }
        printCountMsg(ball, strike);
    }

    public void printCountMsg(int ball, int strike){
        // 3개의 숫자를 모두 맞힐 경우
        if(strike == SIZE) {
            System.out.println(VICTORY_MSG);
            System.out.println(RESTART_MSG);
        }
        // 하나도 없는 경우
        else if (ball == 0 && strike == 0){
            System.out.println(NOTHING_MSG);
        }
        // 볼, 스트라이크 둘 다 있는 경우
        else if (ball != 0 && strike != 0){
            System.out.println(ball + BALL_MSG + " " + strike + STRIKE_MSG);
        }
        // 볼만 있는 경우
        else if (ball == 0){
            System.out.println(ball + BALL_MSG);
        }
        // 스트라이크만 있는 경우
        else if (strike == 0) {
            System.out.println(strike + STRIKE_MSG);
        }
    }
}