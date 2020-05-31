package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Principal extends JFrame {

	private JPanel contentPane;

	public static Clip sonido;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					sonido= AudioSystem.getClip();
		            sonido.open(AudioSystem.getAudioInputStream(new File("src/juego/imagenes/intro.wav")));
		            sonido.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/juego/imagenes/LogoBueno.png")));
		setTitle("Zelda Juan Carlos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(15, 16, 200, 82);
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/ZeldaLogo.png")));
		
		JButton btnJugar = new JButton("");
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					MiJuego frame = new MiJuego();
					frame.setVisible(true);
					dispose();
					sonido.stop();
					sonido= AudioSystem.getClip();
		            sonido.open(AudioSystem.getAudioInputStream(new File("src/juego/imagenes/partida.wav")));
		            sonido.start();
		            
		            
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnJugar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJugar.setBounds(10, 200, 141, 47);
		btnJugar.setBackground(Color.WHITE);
		btnJugar.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/jugar.png")));
		btnJugar.setOpaque(false);;
		btnJugar.setBorderPainted(false);
		btnJugar.setContentAreaFilled(false);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(15, 104, 200, 47);
		lblNewLabel_2.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/vegamedia.png")));
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel_2);
		contentPane.add(btnJugar);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_3.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/portada.gif")));
		lblNewLabel_3.setBounds(0, 0, 465, 442);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JLabel label = new JLabel("New label");
	
	}
}
