

public class test1 {
    public static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String ALPHABET_LOWER = new String(ALPHABET_UPPER.toLowerCase());
    public static final int ALPHABET_LENGTH = ALPHABET_UPPER.length();

    public static void main(String[] args)  {

        String u = "I should have known that you would have a perfect answer for me!!!";
        String v = "J vltasl rlhr zdfog odxr ypw atasl rlhr p gwkzzyq zntyhv lvz wp!!!";

        System.out.println(
                movingShift(u, 0)
        );

        
        System.out.println(
                demovingShift(v, 0)
        );


    }

    public static char getNewChar(int offset, char c){
        int pos = 0;
        if (!Character.isLetter(c)) return c;

            if (Character.isLowerCase(c)) {
                pos = (ALPHABET_LOWER.indexOf(c) + offset) % ALPHABET_LENGTH;
                return (ALPHABET_LOWER.charAt(pos));

            } else {
                pos = (ALPHABET_UPPER.indexOf(c) + offset) % ALPHABET_LENGTH;
                return (ALPHABET_UPPER.charAt(pos));
            }


    }

    public static char getOldChar(int offset, char c){
        int pos = 0;
        if (!Character.isLetter(c)) return c;

        //pos = (int)(offset/ALPHABET_LENGTH) + ALPHABET_UPPER.indexOf(c) - offset;

        if (Character.isLowerCase(c)) {
            pos =  ((int)(offset/ALPHABET_LENGTH)) * ALPHABET_LENGTH + ALPHABET_LOWER.indexOf(c) - offset;
            if (pos < 0) pos = ALPHABET_LENGTH + pos;
            return (ALPHABET_LOWER.charAt(pos));

        } else {
            pos =  ((int)(offset/ALPHABET_LENGTH)) * ALPHABET_LENGTH + ALPHABET_UPPER.indexOf(c) - offset;
            if (pos < 0) pos = ALPHABET_LENGTH + pos;

            return (ALPHABET_UPPER.charAt(pos));
        }


    }

    public static String movingShift(String s, int shift){
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder("");

        int localShift = shift;
        for (char aChar : chars) {
            localShift++;
            result.append(getNewChar(localShift, aChar));
        }

        return result.toString();
    }

    public static String demovingShift(String s, int shift){
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder("");

        int localShift = shift;
        for (char aChar : chars) {
            localShift++;
            result.append(getOldChar(localShift, aChar));
        }

        return result.toString();
    }
}
