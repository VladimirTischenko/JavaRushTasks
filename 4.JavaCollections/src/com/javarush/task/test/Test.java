package com.javarush.task.test;

/**
 * Created by Vladimir on 13.03.2017.
 */
public class Test {
    private String input;

    public Test(String in) {
        input = in;
    }

    public void check() {
        int stackSize = input.length();
        Stack theStack = new Stack(stackSize);

        for (int j = 0; j < input.length(); j++)
        {
            char ch = input.charAt(j);
            switch (ch) {
                case '{': // opening symbols
                case '[':
                case '(':
                    theStack.push(ch); // push them
                    break;

                case '}': // closing symbols
                case ']':
                case ')':
                    if (!theStack.isEmpty()) // if stack not empty,
                    {
                        char chx = theStack.pop(); // pop and check
                        if ((ch == '}' && chx != '{') || (ch == ']' && chx != '[')
                                || (ch == ')' && chx != '('))
                            System.out.println("Error: " + ch + " at " + j);
                    } else
                        // prematurely empty
                        System.out.println("Error: " + ch + " at " + j);
                    break;
                default: // no action on other characters
                    break;
            }
        }
        if (!theStack.isEmpty())
            System.out.println("Error: missing right delimiter");
    }
    public static void main(String[] args) throws Exception {
        String input = "[(])";
        Test theChecker = new Test(input);
        theChecker.check();
    }
}