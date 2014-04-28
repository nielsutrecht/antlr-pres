import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Before;
import org.junit.Test;

import parser.SimpleLexer;
import parser.SimpleParser;
import parser.SimpleParser.ExprContext;

public class SimpleParserTest  {
	
	private ExprContext parseExpression(String expression) {
		SimpleLexer lexer = new SimpleLexer(new ANTLRInputStream(expression));
		SimpleParser parser = new SimpleParser(new CommonTokenStream(lexer));
		
		return parser.calc().expr();
	}
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void testExpr() {
		ExprContext ctx = parseExpression("(1+2)*3+10/2*80+34");
		int result = visit(ctx);
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
