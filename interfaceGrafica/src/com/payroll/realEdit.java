package com.payroll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.JToggleButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class realEdit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private static int SSindex = 0;
	private int acc = 1;
	boolean custom = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//realEdit frame = new realEdit();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public realEdit(Funcionario[] func, int index, Agenda[] agenda) {
		
		custom = func[index].isCustom();
		Utility UT = new Utility();
		setTitle("Editar Informações");
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		contentPane.setLayout(null);
		setSize(620, 540);
		
		JLabel lblEditar = new JLabel("EDITAR");
		contentPane.add(lblEditar, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 604, 506);
		contentPane.add(panel);
		
		JButton button = new JButton("Salvar");
		button.setBounds(501, 337, 93, 158);
		panel.add(button);
		
		JLabel label = new JLabel("Endere\u00E7o:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(28, 164, 93, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Nome:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(28, 128, 56, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Valor:");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(26, 384, 71, 21);
		panel.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		if(func[index] instanceof Horista)
		{
			textField.setText(Double.toString(((Horista)func[index]).getSalarioBase()));
		}else textField.setText(Double.toString(func[index].getSalary()));	
		textField.setBackground(SystemColor.textHighlightText);
		textField.setBounds(77, 384, 57, 24);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText(func[index].getAdress());
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.textHighlightText);
		textField_1.setBounds(142, 161, 285, 24);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText(func[index].getName());
		textField_2.setForeground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.textHighlightText);
		textField_2.setBounds(142, 126, 285, 24);
		panel.add(textField_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(272, 426, 0, 0);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(realEdit.class.getResource("/com/payroll/icons8-gest\u00E3o-de-cliente-100.png")));
		label_4.setBounds(28, 11, 145, 107);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("M\u00E9todo de pagamento:");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(28, 352, 202, 21);
		panel.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { func[index].getPayMode(), "Maos", "Deposito"}));
		comboBox.setBounds(224, 355, 140, 20);
		panel.add(comboBox);
		
		JLabel label_6 = new JLabel("Tipo de funcin\u00E1rio:");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(28, 196, 202, 21);
		panel.add(label_6);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Assalariado", "Comissionado"}));
		
		String setValue = func[index].getType();
		switch(setValue) {
		case "Horista":
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Assalariado", "Comissionado"}));
			break;
		case "Comissionado":
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Horista", "Assalariado"}));
			break;
		case "Assalariado":
			comboBox_1.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Horsita", "Comissionado"}));
			break;
		}
		
		comboBox_1.setBounds(287, 196, 140, 20);
		panel.add(comboBox_1);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(realEdit.class.getResource("/com/payroll/icons8-caro-64.png")));
		label_7.setBounds(28, 247, 106, 107);
		panel.add(label_7);
		
		JComboBox comboBox_sind = new JComboBox();
		if(func[index].isSindicaty()) {
			comboBox_sind.setModel(new DefaultComboBoxModel(new String[] {"SIM", "NAO"}));
		}else comboBox_sind.setModel(new DefaultComboBoxModel(new String[] {"NAO", "SIM"}));
		comboBox_sind.setBounds(371, 95, 56, 20);
		panel.add(comboBox_sind);
		
		JLabel lblDiaDePagamento = new JLabel("");
		lblDiaDePagamento.setForeground(Color.BLACK);
		lblDiaDePagamento.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDiaDePagamento.setBounds(289, 224, 138, 21);
		panel.add(lblDiaDePagamento);
		
		
		
		JList list = new JList();
		if(func[index].isCustom())
		{
			acc = 0; list.setVisible(true);			
			DefaultListModel DLMA = new DefaultListModel();
			for(int i = 0; i < 50; i++) { 
				if(agenda[i].isSaved()) {
					
					DLMA.addElement(agenda[i]);
				}
			}
			list.setForeground(Color.BLACK);
			list.setFont(new Font("Tahoma", Font.PLAIN, 14));
			list.setBorder(new CompoundBorder());
			list.setBackground(Color.WHITE);
			list.setBounds(448, 130, 132, 176);
			panel.add(list); 
			list.setModel(DLMA);
			list.setSelectedIndex(func[index].getAgendaID());
			func[index].setCustom(true);
		}
		
		JButton tglbtnNewToggleButton = new JButton("Custom Schedule");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(acc == 1 && agenda[0].isSaved()) 
				{
					acc = 0; list.setVisible(true);			
					DefaultListModel DLMA = new DefaultListModel();
					for(int i = 0; i < 50; i++) { 
						if(agenda[i].isSaved()) {
							
							DLMA.addElement(agenda[i]);
						}
					}
					list.setForeground(Color.BLACK);
					list.setFont(new Font("Tahoma", Font.PLAIN, 14));
					list.setBorder(new CompoundBorder());
					list.setBackground(Color.WHITE);
					list.setBounds(448, 130, 132, 176);
					panel.add(list); 
					list.setModel(DLMA);
					list.setSelectedIndex(0);
					custom = true;
				}
				else if(acc == 0) {
					acc = 1;
					custom = false;
					list.setVisible(false);
					panel.remove(list);
					
				}
				if(!agenda[0].isSaved()) {
					JOptionPane.showMessageDialog(null ,
							"Ainda não há agendas criadas!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tglbtnNewToggleButton.setBounds(448, 101, 132, 23);
		panel.add(tglbtnNewToggleButton);
		
		JLabel lblSindicato = new JLabel("Sindicato:");
		lblSindicato.setForeground(Color.BLACK);
		lblSindicato.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSindicato.setBounds(280, 94, 92, 21);
		panel.add(lblSindicato);
		
		textField_3 = new JTextField();
		if(func[index].getType().equals("Assalariado") && !func[index].isCustom()) {
			textField_3.setBounds(387, 224, 40, 30);
			textField_3.setText(Integer.toString(((Assalariado) func[index]).getPayday()) );
			panel.add(textField_3);
			
			textField_3.setColumns(2);
			lblDiaDePagamento.setText("Dia de pagamento:");
		}
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_1.getSelectedItem().toString().equals("Assalariado") ) {
					
					textField_3.setBounds(387, 224, 40, 30);
					panel.add(textField_3);
					textField_3.setColumns(2);
					lblDiaDePagamento.setText("Dia de pagamento:");
					
				}else {
					panel.remove(textField_3);
					lblDiaDePagamento.setText("");
				}
			}
		});
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox_1.getSelectedItem().toString().equals("Assalariado") && !custom) {
					func[index] = new Assalariado();
					
				}else if(comboBox_1.getSelectedItem().toString().equals("Horista") && !custom ) {
					func[index] = new Horista();
					
				}else if(comboBox_1.getSelectedItem().toString().equals("Comissionado") && !custom ) {
					func[index] = new Comissionado();
					
				} else if(custom) {
					
					if(agenda[list.getSelectedIndex()] instanceof Mensal) {
						func[index] = new Assalariado();
						func[index].setType("Assalariado");
						((Assalariado) func[index]).setPayday(((Mensal)agenda[list.getSelectedIndex()]).getDia());
						
					}else if(agenda[list.getSelectedIndex()] instanceof Semanal) {
						func[index] = new Horista();
						func[index].setType("Horista");
						((Horista) func[index]).setPday(((Semanal)agenda[list.getSelectedIndex()]).getDia());
					}
					func[index].setAgendaID(list.getSelectedIndex());
					
				}
				//Valores independem de tipo
				func[index].setName(textField_2.getText());
				func[index].setAdress(textField_1.getText());
				func[index].setPayMode(comboBox.getSelectedItem().toString());
				func[index].setCustom(custom);
				if(!func[index].isCustom()){
					func[index].setType(comboBox_1.getSelectedItem().toString());
				}
				func[index].setCode("2019" + index);
				func[index].setSindicatycode("1010" + index);
				func[index].setAgendaID(list.getSelectedIndex());
				if(comboBox_sind.getSelectedItem().toString().equals("SIM")) {
					func[index].setSindicaty(true);
				} else func[index].setSindicaty(false);
				
				//Salario Base do Horista
				if(func[index] instanceof Horista) {
					try {
						((Horista) func[index]).setSalarioBase(Double.parseDouble(textField.getText()));
					} catch(Exception ex0) {
						UT.ERRO();
						System.err.print(ex0);
						return;
					}
				} 
				
				//Salario de Assalariado e Comissionado
				else {
					try { 
						func[index].setSalary(Double.parseDouble(textField.getText()));
					} catch(Exception ex0) {
						UT.ERRO();
						System.err.print(ex0); 
						return;
					}
				}
				
				//Dia de recebimento de Assalariado
				if(func[index] instanceof Assalariado && !func[index].isCustom()) {
					try {
						if(Integer.parseInt(textField_3.getText()) > 30 || Integer.parseInt(textField_3.getText()) < 1) {
							throw new Exception("Valores fora do intervalo do mês");
						}
						else ((Assalariado) func[index]).setPayday(Integer.parseInt(textField_3.getText()));
					} catch(Exception ex) {
						UT.ERRO();
						System.err.print(ex);
						return;
					}
				}
				func[index].setSaved(true);
				Command.saveS(func);
				setVisible(false);
				
			}
		});
		
		
		
	}
}
