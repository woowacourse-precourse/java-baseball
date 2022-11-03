package baseball.controller;

import baseball.model.Computer;
import baseball.model.User;
import camp.nextstep.edu.missionutils.Console;

public class GamePlay {
    private Computer computer = new Computer();
    private User user = new User();
    public void playContinuous(){
        computer.generateNumber();
        while (true){
            System.out.print("숫자를 입력하세요: ");
            typingNumber();
        }
    }
    public void play(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        playContinuous();
    }

    public void typingNumber(){
        user.inputNumber();
    }
}
