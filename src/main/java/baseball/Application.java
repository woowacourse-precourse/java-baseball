package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void CheckPlayerNumberValidation(ArrayList<Integer> playerNumberArrayList) {
        HashSet<Integer> playerNumberSet = new HashSet<>();

        // 집합에 게임 플레이어가 입력한 숫자를 넣는다.
        for (Integer playerNumber : playerNumberArrayList) {
            playerNumberSet.add(playerNumber);
        }

        // 집합의 크기가 3이 아니거나 숫자 0을 포함하면 예외를 발생한다.
        if (playerNumberSet.size() != 3 || playerNumberSet.contains(0)) {
            throw new IllegalArgumentException("세자리 수가 아니거나 중복되는 숫자가 있거나 0이 있음");
        }
    }

    private static ArrayList<Integer> getPlayerNumber() {
        String playerString = Console.readLine();
        ArrayList<Integer> playerNumberArrayList = new ArrayList<>();

        // 게임 플레이어가 입력한 숫자를 잘라 ArrayList에 넣는다.
        String[] playerStringArray = playerString.split("");
        for (String letter : playerStringArray) {
            playerNumberArrayList.add(Integer.parseInt(letter));
        }

        // 게임 플레이어가 입력한 숫자가 유효하지 않으면 예외를 발생한다.
        CheckPlayerNumberValidation(playerNumberArrayList);

        return playerNumberArrayList;
    }

    private static ArrayList<Integer> createAnswerNumber() {
        ArrayList<Integer> answerNumberArrayList = new ArrayList<>();

        // 1에서 9까지 서로 다른 임의의 수 3개를 생성한다.
        while (answerNumberArrayList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumberArrayList.contains(randomNumber)) {
                answerNumberArrayList.add(randomNumber);
            }
        }

        return answerNumberArrayList;
    }

    private static ArrayList<ArrayList<Integer>> countStrikes(ArrayList<Integer> playerNumber, ArrayList<Integer> answerNumber) {
        int strikeCount = 0;
        ArrayList<Integer> strikeCountArrayList = new ArrayList<>();
        ArrayList<Integer> wrongNumberIndexArrayList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> strikeResultArrayList = new ArrayList<>();

        // 스트라이크의 수를 계산하고, 틀린 숫자는 index를 기록한다.
        for (int i=0; i<4; i++) {
            if (playerNumber.get(i) == answerNumber.get(i)) {
                strikeCount = strikeCount + 1;
            } else if (playerNumber.get(i) != answerNumber.get(i)) {
                wrongNumberIndexArrayList.add(i);
            }
        }

        // 스트라이크의 수와 틀린 숫자 index를 ArrayList로 리턴한다.
        strikeResultArrayList.add(strikeCountArrayList);
        strikeResultArrayList.add(wrongNumberIndexArrayList);

        return strikeResultArrayList;
    }
}
