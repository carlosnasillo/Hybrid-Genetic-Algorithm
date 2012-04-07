/* 
+++
    Copyright (C) 2012 Carlos Nasillo / me@carlosnasillo.com.
    
    Permission is hereby granted, free of charge, to any person obtaining a copy of 
    this software and associated documentation files (the "Software"), to deal in the 
    Software without restriction, including without limitation the rights to use, copy,
    modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
    and to permit persons to whom the Software is furnished to do so, subject to the 
    following conditions:
    
    The above copyright notice and this permission notice shall be included in all copies
    or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
    INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
    PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
    FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR 
    OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
    DEALINGS IN THE SOFTWARE.
---
*/

package project_clean;


import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;


public class Main extends javax.swing.JFrame{
//..............................................................................  
    Parser parser = new Parser();
    Tokenizer tokenize = new Tokenizer();
    LCS lcs = new LCS();
    Grader grade = new Grader();
    Population population;
    Random random = new Random();
//..............................................................................  
    ArrayList <VirusData> virusDB = new ArrayList<VirusData>();
    protected String[] suspectFileTokens;
//..............................................................................  
    Exception error;
    private String selectedFileName;
    private String selectedDBname;
    private int nMatches = 0;
    private boolean isGA = false;
//..............................................................................  
    Icon sucess = new javax.swing.ImageIcon(getClass()
                                    .getResource("/project_clean/success.png"));
    Icon failure = new javax.swing.ImageIcon(getClass()
                                    .getResource("/project_clean/failure.png"));
//..............................................................................  
    protected int tLength;
    protected int maxZeros;
    protected int maxGenerations;
    protected int poolSize;
    protected double crossoverRate;
    protected double mutationRate;
    protected boolean useElitism;
    protected boolean useMultCross;
    protected boolean useMultMut;
    protected boolean gaCheckSubsequence;
    protected boolean gaCheckSubstring;
//..............................................................................


//------------------------------------------------------------------------------
    public Main() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
        }
        initComponents();
        getSettingsToVariables();
    }

