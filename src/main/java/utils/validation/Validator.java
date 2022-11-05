package utils.validation;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private List<Validation> validationList;

    private Validator(){
        validationList = new ArrayList<>();
    }

    public static Validator build(){
        Validator instance = new Validator();
        return instance;
    }

    public Validator addValidation(Validation validation){
        validationList.add(validation);
        return this;
    }
}
