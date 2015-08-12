//
// com.rds.blurred.lines
// GrayColorScheme.java
// Author: Richard Dodson
// Created: Sun Jul  7 2013 at 22:21:28 UTC 2013
//

package com.rds.blurred.lines;

import java.awt.Color;

public class GrayColorScheme extends AbstractColorScheme {
	public GrayColorScheme() {
	}

	@Override
	public Color getColor(double depth) {
		return new Color((float)depth, (float)depth, (float)depth);
	}
}