package baseball;

import baseball.model.Answer;
import baseball.model.Nums;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Judgment {
    public static int[] judgment(Integer[] input, List<Integer> answer) {
        int[] result = new int[]{0, 0}; //result[0] = 볼, result[1] = 스트라이크
        for (int i = 0; i < 3; i++) {
            int[] temp = returnJudgmentResult(input[i], i, answer);
            result[0] += temp[0];
            result[1] += temp[1];
        }
        return result;
    } public static int[] returnJudgmentResult(int input, int index, List<Integer> answer) {
        int[] result = new int[]{0, 0};
        if (isStrike(input, answer.get(index))) {
            result[1]++;
            return result;
        }
        if (isBall(input, answer)) {
            result[0]++;

        }
        return result;
    }public static boolean isBall(int number, List<Integer> answer) {
        return answer.contains(number);
    }

    public static boolean isStrike(int number, int answerNumber) {
        return number == answerNumber;
    }

    public static int[] getJudg(Answer answer) {
        int[] judg;
        try {
            Nums nums = new Nums(Console.readLine());
            judg = judgment(nums.inputNums, answer.answerList);
            System.out.println(printJudge(judg));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return judg;
    }

    public static String printJudge(int[] judg) {
        String result = "";
        if (judg[0] != 0) {
            result += judg[0] + "볼";
        }

        if (judg[0] != 0 && judg[1] != 0) {
            result += " ";
        }
        if (judg[1] != 0) {
            result += judg[1] + "스트라이크";
        }

        if (result.equals("")) {
            return "낫싱";
        }
        return result;
    }
}
