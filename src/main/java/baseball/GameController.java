package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GameController {

    public List<Integer> RandomGenerator() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public boolean checkInput(String input) {
        Pattern pattern = Pattern.compile("[1-9]{3}");
        if (input == null){
            return false;
        }
        return pattern.matcher(input).matches();
    }

    public void startFirst(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        startGame();
    }

    public void startGame() {
        try {
            playGame(RandomGenerator());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void playGame(List<Integer> answer) {
        boolean isAnswer = false;
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            if (!checkInput(input)) {
                throw new IllegalStateException("올바르지 않은 입력입니다");
            }
            List<Integer> userInput = new ArrayList<>();
            for (int i =0; i<input.length();i++){
                int num = input.charAt(i) - '0';
                userInput.add(num);
            }
            isAnswer = baseballGame(answer, userInput);
        } while (!isAnswer);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        endGame();
    }

    public boolean baseballGame(List<Integer> answer, List<Integer> userInput) {
        int ballCount = 0;
        int strikeCount = 0;

        for (int i=0;i<3;i++) {
           if (answer.get(i) == userInput.get(i)){
               strikeCount++;
           }
        }
        for (int i=0;i<3;i++){
            if (answer.contains(userInput.get(i)) && answer.get(i)!=userInput.get(i)){
                ballCount++;
            }
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }
        else if (ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
            if (strikeCount == 3) {
                return true;
            }
        } else if (strikeCount == 0) {
            System.out.println(ballCount + "볼");
        } else {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        return false;
    }

    public void endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        Pattern pattern = Pattern.compile("[1-2]");
        if (input.length() > 1 || !pattern.matcher(input).matches()){
            throw new IllegalStateException("올바르지 않은 입력입니다");
        }
        if (input.equals("1")){
            startGame();
        }
    }
}
