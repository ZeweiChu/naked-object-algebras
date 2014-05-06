package noa.demo.alg;

import java.util.List;

import noa.annos.Level;
import noa.annos.Syntax;

public interface ExpAlg<P, E> {
	
	// needed because apparently ANTLR4 does not allow calling
	// left-recursive rules directly (?)
	@Syntax("prog = exp")
	P start(E e);

	// Support for precedence annos on infix operators.
	@Syntax("exp = exp '*' exp") @Level(20)
	E mul(E l, E r);

	@Syntax("exp = exp '+' exp") @Level(10)
	E add(E l, E r);


	// Refer to tokens (defined in Tokens.java)
	@Syntax("exp = NUM")
	E lit(int n);
	
	// Special notation for separated lists
	@Syntax("exp = 'avg' '(' exp@','+ ')'")
	E avg(List<E> es);
}