//------------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup_checkType = new javax.swing.ButtonGroup();
        label_programTitle = new javax.swing.JLabel();
        radio_checkString = new javax.swing.JRadioButton();
        radio_checkFile = new javax.swing.JRadioButton();
        button_enterSuspect = new javax.swing.JButton();
        label_suspect = new javax.swing.JTextField();
        img_selectSuspect = new javax.swing.JLabel();
        button_selectDabatase = new javax.swing.JButton();
        label_databasePath = new javax.swing.JTextField();
        img_selectDB = new javax.swing.JLabel();
        button_scan = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        label_consoleTitle = new javax.swing.JLabel();
        scrollPane_log = new javax.swing.JScrollPane();
        console = new javax.swing.JTextArea();
        button_forceGA = new javax.swing.JButton();
        label_tableTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        separator_Vertical = new javax.swing.JSeparator();
        label_programSettings = new javax.swing.JLabel();
        label_tokenLength = new javax.swing.JLabel();
        slider_tokenLength = new javax.swing.JSlider();
        text_tokenLength = new javax.swing.JTextField();
        label_maxZeros = new javax.swing.JLabel();
        slider_maxZeros = new javax.swing.JSlider();
        text_maxZeros = new javax.swing.JTextField();
        separator_Horizontal_1 = new javax.swing.JSeparator();
        label_GA_Settings = new javax.swing.JLabel();
        label_maxGenerations = new javax.swing.JLabel();
        slider_maxGenerations = new javax.swing.JSlider();
        text_maxGenerations = new javax.swing.JTextField();
        label_populationSize = new javax.swing.JLabel();
        slider_populationSize = new javax.swing.JSlider();
        text_populationSize = new javax.swing.JTextField();
        label_crossoverRate = new javax.swing.JLabel();
        slider_crossoverRate = new javax.swing.JSlider();
        text_crossoverRate = new javax.swing.JTextField();
        label_mutationRate = new javax.swing.JLabel();
        slider_mutationRate = new javax.swing.JSlider();
        text_mutationRate = new javax.swing.JTextField();
        checkBox_elitism = new javax.swing.JCheckBox();
        checkBox_mutation = new javax.swing.JCheckBox();
        checkBox_crossover = new javax.swing.JCheckBox();
        checkBox_subsequence = new javax.swing.JCheckBox();
        checkBox_substring = new javax.swing.JCheckBox();
        separator_Horizontal_2 = new javax.swing.JSeparator();
        label_maxFitness = new javax.swing.JLabel();
        text_maxFitness = new javax.swing.JTextField();
        label_generation = new javax.swing.JLabel();
        text_generation = new javax.swing.JTextField();
        separator_Horizontal_3 = new javax.swing.JSeparator();
        text_bestChromosome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BSc Computing Project - Carlos Nasillo");
        setMinimumSize(new java.awt.Dimension(855, 595));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_programTitle.setFont(new java.awt.Font("Tahoma", 1, 14));
        label_programTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_programTitle.setText("Polymorphic Virus Detector");
        getContentPane().add(label_programTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 470, -1));

        radioGroup_checkType.add(radio_checkString);
        radio_checkString.setText("Check a suspect String");
        radio_checkString.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_checkStringMouseClicked(evt);
            }
        });
        getContentPane().add(radio_checkString, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 46, 150, -1));

        radioGroup_checkType.add(radio_checkFile);
        radio_checkFile.setText("Check a suspicious File");
        radio_checkFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                radio_checkFileMouseClicked(evt);
            }
        });
        getContentPane().add(radio_checkFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 72, 150, -1));

        button_enterSuspect.setText("Select an option");
        button_enterSuspect.setEnabled(false);
        button_enterSuspect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_enterSuspectMouseClicked(evt);
            }
        });
        getContentPane().add(button_enterSuspect, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 108, 111, -1));

        label_suspect.setEditable(false);
        label_suspect.setEnabled(false);
        label_suspect.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                label_suspectFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                label_suspectFocusLost(evt);
            }
        });
        getContentPane().add(label_suspect, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 108, 300, 22));

        img_selectSuspect.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        img_selectSuspect.setFocusable(false);
        img_selectSuspect.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(img_selectSuspect, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 26, 29));

        button_selectDabatase.setText("Select Database");
        button_selectDabatase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_selectDabataseMouseClicked(evt);
            }
        });
        getContentPane().add(button_selectDabatase, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        label_databasePath.setEditable(false);
        label_databasePath.setText("Database Name");
        label_databasePath.setEnabled(false);
        getContentPane().add(label_databasePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 150, 300, 22));

        img_selectDB.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        img_selectDB.setFocusable(false);
        img_selectDB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(img_selectDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 26, 29));

        button_scan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button_scan.setText("Start Scan");
        button_scan.setBorderPainted(false);
        button_scan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_scanMouseClicked(evt);
            }
        });
        getContentPane().add(button_scan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 470, 30));

        progressBar.setForeground(new java.awt.Color(0, 153, 255));
        progressBar.setFocusable(false);
        progressBar.setStringPainted(true);
        getContentPane().add(progressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 231, 470, -1));

        label_consoleTitle.setText("Program Log");
        getContentPane().add(label_consoleTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 259, -1, -1));

        DefaultCaret caret = (DefaultCaret)console.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        console.setColumns(20);
        console.setEditable(false);
        console.setFont(new java.awt.Font("Monospaced", 0, 12));
        console.setRows(20);
        scrollPane_log.setViewportView(console);

        getContentPane().add(scrollPane_log, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 279, 472, 110));

        button_forceGA.setForeground(new java.awt.Color(255, 153, 0));
        button_forceGA.setText("Force GA");
        button_forceGA.setEnabled(false);
        button_forceGA.setFocusable(false);
        button_forceGA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_forceGAMouseClicked(evt);
            }
        });
        getContentPane().add(button_forceGA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 90, -1));

        label_tableTitle.setText("Token Matches");
        getContentPane().add(label_tableTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Virus Name", "Total Grade", "% Grade AVRG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setResizable(false);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(1).setResizable(false);
        jTable1.getColumnModel().getColumn(2).setResizable(false);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 470, 90));

        separator_Vertical.setOrientation(javax.swing.SwingConstants.VERTICAL);
        separator_Vertical.setEnabled(false);
        getContentPane().add(separator_Vertical, new org.netbeans.lib.awtextra.AbsoluteConstraints(494, -1, 16, 530));

        label_programSettings.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_programSettings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_programSettings.setText("Program Settings");
        getContentPane().add(label_programSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 320, -1));

        label_tokenLength.setText("Token Length");
        getContentPane().add(label_tokenLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 72, 23));

        slider_tokenLength.setMaximum(15);
        slider_tokenLength.setMinimum(5);
        slider_tokenLength.setSnapToTicks(true);
        slider_tokenLength.setToolTipText("Recommended value = 10");
        slider_tokenLength.setValue(10);
        slider_tokenLength.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_tokenLengthStateChanged(evt);
            }
        });
        getContentPane().add(slider_tokenLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, -1, -1));

        text_tokenLength.setEditable(false);
        text_tokenLength.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_tokenLength.setText("10");
        text_tokenLength.setEnabled(false);
        text_tokenLength.setFocusable(false);
        getContentPane().add(text_tokenLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 32, -1));

        label_maxZeros.setText("Max N zeros");
        getContentPane().add(label_maxZeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 72, 23));

        slider_maxZeros.setMaximum(15);
        slider_maxZeros.setSnapToTicks(true);
        slider_maxZeros.setToolTipText("Recommended value = 5");
        slider_maxZeros.setValue(5);
        slider_maxZeros.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_maxZerosStateChanged(evt);
            }
        });
        getContentPane().add(slider_maxZeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        text_maxZeros.setEditable(false);
        text_maxZeros.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_maxZeros.setText("5");
        text_maxZeros.setEnabled(false);
        text_maxZeros.setFocusable(false);
        getContentPane().add(text_maxZeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 32, -1));

        separator_Horizontal_1.setForeground(new java.awt.Color(204, 204, 204));
        getContentPane().add(separator_Horizontal_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 330, 10));

        label_GA_Settings.setFont(new java.awt.Font("Tahoma", 1, 14));
        label_GA_Settings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_GA_Settings.setText("Genetic Algorithm Settings");
        getContentPane().add(label_GA_Settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 320, -1));

        label_maxGenerations.setText("Generations");
        getContentPane().add(label_maxGenerations, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 72, 23));

        slider_maxGenerations.setMajorTickSpacing(10);
        slider_maxGenerations.setMaximum(10000);
        slider_maxGenerations.setMinimum(500);
        slider_maxGenerations.setMinorTickSpacing(10);
        slider_maxGenerations.setSnapToTicks(true);
        slider_maxGenerations.setToolTipText("Recommended value = 2000");
        slider_maxGenerations.setValue(2000);
        slider_maxGenerations.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_maxGenerationsStateChanged(evt);
            }
        });
        getContentPane().add(slider_maxGenerations, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, -1, -1));

        text_maxGenerations.setEditable(false);
        text_maxGenerations.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_maxGenerations.setText("2000");
        text_maxGenerations.setEnabled(false);
        text_maxGenerations.setFocusable(false);
        getContentPane().add(text_maxGenerations, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, 32, -1));

        label_populationSize.setText("Population Size");
        getContentPane().add(label_populationSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 72, 23));

        slider_populationSize.setMajorTickSpacing(2);
        slider_populationSize.setMaximum(500);
        slider_populationSize.setMinimum(20);
        slider_populationSize.setMinorTickSpacing(2);
        slider_populationSize.setSnapToTicks(true);
        slider_populationSize.setToolTipText("Recommended value = 200");
        slider_populationSize.setValue(200);
        slider_populationSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_populationSizeStateChanged(evt);
            }
        });
        getContentPane().add(slider_populationSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, -1, -1));

        text_populationSize.setEditable(false);
        text_populationSize.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_populationSize.setText("200");
        text_populationSize.setEnabled(false);
        text_populationSize.setFocusable(false);
        getContentPane().add(text_populationSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 250, 32, -1));

        label_crossoverRate.setText("Crossover Rate");
        getContentPane().add(label_crossoverRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, 80, 23));

        slider_crossoverRate.setSnapToTicks(true);
        slider_crossoverRate.setToolTipText("Recommended value = 75");
        slider_crossoverRate.setValue(75);
        slider_crossoverRate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_crossoverRateStateChanged(evt);
            }
        });
        getContentPane().add(slider_crossoverRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, -1, -1));

        text_crossoverRate.setEditable(false);
        text_crossoverRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_crossoverRate.setText("75");
        text_crossoverRate.setEnabled(false);
        text_crossoverRate.setFocusable(false);
        getContentPane().add(text_crossoverRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 32, -1));

        label_mutationRate.setText("Mutation Rate");
        getContentPane().add(label_mutationRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 330, 72, 23));

        slider_mutationRate.setMaximum(10);
        slider_mutationRate.setSnapToTicks(true);
        slider_mutationRate.setToolTipText("Recommended value = 0.5");
        slider_mutationRate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                slider_mutationRateStateChanged(evt);
            }
        });
        getContentPane().add(slider_mutationRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, -1, -1));

        text_mutationRate.setEditable(false);
        text_mutationRate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_mutationRate.setText("1");
        text_mutationRate.setEnabled(false);
        text_mutationRate.setFocusable(false);
        getContentPane().add(text_mutationRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 330, 32, -1));

        checkBox_elitism.setSelected(true);
        checkBox_elitism.setText("Use Elitism");
        getContentPane().add(checkBox_elitism, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, -1, -1));

        checkBox_mutation.setSelected(true);
        checkBox_mutation.setText("Multiple Mutations");
        getContentPane().add(checkBox_mutation, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

        checkBox_crossover.setSelected(true);
        checkBox_crossover.setText("Dual Crossover");
        getContentPane().add(checkBox_crossover, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, -1, -1));

        checkBox_subsequence.setSelected(true);
        checkBox_subsequence.setText("Check for Subsequence");
        getContentPane().add(checkBox_subsequence, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, -1, -1));

        checkBox_substring.setSelected(true);
        checkBox_substring.setText("Check for Substring");
        getContentPane().add(checkBox_substring, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, -1, -1));

        separator_Horizontal_2.setForeground(new java.awt.Color(204, 204, 204));
        getContentPane().add(separator_Horizontal_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 330, 10));

        label_maxFitness.setFont(new java.awt.Font("Tahoma", 2, 11));
        label_maxFitness.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_maxFitness.setText("HIGHEST FITNESS");
        getContentPane().add(label_maxFitness, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 140, -1));

        text_maxFitness.setEditable(false);
        text_maxFitness.setFont(new java.awt.Font("Tahoma", 1, 18));
        text_maxFitness.setForeground(new java.awt.Color(51, 102, 255));
        text_maxFitness.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_maxFitness.setText("0");
        text_maxFitness.setAutoscrolls(false);
        text_maxFitness.setFocusable(false);
        text_maxFitness.setRequestFocusEnabled(false);
        getContentPane().add(text_maxFitness, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 140, 40));

        label_generation.setFont(new java.awt.Font("Tahoma", 2, 11));
        label_generation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_generation.setText("GENERATION");
        getContentPane().add(label_generation, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 460, 140, -1));

        text_generation.setEditable(false);
        text_generation.setFont(new java.awt.Font("Tahoma", 1, 18));
        text_generation.setForeground(new java.awt.Color(51, 102, 255));
        text_generation.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        text_generation.setText("0");
        text_generation.setAutoscrolls(false);
        text_generation.setFocusable(false);
        text_generation.setRequestFocusEnabled(false);
        getContentPane().add(text_generation, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 140, 40));
        getContentPane().add(separator_Horizontal_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 850, 10));

        text_bestChromosome.setEditable(false);
        text_bestChromosome.setForeground(new java.awt.Color(102, 102, 102));
        text_bestChromosome.setText("GA not yet started...");
        getContentPane().add(text_bestChromosome, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 540, 740, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11));
        jLabel1.setText("Best eSignature");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

