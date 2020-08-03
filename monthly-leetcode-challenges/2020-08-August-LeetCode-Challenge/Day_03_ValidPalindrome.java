class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isAlphaNumeric(s.charAt(left))) {
                left++;
            }

            while (left < right && !isAlphaNumeric(s.charAt(right))) {
                right--;
            }

            if (left > right) {
                return false;
            }

            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (isLowerCaseLetter(leftChar)) {
                if (!(leftChar == rightChar || leftChar == rightChar + 32)) {
                    return false;
                }
            } else if (isUpperCaseLetter(leftChar)) {
                if (!(leftChar == rightChar || leftChar + 32 == rightChar)) {
                    return false;
                }
            } else {
                if (!(leftChar == rightChar)) {
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return isDigit(c) || isLetter(c);
    }

    private boolean isDigit(char c) {
        return '0' <= c && c <= '9';
    }

    private boolean isLetter(char c) {
        return isLowerCaseLetter(c) || isUpperCaseLetter(c);
    }

    private boolean isLowerCaseLetter(char c) {
        return 'a' <= c && c <= 'z';
    }

    private boolean isUpperCaseLetter(char c) {
        return 'A' <= c && c <= 'Z';
    }
}
