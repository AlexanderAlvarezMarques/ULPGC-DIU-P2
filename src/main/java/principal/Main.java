package principal;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author Alexander Álvarez Marques
 */
public class Main extends javax.swing.JFrame {

    Map<String, Double> exchanges;
    DecimalFormat df = new DecimalFormat("#.00");
    Color backgroundcolor = new Color(247, 241, 218);

    /**
     * Creates new form main
     */
    public Main() {
        initExchangesMap();
        initComponents();
        
        setBackgroundColor();

        super.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        panelCurrency = new javax.swing.JPanel();
        labelCurrency = new javax.swing.JLabel();
        comboBoxCurrency = new javax.swing.JComboBox<>();
        panelExchangeInformation = new javax.swing.JPanel();
        labelExchangeInformation = new javax.swing.JLabel();
        panelExchangeCalculator = new javax.swing.JPanel();
        labelExchangeCalculator = new javax.swing.JLabel();
        inputExchange = new javax.swing.JTextField();
        inputExchange.setText("1");
        labelExchangeFinalValue = new javax.swing.JLabel();
        buttonCalculate = new javax.swing.JButton();
        labelExchangeFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(215, 210));
        setMinimumSize(new java.awt.Dimension(210, 210));
        setPreferredSize(new java.awt.Dimension(215, 210));
        setResizable(false);

        labelCurrency.setText("Seleccione la divisa base:");

