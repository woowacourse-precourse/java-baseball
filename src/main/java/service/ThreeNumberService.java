package service;

import model.ThreeNumber;

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

    public boolean judge() {
        return true;
    }
}
