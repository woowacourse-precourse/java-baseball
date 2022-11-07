package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
public class Application {
    public static void setComputer(List<Integer> computer){
        while(computer.size() != 3){
            int num = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(num)) {
                computer.add(num);
            }
        }
    }

    public static List<Integer> readInput(){
        String playerNumber = Console.readLine();
        isValid(playerNumber);
        List<Integer> player = new ArrayList<>();
        int num = Integer.valueOf(playerNumber);
        int[] n = new int[3];

        n[0] = num/100;
        n[1] = (num%100)/10;
        n[2] = (num%100)%10;

        for(int i = 0; i < 3; i++){
            if(!player.contains(n[i])){
                player.add(n[i]);
            } else {
                throw new IllegalArgumentException("잘못된 값을 입력 - 중복되는 숫자를 입력함");
            }
        }

        return player;
    }

    public static void isValid(String str){
        if(str.length() != 3){
            throw new IllegalArgumentException("잘못된 깂을 입력 - 길이가 3이 아님");
        }
    }
    public static String returnGameResult(List<Integer> player, List<Integer> computer){
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < player.size(); i++){
            int idx = computer.indexOf(player.get(i));
            if(idx == i) {
                strikeCount++;
            } else if(idx == -1){
                continue;
            } else {
                ballCount++;
            }
        }

        if(ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        } else if(ballCount == 0) {
            return strikeCount + "스트라이크";
        } else if(strikeCount == 0) {
            return ballCount + "볼";
        } else {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
    }
    public static boolean checkStringForEnd(String str){
        if(str.equals("3스트라이크")){
            return true;
        }
        return false;
    }
    public static boolean setRepeat(List<Integer> player, List<Integer> computer){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int num = Integer.valueOf(Console.readLine());
        if(num == 1) {
            player.clear();
            computer.clear();
            setComputer(computer);
            return true;
        } else if(num == 2) {
            return false;
        } else {
            throw new IllegalArgumentException("잘못된 깂을 입력 - 1또는 2를 입력");
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean repeat = true;
        List<Integer> computer = new ArrayList<>();
        List<Integer> player;
        String result;

        System.out.println("숫자 야구 게임을 시작합니다.");
        setComputer(computer);
        while(repeat){
            System.out.print("숫자를 입력해주세요 : ");
            player = readInput();
            result = returnGameResult(player,computer);
            System.out.println(result);
            if(checkStringForEnd(result)){
                repeat = setRepeat(player,computer);
            }
        }
    }
}
