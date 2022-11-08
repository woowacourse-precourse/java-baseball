package model;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerThreeNumber extends ThreeNumber{

    public ComputerThreeNumber() {
        super();
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
        int check = 0;

        while(check != 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            check += findDuplicate(randomNumber);
        }

        System.out.println("size: " + myList.size());

        for(int i = 0; i < myList.size(); i++) {
            System.out.print(myList.get(i) + " ");
        }
    }

    public int findDuplicate(int num) {
        if(addToMyList(num))
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
