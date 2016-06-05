package exercises4chapter;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    public static ArrayList<Integer> checkString(String string) {
        if (string == null)
            throw  new IllegalArgumentException();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Pattern p = Pattern.compile("\\d\\d\\d");
        Matcher m = p.matcher(string);
        while (m.find())
            list.add(Integer.parseInt(m.group()));
        return list;
    }
}
