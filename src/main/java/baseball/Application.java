package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {

    static int input(){
        System.out.print("숫자를 입력해주세요 : ");
        int input = Integer.parseInt(Console.readLine());
        System.out.println(input);
        return input;
    }

    static ArrayList<Integer> separate(int input){
        ArrayList<Integer> player = new ArrayList<>();
        while(input>0){
            player.add(input%10);
            input = input/10;
        }
        return player;
    }

    static void verifyPlayer(ArrayList<Integer> player){
        if(player.size() != 3 || (player.contains(0))) throw new IllegalArgumentException();
        if(player.get(0) == player.get(1) || player.get(0) == player.get(2) || player.get(1) == player.get(2)) throw new IllegalArgumentException();
        return;
    }

    static ArrayList<Integer> random(){
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    static int getBallScore(ArrayList<Integer> computer, ArrayList<Integer> player){
        int ballScore = 0;
        for(int i=0; i<player.size(); i++){
            int playerNum = player.get(i);
            int computerNum = computer.get(i);
            if(playerNum != computerNum && computer.contains(playerNum)) ballScore +=1;
        }
        return ballScore;
    }

    static int getStrikeScore(ArrayList<Integer> computer, ArrayList<Integer> player){
        int strikeScore = 0;
        for(int i=0; i<player.size(); i++){
            int playerNum = player.get(i);
            int computerNum = computer.get(i);
            if(playerNum == computerNum) strikeScore +=1;
        }
        return strikeScore;
    }

    static void print(int ball, int strike){
        if(strike == 3){
            System.out.println(strike+"스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        else if(ball > 0 && strike > 0){
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }else if(ball > 0){
            System.out.println(ball+"볼");
        }else if(strike>0){
            System.out.println(strike+"스트라이크");
        }else{
            System.out.println("낫싱");
        }
    }

    static boolean compare(ArrayList<Integer> computer, ArrayList<Integer> player){
        int ball = getBallScore(computer,player);
        int strike = getStrikeScore(computer,player);
        print(ball,strike);
        if(strike == 3) return true;
        else return false;
    }

    static void game(){
        ArrayList<Integer> computer = random();
        ArrayList<Integer> player = new ArrayList<>();
        do{
            int inputInt = input();
            player = separate(inputInt);
            Collections.reverse(player);
            verifyPlayer(player);
        }while(!compare(computer,player));
    }

    static boolean finish(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int restart = Integer.parseInt(Console.readLine());
        if(restart == 1) return false;
        else if(restart == 2) return true;
        else throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do{
            game();
        }while(!finish());
    }
}
