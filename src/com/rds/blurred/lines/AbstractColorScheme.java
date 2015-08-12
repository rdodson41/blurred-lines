//
// com.rds.blurred.lines
// AbstractColorScheme.java
// Author: Richard Dodson
// Created: Sun Jul  7 2013 at 21:38:13 UTC 2013
//

package com.rds.blurred.lines;

import java.awt.Color;

public abstract class AbstractColorScheme implements ColorScheme{
	public Color getColor(double iteration, int max_iterations) {
		return getColor(iteration / max_iterations);
	}
}