package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static boolean game_over = false;
    public static boolean oneGameFinished = false;

    public static void makeGame(List<Integer> computer){
        computer.clear();
        while (computer.size()<3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        System.out.print("숫자 야구 게임을 시작합니다.");
        System.out.println();
    }

    public static void playgame(List<Integer> computer, List<Integer> user){
        while(!oneGameFinished){
            getNumber(user);
            judgement(computer,user);
            System.out.println();
        }
    }
    public static void getNumber(List<Integer> user){
        user.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String pitching = Console.readLine();

        try{
            isvalid(pitching);
        } catch(IllegalArgumentException e) {
            throw e;
        }

        for(int i=0;i<3;i++) {
            user.add(Integer.parseInt(String.valueOf(pitching.charAt(i))));
        }
    }

    public static void judgement(List<Integer> computer, List<Integer> user){
        int ball = 0;
        int strike = 0;
        for(int i=0;i<3;i++){
            int position = computer.indexOf(user.get(i));
            if(position==i){
                strike += 1;
            } else if (!(position==-1)) {
                ball += 1;
            }
        }
        if(showResult(strike,ball)) oneGameFinished = true;
    }

    public static boolean showResult(int strike, int ball){
        if(strike==3){
            System.out.print("3스트라이크");
            return true;
        }
        else{
            if(strike==0 && ball==0) {//낫싱
                System.out.print("낫싱");
            }
            if (ball!=0) {
                System.out.print(ball+"볼 ");
            }
            if (strike!=0) {
                System.out.print(strike+"스트라이크 ");
            }
            return false;
        }
    }

    public static void wouldYouExitGame(){

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String command = Console.readLine();

        try{
            iscommand(command);
        } catch(IllegalArgumentException e) {
            throw e;
        }
        if(command.equals("1")) oneGameFinished = false;
        if(command.equals("2")) game_over = true;
    }

    public static void isvalid(String pitching) throws IllegalArgumentException{
        if(pitching.length() != 3) throw new IllegalArgumentException();
        if(!ConsistedOfValidNumber(pitching)) throw new IllegalArgumentException();
    }

    public static boolean ConsistedOfValidNumber(String pitching){
        if(pitching.charAt(0)==pitching.charAt(1) || pitching.charAt(1)==pitching.charAt(2) || pitching.charAt(0)==pitching.charAt(2)) return false;
        for(int i=0;i<3;i++){
            int ascii = pitching.charAt(i);
            if (!(49<=ascii && ascii<=57)) return false;//1~9
        }
        return true;
    }

    public static void iscommand(String command) throws IllegalArgumentException{
        if(!(command.equals("1") || command.equals("2"))) throw new IllegalArgumentException();
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        while(!game_over){
            makeGame(computer);
            playgame(computer,user);
            wouldYouExitGame();
        }

    }
}
