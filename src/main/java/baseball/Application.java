package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.*;
import java.lang.IllegalArgumentException;
import java.util.stream.Collectors;

class BaseballGame {
    public static void gameStart(){

        List<Integer> answerNum = new ArrayList<>(generateAns());
        while (true) {
            Integer userNum = input();
            judge(userNum, answerNum);
        }

    }
    public static List<Integer> generateAns(){

       List<Integer> answerNum = new ArrayList<>();

        while (answerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNum.contains(randomNumber)) {
                answerNum.add(randomNumber);
            }
        }

        return answerNum;
    }
    public static Integer input(){
        Scanner sc = new Scanner(System.in);
        Integer userNum;

        System.out.println("숫자를 입력해주세요 : ");
        userNum = sc.nextInt();
        if(userNum<1000 && userNum>0){
            sc.close();
            return userNum;
        }
        else {
            new IllegalArgumentException("허용되지 않은 입력값 입니다.");
            return quit();
        }
    }
    public static List<Integer> intToList(Integer userNum){
        List<Integer> userNumToList = new ArrayList<>();
        while(userNum!=0) {
            userNumToList.add(userNum % 10);
            userNum/=10;
        }
        Collections.reverse(userNumToList);

        //예외잡기
        for(int i=0; i<3; i++){
            if(userNumToList.size()!=3){
                new IllegalArgumentException("허용되지 않은 입력값 입니다.");
                quit();
            }
            if(userNumToList.get(i)==0) {
                new IllegalArgumentException("허용되지 않은 입력값 입니다.");
                quit();
            }
            if(userNumToList.get(i)<0) {
                new IllegalArgumentException("허용되지 않은 입력값 입니다.");
                quit();
            }
        }
        if(userNumToList.get(0).equals(userNumToList.get(2))==true){
            new IllegalArgumentException("허용되지 않은 입력값 입니다.");
            quit();
        }
        if(userNumToList.get(0).equals(userNumToList.get(1))==true){
            new IllegalArgumentException("허용되지 않은 입력값 입니다.");
            quit();
        }
        if(userNumToList.get(1).equals(userNumToList.get(2))==true){
            new IllegalArgumentException("허용되지 않은 입력값 입니다.");
            quit();
        }



        return userNumToList;

    }

    public static void judge(Integer userNum, List<Integer> answerNum){

        List<Integer> userNumToList = intToList(userNum);

        int ball=0,strike=0;

        for (int i=0; i<3; i++){
            if(userNumToList.get(i).equals(answerNum.get(i))==true)
                strike++;
            else if(answerNum.toString().contains(userNumToList.get(i).toString())==true) {
                ball++;
            }
        }

        List<Integer> toPrint = Arrays.asList(ball,strike);
        printCnt(toPrint);

    }
    public static int quit(){
        return 0;
    }
    public static void printCnt(List<Integer> count){
        Integer sum = count.get(0)+count.get(1);

        if(sum.equals(0)==true){
            printNothing();
        }
        else {
            if (count.get(0).equals(0)==false)
                System.out.print(count.get(0) + "볼 ");
            if (count.get(1).equals(0)==false)
                System.out.println(count.get(1) + "스트라이크");
            if(count.get(1).equals(3)==true)
                success();
        }


    }
    public static void printNothing(){
        System.out.println("낫싱");
    }

    public static void success(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        Scanner In = new Scanner(System.in);
        int userWanna = In.nextInt();
        In.close();
        if(userWanna==1)
            gameStart();
        else if (userWanna==2)
            quit();
        else {
            new IllegalArgumentException("허용되지 않은 입력값 입니다.");
            quit();
        }
    }

}



public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        BaseballGame.gameStart();
    }
}
