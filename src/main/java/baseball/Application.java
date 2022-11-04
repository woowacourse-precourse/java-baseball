package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public String randomNum = "";

    public void randomNum(){
        while(randomNum.length() < 3) {
            for (int i = 0; i < 3; i++) {
                int num = Randoms.pickNumberInRange(1, 9);
                String numToString = Integer.toString(num);
                if (randomNum.contains(numToString) == false) {
                    randomNum += numToString;
                }
            }
        }
    }

    public int cntBall(String getNum){
        int cnt = 0;
        char[] getNumList = getNum.toCharArray();
        char[] randomNumList = randomNum.toCharArray();

        for(int i = 0; i< 3; i++){
            for(int j = 0 ; j < 3 ; j ++){
                if(randomNumList[i] == getNumList[j]){
                    cnt ++;
                }
            }
        }
        return cnt;
    }

    public int cntStrike(String getNum){
        int cnt = 0;
        char[] getNumList = getNum.toCharArray();
        char[] randomNumList = randomNum.toCharArray();

        for(int i = 0; i< 3; i++){
            if(randomNumList[i] == getNumList[i]){
                cnt ++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Application application = new Application();
        application.randomNum(); // 난수생성
        String userNum = Console.readLine(); // 점수받기

        System.out.println(application.cntBall(userNum));
        System.out.println(application.cntStrike(userNum));

    }
}
