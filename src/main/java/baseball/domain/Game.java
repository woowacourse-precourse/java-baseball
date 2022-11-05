package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Game {

    private int strike;
    private int ball;
    private boolean status;

    User user;
    Computer computer;

    public Game() {
        this.user = new User();
        this.computer = new Computer();
        this.status = true;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStrike(){
        return strike;
    }

    public void setStrike(int strike){
        this.strike = strike;
    }

    public int getBall(){
        return ball;
    }

    public void setBall(int ball){
        this.ball = ball;
    }

    public void outputRestart() {
        System.out.println(END_GAME);
        System.out.println(IS_CONTINUE);
        String answerstr = Console.readLine();
        checkRestartNumberLength(answerstr);
        checkIsDigit(answerstr.charAt(0));
        int answerint = charToInt(answerstr.charAt(0));
        checkValidNumber(answerint);
        selectRestart(answerint);
    }

    public void selectRestart(int answer) {
        if (answer == RESTART) {
            computer.createRandomNumbers();
        } else {
            status = false;
        }
    }

    public void checkRestartNumberLength(String number) {
        if (number.length() > RESTART_NUMBER_LENGTH || number.length() < RESTART_NUMBER_LENGTH) {
            throw new IllegalArgumentException(RESTART_EXCEPTION);
        }
    }

    public void checkValidNumber(int number) {
        if (number < RESTART_NUMBER_MIN || number > RESTART_NUMBER_MAX) {
            throw new IllegalArgumentException(RESTART_EXCEPTION);
        }
    }

    public void checkIsDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException(RESTART_EXCEPTION);
        }
    }

    public int charToInt(char number) {
        return Integer.parseInt(String.valueOf(number));
    }



}
