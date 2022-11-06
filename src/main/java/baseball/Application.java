package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        while(true){
            int strike = 0;
            int ball = 0;

            System.out.println("숫자 야구 게임을 시작합니다.");

            // 1. 3자리 수 랜덤 생성 - Randoms의 pickNumberInRange()사용
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);

                // 각 수는 서로 다른 수
                if (!numbers.contains(randomNumber)) {
                    numbers.add(randomNumber);
                }
            }

            System.out.print("숫자를 입력해주세요 : ");
            String player = Console.readLine();         // Console의 readLine() 사용

            // 잘못된 입력 - IllegalArgumentException 발생
            if(player.isEmpty() || !Character.isDigit(Integer.parseInt(player))){
                throw new IllegalArgumentException("잘못된 입력입니다!");
            }

            // 2. 스트라이크 볼 낫싱 판별
            int j=0;
            for(int i=0; i<numbers.size(); i++){
                char playerNumbers = player.charAt(j);
                if((i == j) && (numbers.get(i) == playerNumbers)){
                    strike++;
                    System.out.print(strike+"스트라이크 ");
                    j++;
                }
                else if((i != j) && (numbers.get(i) == playerNumbers)){
                    ball++;
                    System.out.print(ball+"볼 ");
                    j++;
                }
                else{
                    j++;
                    System.out.print("낫싱");
                }
            }

            // 3. 종료 조건 - 3자리 수를 모두 맞힌경우
            if(strike == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

                String continueOrExit = Console.readLine();
                if(Integer.parseInt(continueOrExit) == 2)
                    break;
            }
        }
    }
}
