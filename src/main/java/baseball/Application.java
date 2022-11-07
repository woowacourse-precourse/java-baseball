package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Application {
    public static int findBalls(String input, ArrayList<Integer> correct)
    {
        int loc=0;
        int ball=0;
        while (loc<3){
            int valueOfCurrent = Character.getNumericValue(input.charAt(loc));
            if (correct.indexOf(valueOfCurrent) != 1 && correct.contains(valueOfCurrent)){
                ball++;
            }
            loc++;
        }
        return ball;
    }
    public static int findStrikes(String input, ArrayList<Integer> correct){
        int loc=0;
        int strike=0;
        while (loc<3){
            int valueOfCurrent = Character.getNumericValue(input.charAt(loc));
            if(correct.indexOf(valueOfCurrent) == loc)
            {
                strike++;
            }
            loc++;
        }
        return strike;
    }

//    게임 시작 초기값 생성 (위치, 값)
    public static void main(String[] args) {
        //기능 테스트
//        int randNum = Randoms.pickNumberInRange(0,999);
//        System.out.println("RandomNum : " + randNum);
//        String inputData = Console.readLine();
//        System.out.println("InputData : " + inputData);
        String inputData = "123";

//        초기값 생성
        ArrayList<Integer> randomArray = new ArrayList<>();
        int loc = 0;
        while (loc<3){
            int randNum = Randoms.pickNumberInRange(1,9);
            if (randomArray.contains(randNum)) continue;

            randomArray.add(randNum);
            loc++;
        }

//        입력 값과 정답 비교
        int strike = findStrikes(inputData,randomArray);
        int ball = findBalls(inputData,randomArray);
        System.out.println("correct : " + randomArray);
        System.out.println("strike : "+strike);
        System.out.println("ball : "+ball);
    }
}