//------------------------------------------------------------------------------
    private boolean fileChooser(boolean isDatabase){
        getSettingsToVariables();
        JFileChooser fileSelect = new JFileChooser();
        int returnVal = fileSelect.showOpenDialog(null);
        String pathToFile;

        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileSelect.getSelectedFile();
            pathToFile = file.getAbsolutePath();
            try{
                if(!isDatabase) {
                    String fileSignature = parser.binaryFileToHexString(pathToFile);
                    suspectFileTokens = tokenize.raw(fileSignature, isDatabase, 
                                                     tLength, maxZeros);
                    label_suspect.setText(pathToFile);
                    selectedFileName = file.getName();
                }
                else {                    
                    for(String vDef : parser.readVirusDatabase(pathToFile)){
                        addVirus(parser.cleanDefinitionList(vDef));                             
                    }
                    label_databasePath.setText(pathToFile);
                    selectedDBname = file.getName();
                }
            }
            catch (Exception e){
                error = e;
                return false;
            }            
            return true;
        }
        return false;
    }

//------------------------------------------------------------------------------
    private void addVirus(String[] vDefinitionSplit){
        VirusData virus = new VirusData(vDefinitionSplit[0], parser.removeSpaces(vDefinitionSplit[1]));
        virusDB.add(virus);
    }

