package org.concordion.ide.eclipse.wizards;

import static org.junit.Assert.assertEquals;

import org.concordion.ide.eclipse.template.FixtureTemplate.Language;
import org.junit.Test;

public class NewSpecWizardTest {

	@Test
	public void testTestCaseName() {
		assertEquals("blaTest.java", NewSpecWizard.fixtureName("bla.html", "Test", Language.JAVA));
		assertEquals("blaTest.java", NewSpecWizard.fixtureName("bla", "Test", Language.JAVA));
		assertEquals("blaTest.groovy", NewSpecWizard.fixtureName("bla", "Test", Language.GROOVY));
	}

}
