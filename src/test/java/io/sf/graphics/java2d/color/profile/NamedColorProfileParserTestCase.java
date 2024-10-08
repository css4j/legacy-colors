/*
 *
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
/* $Id$ */

package io.sf.graphics.java2d.color.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.color.ICC_Profile;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import io.sf.graphics.java2d.color.NamedColorSpace;
import io.sf.graphics.java2d.color.RenderingIntent;

/**
 * Tests the {@link NamedColorProfileParser}.
 */
public class NamedColorProfileParserTestCase {

	private static final String NCP_EXAMPLE_FILE = "ncp-example.icc";

	@Test
	public void testParser() throws Exception {
		InputStream in = getClass().getResourceAsStream(NCP_EXAMPLE_FILE);
		assertNotNull(in, NCP_EXAMPLE_FILE + " is missing!");
		ICC_Profile iccProfile;
		try {
			iccProfile = ICC_Profile.getInstance(in);
		} finally {
			IOUtils.closeQuietly(in);
		}
		NamedColorProfileParser parser = new NamedColorProfileParser();
		NamedColorProfile ncp = parser.parseProfile(iccProfile);
		assertEquals("Named Color Profile Example", ncp.getProfileName());
		assertEquals("The Apache Software Foundation", ncp.getCopyright());
		assertEquals(RenderingIntent.PERCEPTUAL, ncp.getRenderingIntent());
		NamedColorSpace[] namedColors = ncp.getNamedColors();
		assertEquals(2, namedColors.length);
		NamedColorSpace ncs;
		ncs = namedColors[0];
		assertEquals("Postgelb", ncs.getColorName());
		float[] xyz = ncs.getXYZ();
		assertEquals(0.6763079f, xyz[0], 0.01f);
		assertEquals(0.6263507f, xyz[1], 0.01f);
		assertEquals(0.04217565f, xyz[2], 0.01f);

		ncs = namedColors[1];
		assertEquals("MyRed", ncs.getColorName());
	}

}
