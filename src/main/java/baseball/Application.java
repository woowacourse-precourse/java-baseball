package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    private static String gameStart = "숫자 야구 게임을 시작합니다.";
    private static String gameExit = "프로그램을 종료합니다.";

    public static void main(String[] args) {
        //프로그램 구현
        System.out.println(gameStart);
        gameStart();
    }

    //게임 시작
    public static void gameStart() {
        int start_yn = 1; //exit 변수
        //랜덤으로 3자리 숫자를 정하는 기능
        List<Integer> computer = randomNum();
        // 3스트라이크가 나올때 까지 반복
        while (start_yn == 1) {
            // 3자리 숫자 입력 기능 실행
            System.out.print("숫자를 입력해주세요 : ");
            int input_num = int_input();
            // 스트라이크, 볼, 낫싱 확인기능 실행
            int strike = strike(input_num_list(input_num), computer);
            int ball = ball(input_num_list(input_num), computer);
            int nothing = nothing(input_num_list(input_num), computer);
            //숫자 검증 기능(출력기능)
            print_verification(strike, ball, nothing);
            //3스트라이크일 경우 while문 종료 선택 문구
            if (strike == 3) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                start_yn = exit();
            }
            if (strike == 3 && start_yn == 1) {
                gameStart();
                break;
            } else if (strike == 3 && start_yn == 2) {
                gameExit();
                return;
            }
        }
    }

    //랜덤으로 3자리 숫자를 정하는 기능
    public static List<Integer> randomNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    //게임종료 선택시 프로그램 종료 출력 기능
    public static void gameExit() {
        System.out.println(gameExit);
    }

    //숫자를 입력받는 기능
    static int int_input() throws IllegalArgumentException {
        // Console 사용하여 String 형태 int 변경
        String input_num_string = Console.readLine();
        int input_num_int = Integer.parseInt(input_num_string);
        // 잘못된 값을 입력했을 때 예외 처리
        if (!(input_num_int > 99 && input_num_int < 1000)) {
            throw new IllegalArgumentException();
        }
        return input_num_int;
    }

    //input_num 를 배열로 변환하는 기능
    public static List<Integer> input_num_list(int input_num) {
        List<Integer> result = new ArrayList<>();
        //100의 자리수 배열에 추가
        result.add(input_num / 10 / 10);
        //10의 자리수 배열에 추가
        result.add(input_num / 10 % 10);
        //1의 자리수 배열에 추가
        result.add(input_num % 10);

        return result;
    }

    //strike 개수 구하는 기능
    public static int strike(List<Integer> input_num_list, List<Integer> computer) {
        int strike = 0;
        //1개 이상의 숫자가 같고 자리가 같은 경우 = (맞은개수)스트라이크
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(input_num_list.get(i), computer.get(i))) {
                strike += 1;
            }
        }
        return strike;
    }

    //ball 개수 구하는 기능
    public static int ball(List<Integer> input_num_list, List<Integer> computer) {
        //1개 이상의 숫자가 같고 자리가 다른 경우 = (맞은개수)볼
        int ball = 0;
        if (Objects.equals(input_num_list.get(0), computer.get(1)) || Objects.equals(input_num_list.get(0), computer.get(2))) {
            ball += 1;
        }
        if (Objects.equals(input_num_list.get(1), computer.get(0)) || Objects.equals(input_num_list.get(1), computer.get(2))) {
            ball += 1;
        }
        if (Objects.equals(input_num_list.get(2), computer.get(0)) || Objects.equals(input_num_list.get(2), computer.get(1))) {
            ball += 1;
        }
        return ball;
    }

    //nothing 구하는 기능(낫싱이 3일경우 모두 맞지 않는 수)
    public static int nothing(List<Integer> input_num_list, List<Integer> computer) {
        int nothing = 0;
        //포함되지 않는 숫자의 개수
        for (int i = 0; i < 3; i++) {
            if (!(input_num_list.contains(computer.get(i)))) {
                nothing += 1;
            }
        }
        return nothing;
    }

    //숫자 검증 기능(출력기능)
    public static void print_verification(int strike, int ball, int nothing) {
        //스트라이크가 1개 이상, 볼이 0개일 경우
        if (strike > 0 && ball == 0) {
            //3스트라이크 일 경우
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
            //아닐 경우
            else {
                System.out.println(strike + "스트라이크");
            }
        }
        //스트라이크가 1개 이상, 볼이 1개 이상일 경우
        else if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        //스트라이크가 0개, 볼이 1개이상
        else if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }
        //낫싱인 경우
        else if (nothing == 3) {
            System.out.println("낫싱");
        }
    }

    static int exit() {
        return Integer.parseInt(Console.readLine());
    }
}
