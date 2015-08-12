/*
 * Frame.java
 * Created by Richard Dodson on Jul 7, 2013 at 5:46:49 PM.
 *
 */

package com.rds.Fractals;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	protected Fractal fractal = new Mandelbrot();
	protected AffineTransform affine_transform = new AffineTransform();
	protected ColorScheme color_scheme = ColorScheme.GRAY;

	protected JPanel panel;

	public Frame() {
		super("Fractals 0.1");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics graphics) {
				fractal.paint(graphics, affine_transform, color_scheme);
			}
		};
		setContentPane(panel);
		Dimension preferred_size = new Dimension(640, 480);
		panel.setPreferredSize(preferred_size);
		MouseAdapter mouse_adapter = new MouseHandler();
		panel.addMouseListener(mouse_adapter);
		panel.addMouseWheelListener(mouse_adapter);

		pack();

		Point2D point = new Point2D.Double(0, 0);
		center(point);
	}


	public void center(Point2D point) {
		double translate_x = point.getX() - 320;
		double translate_y = point.getY() - 240;
		affine_transform.translate(translate_x, translate_y);
		panel.repaint();
	}

	public void zoomIn() {
		affine_transform.translate(160, 120);
		affine_transform.scale(0.5, 0.5);
		panel.repaint();
	}

	public void zoomOut() {
		affine_transform.scale(2, 2);
		affine_transform.translate(-160, -120);
		panel.repaint();
	}

	public void zoom(double ratio) {

	}

	public static void main(String[] arguments) {
		Frame frame = new Frame();
		frame.setVisible(true);
	}

	protected class MouseHandler extends MouseAdapter {
		public MouseHandler() {
		}

		@Override
		public void mouseClicked(MouseEvent mouse_event) {
			Point point = mouse_event.getPoint();
			center(point);
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent mouse_wheel_event) {
			double rotation = mouse_wheel_event.getPreciseWheelRotation();
			System.out.println(rotation);
		}
	}
}