//------------------------------------------------------------------------------
    private void printVirusDB_FULL (){
        Iterator<VirusData> iteratorVirusDB = virusDB.iterator();
        while(iteratorVirusDB.hasNext()){
            VirusData v = iteratorVirusDB.next();
            String vName = v.getName();
            System.out.print(vName + "\t\t  ");
            for(String t : v.getMatchesLCS()){
                System.out.print(t + ", ");
            }
            System.out.print("\t\t\t" + v.grade);
            System.out.print("\n");
        }
    }

//------------------------------------------------------------------------------
    private void breakLineTable(int rowNumber){
        jTable1.setValueAt("---EV---", rowNumber, 0);
        jTable1.setValueAt("---EV---", rowNumber, 1);
        jTable1.setValueAt("---EV---", rowNumber, 2);
    }

//------------------------------------------------------------------------------
    private void disableSettings(){
        slider_crossoverRate.setEnabled(false);
        slider_maxGenerations.setEnabled(false);
        slider_maxZeros.setEnabled(false);
        slider_mutationRate.setEnabled(false);
        slider_populationSize.setEnabled(false);
        slider_tokenLength.setEnabled(false);
        checkBox_crossover.setEnabled(false);
        checkBox_elitism.setEnabled(false);
        checkBox_mutation.setEnabled(false);
        checkBox_subsequence.setEnabled(false);
        checkBox_substring.setEnabled(false);
    }

