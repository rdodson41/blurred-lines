/*
 * Fractal.java
 * Created by Richard Dodson on Jul 7, 2013 at 5:29:52 PM.
 *
 */
package com.rds.Fractals;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public interface Fractal {
	public void paint(Graphics graphics, AffineTransform affine_transform, ColorScheme color_scheme);
	public boolean isDivergent(Point2D point);
	public Point2D iterate(Point2D z, Point2D c);
}