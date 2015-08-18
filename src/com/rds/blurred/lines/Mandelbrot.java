//
// com.rds.blurred.lines
// Mandelbrot.java
// Author: Richard Dodson
// Created: Tue Aug 18 01:38:36 UTC 2015
//

package com.rds.blurred.lines;

import java.awt.geom.AffineTransform;

public class Mandelbrot extends AbstractFractal {
	public Mandelbrot() {
		
	}
	
	public int[] generate(int width, int height, AffineTransform affine_transform, int maximum_iterations, int[] data) {
		double[] matrix = new double[6];
		affine_transform.getMatrix(matrix);

		for(int j = 0; j < height; j++) {
			for(int i = 0; i < width; i++) {
				double x0 = matrix[0] * i + matrix[2] * j + matrix[4];
				double y0 = matrix[1] * i + matrix[3] * j + matrix[5];

				int k = 0;
				for(double x = x0, y = y0; k < maximum_iterations && x * x + y * y < 4; k++) {
					double x1 = x * x - y * y + x0;
					y = 2 * x * y + y0;
					x = x1;
				}

				data[i + j * width] = k;
			}
		}

		return data;
	}
}
