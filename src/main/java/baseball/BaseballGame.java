package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BaseballGame {

    // 애플리케이션 실행
    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 게임 진행 1, 종료 2
        int game = 1;
        // 컴퓨터의 숫자 초기화
        List<Integer> computer = initAnswerNumber();

        // 사용자 초기화
        List<Integer> human = Collections.emptyList();

        while (game != 2) {
            System.out.println("컴퓨터 숫자 = " + computer.toString());
            System.out.print("숫자를 입력해주세요 : ");

            // 사용자의 입력값 저장
            human = inputHumanNumber(Console.readLine());

            // 입력 값과 결과 비교
            Baseball result = compareInputWithAnswer(human, computer);

            // 출력
            printResult(result);
            game = checkThreeStrike(result);

            // 스트라이크 3회, 숫자 1 입력시 게임 재시작
            if (restart(result, game)) {
                computer = initAnswerNumber();
            }

            // 스트라이크 3회, 숫자 2 입력시 게임 종료
            if (gameOver(result,game)) {
                System.out.println("게임 종료");
            }
        }


    }
    // 컴퓨터의 숫자 초기화
    public List<Integer> initAnswerNumber() {
        List<Integer> answerNumber = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            answerNumber.add(i, Randoms.pickNumberInRange(1, 9));
            if (!checkOverlap(answerNumber, i)) {
                answerNumber.remove(i);
                i--;
            }
        }
        return answerNumber;
    }

    // 초기화시 중복 검사
    public boolean checkOverlap(List<Integer> answerNumber, int i) {
        for (int j = 0; j < i; j++) {
            if (Objects.equals(answerNumber.get(i), answerNumber.get(j))) {
                return false;
            }
        }
        return true;
    }

    // 사용자의 값 입력받기
    public List<Integer> inputHumanNumber(String read) {
        String[] inputHumanNumberStr = read.split("");

        if (inputHumanNumberStr.length > 3) {
            System.out.println("길이가 넘는 예외 발생");
            throw new IllegalArgumentException("길이가 넘었습니다.");
        }

        int[] inputHumanNumber = new int[3];

        try {
            inputHumanNumber = Arrays.stream(inputHumanNumberStr)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("예외 발생");
        }

        List<Integer> humanNumberList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            humanNumberList.add(inputHumanNumber[i]);
            if (!checkOverlap(humanNumberList, i)) {
                System.out.println("중복값 예외 발생");
                throw new IllegalArgumentException("중복 값을 입력하였습니다.");
            }
        }
        return humanNumberList;
    }

    // 입력 값과 결과를 비교
    public Baseball compareInputWithAnswer(List<Integer> human, List<Integer> computer) {
        Baseball result = new Baseball();
        // 스트라이크 비교
        int strike = returnStrike(human, computer);
        // 볼 비교
        int ball = returnBallCount(human, computer);

        // 스트라이크, 볼 정보 저장
        result.setStrike(strike);
        result.setBall(ball);

        return result;
    }

    public int returnBallCount(List<Integer> human, List<Integer> computer) {
        int ball = 0;
        for (int i = 0; i < human.size(); i++) {
            for (int j = 0; j < computer.size(); j++) {
                ball += checkBallCount(i, j, human, computer);
            }
        }
        return ball;
    }

    public int checkBallCount(int i, int j, List<Integer> human, List<Integer> computer) {
        if (i == j) {
            return 0;
        }

        if (human.get(i).equals(computer.get(j))) {
            return 1;
        } else {
            return 0;
        }
    }

    public int returnStrike(List<Integer> human, List<Integer> computer) {
        int strike = 0;
        for (int i = 0; i < human.size(); i++) {
            strike += checkStrike(i, human, computer);
        }
        return strike;
    }

    public int checkStrike(int i, List<Integer> human, List<Integer> computer) {
        if (human.get(i).equals(computer.get(i))) {
            return 1;
        } else {
            return 0;
        }
    }

    public void printResult(Baseball result) {
        if (result.getBall() == 0 && result.getStrike() == 0) {
            System.out.println("낫싱");
        } else if (result.getBall() > 0 && result.getStrike() > 0) {
            System.out.println(result.getBall() + "볼 " + result.getStrike() + "스트라이크");
        } else if (result.getBall() == 0 && result.getStrike() > 0) {
            System.out.println(result.getStrike() + "스트라이크");
        } else if (result.getBall() > 0 && result.getStrike() == 0) {
            System.out.println(result.getBall() + "볼");
        } else{
            System.out.println(result.getStrike()+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

    public int checkThreeStrike(Baseball result) {
        int game;

        if (result.getStrike() == 3) {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            game = Integer.parseInt(Console.readLine());
        }else{
            game = 1;
        }

        if (game != 1 && game != 2) {
            throw new IllegalStateException();
        }else{
            return game;
        }
    }

    // 게임 종료
    private boolean gameOver(Baseball result, int game) {
        if (result.getStrike() == 3 && game == 2) {
            return true;
        }else{
            return false;
        }
    }

    // 게임 재시작
    private boolean restart(Baseball result, int game) {
        if (result.getStrike() == 3 && game == 1) {
            return true;
        }else{
            return false;
        }
    }
}
