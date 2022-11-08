package controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static createnumberlist.computer.computerNumberList;
import static createnumberlist.user.createUserNumberList;
import static judgement.result.resultJudgement;
import static validate.check.restartNumberValidate;

public class game {

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int restart=1;

        while (restartNumberValidate(restart)) {
            List<Integer> computer = computerNumberList();
            String result = "";
            while (!result.equals("3스트라이크")) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = Console.readLine();
                List<Integer> user = createUserNumberList(userInput);
                result = resultJudgement(computer, user);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            restart = Integer.parseInt(Console.readLine());
        }
    }
}
