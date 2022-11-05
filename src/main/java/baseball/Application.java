package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {


    public static List<Integer> GenerateRandomNumber(int digits) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < digits; i++) {
            list.add(GenerateNonDuplicateRandomNumber(list));
        }
        return list;
    }

    public static boolean isValidLength(int n) {
        return n == 3;
    }

    public static Set<Integer> InputToSet(String userInput) {
        String[] splitUserInput = userInput.split("");
        Set<Integer> set =new LinkedHashSet<>();
        for (int i = 0; i <userInput.length() ; i++) {
            set.add(Integer.parseInt(splitUserInput[i]));
        }
        return set;
    }

    public static boolean isValidSetSize(Set set) {
        return set.size() == 3;
    }


    public static int GenerateNonDuplicateRandomNumber(List<Integer> randNum) {
        int k;
        do {
            k = Randoms.pickNumberInRange(1, 9);
        }
        while (randNum.contains(k));
        return k;
    }

    public static boolean isContain(int number, List<Integer> answer) {
        return answer.contains(number);
    }

    public static boolean isStrike(int number, int answerNumber) {
        return number == answerNumber;
    }

    public static int[] Judgment(Integer[] input, List<Integer> answer) {
        int[] result =new int[]{0, 0}; //result[0] = 볼, result[1] = 스트라이크
        for (int i = 0; i <3 ; i++) {
            if(isStrike(input[i],answer.get(i))) {
                result[1]++;
                continue;
            }
            if (isContain(input[i], answer)) {
                result[0]++;
            }
        }
        return result;


    }



    static class Nums{
        public Integer[] inputNums;
        Nums(String inputData) throws Exception  {
            if(!isValidLength(inputData.length())) throw new IllegalArgumentException() ;
            Set<Integer> sets = InputToSet(inputData);
            if(!isValidSetSize(sets)) throw new IllegalArgumentException();
            this.inputNums = sets.toArray(new Integer[3]);
        }
    }


    public static void baseballGame() {
        List<Integer> answerList = GenerateRandomNumber(3);
        int[] judg = new int[]{0, 0};
        while (judg[1] != 3) {
            try {
                Nums nums = new Nums(Console.readLine());
                judg = Judgment(nums.inputNums, answerList);
            } catch (Exception e) {
                System.exit(-1);
            }
        }
    }

    public static String printJudge(int[] judg) {
        String result = "";
        if (judg[0] != 0) {
            result += judg[0]+"볼";
        }
        if (judg[1] != 0) {
            result += " " + judg[1] + "스트라이크";
        }

        if (result.equals("")) {
            return "낫싱";
        }
        return result;
    }

    public static void main(String[] args) {
        int endGame = 0;
        while (endGame!=2)
        {
            baseballGame();
        }
    }

}
