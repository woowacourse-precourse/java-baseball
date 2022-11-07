package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static int makeRandomNum(){
        List<Integer> randomDigitList = new ArrayList<>();
        while (randomDigitList.size() < 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (!randomDigitList.contains(randomDigit)) {
                randomDigitList.add(randomDigit);
            }
        }
        int randomNumber = randomDigitList.get(0)*100 + randomDigitList.get(1)*10 +randomDigitList.get(2);
        return randomNumber;
    }

    public static int strike(int input, int randomNumber){
        List<Integer> inputList = new ArrayList<>();
        List<Integer> randomNumList = new ArrayList<>();
        //빈 리스트에 각 자리 숫자들 넣기(일의자리부터)
        for(int i=0; i<3; i++){
            inputList.add(input % 10);
            input /= 10;
            randomNumList.add(randomNumber % 10);
            randomNumber /= 10;
        }
        //각 자리 숫자들 비교
        int count =0;
        for(int i=0; i<3; i++){
            if(inputList.get(i).equals(randomNumList.get(i))){
                count++;
            }
        }
        return count;
    }

    public static int ball(int input, int randomNumber){
        List<Integer> inputList = new ArrayList<>();
        List<Integer> randomNumList = new ArrayList<>();
        //빈 리스트에 각 자리 숫자들 넣기(일의자리부터)
        for(int i=0; i<3; i++){
            inputList.add(input % 10);
            input /= 10;
            randomNumList.add(randomNumber % 10);
            randomNumber /= 10;
        }
        //각 자리 숫자들 비교
        int count = 0;
        for(int i=1; i<3; i++){
            if(inputList.get(0).equals(randomNumList.get(i))){
                count++;
            }
            if(inputList.get(i).equals(randomNumList.get(0))){
                count++;
            }
            if(inputList.get(i).equals(randomNumList.get(3-i))){
                count++;
            }
        }
        return count;
    }

    public static boolean validation(String inputStr){
        boolean validation = true;
        //3자리 숫자여부 판단, 숫자가 아닐 경우 유효성 검사 종료
        if(!inputStr.matches("^[1-9]{3}$")){
            return false;
        }
        //리스트에 각 자리 숫자 넣기
        int input = Integer.parseInt(inputStr);
        List<Integer> inputList = new ArrayList<>();
        for(int i=0; i<3; i++){
            inputList.add(input % 10);
            input /= 10;
        }
        //각 자리 숫자 반복 여부 판단
        for(int i=0; i<2; i++){
            if(inputList.get(0).equals(inputList.get(i+1))){
                validation = false;
            }
        }
        if(inputList.get(1).equals(inputList.get(2))){
            validation = false;
        }

        return validation;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int randomNumber = makeRandomNum();
        String inputStr = Console.readLine();
        boolean validation = validation(inputStr);

    }
}

