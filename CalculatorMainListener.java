import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.*;

public class CalculatorMainListener extends CalculatorBaseListener {

    Deque<Double> numbers = new ArrayDeque<>();

    private Double getResult() {
        return numbers.peek();
    }

    @Override
    public void exitExpression(CalculatorParser.ExpressionContext ctx) {
        double value = numbers.poll();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            String operator = ctx.getChild(i).getText();
            if (numbers.size() < 1) {
                throw new IllegalArgumentException("Not enough numbers in stack for operation");
            }
            double nextValue = numbers.poll();
            if (operator.equals("+")) {
                value += nextValue;
            } else if (operator.equals("-")) {
                value -= nextValue;
            } else if (operator.equals("*")) {
                value *= nextValue;
            } else if (operator.equals("/")) {
                value /= nextValue;
            }
        }
        if (!numbers.isEmpty()) {
            throw new IllegalArgumentException("Too many numbers in stack");
        }
        numbers.add(value);
        super.exitExpression(ctx);
    }

    @Override
    public void exitMultiplicativeExpr(CalculatorParser.MultiplicativeExprContext ctx) {
        double value = numbers.pop();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            String operator = ctx.getChild(i).getText();
            double nextValue = numbers.pop();
            if (operator.equals("*")) {
                value *= nextValue;
            } else if (operator.equals("/")) {
                value /= nextValue;
            }
        }
        numbers.add(value);
        super.exitMultiplicativeExpr(ctx);
    }

    @Override
    public void exitExponentiationExpr(CalculatorParser.ExponentiationExprContext ctx) {
        double value = numbers.pop();
        for (int i = 1; i < ctx.getChildCount(); i += 2) {
            String operator = ctx.getChild(i).getText();
            double nextValue = numbers.pop();
            if (operator.equals("^")) {
                value = Math.pow(value, nextValue);
            }
        }
        numbers.add(value);
        super.exitExponentiationExpr(ctx);
    }

    @Override
    public void exitSqrtExpression(CalculatorParser.SqrtExpressionContext ctx) {
        double value = numbers.pop();
        if (ctx.ROOT() != null) {
            value = Math.sqrt(value);
        }
        numbers.add(value);
        super.exitSqrtExpression(ctx);
    }

    @Override
    public void exitPrimaryExpr(CalculatorParser.PrimaryExprContext ctx) {
        if (ctx.INT() != null) {
            numbers.add(Double.valueOf(ctx.INT().getText()));
        } else if (ctx.FLOAT() != null) {
            numbers.add(Double.valueOf(ctx.FLOAT().getText()));
        }
        super.exitPrimaryExpr(ctx);
    }

    public static void main(String[] args) throws Exception {
        double result = calc("4^2 + 3 + 3");
        System.out.println("Result = " + result);
    }
    public static Double calc(String expression) {
        return calc(CharStreams.fromString(expression));
    }

    public static Double calc(CharStream charStream) {
        CalculatorLexer lexer = new CalculatorLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        CalculatorParser parser = new CalculatorParser(tokens);
        ParseTree tree = parser.expression();

        ParseTreeWalker walker = new ParseTreeWalker();
        CalculatorMainListener mainListener = new CalculatorMainListener();
        walker.walk(mainListener, tree);
        return mainListener.getResult();
    }
}