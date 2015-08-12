/*
 * Mandelbrot.java
 * Created by Richard Dodson on Jul 7, 2013 at 5:46:15 PM.
 *
 */

package com.rds.Fractals;

import java.awt.geom.Point2D;

public class Mandelbrot extends AbstractFractal {
	public Mandelbrot() {
	}
	
	@Override
	public boolean isDivergent(Point2D z) {
		double x = z.getX();
		double y = z.getY();
		return Math.sqrt(x * x + y * y) > 2;
	}

	@Override
	public Point2D iterate(Point2D z, Point2D c) {
		double x = z.getX() * z.getX() - z.getY() * z.getY() + c.getX();
		double y = 2 * z.getX() * z.getY() + c.getY();
		return new Point2D.Double(x, y);
	}
}