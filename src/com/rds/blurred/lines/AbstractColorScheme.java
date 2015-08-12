/*
 * AbstractColorScheme.java
 * Created by Richard Dodson on Jul 7, 2013 at 5:38:13 PM.
 *
 */

package com.rds.Fractals;

import java.awt.Color;

public abstract class AbstractColorScheme implements ColorScheme{
	@Override
	public Color getColor(double iteration, int max_iterations) {
		return getColor(iteration / max_iterations);
	}
}