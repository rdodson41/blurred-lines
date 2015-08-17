//
// com.rds.blurred.lines
// Frame.java
// Author: Richard Dodson
// Created: Thu Aug 13 02:13:02 UTC 2015
//

package com.rds.blurred.lines;

import java.awt.Graphics;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Frame extends JFrame {
	protected Application application;
	
	public Frame(Application application) {
		super();
		
		this.application = application;
		
		Panel panel = createPanel();
		setContentPane(panel);
		
		WindowAdapter window_adapter = createWindowAdapter();
		addWindowListener(window_adapter);
	}
	
	protected Panel createPanel() {
		return new Panel();
	}
	
	protected WindowAdapter createWindowAdapter() {
		return new WindowAdapter();
	}
	
	protected class Panel extends javax.swing.JPanel {
		public void paintComponent(Graphics graphics) {
			application.render(graphics);
		}
	}
	
	protected class WindowAdapter extends java.awt.event.WindowAdapter {
		public void windowClosing(WindowEvent window_event) {
			application.quit();
		}
	}
	
	public static void main(String[] arguments) {
		Application application = new Application();
		Frame frame = new Frame(application);
		frame.setVisible(true);
	}
}
