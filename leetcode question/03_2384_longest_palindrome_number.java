
class Solution {
    public String largestPalindromic(String num) {
        HashMap<Character, Integer> hm = new HashMap<>();

        // Count frequency of each digit
        for (char c : num.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        StringBuilder str = new StringBuilder();
        char middleChar = '\0';

        // Create the left part of the palindrome
        for (char c = '9'; c >= '0'; c--) {
            if (hm.containsKey(c)) {
                int count = hm.get(c);

                // Add half of the even count to the left part
                for (int i = 0; i < count / 2; i++) {
                    str.append(c);
                }

                // If count is odd and we haven't set a middle character yet, set it
                if (count % 2 == 1 && middleChar == '\0') {
                    middleChar = c;
                }
            }
        }

        // Remove leading zeros if any (but leave one zero if that's all we have)
        if (str.length() > 0 && str.charAt(0) == '0') {
            str = new StringBuilder();
        }

        // Construct the palindrome
        StringBuilder palindrome = new StringBuilder(str);
        if (middleChar != '\0') {
            palindrome.append(middleChar);
        }
        palindrome.append(str.reverse());

        return palindrome.length() ==0 ? "0" : palindrome.toString();
    }
}
