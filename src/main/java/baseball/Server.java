package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

// 숫자 야구 게임 관리
public class Server {

    private static final int GAME_NUMBER_RANGE_MAX = 9;
    private static final int GAME_NUMBER_RANGE_MIN = 1;
    private static final int COUNT_GAME_NUMBER = 3;

    public void run() {
        Client.showGameStartMessage();
        while (true) {
            List<Integer> computerNumberList = makeNewGameNumber();
            boolean isNotGameOver = true;
            while (isNotGameOver) {
                int playerGameNumber = Client.askPlayerGameNumber();

                JudgedResultDto dto
                    = judgeInputNumber(playerGameNumber, computerNumberList);
                Client.showJudgedResult(dto);
                isNotGameOver = dto.getCountStrikes() != 3;
            }
            Client.showGameEndMessage();
            if (!Client.askMoreGame()) {
                return;
            }
        }
    }

    public List<Integer> makeNewGameNumber() {
        List<Integer> computerNumberList = new ArrayList<Integer>(COUNT_GAME_NUMBER);
        while (computerNumberList.size() < COUNT_GAME_NUMBER) {
            int randomNumber = pickNumberInRange(GAME_NUMBER_RANGE_MIN, GAME_NUMBER_RANGE_MAX);
            if (computerNumberList.contains(randomNumber)) {
                continue;
            }
            computerNumberList.add(randomNumber);
        }
        return computerNumberList;
    }

    public JudgedResultDto judgeInputNumber(int inputNumber,
        List<Integer> computerNumberList) {
        int countBalls = 0, countStrikes = 0;

        String[] playerNumberString = Integer.toString(inputNumber).split("");

        for (int index = 0; index < playerNumberString.length; ++index) {
            int parsed = Integer.parseInt(playerNumberString[index]);
            int matchIndex = computerNumberList.indexOf(parsed);
            if (matchIndex == -1) {
                continue;
            }
            if (matchIndex == index) {
                ++countStrikes;
                continue;
            }
            ++countBalls;
        }

        return new JudgedResultDto(countBalls, countStrikes);
    }
}
