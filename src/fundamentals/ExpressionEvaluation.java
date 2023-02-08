/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamentals;

import java.util.Stack;

/**
 *
 * @author KELVIN WARUI
 */
public class ExpressionEvaluation {

    public static void main(String[] args) {
        Stack<String> operators = new Stack<>();
        Stack<Double> vals = new Stack<>();
        String expression = "( ( 1 + sqrt ( 5.0 ) ) / 2.0 )";//"( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"
        String[] tokens = expression.split(" ");
        for (String t : tokens) {
            switch (t) {
                case "(":
                    break;
                case "+":
                    operators.push(t);
                    break;
                case "-":
                    operators.push(t);
                    break;
                case "*":
                    operators.push(t);
                    break;
                case "/":
                    operators.push(t);
                    break;
                case "sqrt":
                    operators.push(t);
                    break;
                case ")":
                    // Pop, evaluate, and push result if token is ")".
                    String op = operators.pop();
                    Double val = vals.pop();
                    if (op.equals("+")) {
                        val = vals.pop() + val;
                    }
                    if (op.equals("-")) {
                        val = vals.pop() - val;
                    }
                    if (op.equals("*")) {
                        val = vals.pop() * val;
                    }
                    if (op.equals("/")) {
                        val = vals.pop() / val;
                    }
                    if (op.equals("sqrt")) {
                        val = Math.sqrt(val);
                    }
                    vals.push(val);
                    break;
                default:
                    vals.push(Double.valueOf(t));
                    break;
            }
        }
        System.out.println(vals.pop());
    }
}
