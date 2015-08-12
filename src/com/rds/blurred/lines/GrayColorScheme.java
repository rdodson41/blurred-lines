/*
 * GrayColorScheme.java
 * Created by Richard Dodson on Jul 7, 2013 at 6:21:28 PM.
 *
 */

package com.rds.Fractals;

import com.rds.g2d.Color;

public class GrayColorScheme extends AbstractColorScheme {
	public GrayColorScheme() {
	}

	@Override
	public Color getColor(double depth) {
		return new Color(depth, depth, depth);
	}
}