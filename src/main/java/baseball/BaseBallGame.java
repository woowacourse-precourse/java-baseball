package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {
    private List<Integer> computer;
    private List<Integer> user;

    public List<Integer> randomNumbers() {
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (computer.contains(randomNum) == false) {
                computer.add(randomNum);
            }
        }
        System.out.println("computer숫자" + computer);
        return computer;
    }

    public List<Integer> inputNumbers(){
         user = new ArrayList<>();
        System.out.printf("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        String[] nums = inputNum.split("");

        if (nums.length != 3) {
            throw new IllegalStateException();
        }
        for (String num : nums) {
            int numInt = Integer.parseInt(num);
            if (user.contains(numInt)) {
                throw new IllegalStateException();
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

    public void reStart(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if(userInput.equals("1")){
            run();
        }else if(userInput.equals("2")){
            return;
        }else{
            throw new IllegalStateException();
        }
    }

    public void run() {
        List<Integer> computerNumber = randomNumbers();
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            List<Integer> userNumber = inputNumbers();
            List<Integer> result = findNumber(computerNumber, userNumber);
            int strike = result.get(0);
            int ball = result.get(1);

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                reStart();
                break;
            } else if (strike != 0 && ball != 0) {
                System.out.printf("%d볼 %d스트라이크\n", strike, ball);
            } else if (strike != 0) {
                System.out.printf("%d스트라이크\n", strike);
            } else if (ball != 0) {
                System.out.printf("%d볼\n", ball);
            } else {
                System.out.println("낫싱");
            }
        }
    }

}