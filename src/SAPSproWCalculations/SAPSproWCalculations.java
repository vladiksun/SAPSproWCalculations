package SAPSproWCalculations;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SAPSproWCalculations {

	private JFrame frmSapsprowcalculator;
	private JTextField pathtextField;
	private JTextField TotalAreaTextField_1;
	private JTextField detailTextField_1;
	private JTextField scrapAreaTextField_1;
	private JTextField wasteAreaTextField_1;
	private JTextArea textArea;
	
	private JFileChooser filechooser = new JFileChooser();
	private ArrayList <String> myList = new ArrayList<String>();
	private File filesource;
	private JLabel dropLabel;
	private JLabel lblNewLabel;
	private JTextField cutLengthtextField;
	private JTextField pierceNumberTextField;
	private JTextField totalTimeTextField;
	private JTextField areaBeforetextField;
	private JTextField areaAftertextField;
	private JTextField areaCorrectionTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SAPSproWCalculations window = new SAPSproWCalculations();
					window.frmSapsprowcalculator.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SAPSproWCalculations() {
		setLookAndFeel();
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame - GUI
	 */
	private void initialize() {
		frmSapsprowcalculator = new JFrame();
		frmSapsprowcalculator.setTitle("SAPSproWCalculator demo");
		frmSapsprowcalculator.setFont(new Font("Dialog", Font.ITALIC, 12));
		frmSapsprowcalculator.setBounds(70, 100, 492, 621);
		frmSapsprowcalculator.setSize(new Dimension(850, 600));
		frmSapsprowcalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSapsprowcalculator.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOneTouchExpandable(true);
		frmSapsprowcalculator.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerLocation(450);
		splitPane_1.setOneTouchExpandable(true);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		dropLabel = new JLabel("");
		dropLabel.setBackground(Color.WHITE);
		dropLabel.setIcon(new ImageIcon(getClass().getResource("/images/DropBoxIcon.png")));
		dropLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dropLabel.setMinimumSize(new Dimension(50, 50));
		dropLabel.setPreferredSize(new Dimension(50, 50));
		dropLabel.setMaximumSize(new Dimension(50, 50));
		splitPane_1.setRightComponent(dropLabel);
		
		JPanel panel = new JPanel();
		panel.setSize(new Dimension (400,400));
		panel.setMinimumSize(new Dimension(400, 400));
		panel.setMaximumSize(new Dimension(500, 500));
		panel.setPreferredSize(new Dimension(400, 400));
		splitPane_1.setLeftComponent(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u041F\u0443\u0442\u044C \u043A \u0444\u0430\u0439\u043B\u0443 ECO", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		lblNewLabel = new JLabel("\u0420\u0430\u0441\u043A\u0440\u043E\u0439 \u2116");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("\u0423\u041F/\u041A\u041F", null, panel_2, null);
		
		JLabel label = new JLabel("\u041F\u043B\u043E\u0449\u0430\u0434\u044C \u0432\u0441\u0435\u0433\u043E, \u043A\u0432.\u043C\u043C (#32)");
		
		TotalAreaTextField_1 = new JTextField();
		TotalAreaTextField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u041F\u043B\u043E\u0449\u0430\u0434\u044C \u0434\u0435\u0442\u0430\u043B\u0435\u0439, \u043A\u0432.\u043C\u043C (#23)");
		
		detailTextField_1 = new JTextField();
		detailTextField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u041F\u043B\u043E\u0449\u0430\u0434\u044C \u043B\u043E\u043C\u0430, \u043A\u0432.\u043C\u043C (#25)");
		
		scrapAreaTextField_1 = new JTextField();
		scrapAreaTextField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u041F\u043B\u043E\u0449\u0430\u0434\u044C \u0443\u0433\u0430\u0440\u0430, \u043A\u0432.\u043C\u043C (#27)");
		
		wasteAreaTextField_1 = new JTextField();
		wasteAreaTextField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("\u041F\u0435\u0440\u0438\u043C\u0435\u0442\u0440 \u0440\u0435\u0437\u0430, \u043C\u043C (#9)");
		
		cutLengthtextField = new JTextField();
		cutLengthtextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u041F\u0440\u043E\u0431\u0438\u0432\u043E\u043A, \u0448\u0442 (#10)");
		
		pierceNumberTextField = new JTextField();
		pierceNumberTextField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u041E\u0431\u0449\u0435\u0435 \u0432\u0440\u0435\u043C\u044F, \u0447:\u043C\u043C:\u0441\u0441 (#31)");
		
		totalTimeTextField = new JTextField();
		totalTimeTextField.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(TotalAreaTextField_1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(label_2)
								.addComponent(label_3)
								.addComponent(label_4)
								.addComponent(label_5)
								.addComponent(label_6))
							.addGap(18)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
								.addComponent(scrapAreaTextField_1)
								.addComponent(detailTextField_1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
								.addComponent(wasteAreaTextField_1)
								.addComponent(cutLengthtextField)
								.addComponent(pierceNumberTextField)
								.addComponent(totalTimeTextField))))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(TotalAreaTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(detailTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrapAreaTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(wasteAreaTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(cutLengthtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(pierceNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("\u041A\u043E\u0440\u0440\u0435\u0446\u0438\u044F", null, panel_3, null);
		
		JLabel label_7 = new JLabel("\u041F\u043B\u043E\u0449\u0430\u0434\u044C \u043E\u0441\u0442\u0430\u0442\u043A\u0430 \u0414\u041E \u0432 \u043A\u0432.\u043C");
		
		areaBeforetextField = new JTextField();
		areaBeforetextField.setColumns(10);
		
		JLabel label_8 = new JLabel("\u041F\u043B\u043E\u0449\u0430\u0434\u044C \u043E\u0441\u0442\u0430\u0442\u043A\u0430 \u041F\u041E\u0421\u041B\u0415 \u0432 \u043A\u0432.\u043C");
		
		areaAftertextField = new JTextField();
		areaAftertextField.setColumns(10);
		
		JButton calculateButton = new JButton("\u0420\u0430\u0441\u0441\u0447\u0438\u0442\u0430\u0442\u044C");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (areaBeforetextField.getText().equals(""))
	                 JOptionPane.showMessageDialog(null,"Необходимо ввести площадь ДО", "Warning",JOptionPane.WARNING_MESSAGE);
	             
	            else if (areaAftertextField.getText().equals("")){
	                 JOptionPane.showMessageDialog(null,"Необходимо ввести площадь ПОСЛЕ", "Warning",JOptionPane.WARNING_MESSAGE);
	             }
	             
	            else {
	            	String tempBefore = areaBeforetextField.getText().replace(",", ".");
	            	String tempAfter = areaAftertextField.getText().replace(",", ".");
	            	BigDecimal correctionValue = (new BigDecimal(tempBefore).subtract(new BigDecimal(tempAfter))).multiply(Calc.bil);
	            	BigDecimal scaled = correctionValue.setScale(0, RoundingMode.HALF_UP);
	            	areaCorrectionTextField.setText(scaled.toString());
	             }
	            	 

			}
		});
		
		JLabel label_9 = new JLabel("\u041F\u043B\u043E\u0449\u0430\u0434\u044C \u043A\u043E\u0440\u0440\u0435\u043A\u0442\u0438\u0440\u043E\u0432\u043A\u0438 \u0432 \u043A\u0432. \u043C\u043C");
		
		areaCorrectionTextField = new JTextField();
		areaCorrectionTextField.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaBeforetextField.setText("");
				areaAftertextField.setText("");
				areaCorrectionTextField.setText("");
			}
			
		});
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(130)
							.addComponent(calculateButton))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(label_9)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(areaCorrectionTextField))
								.addGroup(gl_panel_3.createSequentialGroup()
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
										.addComponent(label_8)
										.addComponent(label_7))
									.addGap(18)
									.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING, false)
										.addComponent(areaAftertextField)
										.addComponent(areaBeforetextField, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnClear)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(areaBeforetextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_8)
						.addComponent(areaAftertextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(calculateButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9)
						.addComponent(areaCorrectionTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnClear)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("\u041F\u0435\u0440\u0435\u0441\u0447\u0435\u0442 ECO (\u0432 \u0440\u0430\u0437\u0440\u0430\u0431\u043E\u0442\u043A\u0435)", null, panel_4, null);
		
		JLabel label_10 = new JLabel("\u0424\u0443\u043D\u043A\u0446\u0438\u044F \u0432 \u0440\u0430\u0437\u0440\u0430\u0431\u043E\u0442\u043A\u0435");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(110)
					.addComponent(label_10)
					.addContainerGap(120, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(69)
					.addComponent(label_10)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		pathtextField = new JTextField();
		pathtextField.setColumns(10);	
		
		JButton browseButton = new JButton("\u041E\u0431\u0437\u043E\u0440");
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filechooser.updateUI();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".TXT file", "txt");
	             filechooser.setFileFilter(filter);
	             if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
	            	 
	                 filesource = filechooser.getSelectedFile();
	                 pathtextField.setText(filesource.getAbsolutePath());
	                 processing();

			}
		}});
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addComponent(pathtextField, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(browseButton)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(pathtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(browseButton))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Consolas", Font.PLAIN, 12));
		textArea.setBackground(Color.WHITE);
		textArea.setMargin(new Insets(10,10,10,10));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		// Create FileDrop object for handling D&D onto label
		
		new FileDrop( System.out, dropLabel, /*dragBorder,*/ new FileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {   try
                    {   
                		filesource = new File(files[i].getCanonicalPath());
                		pathtextField.setText(filesource.getAbsolutePath());
                		
                		processing();
                		
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
	}
	
	/**
	 * Setup the look and feel
	 */
	private void setLookAndFeel(){
		try {
            // Set Windows  L&F 
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		} 
		catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
       // handle exception
		}

	}
	
	
	class PopClickListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    public void mouseReleased(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    private void doPop(MouseEvent e){
	    	CopyPopUpMenu menu = new CopyPopUpMenu();
	        menu.show(e.getComponent(), e.getX(), e.getY());
	    }
	}
	
	private void processing(){
		
		// Запись массива
		Calc.fillArrayList(myList, filesource);
		
		//Проверка формата файла ECO
		
		if (!myList.get(0).startsWith("#1"))
			JOptionPane.showMessageDialog(null,"Файл не соответсвует формату файла ECO", "Warning",JOptionPane.WARNING_MESSAGE);
		else {
			Calc.fillLabel(myList, lblNewLabel, "Роскрой № ");
			
			Calc.setContentToJTextArea(myList, textArea);
			
			Calc.fillTotalArea(myList, TotalAreaTextField_1);
			
			Calc.fillDetailArea(myList, detailTextField_1);
			
			Calc.fillScrapArea(myList, scrapAreaTextField_1);
			
			Calc.fillWasteArea(myList, wasteAreaTextField_1);
			
			Calc.fillCutLength(myList, cutLengthtextField);
			
			Calc.fillPierceNumber(myList, pierceNumberTextField);
			
			Calc.setTotalTime(myList, totalTimeTextField);
		}
		
		
		
		
	}
}


