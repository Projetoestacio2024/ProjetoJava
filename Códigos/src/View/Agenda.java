/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.AgendaController;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Thalles
 */
public class Agenda extends javax.swing.JFrame {

    // Frames
    private final AgendaController controller;
    JFrame menuprincipal = new MenuPrincipal();
    JFrame frame = this;

    /* Creates new form Agenda */
    public Agenda() 
    {
        // Componentes
        initComponents();
        
        // Controlador
        controller = new AgendaController(this);
        iniciar();
        this.controller.atualizarTabela();
        
        // CFG Janela
        configuracaoJanela();    
        
        // Travar Fechamento
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // Adiciona um WindowListener para detectar o fechamento da janela
        addWindowListener(new WindowAdapter() 
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                // Exibe um diálogo de confirmação
                int confirmed = JOptionPane.showConfirmDialog(
                        null, 
                        "Tem certeza que deseja sair?", 
                        "Confirmação de Saída",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    // Fecha todas as janelas e sai do aplicativo
                    //dispose();
                    System.exit(0);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        obsScrool = new javax.swing.JScrollPane();
        obsText = new javax.swing.JTextArea();
        botaoAgendar = new javax.swing.JButton();
        textValor = new javax.swing.JTextField();
        listaClientes = new javax.swing.JComboBox<>();
        listaServicos = new javax.swing.JComboBox<>();
        textData = new javax.swing.JFormattedTextField();
        textHora = new javax.swing.JFormattedTextField();
        botaoSair = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoDeletar = new javax.swing.JButton();
        labelObs = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        labelServico = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAgendamentos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);

        obsText.setBackground(java.awt.Color.darkGray);
        obsText.setColumns(20);
        obsText.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        obsText.setForeground(java.awt.Color.lightGray);
        obsText.setRows(5);
        obsText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        obsText.setCaretColor(java.awt.Color.lightGray);
        obsText.setSelectedTextColor(new java.awt.Color(255, 102, 0));
        obsText.setSelectionColor(new java.awt.Color(255, 102, 0));
        obsScrool.setViewportView(obsText);

        botaoAgendar.setBackground(java.awt.Color.darkGray);
        botaoAgendar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        botaoAgendar.setForeground(new java.awt.Color(255, 102, 51));
        botaoAgendar.setText("AGENDAR");
        botaoAgendar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));
        botaoAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAgendarActionPerformed(evt);
            }
        });

        textValor.setBackground(java.awt.Color.darkGray);
        textValor.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        textValor.setForeground(java.awt.Color.lightGray);
        textValor.setText("0");
        textValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textValorActionPerformed(evt);
            }
        });

        listaClientes.setBackground(java.awt.Color.darkGray);
        listaClientes.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        listaClientes.setForeground(java.awt.Color.lightGray);
        listaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaClientesActionPerformed(evt);
            }
        });

        listaServicos.setBackground(java.awt.Color.darkGray);
        listaServicos.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 14)); // NOI18N
        listaServicos.setForeground(java.awt.Color.lightGray);
        listaServicos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaServicosItemStateChanged(evt);
            }
        });
        listaServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaServicosActionPerformed(evt);
            }
        });

        textData.setBackground(java.awt.Color.darkGray);
        textData.setForeground(java.awt.Color.lightGray);

        textHora.setBackground(java.awt.Color.darkGray);
        textHora.setForeground(java.awt.Color.lightGray);
        textHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textHoraActionPerformed(evt);
            }
        });

        botaoSair.setBackground(java.awt.Color.darkGray);
        botaoSair.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        botaoSair.setForeground(new java.awt.Color(255, 102, 51));
        botaoSair.setText("FECHAR");
        botaoSair.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });

        botaoAtualizar.setBackground(java.awt.Color.darkGray);
        botaoAtualizar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        botaoAtualizar.setForeground(new java.awt.Color(255, 102, 51));
        botaoAtualizar.setText("ATUALIZAR");
        botaoAtualizar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        botaoDeletar.setBackground(java.awt.Color.darkGray);
        botaoDeletar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        botaoDeletar.setForeground(new java.awt.Color(255, 102, 51));
        botaoDeletar.setText("DELETAR");
        botaoDeletar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 102, 0)));
        botaoDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeletarActionPerformed(evt);
            }
        });

        labelObs.setBackground(java.awt.Color.lightGray);
        labelObs.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        labelObs.setForeground(new java.awt.Color(0, 0, 0));
        labelObs.setText("Observação");

        labelData.setBackground(java.awt.Color.lightGray);
        labelData.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        labelData.setForeground(new java.awt.Color(0, 0, 0));
        labelData.setText("Data");

        labelHora.setBackground(java.awt.Color.lightGray);
        labelHora.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        labelHora.setForeground(new java.awt.Color(0, 0, 0));
        labelHora.setText("Hora");

        labelServico.setBackground(java.awt.Color.lightGray);
        labelServico.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        labelServico.setForeground(new java.awt.Color(0, 0, 0));
        labelServico.setText("Serviço");

        labelValor.setBackground(java.awt.Color.lightGray);
        labelValor.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        labelValor.setForeground(new java.awt.Color(0, 0, 0));
        labelValor.setText("Valor R$");

        labelNome.setBackground(java.awt.Color.lightGray);
        labelNome.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        labelNome.setForeground(new java.awt.Color(0, 0, 0));
        labelNome.setText("Cliente ");

        tabelaAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Serviço", "Observação", "Data", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaAgendamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAgendamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAgendamentos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(labelNome))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelServico)
                        .addGap(182, 182, 182)
                        .addComponent(labelValor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(labelHora))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textData, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(labelObs))
                    .addComponent(obsScrool, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(botaoAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(botaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(labelNome)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelServico)
                            .addComponent(labelValor))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(listaServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelData)
                            .addComponent(labelHora))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textHora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(labelObs)
                        .addGap(5, 5, 5)
                        .addComponent(obsScrool, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAgendarActionPerformed
        this.controller.agendar();
        this.controller.atualizarTabela();
    }//GEN-LAST:event_botaoAgendarActionPerformed

    private void textValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textValorActionPerformed

    private void listaServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaServicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaServicosActionPerformed

    private void listaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listaClientesActionPerformed

    private void listaServicosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaServicosItemStateChanged
        this.controller.atualizarValor();
    }//GEN-LAST:event_listaServicosItemStateChanged

    private void textHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textHoraActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.frame.dispose();
        MenuPrincipal menuprincipal = new MenuPrincipal();
        menuprincipal.setVisible(true);
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        this.controller.atualizarAgendamento();
        this.controller.atualizarTabela();
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    private void botaoDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeletarActionPerformed
        this.controller.deletarAgendamento();
        this.controller.atualizarTabela();
    }//GEN-LAST:event_botaoDeletarActionPerformed

    private void tabelaAgendamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAgendamentosMouseClicked
        
    }//GEN-LAST:event_tabelaAgendamentosMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAgendar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoDeletar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelServico;
    private javax.swing.JLabel labelValor;
    private javax.swing.JComboBox<String> listaClientes;
    private javax.swing.JComboBox<String> listaServicos;
    private javax.swing.JScrollPane obsScrool;
    private javax.swing.JTextArea obsText;
    private javax.swing.JTable tabelaAgendamentos;
    private javax.swing.JFormattedTextField textData;
    private javax.swing.JFormattedTextField textHora;
    private javax.swing.JTextField textValor;
    // End of variables declaration//GEN-END:variables

    private void iniciar() 
    {
        // Configuração Página
        this.controller.atualizarCliente();
        this.controller.atualizarServico();
        this.controller.atualizarValor();
        this.controller.AtualizarDataHora();
    }
    
    public JComboBox<String> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(JComboBox<String> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public JComboBox<String> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(JComboBox<String> listaServicos) {
        this.listaServicos = listaServicos;
    }
    
    public JTextField getTextValor() {
        return textValor;
    }

    public void setTextValor(JTextField textValor) {
        this.textValor = textValor;
    }

    public JTextArea getObsText() {
        return obsText;
    }

    public void setObsText(JTextArea obsText) {
        this.obsText = obsText;
    }

    public JFormattedTextField getTextData() {
        return textData;
    }

    public void setTextData(JFormattedTextField textData) {
        this.textData = textData;
    }

    public JFormattedTextField getTextHora() {
        return textHora;
    }

    public void setTextHora(JFormattedTextField textHora) {
        this.textHora = textHora;        
    }

    public JTable getTabelaAgendamentos() {
        return tabelaAgendamentos;
    }

    public void setTabelaAgendamentos(JTable tabelaAgendamentos) {
        this.tabelaAgendamentos = tabelaAgendamentos;
    }
        
    public void configuracaoJanela(){
        
        // Titulo
        frame.setTitle("Cadastro de agendamentos");
        
        // Tamanho    
        int labelWidth = 900;  // Obtém a largura preferida da JLabel
        int labelHeight = 600; // Obtém a altura preferida da JLabel
        frame.setSize(labelWidth, labelHeight); 
        
        // Carrega o ícone e define para o JFrame
        ImageIcon icon = new ImageIcon(Main.class.getResource("/view/imagens/icons/agenda32-icon.png")); // Substitua pelo caminho do seu ícone
        frame.setIconImage(icon.getImage()); // Define o ícone da janela
               
        // Impede o redimensionamento
        frame.setResizable(false); 

        // Configura a operação de fechamento
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Resetar Frame
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                frame.setLocationRelativeTo(null);
                frame.setSize(labelWidth, labelHeight); 
            }
            @Override
            public void componentMoved(ComponentEvent e){
                frame.setLocationRelativeTo(null);
                frame.setSize(labelWidth, labelHeight); 
            }                    
        });
    }
}
