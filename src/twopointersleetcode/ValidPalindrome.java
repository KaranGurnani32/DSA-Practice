package twopointersleetcode;

public class ValidPalindrome {
    public static void main(String[] args) {
        String input = "A man, a plan, a canal: Panama ";

        Boolean result = isPalindrome(input);
        System.out.println("Result = " + result);
    }

    private static Boolean isPalindrome(String input) {
        String tempString = "";

        for (Character character : input.toCharArray()) {
            if (Character.isDigit(character) || Character.isLetter(character)) {
                tempString += character;
            }
        }
        tempString = tempString.toLowerCase();

        int leftPointer = 0; // 1 2 3
        int rightPointer = tempString.length() - 1; // 7 6 5 4

        while (leftPointer <= rightPointer) {
            if (tempString.charAt(leftPointer) != tempString.charAt(rightPointer)) {
                return false;
            }

            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
