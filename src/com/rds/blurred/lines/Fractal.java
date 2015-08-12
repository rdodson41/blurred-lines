//
// com.rds.blurred.lines
// Fractal.java
// Author: Richard Dodson
// Created: Sun Jul  7 2013 at 21:29:52 UTC 2013
//

package com.rds.blurred.lines;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public interface Fractal {
	public void paint(Graphics graphics, AffineTransform affine_transform, ColorScheme color_scheme);
	public boolean isDivergent(Point2D point);
	public Point2D iterate(Point2D z, Point2D c);
}