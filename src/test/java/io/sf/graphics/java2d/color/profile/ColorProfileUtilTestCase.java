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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.color.ColorSpace;
import java.awt.color.ICC_Profile;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ColorProfileUtilTestCase {

	@Test
	public void testIsDefaultsRGB() throws IOException {
		ICC_Profile profile = ICC_Profile.getInstance(ColorSpace.CS_sRGB);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		profile.write(baos);
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ICC_Profile profileFromFile = ICC_Profile.getInstance(bais);
		assertTrue(ColorProfileUtil.isDefaultsRGB(profileFromFile));
	}

}
