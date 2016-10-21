import java.awt.EventQueue;

import javax.swing.JFrame;


/**
 * This class initializes the user interface. 
 * Inside the main method, Simulation class is create.
 * Simulation is then started.
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
				Simulation s = new Simulation(200);
				s.start();
			}
			
		});
	}

}
