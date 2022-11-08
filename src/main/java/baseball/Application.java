package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class Application {
    public static void main(String[] args) {
        Solution();
    }

    /**
     * 게임 플레이어가 입력한 숫자의 유효성을 검증해준다.
     * 1에서 9까지 서로 다른 임의의 수 3개인지 검증
     * @param playerNumberArrayList
     */
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

    /**
     * Console API를 사용하여 게임 플레이어에게 숫자를 입력 받는다.
     * @return 게임 플레이어가 입력한 숫자를 ArrayList로 return 한다.
     */
    private static ArrayList<Integer> GetPlayerNumber() {
        String playerString = Console.readLine();
        ArrayList<Integer> playerNumberArrayList = new ArrayList<>();

        // 게임 플레이어가 입력한 숫자를 잘라 ArrayList에 넣는다.
        String[] playerStringArray = playerString.split("");
        for (String letter : playerStringArray) {
            playerNumberArrayList.add(Integer.parseInt(letter));
        }

        // 게임 플레이어가 입력한 숫자를 출력한다.
        System.out.println("숫자를 입력해주세요 : "+playerString);

        // 게임 플레이어가 입력한 숫자가 유효하지 않으면 예외를 발생한다.
        CheckPlayerNumberValidation(playerNumberArrayList);

        return playerNumberArrayList;
    }

    /**
     * 1에서 9까지 서로 다른 임의의 수 3개의 정답 숫자를 생성한다.
     * @return 정답 숫자를 ArrayList로 return 한다.
     */
    private static ArrayList<Integer> CreateAnswerNumber() {
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

    /**
     * 스트라이크의 개수를 계산하고 틀린 숫자의 index를 기록한다.
     * @param playerNumberArrayList 게임 플레이어가 입력한 숫자 ArrayList
     * @param answerNumberArrayList 컴퓨터가 생성한 정답 숫자 ArrayList
     * @return 스트라이크의 개수와 틀린 숫자의 index를 LinkedHashMap으로 return 한다.
     */
    private static LinkedHashMap<String, ArrayList<Integer>> CountStrikes
            (ArrayList<Integer> playerNumberArrayList,
             ArrayList<Integer> answerNumberArrayList) {
        int strikeCount = 0;
        ArrayList<Integer> strikeCountArrayList = new ArrayList<>();
        ArrayList<Integer> wrongNumberIndexArrayList = new ArrayList<>();
        LinkedHashMap<String, ArrayList<Integer>> strikeResultLinkedHashMap = new LinkedHashMap<>();

        // 스트라이크의 수를 계산하고, 틀린 숫자의 index를 기록한다.
        for (int i = 0; i < 3; i++) {
            boolean equalsResult = playerNumberArrayList.get(i).equals(answerNumberArrayList.get(i));

            if (equalsResult) {
                strikeCount = strikeCount + 1;
            } else if (!playerNumberArrayList.get(i).equals(answerNumberArrayList.get(i))) {
                wrongNumberIndexArrayList.add(i);
            }
        }

        // 스트라이크의 수와 틀린 숫자 index를 ArrayList로 리턴한다.
        strikeCountArrayList.add(strikeCount);
        strikeResultLinkedHashMap.put("strikeCountArrayList", strikeCountArrayList);
        strikeResultLinkedHashMap.put("wrongNumberIndexArrayList", wrongNumberIndexArrayList);

        return strikeResultLinkedHashMap;
    }

    /**
     * 볼의 개수를 계산한다.
     * @param playerNumberArrayList 게임 플레이어가 입력한 숫자 ArrayList
     * @param answerNumberArrayList 컴퓨터가 생성한 정답 숫자 ArrayList
     * @param strikeResultLinkedHashMap 스트라이크의 개수와 틀린 숫자의 index가 담긴 LinkedHashMap
     * @return 볼의 개수를 int로 return 한다.
     */
    private static int CountBalls
            (ArrayList<Integer> playerNumberArrayList,
             ArrayList<Integer> answerNumberArrayList,
             LinkedHashMap<String, ArrayList<Integer>> strikeResultLinkedHashMap) {
        int ballCount = 0;
        HashSet<Integer> wrongPlayerNumberSet = new HashSet<>();
        HashSet<Integer> answerNumberSet = new HashSet<>();

        // 플레이어가 틀린 숫자의 집합과 정답 숫자의 집합을 만든다.
        ArrayList<Integer> wrongNumberIndexArrayList = strikeResultLinkedHashMap.get("wrongNumberIndexArrayList");
        for (Integer I : wrongNumberIndexArrayList) {
            wrongPlayerNumberSet.add(playerNumberArrayList.get(I));
            answerNumberSet.add(answerNumberArrayList.get(I));
        }

        // 두 집합의 교집합을 구한다.
        HashSet<Integer> ballSet = new HashSet<>(wrongPlayerNumberSet);
        ballSet.retainAll(answerNumberSet);
        ballCount = ballSet.size();

        return ballCount;
    }

    /**
     * 게임 플레이어가 입력한 숫자를 CountStrikes와 CountBalls 메소드를 이용해 분석한다.
     * @param playerNumberArrayList 게임 플레이어가 입력한 숫자 ArrayList
     * @param answerNumberArrayList 컴퓨터가 생성한 정답 숫자 ArrayList
     * @return 스트라이크의 개수와 볼의 개수를 LinkedHashMap으로 return 한다.
     */
    private static LinkedHashMap<String, Integer> AnalyzePlayerNumber
            (ArrayList<Integer> playerNumberArrayList,
             ArrayList<Integer> answerNumberArrayList) {
        LinkedHashMap<String, Integer> finalResult = new LinkedHashMap<>();

        // 스트라이크의 개수를 계산하는 메소드
        LinkedHashMap<String, ArrayList<Integer>> strikeResultLinkedHashMap = CountStrikes
                (playerNumberArrayList, answerNumberArrayList);

        // 볼의 개수를 계산하는 메소드
        int ballResult = CountBalls
                (playerNumberArrayList,
                        answerNumberArrayList,
                        strikeResultLinkedHashMap);

        // 최종 결과를 LinkedHashMap에 넣는다.
        finalResult.put("strikes", strikeResultLinkedHashMap.get("strikeCountArrayList").get(0));
        finalResult.put("balls", ballResult);

        return finalResult;
    }

    /**
     * 스트라이크의 개수와 볼의 개수를 출력한다.
     * @param finalResult 스트라이크의 개수와 볼의 개수가 담긴 LinkedHashMap
     */
    private static void PrintResult(LinkedHashMap<String, Integer> finalResult) {
        int strikes = finalResult.get("strikes");
        int balls = finalResult.get("balls");

        // 결과 출력
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        } else if (strikes == 0 && balls != 0) {
            System.out.println(balls + "볼");
        } else if (strikes != 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        } else if (strikes != 0 && balls != 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
    }

    /**
     * 스트라이크의 개수가 3이면 게임을 종료한다.
     * @param finalResult 스트라이크의 개수와 볼의 개수가 담긴 LinkedHashMap
     * @return 게임 종료 결과를 Boolean으로 return 한다.
     */
    private static Boolean IsGameFinished(LinkedHashMap<String, Integer> finalResult) {
        int strikes = finalResult.get("strikes");
        boolean result = false;

        // 스트라이크의 개수가 3이면 끝
        if (strikes == 3) {
            result = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        } else if (strikes != 3) {
            result = false;
        }

        return result;
    }

    /**
     * 게임 반복 의사를 묻고 게임을 새로 시작하려면 1, 종료하려면 2를 입력받는다.
     * @return 게임을 새로 시작하려면 1, 종료하려면 2를 int로 return 한다.
     */
    private static int PlayAgain() {
        int result = 0;

        // 게임 반복 의사를 묻는 출력
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        // 게임 플레이어가 입력한 숫자가 1 또는 2가 아니면 입력을 다시 받는다.
        while (true) {
            String playerString = Console.readLine();
            result = Integer.parseInt(playerString);

            if (result == 1 || result == 2) {
                System.out.println(result);
                break;
            }
        }

        return result;
    }

    /**
     * 게임 종료 전까지 게임을 반복하고, 게임이 끝난 경우 PlayAgain 메소드를 이용해 게임 재시작과 종료를 게임 플레이어에게 묻는다.
     * @param answerNumberArrayList 컴퓨터가 생성한 정답 숫자 ArrayList
     * @return 게임을 새로 시작하려면 1, 종료하려면 2를 int로 return 한다.
     */
    private static int PlayGame(ArrayList<Integer> answerNumberArrayList) {
        Boolean finishResult = false;

        // 게임이 끝나지 않았으면 게임을 반복한다.
        while (!finishResult) {
            // 게임 플레이어에게 숫자를 입력 받는다.
            ArrayList<Integer> playerNumberArrayList = GetPlayerNumber();

            // 게임 플레이어가 입력한 숫자를 분석한다.
            LinkedHashMap<String, Integer> analyzedResult = AnalyzePlayerNumber
                    (playerNumberArrayList,
                            answerNumberArrayList);

            // 분석한 결과를 출력한다.
            PrintResult(analyzedResult);

            // 게임이 끝났는지 확인한다.
            finishResult = IsGameFinished(analyzedResult);
        }

        // 게임이 끝난 경우 재시작과 종료를 게임 플레이어에게 묻는다.
        int keepPlaying = PlayAgain();

        return keepPlaying;
    }

    /**
     * 게임 플레이어가 종료를 원하기 전까지 게임을 반복한다.
     */
    private static void Solution() {
        int keepPlaying = 1;

        // 숫자 야구 게임 시작을 알리는 출력
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임 플레이어가 종료를 원하기 전까지 게임을 반복한다.
        while (keepPlaying == 1) {
            ArrayList<Integer> answerNumberArrayList = CreateAnswerNumber();
            keepPlaying = PlayGame(answerNumberArrayList);
        }
    }
}
