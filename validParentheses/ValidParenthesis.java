package validParentheses;

import java.util.Stack;

// https://www.codewars.com/kata/52774a314c2333f0a7000688

public class ValidParenthesis{

    public static boolean validParentheses(String parens)
    {
        Stack<Character> stack = new Stack<>();
        char x;
        for(int i = 0; i < parens.length(); i++) {
            x = parens.charAt(i);
            if(x == '(') {
                stack.push(x);
            }
            else if (x == ')') {
                if(stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
