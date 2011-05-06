package org.concordion.ide.eclipse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ClassUtilsTest {

	@Test
	public void testUnqualifiedNameClassOfQ() {
		fail("Not yet implemented");
	}

	@Test
	public void testUnqualifiedNameString() {
		assertEquals("A", ClassUtils.unqualifiedName("bla.c.A"));
		assertEquals("B", ClassUtils.unqualifiedName("B"));
	}

	@Test
	public void testContainingPackage() {
		assertEquals("bla", ClassUtils.containingPackage("bla.A"));
		assertEquals("bla.A", ClassUtils.containingPackage("bla.A.B"));
		assertNull(ClassUtils.containingPackage("C"));
	}

}
