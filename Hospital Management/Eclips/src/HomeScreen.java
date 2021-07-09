import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Window.Type;
public class HomeScreen extends JFrame {

	private JPanel contentPane;

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
					HomeScreen frame = new HomeScreen();
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
	public HomeScreen() {
		setType(Type.UTILITY);
		setTitle("Home\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Add new record button
		JButton AddNewRecordButton = new JButton("Add New Record");
		AddNewRecordButton.addActionListener(new ActionListener() {
			//Code start
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AddNewRecordScreen().setVisible(true);
				//Code end
			}
		});
		AddNewRecordButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\add new patient.png"));
		AddNewRecordButton.setFont(new Font("Javanese Text", Font.BOLD, 14));
		AddNewRecordButton.setBounds(41, 107, 205, 143);
		contentPane.add(AddNewRecordButton);
		
		//View Record button
		JButton ViewRecordButton = new JButton("View Records\r\n");
		ViewRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code start
				setVisible(false);
				new ViewRecordScreen().setVisible(true);
				//Code end
			}
		});
		ViewRecordButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\rsz_history1.png"));
		ViewRecordButton.setFont(new Font("Javanese Text", Font.BOLD, 14));
		ViewRecordButton.setBounds(731, 108, 205, 140);
		contentPane.add(ViewRecordButton);
		
		//Update Record button
		JButton UpdateRecordButton = new JButton("Update Record\r\n");
		UpdateRecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code start
				setVisible(false);
				 new UpdateRecordScreen().setVisible(true);
				 //Code end
			}
		});
		UpdateRecordButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\rsz_update_details.png"));
		UpdateRecordButton.setFont(new Font("Javanese Text", Font.BOLD, 14));
		UpdateRecordButton.setBounds(395, 107, 205, 143);
		contentPane.add(UpdateRecordButton);
		
		//Log out Button
		JButton LogOutButton = new JButton("Log Out\r\n");
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Code start
				int check=JOptionPane.showConfirmDialog(null,"Do you want to logout?","Warning!",JOptionPane.YES_NO_OPTION);
		        if(check==0)
		        {
		            setVisible(false);
		            new LoginScreen().setVisible(true);
		        }
		        //Code end
			}
		});
		LogOutButton.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\exit.png"));
		LogOutButton.setFont(new Font("Javanese Text", Font.BOLD, 14));
		LogOutButton.setBounds(595, 390, 205, 143);
		contentPane.add(LogOutButton);
		
		//Get Bill Button
		JButton GetBillButton = new JButton("Get Bill\r\n");
		GetBillButton.setIcon(new ImageIcon("C:\\Users\\Sourav Paul\\Downloads\\Bill.png"));
		GetBillButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Code Start
				 setVisible(false);
				 new GetBillScreen().setVisible(true);
				//Code End
			}
		});
		GetBillButton.setFont(new Font("Javanese Text", Font.BOLD, 14));
		GetBillButton.setBounds(208, 390, 205, 143);
		contentPane.add(GetBillButton);
		
		JLabel BackgroundLabel = new JLabel("New label");
		BackgroundLabel.setIcon(new ImageIcon("D:\\College Projects\\Hospital Management\\Eclips\\HMS ICON\\HomeScreen2.png"));
		BackgroundLabel.setBounds(0, 0, 994, 665);
		contentPane.add(BackgroundLabel);
	}
}
