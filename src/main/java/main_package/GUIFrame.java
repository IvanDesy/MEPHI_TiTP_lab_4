package main_package;


import readers.ReadFromDB;
import storages.ReactorHolder;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.File;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.swing.tree.DefaultTreeCellRenderer;

public class GUIFrame {
    private  ReactorHolder reactorHolder = new ReactorHolder();
    public void ShowFrame() throws URISyntaxException {
        JFrame frame = new JFrame("Работа с БД реакторов");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setSize(300, 300);
        panel.setBackground(Color.DARK_GRAY);
        
        JButton selectFileButton = new JButton("Выбрать файл");
        
        selectFileButton.setBackground(Color.BLACK);
        selectFileButton.setForeground(Color.ORANGE);
        
        JButton countryButton = new JButton("Агрегация по странам");
        countryButton.setBackground(Color.BLACK);
        countryButton.setForeground(Color.ORANGE);
        
        
        JButton operatorButton = new JButton("Агрегация по операторам");
        operatorButton.setBackground(Color.BLACK);
        operatorButton.setForeground(Color.ORANGE);
        
        JButton regionButton = new JButton("Агрегация по региона");
        regionButton.setBackground(Color.BLACK);
        regionButton.setForeground(Color.ORANGE);
        
        countryButton.setEnabled(false);
        operatorButton.setEnabled(false);
        regionButton.setEnabled(false);
        
        
        
        selectFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                
                try {
                    fileChooser = new JFileChooser(new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()).getParentFile());
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                fileChooser.setDialogTitle("Проводник. Выбор SQlite файла");
                fileChooser.setBackground(Color.DARK_GRAY);
                fileChooser.setVisible(true);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("SQLite Database (*.sqlite, *.db)", "sqlite", "db");
                fileChooser.setFileFilter(filter);
                int returnValue = fileChooser.showOpenDialog(frame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        ReadFromDB.read(selectedFile.getAbsolutePath(), reactorHolder);
                        JOptionPane.showMessageDialog(null, "Данные получены");
                        
                        reactorHolder.calculateConsumptionPerYear();
                        countryButton.setEnabled(true);
                        operatorButton.setEnabled(true);
                        regionButton.setEnabled(true);                    
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Ошибка: " + ex.getMessage(), "Описание:", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            private Object getContentPane() {
                throw new UnsupportedOperationException("Не поддерживается");
            }
        });

        countryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, HashMap<Integer, Double>> agregatePerCountryMap = reactorHolder.agregatePerCountry();
                String[] columnNames = {"Страна", "Год", "Объем ежегодного потребеления"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                for (HashMap.Entry<String, HashMap<Integer, Double>> entry : agregatePerCountryMap.entrySet()) {
                    String country = entry.getKey();
                    HashMap<Integer, Double> yearData = entry.getValue();
                    for (int year = 2014; year <= 2024; year++) {
                        Object[] rowData = new Object[3];
                        rowData[0] = country;
                        rowData[1] = year;
                        rowData[2] = yearData.getOrDefault(year, 0.0);
                        model.addRow(rowData);
                    }
                }
                JTable table = new JTable(model);
                customJTable(table);
                
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame tableFrame = new JFrame("Суммарное потребление по уровню агрегации: страна");
                tableFrame.add(scrollPane);
                customJFrame(tableFrame);
            }
        });
        
        operatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, HashMap<Integer, Double>> agregatePerCountryMap = reactorHolder.agregatePerOperator();
                String[] columnNames = {"Оператор", "Год", "Объем ежегодного потребеления"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                for (HashMap.Entry<String, HashMap<Integer, Double>> entry : agregatePerCountryMap.entrySet()) {
                    String country = entry.getKey();
                    HashMap<Integer, Double> yearData = entry.getValue();
                    for (int year = 2014; year <= 2024; year++) {
                        Object[] rowData = new Object[3];
                        rowData[0] = country;
                        rowData[1] = year;
                        rowData[2] = yearData.getOrDefault(year, 0.0);
                        model.addRow(rowData);
                    }
                }
                JTable table = new JTable(model);
                customJTable(table);
                
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame tableFrame = new JFrame("Суммарное потребление по уровню агрегации: оператор");
                tableFrame.add(scrollPane);
                customJFrame(tableFrame);
            }
        });

        regionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, HashMap<Integer, Double>> agregatePerCountryMap = reactorHolder.agregatePerRegion();
                String[] columnNames = {"Регион", "Год", "Объём ежегодного потребеления"};
                DefaultTableModel model = new DefaultTableModel(columnNames, 0);
                for (HashMap.Entry<String, HashMap<Integer, Double>> entry : agregatePerCountryMap.entrySet()) {
                    String country = entry.getKey();
                    HashMap<Integer, Double> yearData = entry.getValue();
                    for (int year = 2014; year <= 2024; year++) {
                        Object[] rowData = new Object[3];
                        rowData[0] = country;
                        rowData[1] = year;
                        rowData[2] = yearData.getOrDefault(year, 0.0);
                        model.addRow(rowData);
                    }
                }
                JTable table = new JTable(model);
                customJTable(table);
                
                JScrollPane scrollPane = new JScrollPane(table);
                JFrame tableFrame = new JFrame("Суммарное потребление по уровню агрегации: регион");
                tableFrame.add(scrollPane);
                customJFrame(tableFrame);
            }
            
        });
        
    
        panel.add(selectFileButton);
        panel.add(countryButton);
        panel.add(operatorButton);
        panel.add(regionButton);
        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);      
        
        
    }
    private void customJFrame(JFrame tableFrame){
        tableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        tableFrame.setSize(800, 600);
        tableFrame.setLocationRelativeTo(null);
        tableFrame.setVisible(true);
    }
    
    private void customJTable(JTable table){
        table.setBackground(Color.DARK_GRAY);
        table.setForeground(Color.WHITE);
    }
    
    
    
}
