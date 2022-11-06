package baseball;

import java.util.ArrayList;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            System.out.println("숫자 야구 게임을 시작합니다.");

            ArrayList<Integer> generateAnswer = generateAnswer(args);
            while (true) {
                ArrayList<Integer> inputUserNumber = inputUserNumber(args);
                String AA = numberReferee(generateAnswer, inputUserNumber);
                System.out.println(AA);
                if (AA.equals("3스트라이크")) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }
        } while (restart() != 2);
        System.out.println("게임 종료");
    }



    public static ArrayList<Integer> generateAnswer(String[] args) {
        ArrayList<Integer> answerNumber = new ArrayList<>();
        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
            answerNumber.add(randomNumber);
            }
        }
        return answerNumber;
    }

    public static ArrayList<Integer> inputUserNumber(String[] args){
        ArrayList<Integer> inputNumberArray = new ArrayList<>();
        String inputNumber = Console.readLine();

        try {
            if (inputNumber.charAt(0) == inputNumber.charAt(1) || inputNumber.charAt(0) == inputNumber.charAt(2)
            || inputNumber.charAt(1) == inputNumber.charAt(2) || inputNumber.length() !=3){
            throw new IllegalArgumentException();
            }
            if (!Character.isDigit(inputNumber.charAt(0)) || !Character.isDigit(inputNumber.charAt(1))
            ||!Character.isDigit(inputNumber.charAt(2))) {
            throw new IllegalArgumentException();
            }
            if (inputNumber.charAt(0) ==0 || inputNumber.charAt(1)==0 || inputNumber.charAt(2) ==0){
            throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            System.out.println("게임 종료");
        }


        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(0)));
        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(1)));
        inputNumberArray.add(Character.getNumericValue(inputNumber.charAt(2)));
        return inputNumberArray;
    }

    public static String numberReferee(ArrayList<Integer> generateAnswer, ArrayList<Integer> inputUserNumber) {

        String answer = "";
        int strike = 0;
        int ball = 0;

        for (int i=0; i<3; i++){
            if(Objects.equals(generateAnswer.get(0), inputUserNumber.get(i))) {
                if(i == 0){
                    strike++;
                }else{
                    ball++;
                }
            }
        }

        for (int i=0; i<3; i++){
            if(Objects.equals(generateAnswer.get(1), inputUserNumber.get(i))) {
                if(i == 1){
                    strike++;
                }else{
                    ball++;
                }
            }
        }

        for (int i=0; i<3; i++){
            if(Objects.equals(generateAnswer.get(2), inputUserNumber.get(i))) {
                if(i == 2){
                    strike++;
                }else{
                    ball++;
                }
            }
        }

        if (strike == 0 && ball ==0){
            answer += "낫싱";
        }

        else if (strike == 0){
            answer += (ball+"볼");
        }

        else if (ball ==0){
            answer += (strike+"스트라이크");
        }
        else{answer += (ball+"볼")+" "+(strike+"스트라이크");}
        return answer;
    }
    public static int restart (){
        System.out.println("계속하시겠습니까?1=계속,2=끝");
        int toBeContinue = Integer.parseInt(Console.readLine());
        try{
            if(toBeContinue != 1 && toBeContinue != 2) throw new IllegalArgumentException("게임 종료");
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return toBeContinue;
    }
}

