package view;

import java.util.HashMap;

public class Print {

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static boolean comparisonResult(HashMap<String, Integer> result) {
        Integer ballCount = result.get("ball");
        Integer strikeCount = result.get("strike");
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱\n");
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
}