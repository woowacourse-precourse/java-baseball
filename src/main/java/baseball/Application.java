package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    static List<Integer> computer = new ArrayList<>();
//    static /

    public static void RandomChoice() {
        if (computer.size()==3) computer.clear();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
    public static void CheckInsert(String str) {
        String Regex = "[^0-9]";
        if (str.replaceAll(Regex,"").length()!=3) {
            throw new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다.");
        }
        if (str.length()!=3) {
            throw new IllegalArgumentException("3자리 숫자가 아닙니다");
        }
        for (int i =0; i<str.length(); i++) {
            if (i!=str.indexOf(str.charAt(i))) {
                throw new IllegalArgumentException("중복된 숫자 입력하였습니다.");
            }
        }
    }
    public static boolean distinction(String strInt) {
        int Ball = 0;
        int Strike = 0;
        for (int i=0; i<strInt.length();i++) {
            int ChangeInt = (int)strInt.charAt(i)-48;
            if (computer.get(i) == ChangeInt) {
                Strike+=1;
            } else if (computer.contains(ChangeInt)) {
                Ball+=1;
            }
        }
        if (Ball>=1) System.out.printf("%d볼 ",Ball);
        if (Strike>=1) {
            System.out.printf("%d스트라이크",Strike);
            if (Strike==3) {
                System.out.println();
                return true;
            }
        }
        if (Strike==0 && Ball==0) System.out.println("낫싱");
        else System.out.println();
        return false;
    }
    public static int Regame(Scanner scanner) {
//        String strMsg = Console.readLine();
        String strMsg = scanner.nextLine();
        if (strMsg.equals("1") || strMsg.equals("2") ) {
            if (strMsg.equals("1"))  RandomChoice();
            return (int)strMsg.charAt(0)-48;
        }
        throw new IllegalArgumentException("1,2이외의 값을 입력하였습니다.");
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        RandomChoice();
        Scanner scanner = new Scanner(System.in);
        int ExitVal = 1;
        while (ExitVal == 1 ){
            System.out.println("숫자를 입력해주세요 : ");
//            String strMsg = Console.readLine();
            String strMsg = scanner.nextLine();
            CheckInsert(strMsg);
            boolean ReturnVal = distinction(strMsg);
            if (ReturnVal) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                ExitVal = Regame(scanner);
            }
        }
        System.out.println("게임 종료");
        scanner.close();
    }
}
