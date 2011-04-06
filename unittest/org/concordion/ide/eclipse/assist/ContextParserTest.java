package org.concordion.ide.eclipse.assist;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContextParserTest {

	private static final String ASSERT_EQ = "<span con:assertEquals=\"|\">";
	private static final String NS = "<span con:|>";
	private static final String BLA = "<span bla:|";
	private static final String WITH_CHARS = "<span con:assertT|";
	
	private static final String PFX = "con";
	private static final char CURSOR = '|';
	
	@Test
	public void testFindContext() {
		ContextParser parser = new ContextParser();
		assertSame(AssistType.ASSERT_EQUALS, parser.findContext(ASSERT_EQ, ASSERT_EQ.indexOf(CURSOR), PFX).getType());
		assertSame(AssistType.PARTIAL_COMMAND, parser.findContext(NS, NS.indexOf(CURSOR), PFX).getType());
		
		assertSame(AssistType.UNKNOWN, parser.findContext("", 0, PFX).getType());
		assertSame(AssistType.UNKNOWN, parser.findContext("asdfsadfsdaf", 3, PFX).getType());
		assertSame(AssistType.UNKNOWN, parser.findContext(BLA, BLA.indexOf(CURSOR), PFX).getType());
	}

	@Test
	public void testFindContextWithPrefix() {
		ContextParser parser = new ContextParser();
		AssistContext result = parser.findContext(WITH_CHARS, WITH_CHARS.indexOf(CURSOR), PFX);
		assertSame(AssistType.PARTIAL_COMMAND, result.getType());
		assertTrue(result.hasPrefix());
		assertEquals("assertT", result.getPrefix());
	}
}
