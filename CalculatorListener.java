// Generated from java-escape by ANTLR 4.11.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(CalculatorParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(CalculatorParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(CalculatorParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#exponentiationExpr}.
	 * @param ctx the parse tree
	 */
	void enterExponentiationExpr(CalculatorParser.ExponentiationExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#exponentiationExpr}.
	 * @param ctx the parse tree
	 */
	void exitExponentiationExpr(CalculatorParser.ExponentiationExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#sqrtExpression}.
	 * @param ctx the parse tree
	 */
	void enterSqrtExpression(CalculatorParser.SqrtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#sqrtExpression}.
	 * @param ctx the parse tree
	 */
	void exitSqrtExpression(CalculatorParser.SqrtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(CalculatorParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(CalculatorParser.PrimaryExprContext ctx);
}