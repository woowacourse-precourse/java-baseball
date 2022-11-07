package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public String randomNum = "";

    public void illegalArgumentException(String s){
        if(s.length() != 3){
            throw new IllegalArgumentException("세자리 수보다 크거나 작음");
        }
    }

    public String randomNum(){
        while(randomNum.length() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String numToString = Integer.toString(randomNumber);
            if(randomNum.contains(numToString) == false){
                randomNum += numToString;
            }
        }
        return randomNum;
    }

    public int cntBall(String getNum, String randomNumber){
        int cnt = 0;
        String[] getNumList = new String[getNum.length()];
        getNumList = getNum.split("");

        for(int i =0; i < getNum.length();i++){
            if(randomNumber.contains(getNumList[i]) == true){
                cnt++;
            }
            else{
                continue;
            }
        }
        return cnt;
    }

    public int cntStrike(String getNum, String randomNumber){
        int cnt = 0;
        char[] getNumList = getNum.toCharArray();
        char[] randomNumList = randomNumber.toCharArray();

        for(int i = 0; i< 3; i++){
            if(randomNumList[i] == getNumList[i]){
                cnt ++;
            }
        }
        return cnt;
    }

    public boolean playAgain(){

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String stopOrRestart = Console.readLine();
        if(stopOrRestart.equals("2")){
            return false;
        }
        return true;
    }

    public String ballAndStrike(Application application, String userNum, String randomNumber){
        String result = "";
        if (application.cntBall(userNum, randomNumber) == 0 && application.cntStrike(userNum, randomNumber) == 0) {
            result = "낫싱";
        }else if(application.cntBall(userNum, randomNumber) > 0 && application.cntStrike(userNum, randomNumber) == 0){
            result = application.cntBall(userNum, randomNumber) + "볼";
        }else if(application.cntStrike(userNum, randomNumber) == 3){
            result = application.cntStrike(userNum, randomNumber) + "스트라이크";
        }else if(application.cntStrike(userNum, randomNumber) > 0 && application.cntStrike(userNum, randomNumber) == application.cntBall(userNum, randomNumber)){
            result = application.cntStrike(userNum, randomNumber) +"스트라이크";
        }else if(application.cntStrike(userNum, randomNumber) > 0 && application.cntBall(userNum, randomNumber) > application.cntStrike(userNum, randomNumber)){
            result = application.cntBall(userNum, randomNumber)- application.cntStrike(userNum, randomNumber)
                    + "볼 " + application.cntStrike(userNum, randomNumber) + "스트라이크";
        }

        return result;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean againOrNot = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(againOrNot) {
            Application application = new Application();
            String randomNumber = application.randomNum();
            String gameResult = "";

            while(gameResult.equals("3스트라이크") == false) {
                System.out.print("숫자를 입력해주세요 : ");
                String userNum = Console.readLine();
                application.illegalArgumentException(userNum);
                gameResult = application.ballAndStrike(application, userNum, randomNumber);
                System.out.println(gameResult);
            }

            againOrNot = application.playAgain();

        }
    }
}