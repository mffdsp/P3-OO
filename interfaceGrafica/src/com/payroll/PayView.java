package com.payroll;

import java.awt.Color;
import java.awt.Font;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.border.CompoundBorder;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ListSelectionModel;

public class PayView extends JFrame {

		private JPanel contentPane;
		int mode = 1;
	
	public PayView(DefaultListModel DLMA, DefaultListModel DLMC,  DefaultListModel DLMH, Funcionario[] func) {
		
		setForeground(Color.WHITE);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Lista de funcionários pagos hoje");
		setBounds(100, 100, 546, 342);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewClass.class.getResource("/com/payroll/icons/APPICON.png")));
		getContentPane().setBackground(SystemColor.inactiveCaption);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setLocation(width/2-getSize().width/2, height/2-getSize().height/2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 11, 385, 244);
		contentPane.add(scrollPane);
		

		JList hlist = new JList();
		scrollPane.setViewportView(hlist);
		hlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		hlist.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hlist.setForeground(Color.BLACK);
		hlist.setBackground(Color.WHITE);
		hlist.setBorder(new CompoundBorder());
		hlist.setSelectedIndices(new int[] {2});
		hlist.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		Command.saveS(func);
		JList list_1 = new JList();
		list_1.setBounds(135, 11, -128, 232);
		list_1.setBorder(null);
		contentPane.add(list_1);
		hlist.setModel(DLMH);
		JButton btnNewButton = new JButton("Horistas");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		btnNewButton.setIcon(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mode = 1;
				hlist.setModel(DLMH);
			}
		}); 
		btnNewButton.setBounds(10, 11, 115, 59);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Comissionados");
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 2;
				hlist.setModel(DLMC);
			}
		});
		button.setBounds(10, 196, 115, 59);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Assalariados");
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mode = 3;
				hlist.setModel(DLMA);
			}
		});
		button_1.setBorder(null);
		button_1.setBounds(10, 102, 115, 59);
		contentPane.add(button_1);
		
		//Find func
		JButton btnDetalhar = new JButton("Detalhar");
		btnDetalhar.setToolTipText("Clique para detalhar o pagamento");
		btnDetalhar.setBounds(431, 266, 89, 31);
		contentPane.add(btnDetalhar);
		btnDetalhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int achou = 0;
				try{
					if(hlist.getSelectedIndex() == -1) {
						throw new Exception("Necessário selecionar uma opção");
					}
				}catch(Exception eop) {
					System.err.println(eop);
					return;
				}
				for(int i = 0; i < 50; i++) {
					switch (mode){
					case 1:
						if(func[i] instanceof Horista && !hlist.getSelectedValue().toString().equals("Lista Vazia")) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i]).setVisible(true);
							}
							achou += 1;
						}
						break;
					case 2:
						if(func[i] instanceof Comissionado  ) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i]).setVisible(true);	
							}
							achou += 1;
						}
						break;
					case 3:
						if(func[i] instanceof Assalariado) {
							if(hlist.getSelectedIndex() == achou) {
								new DetailView(func[i]).setVisible(true);
							}
							achou += 1;
						}
						break;
				}	
			}
		}});
		
	}
}
