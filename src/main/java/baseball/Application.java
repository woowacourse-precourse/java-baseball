package baseball;

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
}
