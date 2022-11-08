package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        application.inGame();
    }

    public void inGame(){
        do{
            printStartGame();
            int randomNumber = makeRandomNumber();
            int [] score;
            do{
                int insertedNumber = insertNumber();
                score = judge(randomNumber, insertedNumber);
                printJudge(score);
            }while(!isEnd(score));
            printEndGame(true);
        }while(isContinueOrEnd());
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
        int inputInt = getInputToIntType();
        checkIfThreeDigit(inputInt);
        checkIfAllDigitsDifferent(inputInt);
        return inputInt;
    }

    public int[] judge(int answer, int value){
        int [] pos = {0,0,0,0,0,0,0,0,0};
        int [] result = {0,0};
        figureAnswer(answer, pos);
        figureValuePos(value, pos, result);
        return result;
    }

    public void printJudge(int[] score){
        int strikes = checkIfScoreIsInRange(score[0]);
        int balls = checkIfScoreIsInRange(score[1]);
        System.out.println(returnStringByCondition(strikes, balls));
    }

    public boolean isEnd(int[] score){
        if(score[0] == 3 && score[1] == 0){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    public void printEndGame(boolean state){
        if(state){
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
    }

    public boolean isContinueOrEnd(){
        return insertWhetherContinueOrEnd() == 1;
    }

    private int insertWhetherContinueOrEnd(){
        int input = getInputToIntType();
        if(input !=1 && input != 2) throw new IllegalArgumentException("1,2 둘 중의 하나의 숫자만 입력해주세요.");
        return input;
    }

    private int getInputToIntType() {
        String input = Console.readLine();
        int inputInt;
        try{
            inputInt = Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("입력하신 변수가 숫자형이 아닙니다");
        }
        return inputInt;
    }

    private int checkIfScoreIsInRange(int i) {
        if(i > 3 || i < 0) throw new IllegalArgumentException("score가 범위 안에 있지 않습니다");
        return i;
    }

    private String returnStringByCondition(int strikes, int balls){
        if(strikes == 0 && balls == 0) return "낫싱";
        else if(balls == 0) return strikes + "스트라이크";
        else if(strikes == 0) return strikes + "볼";
        else return balls+"볼 "+strikes+"스트라이크";
    }
    private void figureValuePos(int value, int[] pos, int[] result) {
        int n = 100, index = 1;
        while(n >=1){
            if(pos[value/n-1] == index) result[0]++;
            else if(pos[value/n-1] != 0) result[1]++;
            value %= n;
            n /= 10;
            index++;
        }
    }
    private void figureAnswer(int answer, int[] pos) {
        int n = 100, index = 1;
        while(n >=1){
            pos[answer/n-1] = index;
            answer %= n;
            n /= 10;
            index++;
        }
    }
    private void checkIfThreeDigit(int input){
        if(input < 100 || input > 999) throw new IllegalArgumentException("입력하신 변수가 3자리 양의 정수가 아닙니다");
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
