package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        
        while (game == 1) {
            System.out.print("숫자를 입력해주세요 : ");

            // 사용자의 입력값 저장
            human = inputHumanNumber(Console.readLine());
            
        }
        

        // 입력 값과 결과 비교

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
            if (answerNumber.get(i) == answerNumber.get(j)) {
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


}
