package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int NUMBERS_SIZE = 3;

    public static void main(String[] args) {
        Player computer = new Player(selectComputerNumber());
        printStartComment();
        while (true){
            printInputNumberComment();
            Player user = new Player(toIntegers(split(Console.readLine())));
        }

    }

    public static List<Integer> selectComputerNumber(){
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static void printStartComment(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumberComment(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static String[] split(String string){
        return string.split("");
    }

    public static List<Integer> toIntegers(String[] input){
        List<Integer> player = new ArrayList<>();

        for(String number : input)
            player.add(Integer.parseInt(number));

        return player;
    }

    public static int numberOfStrikes(Player computer, Player user){
        int count = 0;

        for(int i=0; i< NUMBERS_SIZE; i++){
            if(computer.isStrike(i, user.getNumberOfIndex(i)))
                count++;
        }

        return count;
    }

    public static int numberOfBalls(Player computer, Player user){
        int count = 0;

        for(int i=0; i< NUMBERS_SIZE; i++){
            if(computer.isBall(i, user.getNumberOfIndex(i)))
                count++;
        }

        return count;
    }
}
