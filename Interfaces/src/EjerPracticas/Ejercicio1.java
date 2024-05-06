package EjerPracticas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;

public class Ejercicio1 {

	private JFrame frmDesignPreviewcontacteditorui;
	private JTextField txtEmailaddress;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio1 window = new Ejercicio1();
					window.frmDesignPreviewcontacteditorui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejercicio1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDesignPreviewcontacteditorui = new JFrame();
		frmDesignPreviewcontacteditorui.setTitle("Design Preview [ContactEditorUI]");
		frmDesignPreviewcontacteditorui.setBounds(100, 100, 516, 364);
		frmDesignPreviewcontacteditorui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDesignPreviewcontacteditorui.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Name", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 480, 99);
		frmDesignPreviewcontacteditorui.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(10, 23, 71, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Title:");
		lblNewLabel_1_1.setBounds(10, 48, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Display Format:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1_2.setBounds(10, 73, 71, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Last name:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_3.setBounds(214, 23, 59, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Nickname:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_4.setBounds(214, 48, 59, 14);
		panel.add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(79, 20, 125, 20);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 45, 125, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(270, 20, 187, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(270, 45, 187, 20);
		panel.add(textField_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"item 1", "item 2", "item 3", "itwm 4"}));
		comboBox.setBounds(79, 69, 378, 18);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "E-mail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 117, 480, 163);
		frmDesignPreviewcontacteditorui.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"item 1", "item 2", "item 3", "item 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(10, 34, 366, 75);
		panel_1.add(list);
		
		txtEmailaddress = new JTextField();
		txtEmailaddress.setBounds(87, 11, 296, 20);
		panel_1.add(txtEmailaddress);
		txtEmailaddress.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("E-mail Address:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(10, 14, 79, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_5.setBounds(401, 15, 69, 14);
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Edit");
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_5_1.setBounds(401, 36, 69, 14);
		panel_1.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("Remove");
		btnNewButton_5_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_5_2.setBounds(401, 58, 69, 14);
		panel_1.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_3 = new JButton("As Default");
		btnNewButton_5_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_5_3.setBounds(401, 84, 69, 14);
		panel_1.add(btnNewButton_5_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("HTML");
		rdbtnNewRadioButton.setBounds(13, 133, 57, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPlainText = new JRadioButton("Plain Text");
		rdbtnPlainText.setBounds(66, 133, 85, 23);
		panel_1.add(rdbtnPlainText);
		
		JRadioButton rdbtnCustom = new JRadioButton("Custom");
		rdbtnCustom.setBounds(153, 133, 69, 23);
		panel_1.add(rdbtnCustom);
		
		JLabel lblMailFormat = new JLabel("Mail Format:");
		lblMailFormat.setBounds(10, 112, 79, 14);
		panel_1.add(lblMailFormat);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(298, 291, 89, 23);
		frmDesignPreviewcontacteditorui.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(401, 291, 89, 23);
		frmDesignPreviewcontacteditorui.getContentPane().add(btnNewButton_1);
	}
}
