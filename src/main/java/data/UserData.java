package data;

import util.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private List<Integer> userData= new ArrayList<>();

    public  List<Integer> getUserData(){
        return userData;
    }

    public void setUserData(String data){
        for(int i = 0; i< Utils.Numlen; i++){
            userData.add(Integer.parseInt(String.valueOf(data.charAt(i))));
        }
    }
}
