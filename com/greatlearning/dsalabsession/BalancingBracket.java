package com.greatlearning.dsalabsession;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

public class BalancingBracket {

    private boolean checkForBalanceBracket(String input){

        if(input.length() % 2 != 0)
            return false;

        Stack stack = new Stack();

        for(int i=0 ; i <input.length() ; i++){

            if( input.charAt(i) == '{' ||
                    input.charAt(i) == '[' ||
                    input.charAt(i) == '('
            ){
                stack.push(input.charAt(i));
            }
            else if(!stack.empty() && ((input.charAt(i) == ']' && (char) stack.peek() == '[') ||
                    (input.charAt(i) == '}' &&  (char) stack.peek() == '{') ||
                    (input.charAt(i) == ')' && (char) stack.peek() == '(') )){
                stack.pop();
            }
            else{
                stack.push(input.charAt(i));
            }

        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BalancingBracket balancingBracket = new BalancingBracket();
        String input = "";

        System.out.println("Enter the string with brackets");

        try {
            input = sc.nextLine();
        }catch (InputMismatchException e){
            System.err.println("Error");
            //e.printStackTrace();
        }

        if(balancingBracket.checkForBalanceBracket(input) ){
            System.out.println("The entered String has Balanced Brackets");
        }else{
            System.out.println("The entered Strings do not contain Balanced Brackets");
        }

    }

}
