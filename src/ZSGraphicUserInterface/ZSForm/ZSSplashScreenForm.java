package ZSGraphicUserInterface.ZSForm;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;

import ZSGraphicUserInterface.ZSIAStyle;

public class ZSSplashScreenForm {
    private static JFrame zsFrmSplash;
    private static JProgressBar zsPgbLoading;
    private static ImageIcon zsIcoImagen;
    private static JLabel zsLblSplash;

    public static void show(){
        zsIcoImagen = new ImageIcon(ZSIAStyle.ZSURL_SPLASH);
        zsLblSplash = new JLabel(zsIcoImagen);
        zsPgbLoading = new JProgressBar(0,100);

        zsPgbLoading.setStringPainted(true);

        zsFrmSplash = new JFrame();
        zsFrmSplash.setUndecorated(true);
        zsFrmSplash.getContentPane().add(zsLblSplash, BorderLayout.CENTER);
        zsFrmSplash.add(zsPgbLoading, BorderLayout.SOUTH);
        zsFrmSplash.setSize(zsIcoImagen.getIconWidth(), zsIcoImagen.getIconHeight());
        zsFrmSplash.setLocationRelativeTo(null); // Centrar en la pantalla

        zsFrmSplash.setVisible(true);
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); // Espera por 50 milisegundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            zsPgbLoading.setValue(i);
        }

        zsFrmSplash.setVisible(false);
    }

}
