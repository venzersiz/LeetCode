class Solution {

    private Map<Character, Character> map = new HashMap<>();

    public Solution() {
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        if (s.length() < 2) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isOpenningTag(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private boolean isOpenningTag(char c) {

        return c == '[' || c == '{' || c == '(';
    }
}