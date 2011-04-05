package org.concordion.ide.eclipse.wizards;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NewSpecWizardTest {

	@Test
	public void testTestCaseName() {
		assertEquals("blaTest.java", NewSpecWizard.testCaseName("bla.html", "Test"));
		assertEquals("blaTest.java", NewSpecWizard.testCaseName("bla", "Test"));
	}

}
