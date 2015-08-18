//
// com.rds.blurred.lines
// Fractal.java
// Author: Richard Dodson
// Created: Sat Aug 15 01:24:21 UTC 2015
//

package com.rds.blurred.lines;

import java.awt.geom.AffineTransform;

public interface Fractal {
	public int[] generate(int width, int height, AffineTransform affine_transform, int maximum_iterations, int[] data);
}