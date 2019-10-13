package controllers;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import views.Notepad;

public class FilePanel {

    Notepad npd;

    public boolean saved;
    boolean newFileFlag;
    String fileName;
    String applicationTitle = "Notepad <3";

    File fileRef;
    JFileChooser chooser;
/////////////////////////////  

    boolean isSave() {
        return saved;
    }

    void setSave(boolean saved) {
        this.saved = saved;
    }

    String getFileName() {
        return new String(fileName);
    }

    void setFileName(String fileName) {
        this.fileName = new String(fileName);
    }
/////////////////////////  

    public FilePanel(Notepad npd) {
        this.npd = npd;

        saved = true;
        newFileFlag = true;
        fileName = new String("Untitled");
        fileRef = new File(fileName);
        this.npd.setTitle(fileName + " - " + applicationTitle);

        chooser = new JFileChooser();

        chooser.addChoosableFileFilter(new FileTypeFilter(".java", "Java Source Files(*.java)"));
        chooser.addChoosableFileFilter(new FileTypeFilter(".txt", "Text Files(*.txt)"));
        chooser.addChoosableFileFilter(new FileTypeFilter(".html", "Hyper Text Markup Language File(*.html)"));
        chooser.setCurrentDirectory(new File("."));

    }
//////////////////////////////////////  

    public boolean saveFile(File temp) {
        FileWriter fout = null;
        try {
            fout = new FileWriter(temp);
            fout.write(npd.taTemp.getText());
        } catch (IOException ioe) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                fout.close();
            } catch (IOException excp) {
                excp.printStackTrace();
            }
        }
        updateStatus(temp, true);
        return true;
    }
////////////////////////  

    public boolean saveThisFile() {
        if (!newFileFlag) {
            return saveFile(fileRef);
        }
        return saveAsFile();
    }

////////////////////////////////////  
    public boolean saveAsFile() {
        File temp = null;
        chooser.setDialogTitle("Save As...");
        chooser.setApproveButtonText("Save Now");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_S);
        chooser.setApproveButtonToolTipText("Click me to save!");

        do {
            if (chooser.showSaveDialog(this.npd) != JFileChooser.APPROVE_OPTION) {
                return false;
            }
            temp = chooser.getSelectedFile();
            if (!temp.exists()) {
                break;
            }
            if (JOptionPane.showConfirmDialog(
                    this.npd, "<html>" + temp.getPath() + " already exists.<br>Do you want to replace it?<html>",
                    "Save As", JOptionPane.YES_NO_OPTION
            ) == JOptionPane.YES_OPTION) {
                break;
            }
        } while (true);

        return saveFile(temp);
    }

////////////////////////  
    public boolean openFile(File temp) {
        FileInputStream fin = null;
        BufferedReader din = null;

        try {
            fin = new FileInputStream(temp);
            din = new BufferedReader(new InputStreamReader(fin));
            String str = " ";
            while (str != null) {
                str = din.readLine();
                if (str == null) {
                    break;
                }
                npd.taTemp.append(str + "\n");
            }

        } catch (IOException ioe) {
            updateStatus(temp, false);
            return false;
        } finally {
            try {
                din.close();
                fin.close();
            } catch (IOException excp) {
                excp.printStackTrace();
            }
        }
        updateStatus(temp, true);
        npd.taTemp.setCaretPosition(0);
        return true;
    }
///////////////////////  

    public void openFile() {
        if (!confirmSave()) {
            return;
        }
        chooser.setDialogTitle("Open File...");
        chooser.setApproveButtonText("Open this");
        chooser.setApproveButtonMnemonic(KeyEvent.VK_O);
        chooser.setApproveButtonToolTipText("Click me to open the selected file.!");

        File temp = null;
        do {
            if (chooser.showOpenDialog(this.npd) != JFileChooser.APPROVE_OPTION) {
                return;
            }
            temp = chooser.getSelectedFile();

            if (temp.exists()) {
                break;
            }

            JOptionPane.showMessageDialog(this.npd,
                    "<html>" + temp.getName() + "<br>file not found.<br>"
                    + "Please verify the correct file name was given.<html>",
                    "Open", JOptionPane.INFORMATION_MESSAGE);

        } while (true);

        npd.taTemp.setText("");

        if (!openFile(temp)) {
            fileName = "Untitled";
            saved = true;
            this.npd.setTitle(fileName + " - " + applicationTitle);
        }
        if (!temp.canWrite()) {
            newFileFlag = true;

        }
    }

    void updateStatus(File temp, boolean saved) {
        if (saved) {
            this.saved = true;
            fileName = new String(temp.getName());
            if (!temp.canWrite()) {
                newFileFlag = true;
            }
            fileRef = temp;
            newFileFlag = false;
        }
    }

    public boolean confirmSave() {
        String strMsg = "<html>The text in the " + fileName + " file has been changed.<br>"
                + "Do you want to save the changes?<html>";
        if (!saved) {
            int x = JOptionPane.showConfirmDialog(this.npd, strMsg, applicationTitle,
                    JOptionPane.YES_NO_CANCEL_OPTION);

            if (x == JOptionPane.CANCEL_OPTION) {
                return false;
            }
            if (x == JOptionPane.YES_OPTION && !saveAsFile()) {
                return false;
            }
        }
        return true;
    }

    public void newFile() {
        if (!confirmSave()) {
            return;
        }

        npd.taTemp.setText("");
        fileName = new String("Untitled");
        fileRef = new File(fileName);
        saved = true;
        newFileFlag = true;
        this.npd.setTitle(fileName + " - " + applicationTitle);
    }

    public void exitNote() {
        if (!confirmSave()) {
            return;
        }
        System.exit(0);
    }
}
