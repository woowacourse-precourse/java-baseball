package view;

import java.util.HashMap;

public class Print {

    /**
     * 애플리케이션을 시작할 때만 출력하는 출력문
     */
    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    /**
     * GamePlayer에게 문자열을 입력하는 순간을 알려줄 때 사용하는 출력문
     */
    public static void inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    /**
     * key: "ball", "strike"로 이루어진 해쉬맵을 받아 힌트를 알려준다.
     *
     * @param result key가 "ball", "strike"로 이루어진 해쉬맵
     * @return 컴퓨터의 수를 맞추면 true, 아니라면 false
     */
    public static boolean comparisonResult(HashMap<String, Integer> result) {
        Integer ballCount = result.get("ball");
        Integer strikeCount = result.get("strike");
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
            return false;
        }

        String outputStatement = createOutputStatement(ballCount, strikeCount);
        System.out.println(outputStatement);
        if (outputStatement.equals("3스트라이크")) {
            return true;
        }
        return false;
    }

    private static String createOutputStatement(Integer ballCount, Integer strikeCount) {
        String outputStatement = "";
        if (ballCount > 0) {
            outputStatement += String.valueOf(ballCount);
            outputStatement += "볼";
        }
        if (ballCount > 0 && strikeCount > 0) {
            outputStatement += " ";
        }
        if (strikeCount > 0) {
            outputStatement += String.valueOf(strikeCount);
            outputStatement += "스트라이크";
        }
        return outputStatement;
    }

    /**
     * 컴퓨터의 수를 맞췄을 때 출력하는 출력문
     */
    public static void gameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}