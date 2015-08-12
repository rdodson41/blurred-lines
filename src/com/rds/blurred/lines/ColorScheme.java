/*
 * ColorScheme.java
 * Created by Richard Dodson on Jul 7, 2013 at 5:36:57 PM.
 *
 */

package com.rds.Fractals;

import java.awt.Color;

public interface ColorScheme {
	public static final ColorScheme GRAY = new GrayColorScheme();
	public static final ColorScheme RAINBOW = new RainbowColorScheme();
	
	public Color getColor(double iteration, int max_iterations);
	public Color getColor(double depth);
}