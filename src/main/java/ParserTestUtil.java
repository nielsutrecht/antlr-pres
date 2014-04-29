import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.tree.Trees;

/**
 * Some utility methods to make debugging grammars easier.
 * 
 * @author Niels Dommerholt (JDriven.com)
 * 
 */

public class ParserTestUtil {

	/**
	 * Turns a token stream into a string, makes for easy debugging of token errors.
	 * 
	 * @param lexer
	 * @return
	 */
    public static String tokensToString(final Lexer lexer) {
        final StringBuilder build = new StringBuilder();
        Token t;
        final String[] names = lexer.getTokenNames();
        while ((t = lexer.nextToken()) != null) {
            build.append("|");
            build.append(t.getText());
            build.append(" -> ");
            if (t.getType() >= 0) {
                build.append(names[t.getType()]);
            }
            else if (t.getType() == Token.EOF) {
                build.append("EOF");
                break;
            }
            else {
                build.append("???");
            }
        }

        return build.toString();
    }
    
    /**
     * Turns a tree (for example a RuleContext from a parser) into a String representation.
     * @param tree
     * @return
     */
    public static String treeToString(Tree tree, Parser parser) {
    	return Trees.toStringTree(tree, parser);
    }

}