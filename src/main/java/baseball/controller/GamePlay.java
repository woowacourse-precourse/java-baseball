package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import baseball.util.Util;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class GamePlay {
    public static boolean restart = false;
    private Computer computer = new Computer();
    private User user = new User();
    public void playContinuous(){
        computer.generateNumber();
        while (true){
            System.out.print("숫자를 입력하세요: ");
            int[] guessNumbers = typingNumber();
            match(guessNumbers);

            if (restart && restartGame()){
                break;
            }
        }
        System.out.println("종료");
    }
    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        playContinuous();
    }

    public int[] typingNumber(){
        return user.inputNumber();
    }

    public boolean restartGame(){
        int restartNumber = user.inputRestart();
        Util.isCorrectInputRestart(restartNumber);
        if (restartNumber == 2) {
            return true;
        }

        GamePlay.restart = false;

        computer.generateNumber();
        return false;
    }

    public void match(int[] guessNumbers){
        computer.compare(guessNumbers);
    }
}
