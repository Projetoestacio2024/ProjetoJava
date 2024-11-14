/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controllers.LoginController;
import Model.DAO.Banco;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends javax.swing.JFrame {

    // Controlador & Frame
    private final LoginController controller;
    JFrame frame = this;
           
    /*** Creates new form Login*/
    public Login() 
    {
        // Componentes
        initComponents();
        configuracaoJanela();
        
        // Controller
        controller = new LoginController(this);
        Banco.inicia();
        
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonEntrar = new java.awt.Button();
        TextSenha = new javax.swing.JPasswordField();
        TextUser = new javax.swing.JTextField();
        CheckMostrarSenha = new javax.swing.JCheckBox();
        JlabelSenha = new javax.swing.JLabel();
        JlabelUsuario = new javax.swing.JLabel();
        fundoLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(1280, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonEntrar.setBackground(java.awt.Color.darkGray);
        buttonEntrar.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        buttonEntrar.setForeground(java.awt.Color.white);
        buttonEntrar.setLabel("Entrar");
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 490, 130, 40));

        TextSenha.setBackground(java.awt.Color.darkGray);
        TextSenha.setForeground(java.awt.Color.lightGray);
        TextSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(TextSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, 320, 30));

        TextUser.setBackground(java.awt.Color.darkGray);
        TextUser.setForeground(java.awt.Color.lightGray);
        TextUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextUserActionPerformed(evt);
            }
        });
        getContentPane().add(TextUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 290, 30));

        CheckMostrarSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CheckMostrarSenha.setText("Mostrar senha");
        CheckMostrarSenha.setToolTipText("");
        CheckMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckMostrarSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(CheckMostrarSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 130, 30));

        JlabelSenha.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        JlabelSenha.setForeground(new java.awt.Color(255, 255, 255));
        JlabelSenha.setText("Senha");
        getContentPane().add(JlabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 100, -1));

        JlabelUsuario.setFont(new java.awt.Font("Nirmala UI Semilight", 1, 18)); // NOI18N
        JlabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        JlabelUsuario.setText("Usuário");
        getContentPane().add(JlabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 70, -1));

        fundoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/imagens/TelaLogin.png"))); // NOI18N
        fundoLogin.setToolTipText("");
        getContentPane().add(fundoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TextUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextUserActionPerformed

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed
        
        // Abrir Controller
        this.controller.entrar();
    }//GEN-LAST:event_buttonEntrarActionPerformed

    private void TextSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextSenhaActionPerformed

    private void CheckMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckMostrarSenhaActionPerformed
        if(CheckMostrarSenha.isSelected()) { TextSenha.setEchoChar((char)0); }
        else { TextSenha.setEchoChar('*'); }
    }//GEN-LAST:event_CheckMostrarSenhaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                new Login().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckMostrarSenha;
    private javax.swing.JLabel JlabelSenha;
    private javax.swing.JLabel JlabelUsuario;
    private javax.swing.JPasswordField TextSenha;
    private javax.swing.JTextField TextUser;
    private java.awt.Button buttonEntrar;
    private javax.swing.JLabel fundoLogin;
    // End of variables declaration//GEN-END:variables

    public void mensagem(String msg){
        JOptionPane.showMessageDialog(null, msg);
    }

    public JPasswordField getTextSenha() {
        return TextSenha;
    }

    public void setTextSenha(JPasswordField TextSenha) {
        this.TextSenha = TextSenha;
    }

    public JTextField getTextUser() {
        return TextUser;
    }

    public void setTextUser(JTextField TextUser) {
        this.TextUser = TextUser;
    }   
    
    public void configuracaoJanela(){
        
        // Titulo
        frame.setTitle("Tela de login");
                
        // Carrega o ícone e define para o JFrame
        ImageIcon icon = new ImageIcon(Main.class.getResource("/view/imagens/icons/cliente32-icon.png")); // Substitua pelo caminho do seu ícone
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
            }
            @Override
            public void componentMoved(ComponentEvent e){
                frame.setLocationRelativeTo(null);
            }                    
        });
    }
}
