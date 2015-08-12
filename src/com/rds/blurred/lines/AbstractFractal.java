//
// com.rds.blurred.lines
// AbstractFractal.java
// Author: Richard Dodson
// Created: Sun Jul  7 2013 at 21:36:15 UTC 2013
//

package com.rds.blurred.lines;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

public abstract class AbstractFractal implements Fractal {
	protected static final int MAX_ITERATIONS = 256;

	@Override
	public void paint(Graphics graphics, AffineTransform affine_transform, ColorScheme color_scheme) {
		paint((Graphics2D)graphics, affine_transform, color_scheme);
	}

	public void paint(Graphics2D graphics, AffineTransform affine_transform, ColorScheme color_scheme) {
		GraphicsConfiguration graphics_configuration = graphics.getDeviceConfiguration();
		Rectangle rectangle = graphics_configuration.getBounds();
		for(int y = rectangle.y; y <= rectangle.height; y++)
			for(int x = rectangle.x; x <= rectangle.width; x++) {
				Point2D z = new Point2D.Double(0, 0);
				Point2D c = new Point2D.Double(x, y);
				affine_transform.transform(c, c);
				int iteration;
				for(iteration = 0; !isDivergent(z) && iteration < MAX_ITERATIONS; iteration++)
					z = iterate(z, c);
				Color color = color_scheme.getColor(iteration, MAX_ITERATIONS);
				graphics.setColor(color);
				graphics.drawRect(x, y, 1, 1);
			}
	}
}