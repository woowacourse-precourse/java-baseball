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

    //게임 시작 또는 종료 버튼
    public static void button(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String button = Console.readLine();
        if(!(button.equals("1") || button.equals("2"))){
            button();
        }
        if(button.equals("1")){
            execute();
        }
    }

    //게임 실행 메서드(버튼 메서드에서 재실행을 하기 위해 분리)
    public static void execute(){
        //랜덤수 생성
        int randomNumber = makeRandomNum();
        //strike 초기화(while 문을 빠져나오기 위한 장치)
        int strike = 0;
        while(strike!=3){
            //입력
            System.out.print("숫자를 입력해 주세요 : ");
            String inputStr = Console.readLine();
            //유효성 검사
            boolean validation = validation(inputStr);
            if(!validation){
                throw new IllegalArgumentException("각 자리가 1-9까지의 서로 다른 수로 이루어져 있는 3자리 자연수를 입력해 주세요");
            }
            //변수 생성
            int input = Integer.parseInt(inputStr);
            int ball = ball(input,randomNumber);
            //strike 재초기화
            strike = strike(input,randomNumber);
            String ballStr = Integer.toString(ball);
            String strikeStr = Integer.toString(strike);
            String ballNumStr = String.format("%s볼",ballStr);
            String strikeNumStr = String.format("%s스트라이크",strikeStr);
            //게임 실행
            if(strike!=0 && ball!=0){
                System.out.print(ballNumStr);
                System.out.print(" ");
                System.out.println(strikeNumStr);
            }
            if(strike!=0 && ball==0){
                System.out.println(strikeNumStr);
            }
            if(strike==0 && ball!=0){
                System.out.println(ballNumStr);
            }
            if(strike==0 && ball==0){
                System.out.println("낫싱");
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        button();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        execute();
    }
}

