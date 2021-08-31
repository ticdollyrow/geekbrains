package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MapWindow extends JFrame {
	private int x = 100;
	private int y = 100;
	private int size = 40;

	public MapWindow() {
		setTitle("Карта");
		setBounds(600, 200, 600, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBackground(Color.decode("#008800"));
		add(mainPanel, BorderLayout.CENTER);

		JPanel buttonsPanel = new JPanel(new GridLayout(1, 4));
		buttonsPanel.setPreferredSize(new Dimension(1, 100));
		add(buttonsPanel, BorderLayout.SOUTH);

		JButton buttonUp = new JButton("Up");
		buttonsPanel.add(buttonUp);
		JButton buttonLeft = new JButton("Left");
		buttonsPanel.add(buttonLeft);
		JButton buttonRight = new JButton("Right");
		buttonsPanel.add(buttonRight);
		JButton buttonDown = new JButton("Down");
		buttonsPanel.add(buttonDown);

		JPanel rectPanel = new JPanel();
		rectPanel.setBounds(x, y, size, size);
		rectPanel.setBackground(Color.WHITE);
		mainPanel.add(rectPanel);

		buttonDown.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				y += 10;
				rectPanel.setBounds(x, y, size, size);
			}
		});

		buttonUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				y -= 10;
				rectPanel.setBounds(x, y, size, size);
			}
		});

		buttonLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x -= 10;
				rectPanel.setBounds(x, y, size, size);
			}
		});

		buttonRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				x += 10;
				rectPanel.setBounds(x, y, size, size);
			}
		});

		setVisible(true);
	}
}
