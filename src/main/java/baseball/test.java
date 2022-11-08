package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test {
//    main(String[] args) throws IOException
    public static void  gameStart() throws IOException {
        Scanner scan = new Scanner(System.in);
        int strike = 0;
        int ball = 0;

        // 컴퓨터 입력값
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        System.out.println("컴퓨터 입력값: " + computer);




        // 사람 입력값
        BufferedReader person = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> personData = new ArrayList<>();

        // 반복해서 입력 데이터 읽기
        String str;
        System.out.println("숫자를 입력해주세요.");

        while ((str = person.readLine()) != null) {

            // 사용자 입력값 리스트에 저장
            String[] str2 = str.split("");
            for (int i = 0; i < str2.length; i++) {
                personData.add(Integer.parseInt(str2[i]));
            }

            // 숫자와 위치까지 일치할 경우
            if (computer.get(0) == personData.get(0)){
                strike++;
            }
            if (computer.get(1) == personData.get(1)){
                strike++;
            }
            if (computer.get(2) == personData.get(2)){
                strike++;
            }

            // 숫자는 일치하나 위치가 불일치일 경우
            if (computer.get(0) == personData.get(1) || computer.get(0) == personData.get(2)){
                ball++;
            }
            if (computer.get(1) == personData.get(2) || computer.get(1) == personData.get(0)){
                ball++;
            }
            if (computer.get(2) == personData.get(1) || computer.get(2) == personData.get(0)){
                ball++;
            }

            // 모두 일치하지 않는 경우
            else {
                if (strike == 0 && ball == 0){
                    System.out.println("낫싱");
                }
            }


            System.out.println("스트라이크:"+ strike + " 볼:" + ball);
            System.out.println("숫자를 입력해주세요.");

            // 재시작
            if (computer.equals(personData)) {
                while (true) {
                    System.out.println("-----------------------");
                    System.out.println("게임재시작(1), 종료(2) ");
                    System.out.print("재시작여부를 입력하세요:");
                    int num = scan.nextInt();
                    if (num == 1) {
                        System.out.println("재시작");
                        break;
                    } else if (num == 2) {
                        return;
                    }
                }

            }

            strike = 0;
            ball = 0;
            personData.clear();



        } //while end
    }
    public static void main(String[] args) throws IOException {
        gameStart();
    }
}

