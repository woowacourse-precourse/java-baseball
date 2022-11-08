package baseball.play;

import baseball.computer.computerNumber;
import baseball.user.userNumber;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static baseball.input.inputToint.toInt;
import static baseball.rulls.ball.isBall;
import static baseball.rulls.strike.isStrike;

public class Result {
    static final int STRIKE = 0;
    static final int BALL = 1;
    static final int Nothing = 2;
    private static int[] Points = new int[3];

    private ArrayList<Integer> solutions = new ArrayList<>();
    Result(){}
    public void setSolutions(computerNumber computer){
        solutions.addAll(computer.getComputer());
    }
    public void init(){
        Points[STRIKE] = 0;
        Points[BALL] = 0;
        Points[Nothing] = 0;
    }

    public void countStrike(computerNumber computer , userNumber user, int index){
        int computerNum = computer.getComputer().get(index);
        int userNum = user.getUser().get(index);
        if(isStrike(computerNum,userNum)) {
            Points[STRIKE] += 1;
            solutions.remove(solutions.indexOf(userNum));
            return;
        }
        if(isBall(solutions,userNum)){
            Points[BALL] +=1;
            return;
        }
        Points[Nothing] +=1;
    }

    public boolean isNothing(){
        if(Points[Nothing] ==3){
            System.out.println("낫싱");
            return true;
        }
        return false;
    }
    public void print(){
        if(isNothing()){
            return;
        }
        if(Points[BALL] > 0){
            if(Points[STRIKE] > 0){
                System.out.print(Points[BALL] + "볼 " + Points[STRIKE]+ "스트라이크");
                return;
            }
            System.out.println(Points[BALL] + "볼 ");
        }
        if(Points[STRIKE] > 0)
            System.out.println(Points[STRIKE] + "스트라이크");
    }

    public boolean gameWin(){
        if(Points[STRIKE] == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다 ! 게임 종료\n 게임을 새로 시작하려면 1, 종료하려먼 2를입력하세요.");
            return true;
        }
        return false;
    }
    public List<Integer> gameState(){
        String answer = Console.readLine();
        List<Integer> answer2int = new ArrayList<>();
        answer2int = toInt(answer);

        return answer2int;
    }

}
