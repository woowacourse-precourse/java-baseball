package model;

import java.util.ArrayList;

public class ThreeNumber {
    protected static ArrayList<Integer> myList;

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

    public int getListLength() {
        return myList.size();
    }

    public ArrayList<Integer> getMyList() {
        return myList;
    }
}
