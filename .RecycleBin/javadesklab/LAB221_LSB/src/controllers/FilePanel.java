
package controllers;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import views.LSBDecryptView;
import views.LSBEncryptView;

public class FilePanel {

    LSBEncryptView npd1;
    LSBDecryptView npd2;
    boolean newFileFlag;
    BufferedImage img;
    public boolean saved;
    String fileName;
    String applicationTitle = "<3";
    private String originalPath;
    File fileRef;
    JFileChooser chooser;

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public FilePanel(LSBEncryptView npd1) {
        this.npd1 = npd1;

        saved = true;
        newFileFlag = true;
        fileName = "Encrypt LSB";
        fileRef = new File(fileName);
        this.npd1.setTitle(fileName + " - " + applicationTitle);

        chooser = new JFileChooser();

        chooser.addChoosableFileFilter(new FileTypeFilter(".bmp", "bitmap image file(*.bmp)"));
        chooser.addChoosableFileFilter(new FileTypeFilter(".jpg", "Joint Photographic Experts Group(*.jpg)"));
        chooser.addChoosableFileFilter(new FileTypeFilter(".gif", "Graphics Interchange Format(*.gif)"));
        chooser.addChoosableFileFilter(new FileTypeFilter(".png", "Portable Network Graphics (*.png)"));
        chooser.setCurrentDirectory(new File("."));
    }

    public FilePanel(LSBDecryptView npd2) {
        this.npd2 = npd2;

        saved = true;
        newFileFlag = true;
        fileName = "Decrypt LSB";
        fileRef = new File(fileName);
        this.npd2.setTitle(fileName + " - " + applicationTitle);

        chooser = new JFileChooser();

        chooser.addChoosableFileFilter(new FileTypeFilter(".bmp", "bitmap image file(*.bmp)"));
        chooser.addChoosableFileFilter(new FileTypeFilter(".jpg", "Joint Photographic Experts Group(*.jpg)"));
        chooser.addChoosableFileFilter(new FileTypeFilter(".gif", "Graphics Interchange Format(*.gif)"));
        chooser.addChoosableFileFilter(new FileTypeFilter(".png", "Portable Network Graphics (*.png)"));
        chooser.setCurrentDirectory(new File("."));
    }

    public void openImage() {

        chooser.setDialogTitle("Open File...");
        chooser.setApproveButtonText("Open this");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_O);
        chooser.setApproveButtonToolTipText("Click me to open the selected file.!");

        File temp = null;
        do {
            if (chooser.showOpenDialog(this.npd1) != JFileChooser.APPROVE_OPTION) {
                return;
            }
            temp = chooser.getSelectedFile();

            if (temp.exists()) {
                break;
            }

            JOptionPane.showMessageDialog(this.npd1,
                    "<html>" + temp.getName() + "<br>file not found.<br>"
                    + "Please verify the correct file name was given.<html>",
                    "Open", JOptionPane.INFORMATION_MESSAGE);

        } while (true);
        originalPath = temp.getAbsolutePath();
        openImage(temp);
    }

    public boolean openImage(File temp) {
        try {
            img = ImageIO.read(temp);
            ImageIcon icon = null;
            try {
                icon = new ImageIcon(img);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Cannot open file!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            if (npd1 != null) {
                npd1.jlOriImgTemp.setIcon(icon);
            } else {
                npd2.jlSteImgTemp.setIcon(icon);
            }
        } catch (IOException ex) {
        }
        return true;
    }

    public boolean showStegoImg() {
        try {
            ImageIcon icon = new ImageIcon(img);
            npd1.jlSteImgTemp.setIcon(icon);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "There is no stego image!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

    public boolean saveImageAs() {
        File temp = null;
        chooser.setDialogTitle("Save As...");
        chooser.setApproveButtonText("Save Now");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_S);
        chooser.setApproveButtonToolTipText("Click me to save!");

        do {
            if (chooser.showSaveDialog(this.npd1) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();
            if (!temp.exists()) {
                break;
            }
            if (JOptionPane.showConfirmDialog(
                    this.npd1, "<html>" + temp.getPath() + " already exists.<br>Do you want to replace it?<html>",
                    "Save As", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                break;
            }
        } while (true);
        saveImage(temp);
        return true;
    }

    public boolean saveImage(File temp) {
        try {
            ImageIO.write(img, "png", temp);
        } catch (IOException ex) {
            Logger.getLogger(FilePanel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
