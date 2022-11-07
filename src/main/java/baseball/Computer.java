package baseball;

public class Computer {
    public void cpuNumber() {
        int number[] = new int [6];

        // 번호 생성
        for(int i=0; i<3; i++) {
            number[i] = (int)(Math.random() * 10) + 1;

            // 중복 번호 제거
            for(int j=0; j<i; j++) {
                if(number[i] == number[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.print("컴퓨터 숫자: ");

        // 번호 출력
        for(int i=0; i<3; i++) {
            System.out.print(number[i] + " ");
        }
    }
}

