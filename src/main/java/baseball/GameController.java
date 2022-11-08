package baseball;

import baseball.util.GetRandomNumber;
import baseball.util.ValidateInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    private static final int RESTART = 1;




    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        String comRandomNumber = GetRandomNumber.GetRandomNumber();
        do {
            String result = Console.readLine();



        } while (RESTART == 1);

    }
}
