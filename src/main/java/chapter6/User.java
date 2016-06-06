package chapter6;

import java.util.ArrayList;
import java.util.List;

public class User {
    private ArrayList<String> phones = new ArrayList<String>();
    public void addPhone(String s) {
        phones.add(s);
    }

    public List<String> getPhones() {
        return phones;
    }
}
