package baseball.number.game;

import baseball.number.player.PlayerNumber;
import baseball.number.computer.ComputerNumbers;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.number.util.GamePhrase.*;

public class PlayGames {

    ComputerNumbers computerNumbers = new ComputerNumbers();
    HintsAboutNumbers hint = new HintsAboutNumbers();
    PlayerNumber playerNumber = new PlayerNumber();

    public void playGames() {
        System.out.println(START_MESSAGE.getValue());

        String quitGame; //게임 재시작 여부 판단하는 변수, 만약 1인경우 재사작, 2인 경우 게임 종료

        do{
            List<Integer> computerNumber = computerNumbers.generateRandomNumbers();

            matchNumber(computerNumber);

            quitGame = quitGameMessage();

        } while(quitGame.equals(RESTART.getValue())); //1 입력시 게임 재시작, 2 입력시 게임 종료

    }

    private String inputNumber() {
        return Console.readLine();
    }

    public void matchNumber(List<Integer> computerNumber) { //컴퓨터의 숫자와 플레이어의 숫자가 일치하는지 확인하는 메서드
        boolean isMatched;
        do {
            List<Integer> playerNumberList = playerNumber.playerNumberToList();

            isMatched = hint.hintAboutNumbers(playerNumberList, computerNumber);
            //숫자 입력시 힌트 출력 메서드 추가
            printEndgameMessage(isMatched);

        } while (!isMatched); //입력한 숫자와 컴퓨터의 숫자가 같을때까지 반복
    }

    private void printEndgameMessage(boolean isMatched) { //게임 종료 및 재시작 여부 문구 출력
        if(isMatched) {
            System.out.println(VICTORY_MESSAGE.getValue());
            System.out.println(RESTART_MESSAGE.getValue());
        }
    }

    public String quitGameMessage() { //게임 재시작 혹은 종료를 결정하는 메서드
        String quitGames;
        do {
            quitGames = inputNumber();
            quitGames = outputQuitGameMessage(quitGames);
        } while(!(quitGames.equals(RESTART.getValue()) || quitGames.equals(EXIT.getValue())));
        return quitGames;
    }
    public String outputQuitGameMessage(String quitGame) {
        if(quitGame.equals(RESTART.getValue())) {
            return quitGame;
        }
        if(quitGame.equals(EXIT.getValue())) {
            System.out.println(QUIT_MESSAGE.getValue());
            return quitGame;
        }
        System.out.println(INVALID_QUIT_NUMBER_MESSAGE.getValue());
        return quitGame;
    }
}
