import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
	public LoginForm() {
		frame = new JFrame("Graphic user interface");
		frame.setSize(400, 400);
		frame.setLayout(null);

		this.mainPanel = new JPanel();
		mainPanel.setLayout(null);

		this.btnLogin = new JButton("Login");
		btnLogin.setSize(100, 20);
		btnLogin.setLocation(80, 110);
		this.mainPanel.add(btnLogin);

		lblUsername = new JLabel("Username");
		lblUsername.setSize(100, 20);
		lblUsername.setLocation(50, 50);
		this.mainPanel.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setSize(100, 20);
		txtUsername.setLocation(130, 50);
		this.mainPanel.add(txtUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setSize(100, 20);
		lblPassword.setLocation(50, 80);
		this.mainPanel.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setSize(100, 20);
		txtPassword.setLocation(130, 80);
		this.mainPanel.add(this.txtPassword);

		frame.setContentPane(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnLogin) {
					System.out.println("Am apasat butonul de login");
					try {
						Application.getInstance()
								.login(new User(txtUsername.getText(), new String(txtPassword.getPassword())));
						JOptionPane.showMessageDialog(null, "Login successfully!");
						
						if(Application.getInstance().currentUser.menuStrategy.toString().contains("Student")) {
							frame.setContentPane(new StudentForm().getPanel());
						}else {
							frame.setContentPane(new TeacherForm().getPanel());
						}
						
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
						frame.revalidate();
						frame.repaint();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
		});
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}

	private JPanel mainPanel;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JButton btnLogin;
	private JFrame frame;
}
