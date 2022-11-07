package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


import java.util.*;

public class Application extends RuntimeException {
    static ArrayList<Character> Client_number_list;
    static ArrayList<Character> Computer_number_list;
    static String Client_input;
    static int Finish = 0, input = 0, ball_count = 0, strike_count = 0;


    public static void main(String[] args) {
        // TODO: 프로그램 구현


        Client_Input();

    }

    static void Client_Input() {

        Finish = 0;
        System.out.println("숫자 야구 게임을 시작합니다. ");
        System.out.println("숫자를 입력해주세요 : ");

        Computer_number_list = new ArrayList<>();

        while (Computer_number_list.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!Computer_number_list.contains((char) (randomNumber + '0'))) {
                Computer_number_list.add((char) (randomNumber + '0'));
            }

        }


        while (Finish != 2) {
            Client_input = Console.readLine();

            System.out.println(Client_input);

            if (Client_input.length() != 3) {

                IllegalSystemExit();

                return;

            } else if (Client_input.length() == 3) {

                Program_logic();

            }
        }
    }

    static void Program_logic() {

        Client_number_list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(Client_input.charAt(i)) || Client_input.length()!=3) {
                IllegalSystemExit();

                return;

            } else if (Character.isDigit(Client_input.charAt(i))) {
                Check_Client_addValue();


            }
        }

        for (int j = 0; j < 3; j++) {

            if (Computer_number_list.get(j) != Client_number_list.get(j) &&
                    Computer_number_list.contains(Client_number_list.get(j))) {
                ball_count++;

            } else if (Computer_number_list.get(j) == Client_number_list.get(j)) {
                strike_count++;
            }

        }
        Client_input_count();

    }

    static void Client_input_count() {

        if (ball_count != 0 && strike_count != 0) {


            not_zero_ball_strike();
            Client_input_reset();
            return;

        } else if (ball_count != 0 && strike_count == 0) {

            not_zero_ball_zero_strike();


        } else if (ball_count == 0 && strike_count != 0) {

            Collect();


        } else if (ball_count == 0 && strike_count == 0) {

            zero_ball_zero_strike();


        }
        return;
    }

    static void Check_Client_addValue() {

        for (int i = 0; i < 3; i++) {
            char change = Client_input.charAt(i);
            Client_number_list.add(change);
        }


    }

    static void Client_input_reset() {
        while (Client_number_list.size() != 0) {
            Client_number_list.remove(0);
        }

        return;
    }
    static void Computer_input_reset() {
//        while(Computer_number_list.size()!=0) {
//            Computer_number_list.remove(0);
//        }
        Computer_number_list.clear();
    }

    static void Collect() {

        if (strike_count == 3) {

            System.out.println(strike_count + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            strike_count = 0;

            input = Integer.parseInt(Console.readLine());

            if (input == 1) {
                Client_input_reset();
                Computer_input_reset();

            }
            if (input == 2) {

                Client_input_reset();
                Computer_input_reset();
                Finish = input;

                return;
            }
            if (input != 1 && input != 2) {
                Client_input_reset();

                IllegalSystemExit();
            }

            Client_Input();

        } else if (strike_count != 3) {
            System.out.println(strike_count + "스트라이크 ");
            System.out.println("숫자를 입력해주세요 : ");
            strike_count = 0;
            Client_input_reset();

        }

    }

    static void not_zero_ball_strike() {
        System.out.println(ball_count + "볼 " + strike_count + "스트라이크");
        System.out.println("숫자를 입력해주세요 : ");
        ball_count = 0;
        strike_count = 0;
        Client_input_reset();

        return;
    }

    static void not_zero_ball_zero_strike() {

        System.out.println(ball_count + "볼");
        System.out.println("숫자를 입력해주세요 : ");

        ball_count = 0;

        Client_input_reset();

    }

    static void zero_ball_zero_strike() {

        System.out.println("낫싱");
        System.out.println("숫자를 입력해주세요 : ");
        ball_count = 0;
        strike_count = 0;
        Client_input_reset();

    }

//    class Illegal_error extends RuntimeException {
//        String name ;
//
//        public Illegal_error(String name) {
//            this.name = name;
//        }
//        public void IllegalArgumentException() {
//
//            throw new IllegalArgumentException(Client_input);
//
//
//        }
//    }

    static void IllegalSystemExit() {
//
//        try {
//
//            RuntimeException e = new IllegalArgumentException(Client_input);
//
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//
//            return;
//
//        }

//

        throw new IllegalArgumentException(Client_input);

    }
}




