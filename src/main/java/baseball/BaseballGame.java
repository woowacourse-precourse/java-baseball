package baseball;

public class BaseballGame {

    public static void Round() {
        Computer BaseballComputerTarget = new Computer();
        BaseballComputerTarget.makeTarget();

        Game(BaseballComputerTarget.target);
    }
    
    public static void Game(int[] target) {
        boolean result = false;

        do {
            System.out.print("숫자를 입력해주세요: ");
            int[] userNumber = User.inputNumber();

            result = PrintResult.printResult(target, userNumber);
        } while(result == false);
    }
}