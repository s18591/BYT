import org.junit.Test;
import static org.junit.Assert.*;

public class ExpressionTest {

	@Test
	public void testConstant() {
		Expression e = new Constant(20);
		assertEquals(e.evaluate(), 20);
	}
	@Test
	public void testAddition() {
		Expression e = new Add(new Constant(2), new Constant(2));
		assertEquals(e.evaluate(), 4);
	}
	@Test
	public void testSubtraction() {
		Expression e = new Subtract(new Constant(2), new Constant(2));
		assertEquals(e.evaluate(), 0);
	}
	@Test
	public void testMultiplication() {
		Expression e = new Multiply(new Constant(2), new Constant(2));
		assertEquals(e.evaluate(), 4);
	}
	@Test
	public void testDivision() {
		Expression e = new Divide(new Constant(2), new Constant(2));
		assertEquals(e.evaluate(), 1);
	}

}