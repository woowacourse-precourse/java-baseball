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


    public static void playGame(List<Integer> computer, List<Integer> user){
        while(true){
            getNumber(user);
            judgement(computer,user);
            System.out.println();
            if(oneGameFinished) break;
        }
    }

    public static void getNumber(List<Integer> user){
        user.clear();
        System.out.print("숫자를 입력해주세요 : ");
        String pitching = Console.readLine();

        isvalid(pitching);

        for(int i=0;i<3;i++) {
            user.add(Integer.parseInt(String.valueOf(pitching.charAt(i))));
        }
    }

    public static void isvalid(String pitching){
        if(pitching.length() != 3) throw new IllegalArgumentException("잘못된 입력입니다.");
        if(!ConsistedOfValidNumber(pitching)) throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public static boolean ConsistedOfValidNumber(String pitching){
        if(pitching.charAt(0)==pitching.charAt(1) || pitching.charAt(1)==pitching.charAt(2) || pitching.charAt(0)==pitching.charAt(2)) return false;
        for(int i=0;i<3;i++){
            int ascii = pitching.charAt(i);
            if (!(49<=ascii && ascii<=57)) return false;//1~9
        }
        return true;
    }


    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        List<Integer> user = new ArrayList<>();
        while(true){
            makeGame(computer);
            playGame(computer,user);
            wouldYouExitGame();
            if(game_over) break;
        }
    }
}
