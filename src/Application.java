import java.awt.EventQueue;

import javax.swing.JFrame;


/**
 * This class sets up the graphical interface. 
 * @author don
 *
 */
public class Application extends JFrame{
	
	public Application(){ initUI();}
	
	public void initUI(){ Gui gui = new Gui(); } 

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Application a = new Application();
				Simulation s = new Simulation(100);
				s.start();
			}
			
		});
	}

}