        comboBoxCurrency.setModel(new javax.swing.DefaultComboBoxModel<>(getCurrencies()));
        comboBoxCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCurrencyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCurrencyLayout = new javax.swing.GroupLayout(panelCurrency);
        panelCurrency.setLayout(panelCurrencyLayout);
        panelCurrencyLayout.setHorizontalGroup(
            panelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurrencyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxCurrency, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCurrency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelCurrencyLayout.setVerticalGroup(
            panelCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCurrencyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboBoxCurrency.setSelectedIndex(0);

        setLabelExchangeInformation();

        javax.swing.GroupLayout panelExchangeInformationLayout = new javax.swing.GroupLayout(panelExchangeInformation);
        panelExchangeInformation.setLayout(panelExchangeInformationLayout);
        panelExchangeInformationLayout.setHorizontalGroup(
            panelExchangeInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExchangeInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelExchangeInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelExchangeInformationLayout.setVerticalGroup(
            panelExchangeInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelExchangeInformation)
        );

        labelExchangeCalculator.setText("Introduzca el valor de cambio:");

        inputExchange.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputExchangeKeyTyped(evt);
            }
        });

        labelExchangeFinalValue.setForeground(new java.awt.Color(255, 0, 0));
        setLabelExchangeFinalValue();

        buttonCalculate.setText("Calcular");
        buttonCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCalculateActionPerformed(evt);
            }
        });

        labelExchangeFinal.setText("Cambio:");

        javax.swing.GroupLayout panelExchangeCalculatorLayout = new javax.swing.GroupLayout(panelExchangeCalculator);
        panelExchangeCalculator.setLayout(panelExchangeCalculatorLayout);
        panelExchangeCalculatorLayout.setHorizontalGroup(
            panelExchangeCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExchangeCalculatorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelExchangeCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputExchange)
                    .addGroup(panelExchangeCalculatorLayout.createSequentialGroup()
                        .addGroup(panelExchangeCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelExchangeCalculatorLayout.createSequentialGroup()
                                .addComponent(labelExchangeCalculator)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelExchangeCalculatorLayout.createSequentialGroup()
                                .addComponent(labelExchangeFinal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelExchangeFinalValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        panelExchangeCalculatorLayout.setVerticalGroup(
            panelExchangeCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelExchangeCalculatorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelExchangeCalculator)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputExchange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonCalculate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelExchangeCalculatorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelExchangeFinalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelExchangeFinal))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCurrency, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelExchangeInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelExchangeCalculator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelExchangeInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelExchangeCalculator, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCalculateActionPerformed
        setLabelExchangeFinalValue();
    }//GEN-LAST:event_buttonCalculateActionPerformed

    private void comboBoxCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCurrencyActionPerformed
        setLabelExchangeInformation();
        setLabelExchangeFinalValue();
    }//GEN-LAST:event_comboBoxCurrencyActionPerformed

    private void inputExchangeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputExchangeKeyTyped
        if (evt.getKeyChar() == '\n') {
            setLabelExchangeFinalValue();
        }

    }//GEN-LAST:event_inputExchangeKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private void setLabelExchangeInformation() {
        
        String currency = (String) comboBoxCurrency.getSelectedItem();
        String text;
        
        String lastValue = inputExchange.getText();
        inputExchange.setText("1.");
        
        switch (currency) {
            case "EUR":
                text = "1€ = " + df.format(calculateExchange()) + " $";
                labelExchangeInformation.setText(text);
                break;
            case "USD":
                text = "1$ = " + df.format(calculateExchange()) + " €";
                labelExchangeInformation.setText(text);
                break;
            default:
                showMessage("Se ha producido un error."
                        + "\nCerrando el programa de forma inminente.");
                System.exit(0);
        }
        
        inputExchange.setText(lastValue);
    }

    private void setLabelExchangeFinalValue() {
        double exchange = calculateExchange();
        labelExchangeFinalValue.setText(df.format(exchange));
    }

    private double calculateExchange() {
        
        String input = inputExchange.getText();
        input = input.replaceFirst(",", ".");
        double value = 1.;
        if (checkInputNumberFormat(input)) {
            value = Double.parseDouble(input);
        } else {
            JOptionPane.showMessageDialog(null, "Número no válido. El formato debe ser: 0.00");
        }

        String currency = (String) comboBoxCurrency.getSelectedItem();
        double exchange = exchanges.get("USD");
                
//        double exchange = exchanges.get((String) comboBoxCurrency.getSelectedItem());
        
        return currency.equals("EUR") ? value * exchange : value / exchange;
        
//        double exchange = exchanges.get((String) comboBoxCurrency.getSelectedItem());
//        return exchange * value;
    }

    private void initExchangesMap() {
        try {
            exchanges = new HashMap<>();

            JSONObject exchangesObject = requestURLExchanges();

            exchanges.put("USD", exchangesObject.getDouble("USD"));
            
            // Para trabajar con mas divisas
//            exchangesObject.keySet().forEach(currency -> {
//                exchanges.put(currency, exchangesObject.getDouble(currency));
//            });
        } catch (JSONException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void setBackgroundColor() {
        
        panelBase.setBackground(backgroundcolor);
        panelCurrency.setBackground(backgroundcolor);
        panelExchangeCalculator.setBackground(backgroundcolor);
        panelExchangeInformation.setBackground(backgroundcolor);

    }

    private boolean checkInputNumberFormat(String input) {        
        return Pattern.compile("\\d*([.]\\d+)?").matcher(input).find();
    }

    private String[] getCurrencies() {

//        String[] currencies = new String[exchanges.size()];
//
//        int i = 0;
//        for (String currency : exchanges.keySet()) {
//            currencies[i] = currency;
//            i++;
//        }

        String currencies [] = new String [] {"EUR", "USD"};

        Arrays.sort(currencies);

        return currencies;

    }

    private JSONObject requestURLExchanges() {

        JSONObject json = null;
        
        try {
            json = readJSONFileFromURL("ttps://api.exchangeratesapi.io/latest?base=EUR");
        } catch (IOException | JSONException e) {
            try {
                json = readJSONFileFromFile("./src/main/java/files/eur.json");
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                showMessage("Error durante la apertura/lectura del fichero."
                        + "\nContacte con el administrador del sistema."
                        + "\nEl programa se cerrara de forma inmediata.");
                System.exit(0);
            }
        }
        
        return json.getJSONObject("rates");
    }

    private JSONObject readJSONFileFromURL(String url) throws JSONException, IOException {

        JSONObject json;
        URLConnection connection;
        Scanner scanner;

        connection = new URL(url).openConnection();
        scanner = new Scanner(connection.getInputStream());

        String response = scanner.useDelimiter("\\A").next();
        json = new JSONObject(response);

        return (JSONObject) json.get("rates");
    }
    
    private JSONObject readJSONFileFromFile(String source) throws Exception {
        
        FileReader fr = new FileReader(source);
        
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(fr);
        String str = obj.toString();
        
        JSONObject json = new JSONObject(str);
        
        return json;
        
    }

    private void showMessage(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCalculate;
    private javax.swing.JComboBox<String> comboBoxCurrency;
    private javax.swing.JTextField inputExchange;
    private javax.swing.JLabel labelCurrency;
    private javax.swing.JLabel labelExchangeCalculator;
    private javax.swing.JLabel labelExchangeFinal;
    private javax.swing.JLabel labelExchangeFinalValue;
    private javax.swing.JLabel labelExchangeInformation;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelCurrency;
    private javax.swing.JPanel panelExchangeCalculator;
    private javax.swing.JPanel panelExchangeInformation;
    // End of variables declaration//GEN-END:variables

}
