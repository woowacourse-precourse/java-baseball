package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;

public class Application {
    public static List<Integer> generateThreeDifferentNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /**
     * 플레이어의 입력값이 1~9사이 서로다른 3가지 숫자인지 확인
     *
     * @param playerInput Console.readLine()에서 받은 String 값
     */
    public static void isDifferentThreeNum(String playerInput) {
        List<String> playerInputArray = Arrays.asList(playerInput.split(""));
        Set<String> delSameNum = new HashSet<>(playerInputArray);
        boolean isOneToNineAndSizeThree = Pattern.matches("^[1-9]{3}$", playerInput);
        boolean isNoOverlap = playerInputArray.size() == delSameNum.size();

        if (!(isOneToNineAndSizeThree && isNoOverlap)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 플레이어의 입력과 컴퓨터의 입력을 비교해 [스트라이크 수, 볼 수, miss 수]를 생성
     *
     * @param computer 컴퓨터가 생성한 1~9사이 서로다른 3개의 수를 가진 리스트
     * @param player   플레이어가 생성한 1~9사이 서로다른 3개의 수를 가진 스트링
     * @return [스트라이크 수, 볼 수, miss 수]의 리스트
     */
    public static List<Integer> processScore(List<Integer> computer, String player) {
        List<Integer> score = new ArrayList<>(Arrays.asList(0, 0, 0));
        for (int idx = 0; idx < 3; idx++) {
            char currentPlayerChar = player.charAt(idx);
            int currentPlayerCharValue = Character.getNumericValue(currentPlayerChar);

            if (currentPlayerCharValue == computer.get(idx)) { // 인덱스와 값 모두 같은 경우 (스트라이크)
                score.set(0, score.get(0) + 1);
            } else if (computer.contains(currentPlayerCharValue)) { // 인덱스가 다르나 값이 있는 경우(볼)
                score.set(1, score.get(1) + 1);
            } else { // 값이 어디에도 매치하지 않는 경우(Miss)
                score.set(2, score.get(2) + 1);
            }
        }
        return score;
    }

    /**
     * processScore()을 통해 비교된 결과를 플레이어에게 출력
     *
     * @param score processScore()을 통해 처리된 [스트라이크 수, 볼 수, miss 수]
     */
    public static void printScore(List<Integer> score) {
        if (score.get(2) == 3) {
            System.out.println("낫싱");
            return;
        }
        String numOfBall = score.get(1).toString() + "볼";
        String numOfStrike = score.get(0).toString() + "스트라이크";
        List<String> listOfInfo = new ArrayList<>(Arrays.asList(numOfBall, numOfStrike));
        StringBuilder output = new StringBuilder();
        // 0개인 정보는 무시
        for (String stringScore : listOfInfo) {
            if (!(stringScore.charAt(0) == '0')) {
                output.append(stringScore).append(" ");
            }
        }
        System.out.println(output.substring(0, output.length() - 1));
    }

    /**
     * 플레이어가 모든 숫자를 맞췄는지 확인하는 메소드
     *
     * @param score processScore()을 통해 처리된 [스트라이크 수, 볼 수, miss 수]
     * @return 3스트라이크일때 true, 이외는 false
     */
    public static boolean isPlayerWon(List<Integer> score) {
        int strikes = score.get(0);
        if (strikes == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return true;
        }
        return false;
    }

    /**
     * 게임승리시 재시작할지 종료할지 받은 값을 처리
     *
     * @param gameModeInput 게임 승리 후 입력 재시작(1)/종료(2)
     * @return 재시작시 true, 종료시 false
     */
    public static boolean isValidGameModeInput(String gameModeInput) {
        if (gameModeInput.equals("1")) {
            return true;
        } else if (gameModeInput.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean gameMode = true;
        List<Integer> computer = generateThreeDifferentNum();
        List<Integer> score;
        while (gameMode) {
            System.out.print("숫자를 입력해주세요 : ");
            String playerInput = Console.readLine();
            isDifferentThreeNum(playerInput);
            score = processScore(computer, playerInput);
            printScore(score);
            if (isPlayerWon(score)) {
                String gameModeInput = Console.readLine();
                gameMode = isValidGameModeInput(gameModeInput);
                computer = generateThreeDifferentNum();
            }
        }
    }
}
