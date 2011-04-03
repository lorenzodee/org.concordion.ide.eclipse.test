package org.concordion.ide.eclipse.validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.concordion.ide.eclipse.validator.RootElementParser;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class Spec {
	public boolean isConcordionSpec() throws Exception {
		String spec = readSpec();
		RootElementParser parser = new RootElementParser();
		return parser.isConcordionSpec(spec);
	}
	
	private String readSpec() throws IOException {
		InputStream stream = getClass().getResourceAsStream("Spec.html");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String line;
		StringBuilder buffer = new StringBuilder();
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
		}
		stream.close();
		return buffer.toString();
	}
}
