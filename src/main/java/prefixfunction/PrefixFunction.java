package prefixfunction;

public class PrefixFunction {

    private static int[] prefixFunction (String s) {
        int n = s.length();

        int[] pi = new int[n];

        // pi[0] = 0 by default
        for (int i = 1; i < n; i++) {

            int j = pi[i-1];

            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            pi[i] = j;
        }

        return pi;
    }

    private static int indexOf(String haystack, String needle) {
        int[] pi = prefixFunction(needle);
        int j = 0;

        for (int i = 0; i < haystack.length(); ++i) {

            while (needle.charAt(j) != haystack.charAt(i) && j > 0) {
                j = pi[j - 1];
            }

            if (needle.charAt(j) == haystack.charAt(i)) {
                j = j + 1;
                if (j == needle.length()) {
                    return i - j + 1;
                }
            } else {
                j = 0;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        /*String haystack = "aabcddeAACaaab";
        String needle = "AAC";
        String str = needle + "#" + haystack;

        int[] pi = prefixFunction(str);
        System.out.println(Arrays.toString(pi));

        int index = -1;
        for (int i = 0; i < pi.length; i++) {
            if (pi[i] == needle.length()) {
                index = i - 2 * needle.length();
                break;
            }
        }
        System.out.println("expected index = 7");
        System.out.println("index = " + index);*/

        String haystack = "ABC ABCDAB ABCDABCDABDE";
        String needle = "ABCDABD";
        System.out.println("expected index = 15");
        System.out.println("index = " + indexOf(haystack, needle));
    }
}
