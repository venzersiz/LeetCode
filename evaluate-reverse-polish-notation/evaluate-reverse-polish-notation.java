class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperand(token)) {
                Integer operand2 = stack.pop();
                Integer operand1 = stack.pop();

                if (isPlus(token)) {
                    stack.push(Integer.valueOf(operand1) + Integer.valueOf(operand2));
                } else if (isMinus(token)) {
                    stack.push(Integer.valueOf(operand1) - Integer.valueOf(operand2));
                } else if (isMultiplication(token)) {
                    stack.push(Integer.valueOf(operand1) * Integer.valueOf(operand2));
                } else if (isDivision(token)) {
                    stack.push(Integer.valueOf(operand1) / Integer.valueOf(operand2));
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperand(String token) {

        return isPlus(token) || isMinus(token) || isMultiplication(token) || isDivision(token);
    }

    private boolean isPlus(String token) {
        return token.equals("+");
    }

    private boolean isMinus(String token) {
        return token.equals("-");
    }

    private boolean isMultiplication(String token) {
        return token.equals("*");
    }

    private boolean isDivision(String token) {
        return token.equals("/");
    }
}