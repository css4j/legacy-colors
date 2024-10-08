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

package io.sf.graphics.java2d.color;

import java.awt.Color;

/**
 * A default implementation that does not apply any conversion
 */
public final class DefaultColorConverter implements ColorConverter {

	/**
	 * private constructor to support singleton pattern
	 */
	private static final DefaultColorConverter SINGLETON = new DefaultColorConverter();

	private DefaultColorConverter() {
	}

	/**
	 * static factory
	 *
	 * @return singleton instance of DefaultColorConverter
	 */
	public static DefaultColorConverter getInstance() {
		return SINGLETON;
	}

	/** {@inheritDoc} */
	public Color convert(Color color) {
		return color;
	}

}
