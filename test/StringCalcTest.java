import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalcTest {
	StringCalculator calculator = new StringCalculator();
	
	private void checkAdd(String string, int expected) {
		assertEquals(expected,calculator.add(string));
	}
	@Test
	void testaIsEmpty() {
		checkAdd("",0);
	}
	@Test
	void testOneNum() {
		checkAdd("1",1);
	}
	@Test
	void testMoreNum() throws Exception{
		checkAdd("1,2",3);
	}
	@Test
	void testMoreNumSum() throws Exception{
		checkAdd("2,6,3,4",15);
	}
	@Test
	void testNewLine() throws Exception{
		checkAdd("2\n1,5",8);
	}
	@Test
	void testAllowDelimiter() throws Exception{
		checkAdd("//;\n2;3",5);
	}
	@Test
	void negativeException() throws Exception{
		try {
			checkAdd("2,-6,1,3,-68",0);
		}catch (Exception e) {
			assertEquals("negatives not allowed= -6,-68",e.getMessage());
		}
	}
	@Test
	void testBiggerThan1000() throws Exception{
		checkAdd("10,20,1001",30);
	}
	@Test
	void testAllowSecondDelimiter() throws Exception{
		checkAdd("//;\n2;3;1",6);
	}
	@Test
	void negativeAnOtherException() throws Exception{
		try {
			checkAdd("2,-250,1,3,-68,32,-410",0);
		}catch (Exception e) {
			assertEquals("negatives not allowed= -250,-68,-410",e.getMessage());
		}
	}
	@Test
	void testOtherNewLine() throws Exception{
		checkAdd("10,2\n5",17);
	}
	@Test
	void testSecBiggerThan1000() throws Exception{
		checkAdd("1500,10,40",50);
	}
}
