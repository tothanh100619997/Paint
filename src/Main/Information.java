/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author totha
 */
import java.awt.BorderLayout;
import java.awt.Dialog;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class Information extends JDialog {
	private final JPanel contentPane;
       
	public Information(String name,String infotext,int x, int y) {
		this.setTitle(name);
		this.setBounds(x, y, 250, 110);
		this.setVisible(true);
                this.setResizable(false);
                this.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
                this.setAlwaysOnTop(true);
                this.setIconImage(new ImageIcon("Image/infor.png").getImage());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(1, 1));
		this.setContentPane(contentPane);
		
		JEditorPane About = new JEditorPane();
		About.setEditable(false);
		About.setText(infotext);
		contentPane.add(About, BorderLayout.CENTER);

	}

}
