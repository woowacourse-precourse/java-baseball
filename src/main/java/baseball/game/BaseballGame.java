package baseball.game;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class BaseballGame {

    /*
     * 컴퓨터가 세자리의 랜덤 숫자를 선택, 각 자리값을 리스트에 담아 반환
     */
    private List<Integer> computersChoice() {

        List<Integer> computer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

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

        String input = Console.readLine();
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

        if (input.length() > 3) {
            throw new IllegalArgumentException("you can't enter more than three digits");
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

        String input = Console.readLine();
        System.out.println(input);

        if (Integer.valueOf(input).equals(1)) {
            return false;   // 게임 재시작
        } else if (Integer.valueOf(input).equals(2)) {
            return true;    // 게임 종료
        } else {
            throw new IllegalArgumentException("you must choose between 1 and 2");  // 예외
        }
    }

    public void run(){

        List<Integer> computer;
        List<Integer> user;
        List<String> results = new ArrayList<>();
        boolean quit = false;

        computer = computersChoice();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!quit) {

            System.out.print("숫자를 입력해주세요 : ");
            user = usersChoice();
            results.add(getGameResult(computer, user));
            System.out.println(results.get(results.size() - 1));    // 숫자 판별 결과 출력

            // 결과가 3스트라이크라면 게임종료, 재시작 혹은 애플리케이션 종료 중 하나 선택
            if (results.get(results.size() - 1).equals("3스트라이크")) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                computer = computersChoice();
                quit = restartOrQuitGame();    // 게임을 재시작할지 종료할지 여부 결정
            }
        }
    }
}
