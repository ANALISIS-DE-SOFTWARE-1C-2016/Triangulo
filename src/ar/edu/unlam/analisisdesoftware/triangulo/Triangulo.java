package ar.edu.unlam.analisisdesoftware.triangulo;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Window.Type;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Triangulo {

	private JFrame frame;
	private String Result = "?";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Triangulo window = new Triangulo();
					window.frame.setTitle("Triangulo");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Triangulo() {
		initialize();
	}

	/**
	 * Initialize the content.
	 */
	private void initialize() {
		frame = new JFrame();		
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0x009688));
		panel.setBounds(0, 20, 335, 75);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("Triangulo");
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(12, 13, 152, 37);
		label.setFont(new Font("SansSerif", Font.BOLD, 28));
		panel.add(label);
		
		Panel panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 95, 335, 237);
		frame.getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("Lado 1");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		label_1.setBounds(22, 23, 62, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("Lado 2");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		label_2.setBounds(22, 52, 62, 16);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Lado 3");
		label_3.setFont(new Font("SansSerif", Font.PLAIN, 16));
		label_3.setBounds(22, 81, 62, 16);
		panel_1.add(label_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("SansSerif", Font.PLAIN, 16));
		spinner.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinner.setBounds(96, 21, 194, 22);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("SansSerif", Font.PLAIN, 16));
		spinner_1.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinner_1.setBounds(96, 50, 194, 22);
		panel_1.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setFont(new Font("SansSerif", Font.PLAIN, 16));
		spinner_2.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		spinner_2.setBounds(96, 79, 194, 22);
		panel_1.add(spinner_2);
		
		JLabel lblTipoDeTriangulo = new JLabel("El triangulo es");
		lblTipoDeTriangulo.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblTipoDeTriangulo.setBounds(22, 135, 123, 19);
		panel_1.add(lblTipoDeTriangulo);
		
		JLabel lblEquilatero = new JLabel(Result);
		lblEquilatero.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquilatero.setForeground(new Color(0x009688));
		lblEquilatero.setFont(new Font("SansSerif", Font.BOLD, 28));
		lblEquilatero.setBounds(22, 175, 268, 37);
		panel_1.add(lblEquilatero);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(0, 121, 107));
		panel_2.setBounds(0, 0, 335, 20);
		frame.getContentPane().add(panel_2);
	
		// Dimensiono la ventana
		frame.setBounds(new Rectangle(0, 0, 320, 480));
		// la centro segun la resolucion del monitor.
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int ScreenWidth = gd.getDisplayMode().getWidth();
		int ScreenHeight = gd.getDisplayMode().getHeight();
		frame.setBounds((ScreenWidth-frame.getWidth())/2, (ScreenHeight-frame.getHeight())/2, 314, 360);
		
		// Suscribo a los eventos
		class SpinnerChangeListener implements ChangeListener {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				Integer lado1 = (Integer)spinner.getValue();
				Integer lado2 = (Integer)spinner_1.getValue();
				Integer lado3 = (Integer)spinner_2.getValue();
				if ((lado1 > 0)  && (lado2 > 0)  && (lado3 > 0))  {	
					
					if ((lado1 == lado2) && (lado2 == lado3)) {
						Result = "EQUILATERO";
					} else if ((lado1 == lado2) || (lado2 == lado3) || (lado3 == lado1)) {
						Result = "ISOSCELES";
					} else {
						Result = "ESCALENO";
					}
				}
				lblEquilatero.setText(Result);
			}
		}
		spinner.addChangeListener(new SpinnerChangeListener());
		spinner_1.addChangeListener(new SpinnerChangeListener());
		spinner_2.addChangeListener(new SpinnerChangeListener());
	}
}

