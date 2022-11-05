package baseball;
import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("게임을 시작합니다.");
        //랜덤수 생성
        List<Integer> computer = new ArrayList<>();
        makeRandomNumber(computer);

        List<Integer> user = new ArrayList<>();

        //사용자의 입력 (3자리 정수)
        System.out.print("숫자를 입력해주세요 : ");
        String[] inputArray = Console.readLine().split("");

        //입력을 검증 (문제시 예외로 던진다);
        //3자리 미입력시 다시 입력
        if (inputArray.length != 3){
            System.out.println("3자리 정수만 입력해주세요.. ");
            //continue;
        }
        for(String keyword : inputArray){
            try {
                Integer.parseInt(keyword);
            }catch (Exception e){
                e.printStackTrace();
            }

        }

        //사용자의 입력과 답을 비교
        //결과를 출력
        //더 수행할지 여부를 확인
    }

    /**1-9 사이 무작위 숫자를 3개 구현하는 메서드
     * Make random number.
     *
     * @param computer the computer
     */
    public static void makeRandomNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }


}

