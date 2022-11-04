package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class GamePlay {
    private Computer computer = new Computer();
    private User user = new User();
    public void playContinuous(){
        computer.generateNumber();
        while (true){
            System.out.print("숫자를 입력하세요: ");
            int[] guessNumbers = typingNumber();
            match(guessNumbers);
        }
    }
    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        playContinuous();
    }

    public int[] typingNumber(){
        return user.inputNumber();
    }

    public void match(int[] guessNumbers){
        computer.compare(guessNumbers);
    }
}
