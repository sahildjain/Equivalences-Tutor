package gui;

public class InitialiseGui {
	
	public static void main(final String[] args){
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				final Gui gui = new Gui();
				gui.createGui(20);
			}
		});
	}
}