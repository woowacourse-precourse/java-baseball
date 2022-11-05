package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static boolean getGameSelect() {
        String gameSelect = Console.readLine();
        switch (gameSelect) {
            case "1":
                return true;
            case "2":
                return false;
            default:
                throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void runGame() {
        Numbers computerNumbers = Numbers.generateComputerNumbers();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            Numbers userNumbers = Numbers.inputUserNumbers();
            Guess scores = Numbers.guessResult(computerNumbers, userNumbers);
            Guess.guessResultPrint(scores.ballCount, scores.strikeCount);
            if (scores.strikeCount == 3) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            runGame();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            if (!getGameSelect()) {
                break;
            }
        }
    }
}
