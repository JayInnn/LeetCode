package Chapter1;

public class Exe58_Length_of_Last_Word {

    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        s = s.trim();
        String[] str = s.split(" ");
        return str[str.length - 1].length();
    }

}
