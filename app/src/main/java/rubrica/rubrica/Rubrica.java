package rubrica;

import javax.swing.SwingUtilities;

import view.LoginGUI;

public class Rubrica {

    public static void main(String[] args) {

      
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LoginGUI gui = new LoginGUI();
                gui.show();
            }
        });  

}
}
