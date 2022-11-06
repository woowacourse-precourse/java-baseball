package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        //1. 게임 시작 문구 <출력>
        //2. 컴퓨터의 임의의 수 3자리 선택
        //3. 숫자 3자리 입력 받기
        //4. 입력한 수에 대한 결과 표시 출력
        //5. 3스트라이크면 게임 종료 1(리셋)또는 2 입력
        //6. 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

        //라이브러리
        //  -camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
        //    Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        //  사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.


    int[] numbers = new int[3];
    int index = 0;
    while (index < 3){
        numbers[index] = Randoms.pickNumberInRange(1,9);
        boolean hasDuplicate = false;
        for (int j = 0; j < index; j++){
            if (numbers[index]== numbers[j]){hasDuplicate = true;   break; }
        }
        if (!hasDuplicate){index++;}
    }
//        for(int i=0; i<3; i++){
//            int ii =numbers[i];
//            System.out.print(ii);
//        }

        System.out.println("숫자 야구 게임을 시작합니다."); System.out.println("3자리 숫자를 입력해주세요 : ");
//        System.out.println("(!!!숫자 외의 값을 입력하면 바로 튕길 수 있습니다!!!)");


//        String inputNum = Console.readLine();
//        if(whatthe.length() > 3){
//            System.out.println("!!!! 3자리만 입력해주세요 !!!!");
//        }

        int inputNum = Integer.parseInt(Console.readLine());





    }
}
