import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.SpringLayout.Constraints;

public class StudentForm {
	public StudentForm() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		welcomeMessage = new JLabel("Welcome student " + Application.getInstance().currentUser.userName + " these are your TEACHERS");
		mainPanel.add(welcomeMessage, BorderLayout.NORTH);
		displayProfesori();
		mainPanel.setVisible(true);
	}

	public JPanel getPanel() {
		return mainPanel;
	}

	private void displayProfesori() {
		textArea = new JTextArea();
		HardcodatDataManager dataManager = new HardcodatDataManager();
		for (Profesor p : dataManager.createProfesorData()) {
			textArea.append(p.nume + "\n");
		}
		mainPanel.add(textArea, BorderLayout.CENTER);
	}

	private JPanel mainPanel;
	private JLabel welcomeMessage;
	private JTextArea textArea;
}
