package baseball;

/*
* [O] 랜덤 번호 생성
* [O] 잘못된 입력 예외 처리(어플리케이션 종료)
* [O] 입력된 숫자에 대한 스트라이크/볼/낫싱 판별
* [O] 숫자 반복 입력 기능
* [O] 게임 종료 시 재시작 기능
* [O] 기능별 테스트 작성
* [O] 테스트 확인
*/

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    final static String START_USER_INPUT = "1";

    /*
     * Input : 3자리의 연속되고 중복되지 않는 숫자 시컨스 Range(1 ~ 9) ex) 345, 736, 912
     */
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        HashMap<Integer, Integer> computerIndexMap = new HashMap<>();

        boolean isRestart = true;
        String userInput = "";
        int strikeCount = 0, ballCount = 0;

        initRandomNumber(computer, computerIndexMap);

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(isRestart) {
            System.out.print("숫자를 입력해주세요 : ");
            userInput = Console.readLine();

            try {
                validateUserInput(userInput);
            } catch (IllegalArgumentException e) {
                // 입력 예외가 발생한다면 throw exception
                System.out.println(e.getMessage());
                throw e;
            }

            strikeCount = checkStrike(computer, userInput);
            ballCount = checkBall(computerIndexMap, userInput);
            printResult(strikeCount, ballCount);

            if(strikeCount == 3){
                // 스트라이크가 3개라면 새로운 게임 시작할지 정하기
                isRestart = isNewGame(computer, computerIndexMap);
            }
        }
    }

    private static boolean isNewGame(List<Integer> computer, HashMap<Integer, Integer> computerIndexMap) {
        String userInput;
        boolean isRestart;

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        userInput = Console.readLine();
        isRestart = userInput.equals(START_USER_INPUT);

        if(isRestart)
            initRandomNumber(computer, computerIndexMap);

        return isRestart;
    }

    private static void printResult(Integer strike, Integer ball) {
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
            return;
        }

        if(ball > 0)
            System.out.print(ball + "볼 ");

        if(strike > 0)
            System.out.println(strike + "스트라이크");
        else
            System.out.println();
    }

    public static int checkBall(final HashMap<Integer, Integer> computerIndexMap, String userInput) {
        int ballCount = 0;

        for (int idx = 0; idx < userInput.length(); idx++) {
            int userNumber = Character.getNumericValue(userInput.charAt(idx));

            if(computerIndexMap.containsKey(userNumber) && computerIndexMap.get(userNumber) != idx)
                ballCount++;
        }

        return ballCount;
    }

    public static int checkStrike(final List<Integer> computer, String userInput) {
        int strikeCount = 0;

        for (int idx = 0; idx < userInput.length(); idx++) {
            int userNumber = Character.getNumericValue(userInput.charAt(idx));

            if(userNumber == computer.get(idx))
                strikeCount++;
        }
        return strikeCount;
    }

    public static void validateUserInput(String s) {
        if(s.length() != 3)
            throw new IllegalArgumentException("자릿수가 3자리가 아닙니다.");

        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i)))
                throw new IllegalArgumentException("숫자가 아닌 문자 입력 예외.");
        }
    }

    private static void initRandomNumber(List<Integer> computer, HashMap<Integer,Integer> computerIndexMap) {
        // 새로운 게임마다 기존에 사용하던 자료구조 clear
        computer.clear();
        computerIndexMap.clear();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            // 기존에 뽑은 중복된 숫자를 뽑아내지 않기 위해(naive)
            if (!computer.contains(randomNumber)) {
                computerIndexMap.put(randomNumber, computer.size());
                computer.add(randomNumber);
            }
        }
    }
}
