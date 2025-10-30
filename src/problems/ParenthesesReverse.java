package problems;

import java.util.Stack;

class ParenthesesReverse {
    Stack<StringBuilder> reverseStack = new Stack<>();

    public String reverseParentheses(String s) {
        for (int i=0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case '(':
                    markAndIncrementStack();
                    break;
                case ')':
                    reverse();
                    break;

                default:
                    append(s.charAt(i));
            }
        }

        return finalString();
    }

    private String finalString(){

        StringBuilder finalString = new StringBuilder(reverseStack.pop());

        while (!reverseStack.isEmpty()){
            finalString.insert(0, reverseStack.pop());
        }

        return finalString.toString();
    }


    private void markAndIncrementStack(){
        reverseStack.push(new StringBuilder());
    }

    private void append(char ch){
        if (reverseStack.empty()) {
            reverseStack.push(new StringBuilder().append(ch));
            return;
        }

        StringBuilder top = reverseStack.pop();
        reverseStack.push(top.append(ch));
    }

    private void reverse(){
        StringBuilder top = reverseStack.pop().reverse();

        if (reverseStack.empty()) {
            reverseStack.push(top);
            return;
        }

        reverseStack.push(reverseStack.pop().append(top));
    }

    public static void main(String[] args) {
        ParenthesesReverse parenthesesReverse = new ParenthesesReverse();
        String result = parenthesesReverse.reverseParentheses("(abcd)");
        String result1 = parenthesesReverse.reverseParentheses("a(bcdefghijkl(mno)p)q");
        String result2 = parenthesesReverse.reverseParentheses("vdgzyj()");
        String result3 = parenthesesReverse.reverseParentheses("((eqk((h))))");
        String result4 = parenthesesReverse.reverseParentheses("n(ev(t)((()lfevf))yd)cb()");
        String result5 = parenthesesReverse.reverseParentheses("(u(love)i)");
        System.out.println(result + " == dcba");
        System.out.println(result1 + " == apmnolkjihgfedcbq");
        System.out.println(result2 + " == vdgzyj");
        System.out.println(result3 + " == eqkh");
        System.out.println(result4 + " == ndyfvefltvecb");
        System.out.println(result5 + " == iloveu");
    }
}