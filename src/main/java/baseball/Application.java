package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        // TODO: 프로그램 구현

        Computer computer = new Computer();
        OuterLoop:
        while (true) {
            computer.init();
            computer.startGame();
            if(computer.checkFinish()) break OuterLoop;
        }
    }






}
