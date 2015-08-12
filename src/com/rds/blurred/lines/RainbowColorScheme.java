/*
 * RainbowColorScheme.java
 * Created by Richard Dodson on Jul 7, 2013 at 6:22:19 PM.
 *
 */

package com.rds.Fractals;

import com.rds.g2d.Color;

public class RainbowColorScheme extends AbstractColorScheme {
	public RainbowColorScheme() {
	}

	@Override
	public Color getColor(double depth) {
		double red = 1 - Math.abs(4 * depth - 1);
		double green = 1 - Math.abs(4 * depth - 2);
		double blue = 1 - Math.abs(4 * depth - 3);

		red = Math.min(Math.max(red, 0), 1);
		green = Math.min(Math.max(green, 0), 1);
		blue = Math.min(Math.max(blue, 0), 1);

		return new Color(red, green, blue);
	}
}