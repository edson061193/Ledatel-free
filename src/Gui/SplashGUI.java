package Gui;

import Log.underSplash;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class SplashGUI
        extends JFrame {

    private SplashGUI splashGUI = this;
    ImageIcon imagen = new ImageIcon();
    JLabel jLabel2;
    JScrollPane jScrollPane1;
    JLabel lblLogin;
    JProgressBar progLogin;

    public SplashGUI() {
        new underSplash().transparencia(this);
        initComponents();
        setLocationRelativeTo(this);
        starThread();
        mustarCarga();
        pack();
        this.progLogin.setVisible(false);
    }

    private void starThread() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                LogeoGUI gui = new LogeoGUI(SplashGUI.this.splashGUI);
                gui.setVisible(true);
                gui.setLocationRelativeTo(null);
                SplashGUI.this.dispose();
            }
        });
        thread.start();
    }

    public JProgressBar getProgressBar() {
        return this.progLogin;
    }

    public JLabel getLabel() {
        return this.lblLogin;
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
        }
        new SplashGUI().setVisible(true);
    }

    private void initComponents() {
        this.progLogin = new JProgressBar();
        this.lblLogin = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.jLabel2 = new JLabel();
        setDefaultCloseOperation(3);
        setFocusCycleRoot(false);
        setFocusable(false);
        setFocusableWindowState(false);
        setIconImage(new ImageIcon(getClass().getResource("/Fondos/ld.png")).getImage());
        setIconImages(null);
        setType(Window.Type.POPUP);
        addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent evt) {
                SplashGUI.this.formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(new AbsoluteLayout());
        this.progLogin.setBackground(new Color(255, 255, 204));
        this.progLogin.setFont(new Font("sansserif", 1, 12));
        this.progLogin.setAutoscrolls(true);
        this.progLogin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(0, 0, 0))));
        this.progLogin.setOpaque(true);
        this.progLogin.setStringPainted(true);
        getContentPane().add(this.progLogin, new AbsoluteConstraints(150, 370, 310, 20));
        this.lblLogin.setFont(new Font("Ebrima", 0, 14));
        this.lblLogin.setForeground(new Color(255, 255, 255));
        this.lblLogin.setText("cargando...");
        getContentPane().add(this.lblLogin, new AbsoluteConstraints(160, 280, 300, -1));
        getContentPane().add(this.jScrollPane1, new AbsoluteConstraints(40, 340, -1, -1));
        this.jLabel2.setIcon(new ImageIcon(getClass().getResource("/Fondos/ld_1.png")));
        getContentPane().add(this.jLabel2, new AbsoluteConstraints(0, 0, 640, 480));
        getAccessibleContext().setAccessibleParent(this);
        pack();
    }

    private void formWindowStateChanged(WindowEvent evt) {
    }

    private void mustarCarga() {
        progreso().setBackground(new Color(153, 255, 0));
        progreso().setForeground(new Color(0, 0, 0));
        progreso().setStringPainted(true);
    }

    public JProgressBar progreso() {
        return this.progLogin;
    }
}
