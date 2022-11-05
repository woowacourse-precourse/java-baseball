package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public void printStartGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public int makeRandomNumber(){
        int n = 100, value = 0;
        boolean [] check = new boolean[10];
        while(n >= 1){
            int i = getRandomNumber(check);
            value += i*n;
            n/=10;
        }
        return value;
    }

    private int getRandomNumber(boolean[] check) {
        int i;
        do{
            i = Randoms.pickNumberInRange(1, 9);
            if(!check[i]){
                check[i] = true;
                break;
            }
        }while(true);
        return i;
    }

    public int insertNumber(){
        String input = Console.readLine();
        int inputInt;
        try{
            inputInt = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("입력하신 변수가 숫자형이 아닙니다");
        }
        checkIfThreeDigit(inputInt);
        checkIfAllDigitsDifferent(inputInt);
        return inputInt;
    }

    private void checkIfThreeDigit(int input){
        if(input < 100 || input > 999) throw new IllegalArgumentException("입력하신 변수가 3자리 정수가 아닙니다");
    }

    private void checkIfAllDigitsDifferent(int input){
        int n = 100;
        boolean [] check= new boolean[10];
        while(n >=1){
            int i = input / n;
            if(check[i]) throw new IllegalArgumentException("3자리가 모두 다른 숫자가 아닙니다");
            else check[i]=true;
            input%=n;
            n/=10;
        }
    }
}
