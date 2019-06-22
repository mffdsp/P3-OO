package com.view;

import com.adm.CalendarMT;
import com.adm.Command;
import com.adm.Utility;
import com.employee.Funcionario;
import com.employee.Horista;
import com.payroll.SignUP;
import com.schedule.Agenda;
import com.schedule.CriarAgendaView;

import java.awt.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import java.io.*;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

import java.awt.Dialog.ModalExclusionType;

public class MainView extends JFrame{
	
	Utility UT = new Utility();
	Agenda agenda[] = new Agenda[50];
	private JPanel contentPane;
	private JLabel texto;
	private JLabel texto3;
	private static int index = 0;
	
	
	public static void main(String[] args) {
	
		//Nimbus set
	    try {
	        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	            if ("Nimbus".equals(info.getName())) {
	                javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                break;
	            }
	        }
	    } catch (ClassNotFoundException ex) {
	       System.err.println(ex);
	    } catch (InstantiationException ex1) {
	    	System.err.println(ex1);
	    } catch (IllegalAccessException ex2) {
	    	System.err.println(ex2);
	    } catch (javax.swing.UnsupportedLookAndFeelException ex3) {
	    	System.err.println(ex3);
	    }
	    //Nimbus set
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.setVisible(true);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws Exception 
	 */
		
	
	
	public MainView() throws IOException {
				
		//frameset
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setType(Type.NORMAL);
		setTitle("FolhaDePagamento");
		setResizable(false);
		setForeground(UIManager.getColor("textHighlight"));
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/payroll/icons/APPICON.png")));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 521);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setForeground(SystemColor.inactiveCaption);
		setContentPane(contentPane);
		texto = new JLabel("Sistema de Folha de pagamento vers\u00E3o 1.0");
		texto.setForeground(SystemColor.controlText);
		texto.setFont(new Font("Tahoma", Font.PLAIN, 8));
		texto.setBounds(625, 11, 180, 14);
		//frameset
		
		
		JButton button_2 = new JButton("");
		button_2.setContentAreaFilled(false);
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setBounds(451, 120, 81, 81);
		button_2.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-editar-v\u00E1rios-80 (1).png")));
		
		JButton button_1 = new JButton("");
		button_1.setContentAreaFilled(false);
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setBounds(271, 120, 81, 81);
		
		JButton button_3 = new JButton("");
		button_3.setContentAreaFilled(false);
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setBounds(631, 120, 81, 81);
		
		JButton AddBt = new JButton("");
		AddBt.setContentAreaFilled(false);
		AddBt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		AddBt.setBounds(93, 120, 81, 81);
		AddBt.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/add.png")));
		AddBt.setToolTipText("Adicionar Funcion\u00E1rio");
		AddBt.setBackground(Color.WHITE);
		AddBt.setForeground(Color.WHITE);
		AddBt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		
		
		texto3 = new JLabel("Adicionar Funcion\u00E1rio");
		texto3.setLabelFor(AddBt);
		texto3.setBounds(68, 188, 164, 25);
		texto3.setForeground(SystemColor.activeCaptionText);
		texto3.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_3.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-lista-de-verifica\u00E7\u00E3o-64.png")));
		button_3.setToolTipText("Listar Funcion\u00E1rios");
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_3.setBackground(Color.WHITE);
		
		JLabel lblRemoverFuncionrio = new JLabel("Remover Funcion\u00E1rio");
		lblRemoverFuncionrio.setForeground(SystemColor.activeCaptionText);
		lblRemoverFuncionrio.setBounds(242, 188, 147, 25);
		lblRemoverFuncionrio.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblAlterarDados = new JLabel("Alterar Dados");
		lblAlterarDados.setForeground(SystemColor.activeCaptionText);
		lblAlterarDados.setBounds(451, 188, 147, 25);
		lblAlterarDados.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblListarEmpregados = new JLabel("Listar Empregados");
		lblListarEmpregados.setForeground(SystemColor.activeCaptionText);
		lblListarEmpregados.setBounds(615, 188, 147, 25);
		lblListarEmpregados.setFont(new Font("Tahoma", Font.BOLD, 12));
		

		
		contentPane.setLayout(null);
		contentPane.add(AddBt);
		contentPane.add(button_1);
		contentPane.add(button_2);
		contentPane.add(button_3);
		contentPane.add(texto3);
		contentPane.add(lblRemoverFuncionrio);
		contentPane.add(lblListarEmpregados);
		contentPane.add(lblAlterarDados);
		contentPane.add(texto);
		
		
		
		//Screen Config
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(813, 517);
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		JLabel background = new JLabel("", new ImageIcon("img\bgteste.jpg"), JLabel.CENTER);
		background.setBounds(11, 1, 0, 0);
		background.setBackground(new Color(0,0,0,80));
		
		
		//Data
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(SystemColor.controlText);
		JLabel label = new JLabel();
		label.setForeground(SystemColor.controlText);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 419, 103, 25);
		contentPane.add(lblNewLabel);
		label.setBounds(63, 437, 43, 25);
		contentPane.add(label);
		lblNewLabel.setText(CalendarMT.valueToString(CalendarMT.Adia) + "/"  + CalendarMT.valueToString(CalendarMT.Ames)
		+ "/"  + CalendarMT.valueToString(CalendarMT.Aano)); 
		label.setText(CalendarMT.valueToString(CalendarMT.Ahora) + ":" + CalendarMT.valueToString(CalendarMT.Aminuto)); 
	
		
		//ArrayList<Funcionario> teste = new ArrayList();
		
