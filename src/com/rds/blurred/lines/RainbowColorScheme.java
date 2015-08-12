//
// com.rds.blurred.lines
// Frame.java
// Author: Richard Dodson
// Created: Sun Jul  7 2013 at 22:22:19 UTC 2013
//

package com.rds.blurred.lines;

import java.awt.Color;

public class RainbowColorScheme extends AbstractColorScheme {
	public RainbowColorScheme() {
	}
    
	public Color getColor(double depth) {
		double red = 1 - Math.abs(4 * depth - 1);
		double green = 1 - Math.abs(4 * depth - 2);
		double blue = 1 - Math.abs(4 * depth - 3);

		red = Math.min(Math.max(red, 0), 1);
		green = Math.min(Math.max(green, 0), 1);
		blue = Math.min(Math.max(blue, 0), 1);

		return new Color((float)red, (float)green, (float)blue);
	}
}