//------------------------------------------------------------------------------
    private void button_enterSuspectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_enterSuspectMouseClicked
        if(radio_checkFile.isSelected()) {
            if(fileChooser(false)){
                console.append("You have succesfully selected the file "
                               + selectedFileName + "\n\n");
                img_selectSuspect.setIcon(sucess);
            }
            else {
                console.append("Oops! there was an error there: \n" + error + "\n\n");
                img_selectSuspect.setIcon(failure);
            }
        }
    }//GEN-LAST:event_button_enterSuspectMouseClicked

//------------------------------------------------------------------------------
    private void button_scanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_scanMouseClicked
        getSettingsToVariables();
        disableSettings();
            if(img_selectSuspect.getIcon() == sucess && img_selectDB.getIcon() == sucess){
                new Thread(new Runnable() {
                    public void run() {
                        int scanCounter = 0;
                        int counterToken = 0;
                        int sizeDB = virusDB.size();
                        progressBar.setIndeterminate(false);
                        progressBar.setMaximum(sizeDB);
                        if(isGA){
                            progressBar.setForeground(Color.GRAY);
                        }
                        progressBar.setValue(0);
                        ArrayList<String> tokenMatchesTemp = new ArrayList<String>();

                        Iterator<VirusData> iteratorVirusDB = virusDB.iterator();
                        while(iteratorVirusDB.hasNext()){
                            VirusData v = iteratorVirusDB.next();
                            float vTotalGrade = 0;
                            for(String vT : v.getTokens()){
                                for(String fT : suspectFileTokens){
                                    String matchT = lcs.analyzeTokens(v.getName(),
                                                                      vT, fT, tLength);
                                    if (matchT != null) {
                                        if(!tokenMatchesTemp.contains(matchT)) {
                                            vTotalGrade += grade.gradeTotal(fT, vT, matchT, tLength);
                                            tokenMatchesTemp.add(matchT);
                                        }
                                        counterToken++;
                                    }
                                }
                                counterToken = 0;
                            }
                            v.grade = vTotalGrade;
                            v.tLCS_setSize(tokenMatchesTemp.size());
                            tokenMatchesTemp.toArray(v.tLCS);
                            v.calculateGrade_AVRG(tokenMatchesTemp.size());
                            tokenMatchesTemp.clear();
                            final int barValue = scanCounter;
                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                    progressBar.setValue(barValue);
                                }
                            });
                            scanCounter++;
                        }
                        try { Thread.sleep(1); } catch (InterruptedException e) {}
                        Collections.sort(virusDB);
                        Collections.reverse(virusDB);
                        progressBar.setValue(sizeDB);
                        printMatches_GUI();
                    }

                }).start();
            }
            else {
                if(img_selectSuspect.getIcon() != sucess && img_selectDB.getIcon() != sucess)
                    console.append("There is an error with BOTH the Database "
                                 + "and the File/String fields. \n");
                else if (img_selectDB.getIcon() != sucess)
                    console.append("There is an error with the Database selected \n");
                else
                    console.append("There is an error with the File/String"
                                 + " selection field \n");
            }
            progressBar.setValue(virusDB.size());        
    }//GEN-LAST:event_button_scanMouseClicked