		Funcionario[] teste = new Funcionario[50];	
		UT.setALL(teste, agenda);
		Command.saveS(teste);
		
		//AddFuncionario();
		AddBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				index = UT.findIndex(teste);
				teste[index] = new Horista();
				try {
					new SignUP(teste, index).setVisible(true);
					
				}catch(ArrayIndexOutOfBoundsException exception) {
					
					System.out.println("Indice fora dos limites definidos");
				}
				
			}
		});

		//RmvFuncionario();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(teste, "remover", agenda).setVisible(true);
			}
		});
		
		
		button_1.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-remover-usu\u00E1rio-masculino-64 (1).png")));
		button_1.setToolTipText("Remover Funcion\u00E1rio");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_1.setBackground(Color.WHITE);
		
		
		//editFuncionario();
	
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EditView(teste, "editar", agenda).setVisible(true);
			}
		});
		button_2.setToolTipText("Alterar Dados");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_2.setBackground(Color.WHITE);
		
		
		//listarFuncionario();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				DefaultListModel DLMA = new DefaultListModel();
				DefaultListModel DLMC = new DefaultListModel();
				DefaultListModel DLMH = new DefaultListModel();
				try {
					UT.setList(teste, DLMC, DLMA, DLMH);
				}
				catch(NullPointerException e) {
					System.out.println("Exception de ponteiro nulo");
				}
				if(DLMA.getSize() == 0) {
					DLMA.addElement("Lista Vazia");
				}if(DLMH.getSize() == 0) {
					DLMH.addElement("Lista Vazia");
				}if(DLMC.getSize() == 0) {
					DLMC.addElement("Lista Vazia");
				}
				new ListView(DLMA, DLMC, DLMH, teste).setVisible(true);
			}
		});
		
	
		JButton btnAtualizarTempo = new JButton("");
		btnAtualizarTempo.setToolTipText("Passar hora");
		btnAtualizarTempo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtualizarTempo.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-clock-adicionar-64 (1).png")));
		btnAtualizarTempo.setContentAreaFilled(false);
		btnAtualizarTempo.setBorderPainted(false);
		btnAtualizarTempo.setBorder(null);
		btnAtualizarTempo.setForeground(SystemColor.inactiveCaption);
		btnAtualizarTempo.setBackground(SystemColor.activeCaption);
		btnAtualizarTempo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalendarMT.passHour(teste);
				lblNewLabel.setText(CalendarMT.valueToString(CalendarMT.Adia) + "/"  + CalendarMT.valueToString(CalendarMT.Ames)
				+ "/"  + CalendarMT.valueToString(CalendarMT.Aano)); 
				label.setText(CalendarMT.valueToString(CalendarMT.Ahora) + ":" + CalendarMT.valueToString(CalendarMT.Aminuto)); 
			}
		});
		btnAtualizarTempo.setBounds(95, 417, 60, 49);
		contentPane.add(btnAtualizarTempo);
		
		JButton UndoBTN = new JButton("");
		UndoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		UndoBTN.setContentAreaFilled(false);
		UndoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		UndoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Command.undo(teste);
			}
		});
		UndoBTN.setBounds(10, 11, 35, 50);
		contentPane.add(UndoBTN);
		
		JButton RedoBTN = new JButton("");
		RedoBTN.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RedoBTN.setContentAreaFilled(false);
		RedoBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Command.redo(teste);
			}

		});
		RedoBTN.setIcon(new ImageIcon(MainView.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		RedoBTN.setBounds(45, 11, 35, 50);
		contentPane.add(RedoBTN);
		
		JButton button = new JButton("");
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.setHideActionText(true);
		button.setContentAreaFilled(false);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-propriedade-de-tempo-80 (1).png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(teste, "BPonto", agenda).setVisible(true);
			}
		});
		button.setToolTipText("Cart\u00E3o de ponto");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button.setBackground(Color.WHITE);
		button.setBounds(91, 239, 81, 81);
		contentPane.add(button);
		
		JLabel lblLanarCarto = new JLabel("Cart\u00E3o de Ponto");
		lblLanarCarto.setLabelFor(button);
		lblLanarCarto.setForeground(SystemColor.activeCaptionText);
		lblLanarCarto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLanarCarto.setBounds(80, 315, 147, 25);
		contentPane.add(lblLanarCarto);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(teste, "TSindical", agenda).setVisible(true);
			}
		});
		button_4.setContentAreaFilled(false);
		button_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_4.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-pagamento-online-64.png")));
		button_4.setToolTipText("Lan\u00E7ar Taxa");
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(268, 242, 81, 81);
		contentPane.add(button_4);
		
		JLabel lblLanarTaxa = new JLabel("Lan\u00E7ar Taxa");
		lblLanarTaxa.setForeground(SystemColor.activeCaptionText);
		lblLanarTaxa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLanarTaxa.setBounds(271, 315, 147, 25);
		contentPane.add(lblLanarTaxa);
		
		JButton button_5 = new JButton("");
		button_5.setContentAreaFilled(false);
		button_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditView(teste, "Lvenda", agenda).setVisible(true);
			}
		});
		button_5.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-vender-estoque-64.png")));
		button_5.setToolTipText("Lan\u00E7ar Venda");
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(444, 242, 81, 81);
		contentPane.add(button_5);
		
		JLabel lblCriarAgendaDe = new JLabel("Criar Agenda ");
		lblCriarAgendaDe.setForeground(SystemColor.activeCaptionText);
		lblCriarAgendaDe.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCriarAgendaDe.setBounds(631, 315, 96, 25);
		contentPane.add(lblCriarAgendaDe);
		
		JButton btnAaaaaa = new JButton("");
		btnAaaaaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CriarAgendaView(agenda, teste).setVisible(true);
			}
		});
		btnAaaaaa.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAaaaaa.setContentAreaFilled(false);
		btnAaaaaa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAaaaaa.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-criar-arquivo-64 (1).png")));
		btnAaaaaa.setToolTipText("Criar Agenda");
		btnAaaaaa.setForeground(Color.WHITE);
		btnAaaaaa.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnAaaaaa.setBackground(Color.WHITE);
		btnAaaaaa.setBounds(631, 239, 81, 81);
		contentPane.add(btnAaaaaa);
		
		JButton btnRodarFolhaDe = new JButton("");
		btnRodarFolhaDe.setContentAreaFilled(false);
		btnRodarFolhaDe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRodarFolhaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CalendarMT.payboo[CalendarMT.DAYSGONE]){
					JOptionPane.showMessageDialog(null ,
							"Folha de pagamento j� rodada hoje", "ERRO", JOptionPane.ERROR_MESSAGE);
					return;
				}
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja rodar a folha de pagamento para hoje?", "Confirma��o", dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					CalendarMT.payboo[CalendarMT.DAYSGONE] =  true;
					DefaultListModel DLMA = new DefaultListModel();
					DefaultListModel DLMC = new DefaultListModel();
					DefaultListModel DLMH = new DefaultListModel();
					try{
						UT.payList(teste, DLMC, DLMA, DLMH);
					}
					catch(NullPointerException e2) {
						System.out.println("Exception de ponteiro nulo");
					}
					if(DLMA.getSize() == 0) {
						DLMA.addElement("Lista Vazia");
					}if(DLMH.getSize() == 0) {
						DLMH.addElement("Lista Vazia");
					}if(DLMC.getSize() == 0) {
						DLMC.addElement("Lista Vazia");
					}
					new PayView(DLMA, DLMC, DLMH, teste).setVisible(true);
				}
			}
		});
		btnRodarFolhaDe.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/icons8-transfer\u00EAncia-de-dinheiro-64 (1).png")));
		btnRodarFolhaDe.setToolTipText("Listar Funcion\u00E1rios");
		btnRodarFolhaDe.setForeground(new Color(245, 255, 250));
		btnRodarFolhaDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 7));
		btnRodarFolhaDe.setBackground(Color.WHITE);
		btnRodarFolhaDe.setBounds(701, 386, 81, 81);
		contentPane.add(btnRodarFolhaDe);
		
		JLabel lblLanarVenda = new JLabel("Lan\u00E7ar Venda");
		lblLanarVenda.setForeground(SystemColor.activeCaptionText);
		lblLanarVenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLanarVenda.setBounds(451, 315, 147, 25);
		contentPane.add(lblLanarVenda);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setBounds(10, 135, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblRodarFolha = new JLabel("Rodar Folha ");
		lblRodarFolha.setForeground(Color.BLACK);
		lblRodarFolha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRodarFolha.setBounds(705, 448, 96, 25);
		contentPane.add(lblRodarFolha);
		
		
		JLabel label_2 = new JLabel(CalendarMT.getWeekDay());
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(22, 453, 96, 25);
		contentPane.add(label_2); 
		
		CalendarMT.clock(lblNewLabel, label, label_2, teste);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setIcon(new ImageIcon(MainView.class.getResource("/com/payroll/icons/ca28g-fpnyu.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalendarMT.timeChange(teste);
			}
		});
		btnNewButton.setBounds(145, 422, 55, 40);
		contentPane.add(btnNewButton);
		
}
}
