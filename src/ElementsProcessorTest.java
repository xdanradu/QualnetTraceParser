import static org.junit.Assert.*;

import org.junit.Test;


public class ElementsProcessorTest {

	@Test
	public void parseIpv4_1() {
		ElementsProcessor processor = new ElementsProcessor();
		assertTrue(processor.parseIpv4("4 5 0 0 0 1998 4756 ").getLength().equals("1998"));
	}

	@Test
	public void parseUdp_1() {
		ElementsProcessor processor = new ElementsProcessor();
		assertTrue(processor.parseUdp("1814 1814 48 0").getLength().equals("48"));

	}
	
}
