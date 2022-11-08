package baseball;


import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseBallGame {
    private List<Integer> computer;
    private List<Integer> user;
    private String answer;


    public void reStart(String userNum) {
        if (userNum.equals("1")) run();
        else if (userNum.equals("2")) return;
        else throw new IllegalArgumentException();
    }

    public void run() {
        Computer computer = new Computer();
        List<Integer> computerNumber = computer.randomNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game = new Game(computerNumber);
        User user = new User();

        while (true) {
            System.out.printf("숫자를 입력해주세요 : ");
            String userNum = Console.readLine();

            List<Integer> userNumber = user.inputNumbers(userNum);
            String answer = game.gameRun(userNumber);

            if (answer.equals("게임 종료")) break;
            else System.out.println(answer);
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userNum = Console.readLine();
        reStart(userNum);
    }

}