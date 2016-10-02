import java.awt.EventQueue;

import javax.swing.JFrame;

public class Application extends JFrame{
	
	public Application(){
		initUI();
	}
	
	public void initUI(){
		
		setTitle("Pinball simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setVisible(true);
		circleComponent circle = new circleComponent();
		add(circle);
		for( int i = 0 ; i < 10 ; i++ ){
			circle.move();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Application ex = new Application();
			}
		
		
	});
		

	}

}
