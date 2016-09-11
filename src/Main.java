import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("pinball simulation");
		frame.setSize(800, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		//frame.setLocation(900, 250);
		
		circleComponent circle = new circleComponent();
		frame.add(circle);

	}

}
