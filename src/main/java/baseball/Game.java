package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int NUMBER_OF_DIGIT = 3;

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> numComputer = NumComputerPicker.pickNumComputer();

        List<Integer> numInput = new ArrayList<>();
        while (true) {
            getNumInput(numInput);
        }
    }

    private void getNumInput(List<Integer> result) {
        String str = Console.readLine();
        for (int i = 0; i < str.length(); i++) {
            int num = Character.getNumericValue(str.charAt(i));
            result.add(num);
        }

        return;
    }
}
