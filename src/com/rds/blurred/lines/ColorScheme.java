//
// com.rds.blurred.lines
// ColorScheme.java
// Author: Richard Dodson
// Created: Sun Jul  7 2013 at 21:36:57 UTC 2013
//

package com.rds.blurred.lines;

import java.awt.Color;

public interface ColorScheme {
	public static final ColorScheme GRAY = new GrayColorScheme();
	public static final ColorScheme RAINBOW = new RainbowColorScheme();
	
	public Color getColor(double iteration, int max_iterations);
	public Color getColor(double depth);
}