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
//        int num1 = inputNum/100; int num2 = inputNum/10; int num3 = inputNum%10;
//        int inputNumbers[] = new int[] {num1, num2, num3};
        System.out.print(inputNum);
        int inputNumbers[] = new int[] {inputNum/100, inputNum/10, inputNum%10};

        int number1= numbers[0]; int number2 = numbers[1]; int number3= numbers[2];

        while (true)
        {int strikeCount = 0, ballCount = 0;

            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if(numbers[i] == inputNumbers[j])
                    {
                        if (i == j){
                            strikeCount++;
                        }
                        else
                        {
                            ballCount++;
                        }
                    }
                }
            }

        if(ballCount > 0){
            System.out.print(ballCount+'볼'+"");
        }
        if(ballCount > 0){
            System.out.print(strikeCount+"스트라이크");
        }
        if(3-ballCount-strikeCount ==3){
            System.out.print("낫싱");
        }


            if (strikeCount == 3)
            {
                System.out.print(strikeCount+"스트라이크"+ System.lineSeparator()+"3개의 숫자를 모두 맞히셨습니다! 게임종료"
                        +System.lineSeparator()+"게임을 새로 시작하려면 1, 종료하려면 2를 하세요");

                int finalNum = Integer.parseInt(Console.readLine());

                if (finalNum == 2);


            }
        }
    }
}
