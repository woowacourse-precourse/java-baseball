package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    /** 컴퓨터 랜덤숫자 생성 기능 */
    public static List<Integer> getComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    /** 플레이어 숫자 입력 기능 */
    public static List<Integer> getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String strPlayerNumber = Console.readLine();

        if (!isValidatePlayerNumber(strPlayerNumber)) {
            throw new IllegalArgumentException("1 ~ 9 사이의 서로 다른 3자리 숫자가 아닙니다. 애플리케이션 종료");
        }

        List<Integer> player = new ArrayList<>();
        for (int i = 0; i < strPlayerNumber.length(); i++) {
            char charNum = strPlayerNumber.charAt(i);
            int intNum = Character.getNumericValue(charNum);
            player.add(intNum);
        }

        return player;
    }

    /** 플레이어 숫자 유효성 검사 기능 */
    public static boolean isValidatePlayerNumber(String strPlayerNumber) {
        if (strPlayerNumber.length() != 3) {
            return false;
        }

        List<Integer> checkList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            // 1 ~ 9 사이의 정수 판별
            char charNum = strPlayerNumber.charAt(i);
            if (!Character.isDigit(charNum) || charNum == '0') {
                return false;
            }

            // 중복 여부 판별
            int intNum = Character.getNumericValue(charNum);
            if (checkList.contains(intNum)) {
                return false;
            } else {
                checkList.add(intNum);
            }
        }

        return true;
    }

    /** 컴퓨터 & 플레이어 숫자 비교 기능 */
    public static boolean isSameComputerPlayer(List<Integer> computer, List<Integer> player) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (computer.get(i).equals(player.get(i))) {
                strikeCount++;
            } else if (computer.contains(player.get(i))) {
                ballCount++;
            }
        }

        getHint(ballCount, strikeCount);
        return strikeCount == 3;
    }

    /** 게임 재시작/종료 선택 기능 */
    public static boolean isExitGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userSelect = Console.readLine();

        if (!isValidateUserSelect(userSelect)) {
            throw new IllegalArgumentException("1 또는 2가 아닙니다. 애플리케이션 종료");
        }

        return userSelect.equals("2");
    }

    /** 게임 재시작/종료 유효성 검사 기능 */
    public static boolean isValidateUserSelect(String userSelect) {
        return userSelect.equals("1") || userSelect.equals("2");
    }

    /** 힌트 계산 기능 */
    public static void getHint(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount != 0 && strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else if (ballCount == 0 && strikeCount != 0) {
            System.out.println(strikeCount + "스트라이크");
        } else if (ballCount != 0 && strikeCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }

        if (strikeCount == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
