package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class ThreeNumber {
    private static ArrayList<Integer> myList;

    public ThreeNumber() {
        myList = new ArrayList<>();
    }

    public boolean addToMyList(int number) {
        if(!myList.contains(number) || !(0 < number && number < 10)) {
            myList.add(number);

            return true;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public Integer getMyListValue(int index) {
        return myList.get(index);
    }

    public boolean contains(int num) {
        if(myList.contains(num)) {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 낫씽은 아니지만 볼인지 스트라이크인지 판단하는 함수
     * */
    public boolean isSameIndex(int num, int index) {
        if(myList.get(index).equals(num)) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void setMyList() {
        while(myList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            addToMyList(randomNumber);
        }
    }
}
