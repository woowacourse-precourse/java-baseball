package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    static List<Integer> randNumber() {
                List<Integer> computer = new ArrayList<>();
                while (computer.size() < 3) {
                    int randomNumber = Randoms.pickNumberInRange(1, 9);
                    if (!computer.contains(randomNumber)) {
                        computer.add(randomNumber);
                    }
                }
        return computer;
    }




    public static void main(String[] args) {
        // TODO: 프로그램 구현
            boolean Game = true;
            int ret = 0;
            while(Game) {
                List<Integer> computerNumber = randNumber();
                startGame(computerNumber);
                Game = reTry();
            }
    }
}
