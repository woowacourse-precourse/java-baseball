package baseball;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
public class NumberBaseBall {
    boolean GameStart(List<Integer> computerNumList) {
        while (true) {
            /**
             * player 숫자 입력받음 */
            int playerNum = Integer.parseInt(Console.readLine());

            /**
             *  다시 시작(1)하거나 완전히 종료(2) */
            if (playerNum == 2) {
                System.out.println(playerNum);
                return false;
            } else if (playerNum == 1) {
                System.out.println(playerNum);
                return true;
            } else {
                System.out.print("숫자를 입력해주세요 : ");
                System.out.println(playerNum);
            }


            /**
             * 자릿수 나누기 */
            List<Integer> playerNumList = numberDigits(playerNum);
            /**
             * player 숫자가 로직에 벗어나는지체크
             * */
            NumberLogicCheck(playerNumList);

            List<Integer> judgeList = judge(computerNumList, playerNumList);
            System.out.println(hint(judgeList));
            if (judgeList.get(0) == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            }
        }
    }
    // 숫자 로직 체크
    void NumberLogicCheck(List<Integer> list){
        if (list.size() != 3) {
            System.out.println("입력한 숫자의 자릿수를 확인하세요.");
            throw new IllegalArgumentException();
        }
        if (list.size() != list.stream().distinct().count()){
            System.out.println("중복되는 숫자를 확인하세요");
            throw new IllegalArgumentException();
        }
    }

    // 자릿수 나누기
    List<Integer> numberDigits(int number) {
        List<Integer> list = new ArrayList<>();
        while (number > 0) {
            int div = number % 10;
            list.add(div);
            number = number / 10;
        }
        Collections.reverse((list));
        return list;
    }
    // Player 숫자와 Computer 숫자 비교
    List<Integer> judge(List<Integer> computerNumList, List<Integer> playerNumList) {
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> checkList = new ArrayList<>();

        strikeCount += countStrike(strikeCount, computerNumList, playerNumList);

        for (int computerIdx = 0; computerIdx < computerNumList.size(); computerIdx++) {
            ballCount += countBall(computerIdx, ballCount, computerNumList, playerNumList);
        }

        checkList.add(strikeCount);
        checkList.add(ballCount);

        return checkList;
    }

    int countStrike(int strikeCount, List<Integer> computerNumberList, List<Integer> userNumberList) {
        int idx = 0;
        while (idx < computerNumberList.size()) {
            if (Objects.equals(computerNumberList.get(idx), userNumberList.get(idx))) {
                strikeCount++;
            }
            idx++;
        }
        return strikeCount;
    }

    int countBall(int computerIdx, int ballCount, List<Integer> computerNumberList, List<Integer> userNumberList) {
        for (int userIdx = 0; userIdx < userNumberList.size(); userIdx++) {
            if (computerIdx != userIdx && Objects.equals(computerNumberList.get(computerIdx), userNumberList.get(userIdx))) {
                ballCount++;
            }
        }
        return ballCount;
    }
    // hint
    String hint(List<Integer> checkList) {
        String playerHint;
        if (checkList.get(0) > 0 && checkList.get(1) > 0) {
            playerHint = checkList.get(1) + "볼 " + "" + checkList.get(0) + "스트라이크";
        } else if (checkList.get(0) == 0 && checkList.get(1) > 0) {
            playerHint = checkList.get(1) + "볼 ";
        } else if (checkList.get(0) > 0 && checkList.get(1) == 0) {
            playerHint = checkList.get(0) + "스트라이크";
        } else {
            playerHint = "낫싱";
        }
        return playerHint;
    }

}
