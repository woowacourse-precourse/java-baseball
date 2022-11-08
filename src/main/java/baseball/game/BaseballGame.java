package baseball.game;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class BaseballGame {

    private List<Integer> computer;

    /*
     * 컴퓨터가 세자리의 랜덤 숫자를 선택, 각 자리값을 리스트에 담아 반환
     */
    private List<Integer> computersChoice() {

        List<Integer> computer = new ArrayList<>();

        // 중복되지 않는 세 개의 숫자를 선택
        while (computer.size() < 3) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    /*
     * 사용자가 세자리의 숫자를 입력, 각 자리값을 리스트에 담아 반환
     */
    private List<Integer> usersChoice() {

        String input;

        // Console.readLine()은 Scanner.nextLine() 기반의 함수이므로 해당 메소드 발생 예외들을 처리해줌
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("NoSuchElementException: no line was found");
        }

        System.out.println(input);

        inputExceptionHandler(input);   // 입력값 예외처리

        List<Integer> user = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            user.add(Character.getNumericValue(input.charAt(i)));
        }

        return user;
    }

    /*
     * 사용자 입력 예외를 처리함
     */
    private void inputExceptionHandler(String input) {

        // 입력한 문자열의 길이가 3이 아니라면, 세 자리의 양수가 아님
        if (input.length() != 3) {
            throw new IllegalArgumentException("you can't enter more than three digits");
        }

        // 입력한 문자열이 숫자로만 구성되어 있지 않다면, 세자리의 양수가 아님
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("you can't enter non-numeric values");
        }
    }

    /*
     * 컴퓨터가 고른 숫자와 사용자가 입력한 숫자를 비교하여 결과를 반환
     */
    private String getGameResult(List<Integer> computer, List<Integer> user) {

        int ball = 0;
        int strike = 0;

        for (int i = 0; i < 3; i++) {

            // 볼 혹은 스트라이크일 경우
            if (computer.contains(user.get(i))) {
                ball++;
            }

            // 스트라이크일 경우
            if (computer.get(i).equals(user.get(i))) {
                ball--;
                strike++;
            }
        }

        String result = "";

        if (ball == 0 && strike == 0) {
            result += "낫싱";
            return result;
        }

        if (ball > 0) {
            result += ball + "볼 ";
        }

        if (strike > 0) {
            result += strike + "스트라이크";
        }

        return result.trim();
    }

    /*
     * 게임 종료 후 숫자 야구 게임 종료 여부 반환
     */
    private boolean restartOrQuitGame() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input;

        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("NoSuchElementException: no line was found");
        }

        System.out.println(input);

        if (Integer.valueOf(input).equals(1)) {
            computer = computersChoice();
            return false;   // 게임 재시작
        } else if (Integer.valueOf(input).equals(2)) {
            return true;    // 게임 종료
        } else {
            throw new IllegalArgumentException("you must choose between 1 and 2");  // 예외
        }
    }

    public void run() {

        List<String> results = new ArrayList<>();
        boolean quit = false;

        computer = computersChoice();   // 1. 컴퓨터가 랜덤한 숫자를 뽑음

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!quit) {

            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> user = usersChoice(); // 2. 사용자가 입력함

            results.add(getGameResult(computer, user)); // 3. 숫자를 판별함
            System.out.println(results.get(results.size() - 1));    // 4. 숫자 판별 결과 출력

            // 5. 결과가 3스트라이크라면 게임종료, 재시작 혹은 애플리케이션 종료 중 하나 선택
            if (results.get(results.size() - 1).equals("3스트라이크")) {
                quit = restartOrQuitGame();
            }
        }
    }
}
