public class StringContains {
    public static boolean contains(String haystack, String needle) {
        if(haystack.length() < needle.length())
            return false;

        else {
            boolean hasFlag = false;
            for(int i = 0; i < needle.length(); i++) {
                if(haystack.charAt(i) != needle.charAt(i))
                    if((i + 1) == needle.length()) {
                        hasFlag = false;
                        break;
                    }

                    else break;

                if((i + 1) == needle.length()) {
                    hasFlag = true;
                    break;
                }

                else continue;
            }

            char[] stk = new char[(haystack.length()-1)];

            for(int i = 1; i < stk.length; i++)
                stk[i - 1] = haystack.charAt(i);

            if(!hasFlag) return contains(new String(stk), needle);
            else return true;
        }
    }
    public static void main(String args[]) {
        System.out.println("contains(\"Java Programming\", \"ogr\") -> " + contains("Java programming", "ogr"));
        System.out.println("contains(\"Java Programming\", \"grammy\") -> " + contains("Java programming", "grammy"));
    }
}