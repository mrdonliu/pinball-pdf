import javax.swing.JFrame;

public class Gui {
	
	private JFrame frame;
	
	public Gui(){
		
		frame = new JFrame();
		frame.setTitle("Pinball simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(Simulation.getDisplay());

	}

}
