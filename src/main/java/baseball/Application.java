package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.*;

public class Application {
    static String answer;
    static int[] hint; // index 0: 볼, index 1: 스트라이크

    static void findHint(String strIn) {
        hint = new int[2];
        for (int i = 0; i < strIn.length(); i++) {
            if (answer.charAt(i) == strIn.charAt(i)) {
                hint[1]++;
            } else if (answer.indexOf(strIn.charAt(i)) != -1) {
                hint[0]++;
            }
        }
    }

    static void generateHint(String strIn) {
        findHint(strIn);
        StringBuilder hintOut = new StringBuilder();
        if (hint[0] > 0) {
            hintOut.append(String.format("%d볼 ", hint[0]));
        }
        if (hint[1] > 0) {
            hintOut.append(String.format("%d스트라이크", hint[1]));
        }
        if (hint[0] + hint[1] == 0) {
            hintOut.append("낫싱");
        }
        System.out.println(hintOut.toString());
    }

    static void checkUserInput(String strIn) {
        UserInputException.lengthCheck(strIn);
        UserInputException.numberCheck(strIn);
        UserInputException.duplicateCheck(strIn);
     }

    static String listToString(List<Integer> listIn) {
        StringBuilder output = new StringBuilder();
        for (Integer integer : listIn) {
            output.append(integer);
        }
        return output.toString();
    }

    static List<Integer> generateNumberSet() {
        List<Integer> generatedSet = new ArrayList<>();
        while (generatedSet.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generatedSet.contains(randomNumber)) {
                generatedSet.add(randomNumber);
            }
        }
        return generatedSet;
    }

    static String generateAnswer() {
        List<Integer> generatedSet = generateNumberSet();
        return listToString(generatedSet);
    }
    static void initGame() {
        answer = generateAnswer();
        System.out.println(answer);
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void main(String[] args) {
        int gameFlag = 1;
        while (gameFlag == 1) {
            initGame();
            String userInput = "";

            while (!answer.equals(userInput)) {
                System.out.print("숫자를 입력해주세요 : ");
                userInput = Console.readLine();
                checkUserInput(userInput);
                generateHint(userInput);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameFlag = Integer.parseInt(Console.readLine());
        }
        return;
    }
}
