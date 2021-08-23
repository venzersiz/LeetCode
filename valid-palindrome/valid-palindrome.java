class Solution {

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        char[] chars = s.toCharArray();

        List<Character> characters = new ArrayList<>();
        for (char c : chars) {
            if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z') {
                characters.add(c);
            }
        }

        Stack<Character> stack = new Stack<>();
        int halfSize = characters.size() / 2;
        boolean even = (characters.size() % 2 == 0);

        for (int i = 0; i < halfSize; i++) {
            stack.push(characters.get(i));
        }

        for (int i = (even ? halfSize : halfSize + 1); i < characters.size(); i++) {
            if (stack.pop() != characters.get(i)) {
                return false;
            }
        }

        return true;
    }
}