package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {

    InputValidation inputValidation = new InputValidation();

    public void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        play();
    }

    public void play() throws IllegalArgumentException {

        List<Integer> computer = makeComputerNumber();
        boolean running = true;
        boolean restartFlag = false;

        while (running) {

            System.out.print("숫자를 입력해 주세요 : ");

            String userInput = Console.readLine();
            userInput = inputValidation.validateInput(userInput);

            Map<String, Integer> score = makeScore(userInput, computer);

            alertScore(score);

            if (score.get("strike") == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                running = restart();
                restartFlag = true;
            }
            if (running && restartFlag) {
                computer = makeComputerNumber();
                restartFlag = false;
            }
        }
    }

    public static List<Integer> makeComputerNumber() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public Map<String, Integer> makeScore(String userInput, List<Integer> computer) {

        Map<String, Integer> score = new HashMap<>();
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < userInput.length(); i++) {
            int number = Integer.parseInt(String.valueOf(userInput.charAt(i)));
            if (computer.contains(number) && computer.get(i) == number) {
                strike++;
            } else if (computer.contains(number)) {
                ball++;
            }
        }
        score.put("ball", ball);
        score.put("strike", strike);

        return score;
    }

    public void alertScore(Map<String, Integer> score) {

        StringBuilder sb = new StringBuilder();

        if (score.get("ball") != 0) {
            sb.append(score.get("ball")).append("볼");
        }
        if (score.get("strike") != 0) {
            sb.append(" ").append(score.get("strike")).append("스트라이크");
        }
        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString().trim());
    }

    public boolean restart() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String gameRestartInput = Console.readLine();

        inputValidation.restartValidation(gameRestartInput);

        if (gameRestartInput.equals("1")) {
            return true;
        }

        return false;
    }

}
