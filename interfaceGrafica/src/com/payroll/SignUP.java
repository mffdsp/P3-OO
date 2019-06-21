package com.payroll;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Window.Type;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DropMode;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class SignUP extends JFrame {
	
	private static double DBsalary = -1;
	private static int actions = 0;
	private static boolean invalidenumber = true;
	private static int SSindex = 0;
	private JPanel contentPane;
	private JTextField AdressField;
	private JTextField NameField;
	private JTextField SalaryField;
	private JLabel errotext;
	boolean sind = false;
	Utility UT = new Utility();
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	
	/**
	 * Launch the application.
	 */
	public void saveValues(Funcionario[] func, int index) {
		
		switch(comboBox.getSelectedItem().toString()) {
			
		case "Assalariado":
			func[index] = new Assalariado();
			break;
			
		case "Horista":
			func[index] = new Horista();
			break; 
			
		case "Comissionado":
			func[index] = new Comissionado();
			break;
		}
		func[index].setSindicaty(sind);
		func[index].setSindicatycode("1919" + index);
		func[index].setName(NameField.getText());
		func[index].setAdress(AdressField.getText());
		func[index].setType(comboBox.getSelectedItem().toString());
		func[index].setPayMode(comboBox_1.getSelectedItem().toString());
		func[index].setCode("2019" + index);
		
	}
	
	public void POPUP(Funcionario[] func, int index) {

		saveValues(func, index);
		try {
			DBsalary = Double.parseDouble(SalaryField.getText());
			invalidenumber = false;
		}catch(Exception ec) {
			System.err.print(ec);
			invalidenumber = true;
		}
		if(func[index].getName().equals("") || func[index].getAdress().equals("") || invalidenumber || DBsalary == -1) {
			JOptionPane.showMessageDialog(null ,
					"Preencha todos os campos corretamente!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	//	DBsalary = Double.parseDouble(SalaryField.getText());
		func[index].setSalary(DBsalary);
		JOptionPane.showMessageDialog(null ,
				"Funcionário adicionado com sucesso!", "Feito", JOptionPane.INFORMATION_MESSAGE);
		actions = 0;
		
		
		
		if(func[index] instanceof Horista) {
			((Horista) func[index]).setSalarioBase(Double.parseDouble(SalaryField.getText()));
			func[index].setSalary(0);
		}if(func[index] instanceof Assalariado) {
			((Assalariado)func[index]).setPayday(30);
		}if(func[index] instanceof Comissionado) {
			//System.err.println("1");
		}
		
		func[index].setSaved(true);
		Command.saveS(func);
		setVisible(false);
		return;
						
	}
	/**
	 * Create the frame.
	 */
	public SignUP(Funcionario[] func, int index) {
		setResizable(false);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Adicionar Funcionário ao Sistema");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setForeground(SystemColor.inactiveCaption);
		setContentPane(contentPane);
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(576, 540);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(28, 128, 56, 21);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(28, 164, 93, 21);
		lblEndereo.setForeground(SystemColor.activeCaptionText);
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblTipo = new JLabel("Valor:");
		lblTipo.setBounds(28, 418, 71, 21);
		lblTipo.setForeground(Color.BLACK);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		AdressField = new JTextField();
		AdressField.setBounds(142, 161, 285, 24);
		AdressField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func, index);
	                
	            }
	        }
		});
		AdressField.setBackground(SystemColor.textHighlightText);
		AdressField.setColumns(10);
		
		NameField = new JTextField();
		NameField.setBounds(142, 126, 285, 24);
		NameField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func, index);
		               
	            }
	        }
		});
		NameField.setBackground(SystemColor.textHighlightText);
		NameField.setForeground(SystemColor.desktop);
		NameField.setColumns(10);
		
		SalaryField = new JTextField();
		SalaryField.setBounds(77, 419, 57, 24);
		SalaryField.setBackground(SystemColor.textHighlightText);
		SalaryField.setColumns(10);
		SalaryField.setText("");
		errotext = new JLabel("");
		errotext.setBounds(272, 426, 0, 0);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(457, 337, 93, 158);
		 
		SalaryField.addKeyListener(new KeyAdapter() {
			@Override
			  public void keyPressed(KeyEvent e) {
	            if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            	POPUP(func, index);
	               
	            }
	        }
		});

		btnSalvar.addActionListener(new ActionListener() {
			//ação
			public void actionPerformed(ActionEvent arg0) {
				POPUP(func, index);
			}
		});
		
		JLabel lblTipo_1 = new JLabel("Tipo de funcin\u00E1rio:");
		lblTipo_1.setBounds(28, 196, 202, 21);
		lblTipo_1.setForeground(Color.BLACK);
		lblTipo_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		comboBox.setBounds(287, 199, 140, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Horista", "Assalariado", "Comissionado"}));
		comboBox.setSelectedIndex(1);
	
		
		
		
		JLabel lblMtodoDePagamento = new JLabel("M\u00E9todo de pagamento:");
		lblMtodoDePagamento.setBounds(28, 386, 202, 21);
		lblMtodoDePagamento.setForeground(Color.BLACK);
		lblMtodoDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		comboBox_1.setBounds(223, 386, 140, 20);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Correios", "Maos", "Conta bancaria"}));
		
		
		
		
		JLabel label = new JLabel("");
		label.setBounds(28, 11, 145, 107);
		label.setIcon(new ImageIcon(SignUP.class.getResource("/com/payroll/icons8-gest\u00E3o-de-cliente-100.png")));
		contentPane.setLayout(null);
		contentPane.add(btnSalvar);
		contentPane.add(lblEndereo);
		contentPane.add(lblNewLabel);
		contentPane.add(lblTipo);
		contentPane.add(SalaryField);
		contentPane.add(AdressField);
		contentPane.add(NameField);
		contentPane.add(errotext);
		contentPane.add(label);
		contentPane.add(lblMtodoDePagamento);
		contentPane.add(comboBox_1);
		contentPane.add(lblTipo_1);
		contentPane.add(comboBox);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(SignUP.class.getResource("/com/payroll/icons8-caro-64.png")));
		label_1.setBounds(28, 279, 106, 107);
		contentPane.add(label_1);
		
		JLabel lblAssociao = new JLabel("Associa\u00E7\u00E3o Sindical:");
		lblAssociao.setForeground(Color.BLACK);
		lblAssociao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAssociao.setBounds(28, 228, 202, 21);
		contentPane.add(lblAssociao);
		
		JComboBox comboBox_sind = new JComboBox();
		
		comboBox_sind.setModel(new DefaultComboBoxModel(new String[] {"N\u00C3O", "SIM"}));
		comboBox_sind.setBounds(287, 231, 140, 20);
		contentPane.add(comboBox_sind);
		
		JLabel codeLabel = new JLabel("New label");
		codeLabel.setForeground(SystemColor.textHighlight);
		codeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		codeLabel.setBounds(507, 11, 67, 14);
		contentPane.add(codeLabel);
		
		codeLabel.setText("2019" + index); 
		
		JLabel ScodeLabel = new JLabel((String) null);
		ScodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ScodeLabel.setBounds(279, 246, 159, 33);
		contentPane.add(ScodeLabel);
		
		
		comboBox_sind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(comboBox_sind.getSelectedItem().equals("SIM")) {
					sind = true;
					
					ScodeLabel.setText("Código sindical = " + "1919" + index);
				}else {
					sind = true;
					ScodeLabel.setText("");
				}
			}
		});
		
		}
}
