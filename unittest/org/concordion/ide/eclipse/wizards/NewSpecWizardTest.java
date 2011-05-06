package org.concordion.ide.eclipse.wizards;

import static org.junit.Assert.assertEquals;

import org.concordion.ide.eclipse.template.FixtureTemplate.Language;
import org.junit.Test;

public class NewSpecWizardTest {

	@Test
	public void testTestCaseName() {
		assertEquals("blaTest.java", NewSpecWizard.fixtureName("bla.html", true, Language.JAVA));
		assertEquals("bla.java", NewSpecWizard.fixtureName("bla", false, Language.JAVA));
		assertEquals("blaTest.groovy", NewSpecWizard.fixtureName("bla", true, Language.GROOVY));
	}

}
