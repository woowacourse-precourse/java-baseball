package baseball.number.game;

import baseball.number.client.PlayerNumber;
import baseball.number.client.HintsAboutNumbers;
import baseball.number.computer.ComputerNumbers;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class PlayGames {

    ComputerNumbers computerNumbers = new ComputerNumbers();
    HintsAboutNumbers hint = new HintsAboutNumbers();
    PlayerNumber playerNumber = new PlayerNumber();

    public void playGames() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        int quitGame; //게임 재시작 여부 판단하는 변수, 만약 1인경우 재사작, 2인 경우 게임 종료

        do{
            List<Integer> computerNumber = computerNumbers.generateRandomNumbers();
            for (Integer integer : computerNumber) {
                System.out.print(integer); //for test
            }

            matchNumber(computerNumber);

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            quitGame = Integer.parseInt(Console.readLine());

        } while(quitGame != 2); //1 입력시 게임 재시작, 2 입력시 게임 종료

        System.out.println("게임을 종료합니다.");
    }

    public void matchNumber(List<Integer> computerNumber) {
        boolean isMatched;
        do {
            String number = Console.readLine();

            List<Integer> client = playerNumber.playerNumberToList(number);

            isMatched = hint.hintAboutNumbers(client, computerNumber);
            //숫자 입력시 힌트 출력 메서드 추가

        } while (!isMatched); //입력한 숫자와 컴퓨터의 숫자가 같을때까지 반복
    }

}
