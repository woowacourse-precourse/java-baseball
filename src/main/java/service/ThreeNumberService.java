package service;

import model.ThreeNumber;

import java.util.ArrayList;

public class ThreeNumberService {
    private static ThreeNumber computer;

    public ThreeNumberService() {
        computer = new ThreeNumber();
    }

    public static void init() {
        computer.setMyList();

        System.out.println("숫자 야구 게임을 시작합니다.");

        System.out.print("숫자를 입력해주세요 : ");
    }

    public int judge(ArrayList<Integer> user) {
        int sum = 0;
        for(int i = 0; i < 3; i++) {

        }
        return 1;
    }

    /**
     * 사용자 숫자가 있는지 확인 함수
     * */
    public int IsIn(int num) {
        if(computer.contains(num)) {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
