package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private List<Integer> computer;
    private List<Integer> user;
    private String answer;

    public List<Integer> randomNumbers() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (computer.contains(randomNum) == false) {
                computer.add(randomNum);
            }
        }
//        System.out.println("computer숫자" + computer);
        return computer;
    }

    public List<Integer> inputNumbers(String userNum){
         user = new ArrayList<>();
        String[] nums = userNum.split("");


        if (nums.length != 3) {
            throw new IllegalArgumentException();
        }
        for (String num : nums) {
            int numInt = Integer.parseInt(num);
            if (user.contains(numInt)) {
                throw new IllegalArgumentException();
            } else {
                user.add(numInt);
            }
        }
        return user;
    }

    public List<Integer> findNumber(List<Integer> computer, List<Integer> user) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i) == user.get(i)) {
                strike++;
            } else if (computer.contains(user.get(i))) {
                ball++;
            }
        }

        List<Integer> strikeAndBall = new ArrayList<>();
        strikeAndBall.add(strike);
        strikeAndBall.add(ball);
        return strikeAndBall;
    }

    public String numberToString(List<Integer> strikeAndBall){
        int strike = strikeAndBall.get(0);
        int ball = strikeAndBall.get(1);

        if (strike == 3) {
            System.out.printf("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return "게임 종료";
        } else if (strike != 0 && ball != 0) {
            answer = ball+"볼 "+strike+"스트라이크";
        } else if (strike != 0) {
            answer = strike+"스트라이크";
        } else if (ball != 0) {
            answer = ball+"볼";
        } else {
            answer = "낫싱";
        }
        return answer;
    }

    public void reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = Console.readLine();
        if(userInput.equals("1")) run();
        else if(userInput.equals("2")) return;
        else throw new IllegalStateException();
    }

    public void run() {
        List<Integer> computerNumber = randomNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            System.out.printf("숫자를 입력해주세요 : ");
            String userNum = Console.readLine();
            List<Integer> userNumber = inputNumbers(userNum);
            List<Integer> strikeAndBall = findNumber(computerNumber, userNumber);

            String answer = numberToString(strikeAndBall);
            if(answer.equals("게임 종료")) break;
            else System.out.println(answer);
        }
        reStart();
    }

}