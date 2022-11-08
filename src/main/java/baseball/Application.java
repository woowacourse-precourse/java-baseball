package baseball;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String computer;
        String player;
        List<String> answerList = new ArrayList<>();
        boolean realEnd = false;
        boolean correct;
        while (!realEnd){
            correct = false;
            System.out.println("1");
            answerList.clear();
            int num = Randoms.pickNumberInRange(1,9);
            while(answerList.size() < 3){
                if(!answerList.contains(Integer.toString(num))){
                    answerList.add(Integer.toString(num));
                }
            }
            computer = String.join("", answerList);
            System.out.println(computer);
            while(!correct){
                System.out.print("숫자를 입력해주세요 : ");
                player = Console.readLine();
                if(!isLengthThree(player) || !isUserNumber(player) || !isDup(player)){
                    throw new IllegalArgumentException();
                }
                OutputView.printHint(new int[]{countingBall(player, computer), countingStrike(player, computer)});
                if(computer.equals(player)){
                    correct = true;
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                }
            }
            String lst = Console.readLine();
            if (!lst.equals("1")) {
                if(lst.equals("2")){
                    realEnd = true;
                }else{
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public static int countingBall(String userNum, String answerNum){
        int ball = 0;
        for(int i=0; i<userNum.length(); i++){
            if(userNum.charAt(i) != answerNum.charAt(i) && answerNum.contains(Character.toString(userNum.charAt(i)))){
                ball++;
            }
        }
        return ball;
    }

    public static int countingStrike(String userNum, String answerNum){
        int strike = 0;
        for(int i=0; i<userNum.length(); i++){
            if(userNum.charAt(i) == answerNum.charAt(i)){
                strike++;
            }
        }
        return strike;
    }

    public static boolean isUserNumber(String num){
        for(int i=0; i<num.length(); i++){
            isAllDigit(num, i);
        }
        return true;
    }

    public static boolean isAllDigit(String num, int idx) throws IllegalArgumentException{
        if(!Character.isDigit(num.charAt(idx))){
            throw new IllegalArgumentException();
        }
        return true;
    }

    public static boolean isLengthThree(String num) throws IllegalArgumentException{
        if(num.length() != 3){
            throw new IllegalArgumentException();
        }
        return true;
    }
    public static boolean isDup(String num) throws IllegalArgumentException{
        Set<Character> set = new HashSet<>();
        for(int i=0; i<num.length(); i++){
            set.add(num.charAt(i));
        }
        if(set.size() != num.length()){
            throw new IllegalArgumentException();
        }
        return true;
    }
}
