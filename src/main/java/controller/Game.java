package controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import createlist.Computer;
import createlist.User;
import validate.Check;
import static judgement.Result.referee;

public class Game {

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int restart=1;

        while (Check.restartNumberValidate(restart)) {
            List<Integer> computer = Computer.numberList();
            String refereeResult = "";
            while (!refereeResult.equals("3스트라이크")) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                List<Integer> user = User.numberList(userInput);
                refereeResult = referee(computer, user);
                System.out.println(refereeResult);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            restart = Integer.parseInt(Console.readLine());
        }
    }
}
