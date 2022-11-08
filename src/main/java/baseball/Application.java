package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Application {


    public static void main(String[] args) {

        int[] dfnumbers = new int[3];
        int index = 0;
        while (index < 3) {
            dfnumbers[index] = Randoms.pickNumberInRange(1, 9);
            boolean hasDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (dfnumbers[index] == dfnumbers[j]) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (!hasDuplicate) {
                index++;
            }  // 기능 2 완료
        }

        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean theswitch = true;


        while (theswitch) {

            System.out.print("3자리 숫자를 입력해주세요 : ");

            int inputNum = Integer.parseInt(Console.readLine()); // 기능3완료

            int inputNumbers[] = new int[]{inputNum / 100, inputNum / 10, inputNum % 10};

            int strikeCount = 0, ballCount = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (dfnumbers[i] == inputNumbers[j]) {
                        if (i == j) {
                            strikeCount++;
                        } else {
                            ballCount++;
                        }
                    }
                }
            }

            if (ballCount != 0) {
                if (strikeCount != 0) {
                    System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                } else {
                    System.out.println(ballCount + "볼");
                }
            } else if (strikeCount !=0 ) {
                if (strikeCount != 3) {
                   System.out.println(strikeCount + "스트라이크");
                }else {
                    theswitch = false;
                }
            } else {
                System.out.println("낫싱");
            }
        }

        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 하세요");

            int finalNum = Integer.parseInt(Console.readLine());
                if (finalNum == 1) {
                    theswitch = true;
                }else{

                }
    }
}
