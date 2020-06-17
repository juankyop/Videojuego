package juego;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class MiJuego extends JFrame {

	JPanel panel;
	private JPanel contentPane;
	static Link player;
	Broncas broncas;
	Topo topo;
	public Clip sonido;
	boolean partida=false;
	JLabel lblNewLabel;
	private JLabel lblNewLabel_4;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				}
			}
		);	
	}

	/**
	 * Create the frame.
	 */
	public MiJuego() {
		
		setTitle("Mini Juego");
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				System.out.println("x-->"+player.CoordX()+", y-->"+player.CoordY());
				System.out.println(panel.getHeight());
				
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if (player.CoordX()>0) {
						player.setCoordX(player.CoordX()-10);
						player.setDireccion("src/juego/imagenes/izquierda.png");;
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (player.CoordX()<(panel.getWidth()-280)) {
						player.setCoordX(player.CoordX()+10);
						player.setDireccion("src/juego/imagenes/derecha.png");;
					}
					break;
				case KeyEvent.VK_UP:
					if (player.CoordY()>0) {
						player.setCoordY(player.CoordY()-10);
						player.setDireccion("src/juego/imagenes/Arriba.png");;
					}
					break;
				case KeyEvent.VK_DOWN:
					if (player.CoordY()<(panel.getWidth()-330)) {
						player.setCoordY(player.CoordY()+10);
						player.setDireccion("src/juego/imagenes/Abajo.png");;
					}
					break;
				}
				
			}
			
		});
		
		Timer reloj = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				broncas.getPanel().update(panel.getGraphics());
				player.getPanel().update(panel.getGraphics());
				topo.getPanel().update(panel.getGraphics());
				System.out.println("x-->"+topo.CoordX()+", y-->"+topo.CoordY());
				ImageIcon MiImagen=new ImageIcon(player.getDireccion());
				panel.getGraphics().drawImage(MiImagen.getImage(), player.CoordX(), player.CoordY(), panel);
				topo.movimientoTopo();
				broncas.movimientoBroncas();
				ImageIcon ImagenBroncas=new ImageIcon(broncas.getDireccion());
				panel.getGraphics().drawImage(ImagenBroncas.getImage(), broncas.CoordX(), broncas.CoordY(), panel);
				
				ImageIcon ImagenTopo = new ImageIcon(topo.getDireccion());
				panel.getGraphics().drawImage(ImagenTopo.getImage(), topo.CoordX(), topo.CoordY(), panel);
				
				if (collision()) {
					player.restarSalud();
					lblNewLabel.setText("Salud: "+String.valueOf(player.getSalud()));
				}
				if (player.getSalud()>250) {
					lblNewLabel_4.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/tres.png")));
				}
				if (player.getSalud()<=250&&player.getSalud()>200) {
					lblNewLabel_4.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/dosymedio.png")));
				}
				if (player.getSalud()<=200&&player.getSalud()>150) {
					lblNewLabel_4.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/dos.png")));
				}
				if (player.getSalud()<=150&&player.getSalud()>100) {
					lblNewLabel_4.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/unoymedio.png")));
				}
				if (player.getSalud()<=100&&player.getSalud()>50) {
					lblNewLabel_4.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/uno.png")));
				}
				if (player.getSalud()==0) {
					perder frame = new perder();
					frame.setVisible(true);
					dispose();
				}
				
			}
		});
		
		reloj.restart();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(548, 0, 180, 452);
		panel.add(panel_1);
		
		//se pinta link
		player=new Link(panel, 300, 0, 0);
		//se pinta broncas
		broncas= new Broncas(panel, 80, 130);
		//se pinta topo
		topo = new Topo(panel, 290,120);
		
		lblNewLabel = new JLabel("Salud: "+player.getSalud());
		
		JLabel lblNewLabel_1 = new JLabel("Escudo: "+player.getEscudo());
		
		JLabel lblNewLabel_2 = new JLabel("Arma: "+player.getArma());
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/tres.png")));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_4, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(28)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(320, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/escenario.png")));
		lblNewLabel_3.setBounds(0, 0, 549, 456);
		panel.add(lblNewLabel_3);
		
	}
	boolean collision() {
		if (player.getBounds().intersects(broncas.getBounds()) || player.getBounds().intersects(topo.getBounds())){ 
			return true;
		}
		else
			return false;
		}
	}
	



