package Lesson_8;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeekbrainsWindow extends JFrame {
	private int randomNumber;
	private JTextField textField;
	private final int MAX_NUMBER = 3;
	private static int number;

	public GeekbrainsWindow() {
		this.randomNumber = (int) (Math.random() * 10) + 1; // [1, 10]

		setTitle("Игра: Угадай число");
		setBounds(600, 300, 600, 160);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setLayout(new FlowLayout());
		setResizable(false);

		textField = new JTextField();
		add(textField, BorderLayout.NORTH);
		textField.setText("Программа загадала число от 1 до 10");
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);

		Font font = new Font("Arial", Font.PLAIN, 18);
		textField.setFont(font);

		JPanel buttonsPanel = new JPanel(new GridLayout(2, 6));
		buttonsPanel.setBackground(Color.WHITE);
		add(buttonsPanel, BorderLayout.CENTER);

		for (int i = 1; i <= 10; i++) {
			JButton button = new JButton(String.valueOf(i));
			button.setFont(font);
			buttonsPanel.add(button);
			int buttonIndex = i;
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tryToAnswer(buttonIndex);
				}
			});
		}

		JButton buttonReboot = new JButton("Reboot");
		buttonReboot.setFont(font);
		buttonsPanel.add(buttonReboot);
		buttonReboot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rebootGame();
			}
		});


		setVisible(true);
	}

	public void tryToAnswer(int answer) {
		if(number >= MAX_NUMBER){
			textField.setText("Превышено число попыток");
			return;
		}
		number++;
		if(answer < randomNumber) {
			textField.setText("Не угадали! Загаданное число больше!");
			return;
		}
		if(answer > randomNumber) {
			textField.setText("Не угадали! Загаданное число меньше");
			return;
		}
		textField.setText("Вы угадали!!! Ответ: " + randomNumber);

	}

	public void rebootGame(){
		this.randomNumber = (int) (Math.random() * 10) + 1;
		textField.setText("Программа загадала число от 1 до 10");
		number = 0;
	}
}

