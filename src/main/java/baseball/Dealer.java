package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Dealer {
    private boolean isGameGoing = true;
    private List<Integer> threeDifferentNumbers;

    public List<Integer> getNewThreeDifferentNumbers() {
        threeDifferentNumbers = new ArrayList<>();
        Set<Integer> pickedNumbers = new HashSet<>();
        while (pickedNumbers.size() < 3) {
            Integer number = Randoms.pickNumberInRange(1, 9);
            pickedNumbers.add(number);
        }
        threeDifferentNumbers.addAll(pickedNumbers);
        Collections.shuffle(threeDifferentNumbers); // Unless the numbers will be arranged in ascending order.
        return threeDifferentNumbers;
    }

    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        System.out.println(dealer.getNewThreeDifferentNumbers());
        System.out.println(dealer.getNewThreeDifferentNumbers());
        System.out.println(dealer.getNewThreeDifferentNumbers());
        System.out.println(dealer.getNewThreeDifferentNumbers());
        System.out.println(dealer.getNewThreeDifferentNumbers());
        System.out.println(dealer.getNewThreeDifferentNumbers());
        System.out.println(dealer.getNewThreeDifferentNumbers());
        System.out.println(dealer.getNewThreeDifferentNumbers());
    }
}
