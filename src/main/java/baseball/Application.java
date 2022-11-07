package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Application {

    public static void main(String[] args) {
        Number computerNumber = Utils.pickComputerNumber();
        boolean applicationStatus = true;
        boolean gameStatus = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (applicationStatus) {
            while (gameStatus) {
                System.out.print("숫자를 입력해주세요 : ");
                String line = Console.readLine();
                Number userNumber = new Number(line);
                Result result = new Result(computerNumber, userNumber);
                result.print();

                if (result.isCorrect()) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    gameStatus = false;
                }
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String line = Console.readLine();
            if ("2".equals(line)) {
                applicationStatus = false;
                System.out.println("게임 종료");
            }
        }
    }
}
