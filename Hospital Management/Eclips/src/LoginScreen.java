import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;          
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import java.awt.Dimension;
import Connection.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginScreen extends JFrame {

	private JPanel contentPane;
	private JTextField UsernameField;
	private JPasswordField PasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Hospital Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToHospital = new JLabel("Welcome To The Hospital Management System");
		lblWelcomeToHospital.setForeground(new Color(25, 25, 112));
		lblWelcomeToHospital.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblWelcomeToHospital.setBounds(100, 35, 1000, 50);
		contentPane.add(lblWelcomeToHospital);
		
		JLabel credit = new JLabel("A Project of Group-1");
		credit.setFont(new Font("Javanese Text", Font.BOLD, 16));
		credit.setBounds(417, 104, 200, 20);
		contentPane.add(credit);
		
		JLabel loginIcon = new JLabel("");
		loginIcon.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\userlogin.png"));
		loginIcon.setBounds(430, 300, 150, 150);
		contentPane.add(loginIcon);
		
		JButton btnUserLogin = new JButton("User Login");
		btnUserLogin.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUserLogin.setBounds(440, 470, 130, 40);
		contentPane.add(btnUserLogin);
		
		
		JLabel mainScreen = new JLabel();
		mainScreen.setFocusTraversalPolicyProvider(true);
		mainScreen.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\building.png"));
		mainScreen.setBounds(0, 0, 994, 671);
		contentPane.add(mainScreen);
		
		
		JLabel UsernameLabel = new JLabel("Username\r\n");
		UsernameLabel.setBounds(567, 193, 97, 33);
		UsernameLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		contentPane.add(UsernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setBounds(567, 270, 97, 33);
		PasswordLabel.setFont(new Font("Javanese Text", Font.BOLD, 18));
		contentPane.add(PasswordLabel);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(661, 192, 283, 33);
		UsernameField.setFont(new Font("Calibri", Font.BOLD, 18));
		UsernameField.setBackground(SystemColor.activeCaption);
		contentPane.add(UsernameField);
		UsernameField.setColumns(10);
		
		PasswordField = new JPasswordField();
		PasswordField.setFont(new Font("Calibri", Font.BOLD, 18));
		PasswordField.setBounds(661, 270, 283, 31);
		PasswordField.setBackground(SystemColor.activeCaption);
		contentPane.add(PasswordField);
		
		JButton LoginButton = new JButton("Login\r\n");
		LoginButton.setBounds(661, 344, 110, 33);
		
		//Login Button
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code start
				String username=UsernameField.getText();
				String password=PasswordField.getText();
				try {
					String query="Select password from user_credentials where username='"+username+"';";
		        	Connection con=ConnectionProvider.getCon();
			        Statement st=con.createStatement();
		            
		            ResultSet rs=st.executeQuery(query);
		            rs.next();
		       
		            String pass=rs.getString(1);
		            if(PasswordField.getText().equals(pass))
				        {   setVisible(false);
				            new HomeScreen().setVisible(true);
				        }
		            else
				          JOptionPane.showMessageDialog(null,"Incorrect Username or Password");	
		            }catch(Exception E)
				 		{
		   			 JOptionPane.showMessageDialog(null, E);
				 		}
				//Code end
			}
		});
		LoginButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\login.png"));
		LoginButton.setFont(new Font("Javanese Text", Font.BOLD, 18));
		contentPane.add(LoginButton);
		
		//Close Button
		JButton CloseButton = new JButton("Close");
		CloseButton.setBounds(834, 344, 110, 33);
		CloseButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\Close.png"));
		CloseButton.setFont(new Font("Javanese Text", Font.BOLD, 18));
		CloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Code start
				int check=JOptionPane.showConfirmDialog(null,"Are you sure?","Warning!",JOptionPane.YES_NO_OPTION);
		        if(check==0)
		            System.exit(0);
		        //Code end
			}
		});
		contentPane.add(CloseButton);
		
		
		JLabel loginScreen = new JLabel();
		loginScreen.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\hmslogin.png"));
		loginScreen.setBounds(0, 0, 994, 671);
		contentPane.add(loginScreen);
		
		
		mainScreen.setVisible(true);
		loginIcon.setVisible(true);
		btnUserLogin.setVisible(true);
		lblWelcomeToHospital.setVisible(true);
		credit.setVisible(true);
		
		UsernameField.setVisible(false);
		PasswordField.setVisible(false);
		CloseButton.setVisible(false);
		LoginButton.setVisible(false);
		UsernameLabel.setVisible(false);
		PasswordLabel.setVisible(false);
		loginScreen.setVisible(false);
		
		
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainScreen.setVisible(false);
				loginIcon.setVisible(false);
				btnUserLogin.setVisible(false);
				lblWelcomeToHospital.setVisible(false);
				credit.setVisible(false);
				
				UsernameField.setVisible(true);
				PasswordField.setVisible(true);
				CloseButton.setVisible(true);
				LoginButton.setVisible(true);
				UsernameLabel.setVisible(true);
				PasswordLabel.setVisible(true);
				
				loginScreen.setVisible(true);
			}
		});

		
		
		
	}
}