//------------------------------------------------------------------------------
    private void printMatches_GUI (){
        Iterator<VirusData> iteratorVirusDB = virusDB.iterator();
        int printCount = 0;
        int nHighAVRG = 0;

        while(iteratorVirusDB.hasNext() && printCount < 5){
            VirusData v = iteratorVirusDB.next();
            if(v.tLCS.length >= 2 && v.getGradeAVRG() >= 40){
                if(v.getGradeAVRG() >= 65){nHighAVRG++;}
                if(!isGA){
                    jTable1.setValueAt(v.getName(), printCount, 0);
                    jTable1.setValueAt(v.getGrade(), printCount, 1);
                    jTable1.setValueAt(v.getGradeAVRG(), printCount, 2);
                    printCount++;
                }
                else{
                    jTable1.setValueAt(v.getName(), nMatches+1, 0);
                    jTable1.setValueAt(v.getGrade(), nMatches+1, 1);
                    jTable1.setValueAt(v.getGradeAVRG(), nMatches+1, 2);
                    printCount++;
                }
            }
        }
        nMatches = printCount;
        if(nMatches == 0) {
            if(isGA){
                console.append("---> Evolution unsuccessful. \n\n");
            }
            else{
                console.append("\n*** No matches Found. ***\n\n");
            }
        }
        else if(nHighAVRG == 0 && printCount != 0){
            if(isGA){
                console.append("---> Evolution fidelity -> LOW ***\n\n");
            }
            else{
                console.append("\n*** Low fidelity (Avrg) matches found. "
                             + "Force evolution?  ***\n\n");
                button_forceGA.setEnabled(true);
                button_forceGA.setFocusable(true);
                breakLineTable(printCount);
            }
        }
        else{
            if(isGA){
                console.append("---> Evolution fidelity -> HIGH ***\n\n");
            }
            else{
                console.append("\n*** High fidelity (Avrg) matches found. "
                             + "GA Started  ***\n\n");
                breakLineTable(printCount);
                startGA();
            }
        }

    }

//------------------------------------------------------------------------------
    private void button_selectDabataseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_selectDabataseMouseClicked
        getSettingsToVariables();
        if (fileChooser(true)) {                                                   
            Iterator<VirusData> iteratorVirusDB = virusDB.iterator();
            console.append("You have succesfully selected the file "
                            + selectedDBname + "\n");
            while(iteratorVirusDB.hasNext()){
                VirusData v = iteratorVirusDB.next();
                String vSig = v.signature;
                v.tokens = tokenize.raw(vSig, true, tLength, maxZeros);
            }
            img_selectDB.setIcon(sucess);
        }
        else {
            console.append("Oops! there was an error there: \n" + error + "\n");
            img_selectDB.setIcon(failure);
        }
    }//GEN-LAST:event_button_selectDabataseMouseClicked

//------------------------------------------------------------------------------
    private void radio_checkStringMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_checkStringMouseClicked
        button_enterSuspect.setText("Enter String");
        button_enterSuspect.setEnabled(true);
        label_suspect.setText("paste or write string here...");
        label_suspect.setEditable(true);
        label_suspect.setEnabled(true);
        img_selectSuspect.setIcon(null);
        if(slider_tokenLength.isEnabled()){
            slider_tokenLength.setEnabled(false);
            slider_maxZeros.setEnabled(false);
        }
    }//GEN-LAST:event_radio_checkStringMouseClicked

//------------------------------------------------------------------------------
    private void radio_checkFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_radio_checkFileMouseClicked
        button_enterSuspect.setText("Select File");
        button_enterSuspect.setEnabled(true);
        label_suspect.setEditable(false);
        label_suspect.setText("File Name");
        label_suspect.setEnabled(false);
        img_selectSuspect.setIcon(null);
        if(slider_tokenLength.isEnabled()){
            slider_tokenLength.setEnabled(false);
            slider_maxZeros.setEnabled(false);
        }
    }//GEN-LAST:event_radio_checkFileMouseClicked

//------------------------------------------------------------------------------
    private void label_suspectFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_label_suspectFocusGained
        label_suspect.setEditable(true);
        label_suspect.setText("");
        label_suspect.setEnabled(true);
    }//GEN-LAST:event_label_suspectFocusGained

//------------------------------------------------------------------------------
    private void label_suspectFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_label_suspectFocusLost
        if(label_suspect.getText().isEmpty() == false
           && label_suspect.getText().matches("[0-9A-Fa-f]+")) {
                getSettingsToVariables();
                suspectFileTokens = tokenize.raw(label_suspect.getText(), 
                                                 false, tLength, maxZeros);
                img_selectSuspect.setIcon(sucess);
                console.append("The entered string has been successfully parsed\n");
        }
        else {
            img_selectSuspect.setIcon(failure);
            console.append("There has been an error parsing your string, try again.\n");
        }
    }//GEN-LAST:event_label_suspectFocusLost

