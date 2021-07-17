class Solution {
    public boolean isValid(String s) {
        
        char[] charArray = s.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        for (char c : charArray) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                try {
                    if (c != map.get(stack.pop())) {
                        return false;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        
        return true;
    }
}