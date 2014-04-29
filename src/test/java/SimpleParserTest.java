import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import parser.SimpleLexer;
import parser.SimpleParser;
import parser.SimpleParser.CalcContext;
import parser.SimpleParser.ExprContext;

public class SimpleParserTest  {

	@Before
	public void setup() {
		
	}
	
	@Test
	public void testExpr() {
		String expression = "(1 + 2) * 5 - 10 / 2";
		SimpleLexer lexer = new SimpleLexer(new ANTLRInputStream(expression));
		SimpleParser parser = new SimpleParser(new CommonTokenStream(lexer));
		
		CalcContext ctx = parser.calc();		
		System.out.println(ParserTestUtil.treeToString(ctx, parser));
		int result = visit(ctx.expr());
		
		
		System.out.println(result);
		
	}
	
	private int visit(ExprContext ctx) {
		if(ctx.number() != null) {
			return Integer.parseInt(ctx.number().getText());
		}
		else if(ctx.PLUS() != null) {
			return visit(ctx.expr(0)) + visit(ctx.expr(1)); 
		}
		else if(ctx.MINUS() != null) {
			return visit(ctx.expr(0)) - visit(ctx.expr(1)); 
		}
		else if(ctx.TIMES() != null) {
			return visit(ctx.expr(0)) * visit(ctx.expr(1)); 
		}
		else if(ctx.DIV() != null) {
			return visit(ctx.expr(0)) / visit(ctx.expr(1)); 
		}	
		else if(ctx.BR_OPEN() != null) {
			return visit(ctx.expr(0));
		}
		else {
			throw new RuntimeException("Unexpected state");
		}
		
	}

}
