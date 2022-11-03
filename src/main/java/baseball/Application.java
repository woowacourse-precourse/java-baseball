package baseball;


import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int[] randomNum = new int[3]; // 서로다른 3개 숫자
        Random rand = new Random();

        for(int count = 0; count < 3; count++){ // 랜덤 숫자 3개 뽑기
            randomNum[count] = rand.nextInt(9) + 1; // 1 ~9
            for(int curCount = 0; curCount < count; curCount++){
                if(randomNum[count] == randomNum[curCount]){ // 중복이면
                    count--; // 중복 아닌 수로 다시 찾기
                }
            }
            System.out.println("num: " + randomNum[count]);
        }

    }
}
