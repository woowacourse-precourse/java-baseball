package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        User user = new User();
        Computer computer = new Computer();
        while (user.getIsProgramEnd().equals(1)) {
            Game game = new Game();

            computer.setComputerNumber(computer.makeRandomNumber());
            while (!game.isGameEnd()) {
                user.setUserInput(user.userInput());
                game.checkValidNumber(user.getUserInput());
                user.setUserInputStringToNumber(user.getUserInput());

                computer.setBall(user.getUserInputNumber());
                computer.setStrike(user.getUserInputNumber());
                computer.printResult();
                
                game.setGameEnd(computer.isAnswer());
            }
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            user.setIsProgramEnd(Integer.parseInt(readLine()));
        }
    }
}
