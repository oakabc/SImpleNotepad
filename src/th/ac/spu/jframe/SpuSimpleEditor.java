package th.ac.spu.jframe;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @WARAKORN PHROMJAK
 */
public class SpuSimpleEditor extends javax.swing.JFrame {

    private javax.swing.JMenu About;
    private javax.swing.JMenu File;
    private javax.swing.JTextArea editorText;
    private javax.swing.JLabel fileName;
    private javax.swing.JFileChooser jFileChooser;
    private javax.swing.JMenuBar jMenuApplcation;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;

    private static SpuSimpleEditor spuSimpleEditor;
    private static String currentFileName;
    private final String NEW_FILE = "NewFile.txt";

    public SpuSimpleEditor() {
        initComponents();
        setEditorNew();
    }

    private void initComponents() {

        jFileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorText = new javax.swing.JTextArea();
        fileName = new javax.swing.JLabel();
        jMenuApplcation = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuItem5 = new javax.swing.JMenuItem();
        About = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editorText.setColumns(20);
        editorText.setRows(5);
        editorText.setName("editorText");
        jScrollPane1.setViewportView(editorText);

        File.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openAction(evt);
            }
        });
        File.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("New");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAction(evt);
            }
        });
        File.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Save");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAction(evt);
            }
        });
        File.add(jMenuItem3);
        File.add(jSeparator1);

        jMenuItem5.setText("Exit");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitAction(evt);
            }
        });
        File.add(jMenuItem5);

        jMenuApplcation.add(File);

        About.setText("About");

        jMenuItem4.setText("Version");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                versionAction(evt);
            }
        });
        About.add(jMenuItem4);

        jMenuApplcation.add(About);

        setJMenuBar(jMenuApplcation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(401, Short.MAX_VALUE).addComponent(fileName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()).addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(fileName)));

        pack();
    }

    private void openAction(java.awt.event.ActionEvent evt) {
        try {
            System.out.println("Open");
            int selectApprove = jFileChooser.showOpenDialog(this);
            File fileOpen = jFileChooser.getSelectedFile();
            if (selectApprove == jFileChooser.APPROVE_OPTION) {
                currentFileName = fileOpen.getName();
                fileName.setText(currentFileName);
                editorText.read(new FileReader(fileOpen), null);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void newAction(java.awt.event.ActionEvent evt) {
        System.out.println("New");
        setEditorNew();
    }

    private void saveAction(java.awt.event.ActionEvent evt) {
        try {
            System.out.println("Save");
            int selectApprove = jFileChooser.showSaveDialog(this);
            File fileSave = jFileChooser.getSelectedFile();
            if (selectApprove == jFileChooser.APPROVE_OPTION) {
                currentFileName = fileSave.getName();
                fileName.setText(currentFileName);
                editorText.write(new FileWriter(fileSave));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void exitAction(java.awt.event.ActionEvent evt) {
        System.out.println("Exit");
        System.exit(0);
    }

    private void versionAction(java.awt.event.ActionEvent evt) {
        System.out.println("Version");
        AboutJDialog about = new AboutJDialog(this,true);
        about.setLocationRelativeTo(this);
        about.setVisible(true);
    }

    private void setEditorNew() {
        currentFileName = NEW_FILE;
        fileName.setText(currentFileName);
        editorText.setText(null);
    }

    public static void main(String args[]) {

        spuSimpleEditor = new SpuSimpleEditor();
        spuSimpleEditor.setVisible(true);

    }
}