//------------------------------------------------------------------------------
    private void startGA(){
        getSettingsToVariables();
        if(nMatches != 0) {
            new Thread(new Runnable() {
                    public void run() {
                        ArrayList<VirusData> virusDB_temp = new ArrayList<VirusData>();
                        VirusData virusMarkScheme;                        
                        progressBar.setValue(0);
                        progressBar.setForeground(Color.ORANGE);
                        progressBar.setMaximum(maxGenerations);
                        int shortestString = 0;
                        int nMarkSchemeElements = 0;
                        getSettingsToVariables();

                        if(nMatches >= 3) {nMarkSchemeElements = 3;}
                        else if(nMatches == 2) {nMarkSchemeElements = 2;}
                        else if(nMatches == 1) {nMarkSchemeElements = 1;}
                        else{}
                        String[] markScheme = new String[nMarkSchemeElements];
                        for(int i=0; i < nMarkSchemeElements; i++){
                            markScheme[i] = virusDB.get(i).signature;
                            if(virusDB.get(i).signature.length() < shortestString
                               || shortestString == 0) {
                                shortestString = virusDB.get(i).signature.length();
                                virusMarkScheme = new VirusData(virusDB.get(i).name,
                                                          virusDB.get(i).signature);
                                virusMarkScheme.tokens = tokenize.raw(virusDB.get(i).signature,
                                                          true, tLength, maxZeros);
                                virusDB_temp.add(virusMarkScheme);
                            }
                        }
                        population = new Population(poolSize, shortestString, 
                                                    markScheme, gaCheckSubsequence,
                                                    gaCheckSubstring);
                        Chromosome offprings[] = new Chromosome[2];
                        offprings[0] = new Chromosome(shortestString);
                        offprings[1] = new Chromosome(shortestString);
                        population.initializePool();
                        text_bestChromosome.setText(population.getBestChromosome().getChromosome());
                        text_maxFitness.setText(Integer.toString(population.getBestChromosome().getFitness()));
                        text_generation.setText("0");
                        for(int i=0; i < maxGenerations; i++){
                            int offpringCounter = 0;
                            if(useElitism){
                                population.storeElite(population.getBestChromosome());
                                offpringCounter++;
                                population.storeElite(population.getBestChromosome());
                                offpringCounter++;
                            }
                            while(offpringCounter < poolSize){
                                // Selection
                                offprings[0] = population.wheelSelection();
                                offprings[1] = population.wheelSelection();
                                //----offprings[0] = population.tournamentSelection(10);
                                //----offprings[1] = population.tournamentSelection(10);
                                // Crossover
                                if(random.nextDouble() < crossoverRate){
                                    offprings = population.crossover(offprings[0], 
                                                                     offprings[1],
                                                                     useMultCross);
                                }
                                // Mutation
                                if(random.nextDouble() < mutationRate){
                                    offprings[0].mutate(useMultMut);
                                }
                                if(random.nextDouble() < mutationRate){
                                    offprings[1].mutate(useMultMut);
                                }
                                // Store Pair
                                population.storeNewOffpring(offprings);
                                offpringCounter += 2;
                            }
                            // Save new pool as current
                            population.replaceOldPool();
                            population.evaluateAllChromosomesFitness();
                            population.sortPool_descending();

                            text_bestChromosome.setText(population.getBestChromosome().getChromosome());
                            text_maxFitness.setText(Integer.toString(population.getBestChromosome().getFitness()));
                            text_generation.setText(Integer.toString(i+1));
                            final int barValue = i+1;
                            SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                    progressBar.setValue(barValue);
                                }
                            });
                        }
                        progressBar.setIndeterminate(true);
                        // Ready for re-check
                        suspectFileTokens = tokenize.raw(population.getBestChromosome().getChromosome(),
                                                         true, tLength, maxZeros);
                        Collections.copy(virusDB, virusDB_temp);
                        virusDB_temp.clear();
                        isGA = true;
                        button_scan.setText("----------->  CHECK EVOLVED SIGNATURE  <-----------");
                        // End re-check setup
                        progressBar.setValue(0);
                        try { Thread.sleep(1); } catch (InterruptedException e) {}
                    }
            }).start();
        }
        else {
            console.append("*** No GA evolution needed ***\n");
        }        
        progressBar.setValue(0);
    }

//------------------------------------------------------------------------------
    private void getSettingsToVariables(){
        tLength = slider_tokenLength.getValue();
        maxZeros = slider_maxZeros.getValue();
        maxGenerations = slider_maxGenerations.getValue();
        poolSize = slider_populationSize.getValue();
        double tempCrossRate = slider_crossoverRate.getValue();
        crossoverRate = tempCrossRate/100;
        double tempMutRate = slider_mutationRate.getValue();
        mutationRate = tempMutRate/1000;
        useElitism = checkBox_elitism.isSelected();
        useMultCross = checkBox_crossover.isSelected();
        useMultMut = checkBox_mutation.isSelected();
        gaCheckSubsequence = checkBox_subsequence.isSelected();
        gaCheckSubsequence = checkBox_substring.isSelected();
    }

