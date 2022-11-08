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
        boolean isOneMoreGame = true;

        while (isOneMoreGame) {
            playOneGame();
            isOneMoreGame = Client.askMoreGame();
        }
    }

    private void playOneGame() {
        List<Integer> computerNumberList = makeNewGameNumber();
        boolean is3Strike = false;

        while (!is3Strike) {
            List<Integer> playerNumberList = Client.askPlayerNumberList();
            JudgedResultDto dto
                = judgeInputNumber(playerNumberList, computerNumberList);
            Client.showJudgedResult(dto);
            is3Strike = dto.is3Strike();
        }
        Client.showGameEndMessage();
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

    public JudgedResultDto judgeInputNumber(List<Integer> playerNumberList,
        List<Integer> computerNumberList) {

        int countBalls = 0, countStrikes = 0;

        if (playerNumberList.equals(computerNumberList)) {
            return JudgedResultDto.make3StrikeDto();
        }

        for (int index = 0; index < playerNumberList.size(); ++index) {
            int playerNumberByIndex = playerNumberList.get(index);
            int matchIndex = computerNumberList.indexOf(playerNumberByIndex);
            if (matchIndex == -1) {
                continue;
            }
            if (matchIndex == index) {
                ++countStrikes;
                continue;
            }
            ++countBalls;
        }

        if (countBalls == 0 && countStrikes == 0) {
            return JudgedResultDto.makeNothingDto();
        }
        return JudgedResultDto.makeNormalDto(countBalls, countStrikes);
    }
}
