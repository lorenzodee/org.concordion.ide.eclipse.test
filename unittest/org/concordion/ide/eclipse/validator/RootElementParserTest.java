package org.concordion.ide.eclipse.validator;

import static org.junit.Assert.*;

import org.concordion.ide.eclipse.validator.RootElementParser;
import org.junit.Test;

/**
 * Test case for {@link RootElementParser}
 */
public class RootElementParserTest {

	private static final String NON_CONCORDION_DOC = "<?xml version=\"1.0\"?>\n<Html><body><a href=\"http://www.concordion.org/\">concordion</a></body></html>";
	private static final String CONCORDION_DOC = "<?xml version=\"1.0\"?>\n<Html xmlns:foo=\"bar\" " +
				"xmlns:conc=\"http://www.concordion.org/2007/concordion\" xmlns:no=\"thing\"><body/></html>";
	private static final String CONCORDION_DOC_1LETTER = "<Html xmlns:foo=\"bar\" " +
				"xmlns:c=\"http://www.concordion.org/2007/concordion\" xmlns:no=\"thing\"><body/></html>";

	@Test
	public void testIsConcordionSpec() {
		RootElementParser parser = new RootElementParser();
		
		assertFalse(parser.isConcordionSpec(
			NON_CONCORDION_DOC));
		assertNull(parser.getNamespacePrefix());

		assertTrue(parser.isConcordionSpec(
			CONCORDION_DOC));
		assertEquals("conc", parser.getNamespacePrefix());

		assertTrue(parser.isConcordionSpec(
			CONCORDION_DOC_1LETTER));
		assertEquals("c", parser.getNamespacePrefix());
	}

}
