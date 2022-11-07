package baseball.number.game;

import baseball.number.player.PlayerNumber;
import baseball.number.computer.ComputerNumbers;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class PlayGames {

    ComputerNumbers computerNumbers = new ComputerNumbers();
    HintsAboutNumbers hint = new HintsAboutNumbers();
    PlayerNumber playerNumber = new PlayerNumber();

    public void playGames() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        String quitGame; //게임 재시작 여부 판단하는 변수, 만약 1인경우 재사작, 2인 경우 게임 종료

        do{
            List<Integer> computerNumber = computerNumbers.generateRandomNumbers();

            matchNumber(computerNumber);

            quitGame = quitGameMessage();

        } while(quitGame.equals("1")); //1 입력시 게임 재시작, 2 입력시 게임 종료

    }

    private String inputNumber() {
        return Console.readLine();
    }

    public void matchNumber(List<Integer> computerNumber) { //컴퓨터의 숫자와 플레이어의 숫자가 일치하는지 확인하는 메서드
        boolean isMatched;
        do {
            String number = inputNumber();

            List<Integer> client = playerNumber.playerNumberToList(number);

            isMatched = hint.hintAboutNumbers(client, computerNumber);
            //숫자 입력시 힌트 출력 메서드 추가
            printEndgameMessage(isMatched);

        } while (!isMatched); //입력한 숫자와 컴퓨터의 숫자가 같을때까지 반복
    }

    private void printEndgameMessage(boolean isMatched) { //게임 종료 및 재시작 여부 문구 출력
        if(isMatched) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public String quitGameMessage() { //게임 재시작 혹은 종료를 결정하는 메서드
        String quitGames = "";
        do {
            quitGames = inputNumber();
            quitGames = outputQuitGameMessage(quitGames);
        } while(!(quitGames.equals("1") || quitGames.equals("2")));
        return quitGames;
    }
    public String outputQuitGameMessage(String quitGame) {
        if(quitGame.equals("1")) {
            return quitGame;
        }
        if(quitGame.equals("2")) {
            System.out.println("게임을 종료합니다");
            return quitGame;
        }
        System.out.println("1 또는 2를 입력해주세요");
        return quitGame;
    }
}