//------------------------------------------------------------------------------
    private void slider_tokenLengthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_tokenLengthStateChanged
        text_tokenLength.setText(Integer.toString(slider_tokenLength.getValue()));
    }//GEN-LAST:event_slider_tokenLengthStateChanged

//------------------------------------------------------------------------------
    private void slider_maxZerosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_maxZerosStateChanged
        text_maxZeros.setText(Integer.toString(slider_maxZeros.getValue()));
    }//GEN-LAST:event_slider_maxZerosStateChanged

//------------------------------------------------------------------------------
    private void slider_populationSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_populationSizeStateChanged
        text_populationSize.setText(Integer.toString(slider_populationSize.getValue()));
    }//GEN-LAST:event_slider_populationSizeStateChanged

//------------------------------------------------------------------------------
    private void slider_crossoverRateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_crossoverRateStateChanged
        text_crossoverRate.setText(Integer.toString(slider_crossoverRate.getValue()));
    }//GEN-LAST:event_slider_crossoverRateStateChanged

//------------------------------------------------------------------------------
    private void slider_mutationRateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_mutationRateStateChanged
        float reduceSliderVal = 0;
        reduceSliderVal = slider_mutationRate.getValue();
        text_mutationRate.setText(Float.toString(reduceSliderVal/10));
    }//GEN-LAST:event_slider_mutationRateStateChanged

//------------------------------------------------------------------------------
    private void slider_maxGenerationsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_slider_maxGenerationsStateChanged
        text_maxGenerations.setText(Integer.toString(slider_maxGenerations.getValue()));
    }//GEN-LAST:event_slider_maxGenerationsStateChanged

//------------------------------------------------------------------------------
    private void button_forceGAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_forceGAMouseClicked
        if(button_forceGA.isEnabled())
            startGA();
    }//GEN-LAST:event_button_forceGAMouseClicked

//------------------------------------------------------------------------------
//------------------------------------------------------------------------------
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_enterSuspect;
    private javax.swing.JButton button_forceGA;
    private javax.swing.JButton button_scan;
    private javax.swing.JButton button_selectDabatase;
    private javax.swing.JCheckBox checkBox_crossover;
    private javax.swing.JCheckBox checkBox_elitism;
    private javax.swing.JCheckBox checkBox_mutation;
    private javax.swing.JCheckBox checkBox_subsequence;
    private javax.swing.JCheckBox checkBox_substring;
    private javax.swing.JTextArea console;
    private javax.swing.JLabel img_selectDB;
    private javax.swing.JLabel img_selectSuspect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_GA_Settings;
    private javax.swing.JLabel label_consoleTitle;
    private javax.swing.JLabel label_crossoverRate;
    private javax.swing.JTextField label_databasePath;
    private javax.swing.JLabel label_generation;
    private javax.swing.JLabel label_maxFitness;
    private javax.swing.JLabel label_maxGenerations;
    private javax.swing.JLabel label_maxZeros;
    private javax.swing.JLabel label_mutationRate;
    private javax.swing.JLabel label_populationSize;
    private javax.swing.JLabel label_programSettings;
    private javax.swing.JLabel label_programTitle;
    private javax.swing.JTextField label_suspect;
    private javax.swing.JLabel label_tableTitle;
    private javax.swing.JLabel label_tokenLength;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.ButtonGroup radioGroup_checkType;
    private javax.swing.JRadioButton radio_checkFile;
    private javax.swing.JRadioButton radio_checkString;
    private javax.swing.JScrollPane scrollPane_log;
    private javax.swing.JSeparator separator_Horizontal_1;
    private javax.swing.JSeparator separator_Horizontal_2;
    private javax.swing.JSeparator separator_Horizontal_3;
    private javax.swing.JSeparator separator_Vertical;
    private javax.swing.JSlider slider_crossoverRate;
    private javax.swing.JSlider slider_maxGenerations;
    private javax.swing.JSlider slider_maxZeros;
    private javax.swing.JSlider slider_mutationRate;
    private javax.swing.JSlider slider_populationSize;
    private javax.swing.JSlider slider_tokenLength;
    private javax.swing.JTextField text_bestChromosome;
    private javax.swing.JTextField text_crossoverRate;
    private javax.swing.JTextField text_generation;
    private javax.swing.JTextField text_maxFitness;
    private javax.swing.JTextField text_maxGenerations;
    private javax.swing.JTextField text_maxZeros;
    private javax.swing.JTextField text_mutationRate;
    private javax.swing.JTextField text_populationSize;
    private javax.swing.JTextField text_tokenLength;
    // End of variables declaration//GEN-END:variables
}
