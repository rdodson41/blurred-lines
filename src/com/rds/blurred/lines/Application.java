//
// com.rds.blurred.ines
// Application.java
// Author: Richard Dodson
// Created: Thu Aug 13 13:47:42 UTC 2015
//

package com.rds.blurred.lines;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class Application {
	protected static int WIDTH = 640;
	protected static int HEIGHT = 480;
	protected static int MAXIMUM_ITERATIONS = 256;
	
	protected int[] data = new int[WIDTH * HEIGHT];
	protected AffineTransform affine_transform = new AffineTransform(4.0 / WIDTH, 0, 0, 3.0 / HEIGHT, -2.5, -1.5);
	protected Fractal fractal = new Mandelbrot();
	
	protected BufferedImage buffered_image = createBufferedImage(WIDTH, HEIGHT);
	
	public Application() {
		update(WIDTH, HEIGHT, MAXIMUM_ITERATIONS);
	}
	
	public void render(Graphics graphics) {
		Graphics2D graphics_2d = (Graphics2D)graphics;
		graphics_2d.drawRenderedImage(buffered_image, new AffineTransform());
	}
	
	public void quit() {
		System.exit(0);
	}
	
	protected void update(int width, int height, int maximum_iterations) {
		data = fractal.generate(width, height, affine_transform, maximum_iterations, data);
		for(int i = 0; i < data.length; i++) {
			data[i] = Color.HSBtoRGB(data[i] / 256f, 1f, 1f);
		}
		buffered_image.setRGB(0, 0, width, height, data, 0, width);
	}
															   
	protected BufferedImage createBufferedImage(int width, int height) {
		return new BufferedImage(width, height);
	}
	
	protected class BufferedImage extends java.awt.image.BufferedImage {
		public BufferedImage(int width, int height) {
			super(width, height, TYPE_INT_ARGB);
		}
	}
}