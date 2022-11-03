package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output output = new Output();
        Terminate terminate = new Terminate();
        boolean exit = false;

        while (!exit) {
            List<Integer> computer = RandomNumber.generate();
            String result = "";
            while (!result.equals("3스트라이크")) {
                List<Integer> player = Input.playerNumber();
                Validate.check(player);
                result = output.result(computer, player);
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            exit = terminate.exit();
        }

    }

}
