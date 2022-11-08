package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flag {
    boolean bool;
    Flag(boolean bool) {
        this.bool = bool;
    }
}
class strikeAndBall {
    int s;
    int b;
    strikeAndBall(int s,int b) {
        this.s = s;
        this.b = b;
    }
}
public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Flag game = new Flag(true);

        while (game.bool) {
            Flag done = new Flag(false);
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                temp(computer, randomNumber);
            }
            System.out.println("숫자 야구 게임을 시작합니다.");
            progressGame(computer,game,done);

        }
    }
    static void printResult(strikeAndBall sAndB,Flag game,Flag done) {
        if (sAndB.s + sAndB.b == 0) {
            System.out.println("낫싱");
        }
        else if(sAndB.s==0) {
            System.out.println(String.format("%d볼",sAndB.b));

        }
        else if (sAndB.b == 0) {
            System.out.println(String.format("%d스트라이크", sAndB.s));
            if (sAndB.s == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                continueGame(game);
                done.bool = true;
                System.out.println(game);
                System.out.println(done);
            }
        }
        else {
            System.out.println(String.format("%d볼 %d스트라이크",sAndB.b, sAndB.s));
        }
    }

    static void continueGame(Flag game) {
        if (Console.readLine().equals("2")) {
            game.bool = false;
        }
    }

    static void progressGame(List<Integer> computer,Flag game,Flag done) {
        while (!done.bool) {
            String input;
            Integer inputNum;
            System.out.print("숫자를 입력해주세요 :");
            input = Console.readLine();
            if (input.length() > 3) {
                throw new IllegalArgumentException();
            }
            inputNum = Integer.parseInt(input);
            int userNum[]={inputNum/100,(inputNum%100)/10,(inputNum%100)%10};
            strikeAndBall sAndB = new strikeAndBall(0, 0);
            for(int i=0;i<userNum.length;i++){
                countIncrease(sAndB,i,computer, userNum[i]);
            }
            System.out.println(computer);
            System.out.println(inputNum);
            printResult(sAndB,game,done);
            System.out.println(game.bool);
            System.out.println(done.bool);
        }
    }

    static void countIncrease(strikeAndBall sAndB,int i,List<Integer> computer, Integer userInput) {
        if(computer.get(i).equals(userInput)){
            sAndB.s+=1;
        } else if (computer.contains(userInput)) {
            sAndB.b+=1;
        }
    }

    static void temp(List<Integer> computer, Integer randomNumber) {
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }


}
