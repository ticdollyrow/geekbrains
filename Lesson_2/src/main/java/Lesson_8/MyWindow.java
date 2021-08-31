package Lesson_8;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
	public MyWindow() throws HeadlessException {
		setTitle("Java");
		setBounds(600, 300, 400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}

