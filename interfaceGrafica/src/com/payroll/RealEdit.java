package com.payroll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.adm.Command;
import com.adm.Utility;
import com.employee.Assalariado;
import com.employee.Comissionado;
import com.employee.Funcionario;
import com.employee.Horista;
import com.schedule.Agenda;
import com.schedule.Mensal;
import com.schedule.Semanal;
import com.view.MainView;

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
import javax.swing.SwingConstants;

public class RealEdit extends JFrame {

	private JPanel contentPane;
	private JTextField TFvalor;
	private JTextField TFadress;
	private JTextField TFname;
	private JTextField textField_3;
	private JTextField textField_4;
	private static int SSindex = 0;
	private int acc = 1;
	boolean custom = false;
	private JTextField TFcomi;

	/**
	 * Launch the application.,
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
	public RealEdit(Funcionario[] func, int index, Agenda[] agenda) {
		
		custom = func[index].isCustom();
		Utility UT = new Utility();
		
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		
		JLabel lblEditar = new JLabel("EDITAR");
		contentPane.add(lblEditar, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setFocusCycleRoot(true);
		panel.setFocusTraversalPolicyProvider(true);
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(0, 0, 604, 506);
		contentPane.add(panel);
		
		JButton BTsave = new JButton("Salvar");
		BTsave.setBounds(501, 337, 93, 158);
		panel.add(BTsave);
		
		JLabel LBadress = new JLabel("Endere\u00E7o:");
		LBadress.setForeground(Color.BLACK);
		LBadress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBadress.setBounds(28, 164, 93, 21);
		panel.add(LBadress);
		
		JLabel LBname = new JLabel("Nome:");
		LBname.setForeground(Color.BLACK);
		LBname.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBname.setBounds(28, 128, 56, 21);
		panel.add(LBname);
		
		JLabel LBvalor = new JLabel("Valor:");
		LBvalor.setForeground(Color.BLACK);
		LBvalor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBvalor.setBounds(26, 386, 71, 21);
		panel.add(LBvalor);
		
		TFvalor = new JTextField();
		TFvalor.setColumns(10);
		if(func[index] instanceof Horista)
		{
			TFvalor.setText(Double.toString(((Horista)func[index]).getSalarioBase()));
		}else TFvalor.setText(Double.toString(func[index].getSalary()));	
		TFvalor.setBackground(SystemColor.textHighlightText);
		TFvalor.setBounds(77, 384, 57, 24);
		panel.add(TFvalor);
		
		TFadress = new JTextField();
		TFadress.setText(func[index].getAdress());
		TFadress.setColumns(10);
		TFadress.setBackground(SystemColor.textHighlightText);
		TFadress.setBounds(142, 161, 285, 24);
		panel.add(TFadress);
		
		TFname = new JTextField();
		TFname.setText(func[index].getName());
		TFname.setForeground(Color.BLACK);
		TFname.setColumns(10);
		TFname.setBackground(SystemColor.textHighlightText);
		TFname.setBounds(142, 126, 285, 24);
		panel.add(TFname);

		JLabel LBicon1 = new JLabel("");
		LBicon1.setIcon(new ImageIcon(RealEdit.class.getResource("/com/payroll/icons/icons8-gest\u00E3o-de-cliente-100.png")));
		LBicon1.setBounds(28, 11, 145, 107);
		panel.add(LBicon1);
		
		JLabel LBmetodo = new JLabel("M\u00E9todo de pagamento:");
		LBmetodo.setForeground(Color.BLACK);
		LBmetodo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBmetodo.setBounds(28, 352, 202, 21);
		panel.add(LBmetodo);
		
		JComboBox CBmetodo = new JComboBox();
		CBmetodo.setModel(new DefaultComboBoxModel(new String[] { func[index].getPayMode(), "Maos", "Deposito"}));
		CBmetodo.setBounds(224, 355, 140, 20);
		panel.add(CBmetodo);
		
		JLabel LBtipo = new JLabel("Tipo de funcin\u00E1rio:");
		LBtipo.setForeground(Color.BLACK);
		LBtipo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBtipo.setBounds(28, 196, 202, 21);
		panel.add(LBtipo);
		
		JLabel LBcomi = new JLabel("Comiss\u00E3o de venda :");
		LBcomi.setForeground(Color.BLACK);
		LBcomi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBcomi.setBounds(26, 418, 164, 21);
		panel.add(LBcomi);
		
		JLabel LBpcomi = new JLabel("%");
		LBpcomi.setForeground(Color.BLACK);
		LBpcomi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBpcomi.setBounds(260, 417, 71, 21);
		panel.add(LBpcomi);
		
		TFcomi = new JTextField();
		TFcomi.setHorizontalAlignment(SwingConstants.RIGHT);
		TFcomi.setColumns(10);
		TFcomi.setBackground(SystemColor.textHighlightText);
		TFcomi.setBounds(200, 416, 57, 24);
		panel.add(TFcomi);
		
		JLabel LBdiap = new JLabel("Dia de pagamento:");
		LBdiap.setForeground(Color.BLACK);
		LBdiap.setFont(new Font("Tahoma", Font.PLAIN, 11));
		LBdiap.setBounds(289, 224, 138, 21);
		panel.add(LBdiap);
		
		JComboBox CBtipo = new JComboBox();
		CBtipo.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Assalariado", "Comissionado"}));
		
		String setValue = func[index].getType();

		switch(setValue) {
		case "Horista":
			TFcomi.setText("15");
			LBcomi.setVisible(false);
			LBpcomi.setVisible(false);
			TFcomi.setVisible(false);
			LBdiap.setVisible(false);
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Assalariado", "Comissionado"}));
			break;
		case "Comissionado":
			TFcomi.setText(Integer.toString(((Comissionado) func[index]).getPVenda()));
			LBdiap.setVisible(false);
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Horista", "Assalariado"}));
			break;
		case "Assalariado":
			TFcomi.setText("15");
			LBcomi.setVisible(false);
			LBpcomi.setVisible(false);
			TFcomi.setVisible(false);
			CBtipo.setModel(new DefaultComboBoxModel(new String[] { func[index].getType(), "Horista", "Comissionado"}));
			break;
		}
		CBtipo.setBounds(287, 196, 140, 20);
		panel.add(CBtipo);
		
		JLabel LBicon2 = new JLabel("");
		LBicon2.setIcon(new ImageIcon(RealEdit.class.getResource("/com/payroll/icons/icons8-caro-64.png")));
		LBicon2.setBounds(28, 247, 106, 107);
		panel.add(LBicon2);
		
		JComboBox CBsind = new JComboBox();
		if(func[index].isSindicaty()) {
			CBsind.setModel(new DefaultComboBoxModel(new String[] {"SIM", "NAO"}));
		}else CBsind.setModel(new DefaultComboBoxModel(new String[] {"NAO", "SIM"}));
		CBsind.setBounds(362, 95, 65, 20);
		panel.add(CBsind);
		
		
		JList list = new JList();
		JScrollPane scrollPane_1 = new JScrollPane();
		
		
		if(func[index].isCustom())
		{
			acc = 0; list.setVisible(true);			
			DefaultListModel DLMA = new DefaultListModel();
			for(int i = 0; i < 50; i++) { 
				if(agenda[i].isSaved()) {
					
					DLMA.addElement(agenda[i]);
				}
			}
			scrollPane_1.setBounds(448, 130, 132, 176);
			list.setForeground(Color.BLACK);
			list.setFont(new Font("Tahoma", Font.PLAIN, 14));
			list.setBorder(new CompoundBorder());
			list.setBackground(Color.WHITE);
			list.setBounds(448, 130, 132, 176);
			panel.add(list); 
			panel.add(scrollPane_1);
			list.setModel(DLMA);
			list.setSelectedIndex(func[index].getAgendaID());
			func[index].setCustom(true);
			scrollPane_1.setViewportView(list);
		}
		
		JButton TFcustom = new JButton("Custom Schedule");
		TFcustom.addActionListener(new ActionListener() {
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
					scrollPane_1.setBounds(448, 130, 132, 176);
					list.setForeground(Color.BLACK);
					list.setFont(new Font("Tahoma", Font.PLAIN, 14));
					list.setBorder(new CompoundBorder());
					list.setBackground(Color.WHITE);
					list.setBounds(448, 130, 132, 176);
					panel.add(list); 
					panel.add(scrollPane_1);
					list.setModel(DLMA);
					list.setSelectedIndex(0);
					scrollPane_1.setViewportView(list);
					list.setVisible(true);
					scrollPane_1.setVisible(true);
					custom = true;
				}
				else if(acc == 0) {
					acc = 1;
					custom = false;
					list.setVisible(false);
					scrollPane_1.setVisible(false);
					panel.remove(list);
					
				}
				if(!agenda[0].isSaved()) {
					JOptionPane.showMessageDialog(null ,
							"Ainda não há agendas criadas!", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		TFcustom.setBounds(449, 94, 132, 23);
		panel.add(TFcustom);
		
		JLabel LBsind = new JLabel("Sindicato:");
		LBsind.setForeground(Color.BLACK);
		LBsind.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBsind.setBounds(260, 94, 92, 21);
		panel.add(LBsind);
		
		JLabel LBrs = new JLabel("R$");
		LBrs.setHorizontalAlignment(SwingConstants.LEFT);
		LBrs.setForeground(Color.BLACK);
		LBrs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		LBrs.setBounds(137, 386, 71, 21);
		panel.add(LBrs);
		
	
		
		
		textField_3 = new JTextField();
		
		if(func[index].getType().equals("Assalariado") && !func[index].isCustom()) {
			textField_3.setBounds(387, 224, 40, 30);
			textField_3.setText(Integer.toString(((Assalariado) func[index]).getPayday()) );
			panel.add(textField_3);
			textField_3.setColumns(2);
			LBdiap.setVisible(true);
		}
		
		CBtipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(CBtipo.getSelectedItem().toString().equals("Assalariado") ) {
					
					textField_3.setBounds(387, 224, 40, 30);
					panel.add(textField_3);
					textField_3.setColumns(2);
					LBdiap.setVisible(true);
					
				}else {
					panel.remove(textField_3);
					LBdiap.setVisible(false);
				}
				if(CBtipo.getSelectedItem().toString().equals("Comissionado")){
					LBcomi.setVisible(true);
					LBpcomi.setVisible(true);
					TFcomi.setVisible(true);
				}else {
					LBcomi.setVisible(false);
					LBpcomi.setVisible(false);
					TFcomi.setVisible(false);
				}
			}
		});
		
		
		BTsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja salvar as informações?", "Confirmação", dialogButton);
				if(!(dialogResult == JOptionPane.YES_OPTION) ){
					return;
				}
				
				if(CBtipo.getSelectedItem().toString().equals("Assalariado") && !custom) {
					//System.out.println("criou A");
					func[index] = new Assalariado();
					func[index].setType("Assalariado");
					
				}else if(CBtipo.getSelectedItem().toString().equals("Horista") && !custom ) {
					//System.out.println("criou H ");
					func[index] = new Horista();
					func[index].setType("Horista");
					
				}else if(CBtipo.getSelectedItem().toString().equals("Comissionado") && !custom ) {
					//System.out.println("criou C ");
					func[index] = new Comissionado();
					func[index].setType("Comissionado");
					
				} else if(custom) {
					
					if(agenda[list.getSelectedIndex()] instanceof Mensal) {
						func[index] = new Assalariado();
						func[index].setType("Assalariado");
						func[index].setAgendaToString(agenda[list.getSelectedIndex()].toString());
						((Assalariado) func[index]).setPayday(((Mensal)agenda[list.getSelectedIndex()]).getDia());
						
					}else if(agenda[list.getSelectedIndex()] instanceof Semanal) {
						
						if(CBtipo.getSelectedItem().toString().equals("Comissionado")) {
							
							func[index] = new Comissionado();
							func[index].setType("Comissionado");
							func[index].setAgendaToString(agenda[list.getSelectedIndex()].toString());
							((Comissionado) func[index]).setPday(((Semanal)agenda[list.getSelectedIndex()]).getDia());
							((Comissionado) func[index]).setFrequencia(((Semanal)agenda[list.getSelectedIndex()]).getFrequencia());
							
						}if(CBtipo.getSelectedItem().toString().equals("Horista")) {
							
							func[index] = new Horista();
							func[index].setType("Horista");
							func[index].setAgendaToString(agenda[list.getSelectedIndex()].toString());
							((Horista) func[index]).setPday(((Semanal)agenda[list.getSelectedIndex()]).getDia());
							((Horista) func[index]).setFrequencia(((Semanal)agenda[list.getSelectedIndex()]).getFrequencia());
							
						}
						
					}
					func[index].setAgendaID(list.getSelectedIndex());
					
				}
				//Valores independem de tipo
				func[index].setName(TFname.getText());
				func[index].setAdress(TFadress.getText());
				func[index].setPayMode(CBmetodo.getSelectedItem().toString());
				func[index].setCustom(custom);
				func[index].setCode("2019" + index);
				func[index].setSindicatycode("111" + index);
				func[index].setAgendaID(list.getSelectedIndex());
				if(CBsind.getSelectedItem().toString().equals("SIM")) {
					func[index].setSindicaty(true);
				} else func[index].setSindicaty(false);
				
				//Salario Base do Horista
				if(func[index] instanceof Horista) {
					try {
						((Horista) func[index]).setSalarioBase(Double.parseDouble(TFvalor.getText()));
					} catch(Exception ex0) {
						UT.ERRO();
						System.err.print(ex0);
						return;
					}
				} 
				//Salario de Assalariado e Comissionado
				else {
					try { 
						func[index].setSalary(Double.parseDouble(TFvalor.getText()));
						if(func[index] instanceof Comissionado) {
							((Comissionado)func[index]).setRealSalary(func[index].getSalary()/2);
						}
						
					} catch(Exception ex0) {
						UT.ERRO();
						System.err.print(ex0); 
						return;
					}
				}
				
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
				
				if(func[index] instanceof Comissionado) {
					try {
						if(Integer.parseInt(TFcomi.getText()) > 100 || Integer.parseInt(TFcomi.getText()) < 0) {
							throw new Exception("Valores fora do intervalo <insira entre 0 e 100>");
						}
						else ((Comissionado) func[index]).setPVenda(Integer.parseInt(TFcomi.getText()));
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
		
		
		
		
		setTitle("Editar Informações");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(contentPane);
		setSize(612, 532);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
	}
}
