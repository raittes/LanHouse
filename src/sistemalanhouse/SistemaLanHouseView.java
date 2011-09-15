/*
 * SistemaLanHouseView.java
 */

package sistemalanhouse;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import sistemalanhouse.logic.BD;
import sistemalanhouse.logic.Calculadora;
import sistemalanhouse.logic.Cliente;
import sistemalanhouse.logic.Maquina;
import sistemalanhouse.logic.Sessao;

/**
 * The application's main frame.
 */
public class SistemaLanHouseView extends FrameView {
    private final BD bd;
    private List<Sessao> sessao;

    public SistemaLanHouseView(SingleFrameApplication app, BD bd) {
        super(app);
        this.bd = bd;
        sessao = new ArrayList();
        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
        
        atualizaInterface();
        
        
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = SistemaLanHouseApp.getApplication().getMainFrame();
            aboutBox = new SistemaLanHouseAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        SistemaLanHouseApp.getApplication().show(aboutBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        Principal = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaEmUso = new javax.swing.JTable();
        javax.swing.DefaultComboBoxModel model2 = new javax.swing.DefaultComboBoxModel();
        comboMaquinas = new javax.swing.JComboBox();
        javax.swing.DefaultComboBoxModel modCli = new javax.swing.DefaultComboBoxModel();
        comboCliente = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        labelUsuario = new javax.swing.JLabel();
        fHora = new javax.swing.JFormattedTextField("##:##:##");
        jLabel5 = new javax.swing.JLabel();
        fMin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fHoraFim = new javax.swing.JTextField();
        fMinFim = new javax.swing.JTextField();
        ListarClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaListaClientes = new javax.swing.JTable();
        RegistroPagamento = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CadastroCliente = new javax.swing.JPanel();
        nomeCliente = new javax.swing.JTextField();
        cpfCliente = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        emailCliente = new javax.swing.JTextField();
        numeroCliente = new javax.swing.JTextField();
        cadastroCliente = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        CadastroPC = new javax.swing.JPanel();
        campoIP = new javax.swing.JTextField();
        campoMesa = new javax.swing.JTextField();
        campoMAC = new javax.swing.JTextField();
        campoHostname = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        RegistroUso = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRegistro = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.setLayout(new java.awt.CardLayout());

        Principal.setName("Principal"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        tabelaEmUso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Maquina", "Cliente", "Entrada (Hrs)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEmUso.setName("tabelaEmUso"); // NOI18N
        tabelaEmUso.getTableHeader().setReorderingAllowed(false);
        tabelaEmUso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEmUsoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaEmUso);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(sistemalanhouse.SistemaLanHouseApp.class).getContext().getResourceMap(SistemaLanHouseView.class);
        tabelaEmUso.getColumnModel().getColumn(0).setResizable(false);
        tabelaEmUso.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tabelaEmUso.columnModel.title0")); // NOI18N
        tabelaEmUso.getColumnModel().getColumn(1).setResizable(false);
        tabelaEmUso.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tabelaEmUso.columnModel.title1")); // NOI18N
        tabelaEmUso.getColumnModel().getColumn(2).setResizable(false);
        tabelaEmUso.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tabelaEmUso.columnModel.title2")); // NOI18N

        comboMaquinas.setModel(model2);
        //String[] listaMaquinas = new String[bd.getMaquinas().size()];
        for(int i=0;i<bd.getMaquinas().size();i++){
            model2.addElement(bd.getMaquinas().get(i).getHostname());
        }
        comboMaquinas.setName("comboMaquinas"); // NOI18N
        comboMaquinas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboMaquinasMouseClicked(evt);
            }
        });
        comboMaquinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMaquinasActionPerformed(evt);
            }
        });

        comboCliente.setModel(modCli);
        comboCliente.setName("comboCliente"); // NOI18N
        comboCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                comboClienteMousePressed(evt);
            }
        });

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        jLabel20.setFont(resourceMap.getFont("jLabel20.font")); // NOI18N
        jLabel20.setText(resourceMap.getString("jLabel20.text")); // NOI18N
        jLabel20.setName("jLabel20"); // NOI18N

        jButton6.setFont(resourceMap.getFont("jButton6.font")); // NOI18N
        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setName("jButton6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        labelUsuario.setText(resourceMap.getString("labelUsuario.text")); // NOI18N
        labelUsuario.setName("labelUsuario"); // NOI18N

        fHora.setText(resourceMap.getString("fHora.text")); // NOI18N
        fHora.setName("fHora"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        fMin.setText(resourceMap.getString("fMin.text")); // NOI18N
        fMin.setName("fMin"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        fHoraFim.setText(resourceMap.getString("fHoraFim.text")); // NOI18N
        fHoraFim.setName("fHoraFim"); // NOI18N

        fMinFim.setText(resourceMap.getString("fMinFim.text")); // NOI18N
        fMinFim.setName("fMinFim"); // NOI18N

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel20))
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18))
                            .addComponent(jLabel2))
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboCliente, 0, 78, Short.MAX_VALUE)
                            .addComponent(comboMaquinas, 0, 106, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)
                        .addComponent(fHora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(3, 3, 3)
                        .addComponent(fMin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addComponent(labelUsuario)
                        .addGap(124, 124, 124))
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fMinFim, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))))
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PrincipalLayout.createSequentialGroup()
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboMaquinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(fMinFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fHoraFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addComponent(labelUsuario)
                        .addGap(51, 51, 51)))
                .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(PrincipalLayout.createSequentialGroup()
                        .addGroup(PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(13, 13, 13)
                        .addComponent(jButton1))
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        mainPanel.add(Principal, "Principal");

        ListarClientes.setName("ListarClientes"); // NOI18N

        tabelaListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "E-mail", "Telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaListaClientes.setName("tabelaListaClientes"); // NOI18N
        jScrollPane3.setViewportView(tabelaListaClientes);
        tabelaListaClientes.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tabelaListaClientes.columnModel.title0")); // NOI18N
        tabelaListaClientes.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tabelaListaClientes.columnModel.title1")); // NOI18N
        tabelaListaClientes.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tabelaListaClientes.columnModel.title2")); // NOI18N
        tabelaListaClientes.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tabelaListaClientes.columnModel.title3")); // NOI18N
        /*DefaultTableModel modelo = (DefaultTableModel) tabelaListaClientes.getModel();
        for(int i=0;i<bd.getClientes().size()-1;i++){
            Cliente cli = (Cliente)bd.getClientes().get(i);
            modelo.addRow(new Object[] {cli.getNome(),cli.getCpf(),cli.getEmail(),cli.getTelefone()});
        }
        tabelaListaClientes.repaint();
        */

        javax.swing.GroupLayout ListarClientesLayout = new javax.swing.GroupLayout(ListarClientes);
        ListarClientes.setLayout(ListarClientesLayout);
        ListarClientesLayout.setHorizontalGroup(
            ListarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );
        ListarClientesLayout.setVerticalGroup(
            ListarClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListarClientesLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(ListarClientes, "listarClientes");

        RegistroPagamento.setName("RegistroPagamento"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout RegistroPagamentoLayout = new javax.swing.GroupLayout(RegistroPagamento);
        RegistroPagamento.setLayout(RegistroPagamentoLayout);
        RegistroPagamentoLayout.setHorizontalGroup(
            RegistroPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroPagamentoLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel3)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        RegistroPagamentoLayout.setVerticalGroup(
            RegistroPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroPagamentoLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(jLabel3)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        mainPanel.add(RegistroPagamento, "Pagamento");

        CadastroCliente.setName("CadastroCliente"); // NOI18N

        nomeCliente.setText(resourceMap.getString("nomeCliente.text")); // NOI18N
        nomeCliente.setName("nomeCliente"); // NOI18N

        cpfCliente.setText(resourceMap.getString("cpfCliente.text")); // NOI18N
        cpfCliente.setName("cpfCliente"); // NOI18N

        jLabel21.setText(resourceMap.getString("jLabel21.text")); // NOI18N
        jLabel21.setName("jLabel21"); // NOI18N

        jLabel22.setText(resourceMap.getString("jLabel22.text")); // NOI18N
        jLabel22.setName("jLabel22"); // NOI18N

        jLabel23.setText(resourceMap.getString("jLabel23.text")); // NOI18N
        jLabel23.setName("jLabel23"); // NOI18N

        jLabel24.setText(resourceMap.getString("jLabel24.text")); // NOI18N
        jLabel24.setName("jLabel24"); // NOI18N

        emailCliente.setText(resourceMap.getString("emailCliente.text")); // NOI18N
        emailCliente.setName("emailCliente"); // NOI18N

        numeroCliente.setText(resourceMap.getString("numeroCliente.text")); // NOI18N
        numeroCliente.setName("numeroCliente"); // NOI18N

        cadastroCliente.setText(resourceMap.getString("cadastroCliente.text")); // NOI18N
        cadastroCliente.setName("cadastroCliente"); // NOI18N
        cadastroCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cadastroClienteMouseClicked(evt);
            }
        });
        cadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroClienteActionPerformed(evt);
            }
        });

        jLabel25.setFont(resourceMap.getFont("jLabel25.font")); // NOI18N
        jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        javax.swing.GroupLayout CadastroClienteLayout = new javax.swing.GroupLayout(CadastroCliente);
        CadastroCliente.setLayout(CadastroClienteLayout);
        CadastroClienteLayout.setHorizontalGroup(
            CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroClienteLayout.createSequentialGroup()
                .addGroup(CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CadastroClienteLayout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel24)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                .addComponent(cpfCliente)
                                .addComponent(emailCliente)
                                .addComponent(numeroCliente))
                            .addComponent(cadastroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CadastroClienteLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel25)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        CadastroClienteLayout.setVerticalGroup(
            CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroClienteLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel25)
                .addGap(39, 39, 39)
                .addGroup(CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CadastroClienteLayout.createSequentialGroup()
                        .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(CadastroClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(numeroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)))
                    .addComponent(jLabel21))
                .addGap(29, 29, 29)
                .addComponent(cadastroCliente)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        mainPanel.add(CadastroCliente, "Cliente");

        CadastroPC.setName("CadastroPC"); // NOI18N

        campoIP.setName("campoIP"); // NOI18N

        campoMesa.setName("campoMesa"); // NOI18N

        campoMAC.setName("campoMAC"); // NOI18N

        campoHostname.setName("campoHostname"); // NOI18N

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        campoNumero.setName("campoNumero"); // NOI18N

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        jLabel18.setFont(resourceMap.getFont("jLabel18.font")); // NOI18N
        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CadastroPCLayout = new javax.swing.GroupLayout(CadastroPC);
        CadastroPC.setLayout(CadastroPCLayout);
        CadastroPCLayout.setHorizontalGroup(
            CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroPCLayout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoHostname, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoIP, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMAC, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        CadastroPCLayout.setVerticalGroup(
            CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CadastroPCLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(campoHostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(campoIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoMAC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(CadastroPCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        mainPanel.add(CadastroPC, "PC");

        RegistroUso.setName("RegistroUso"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        tabelaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "PC", "Entrada", "Saída", "Tempo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaRegistro.setName("tabelaRegistro"); // NOI18N
        jScrollPane1.setViewportView(tabelaRegistro);
        tabelaRegistro.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("tabelaRegistro.columnModel.title0")); // NOI18N
        tabelaRegistro.getColumnModel().getColumn(1).setResizable(false);
        tabelaRegistro.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("tabelaRegistro.columnModel.title1")); // NOI18N
        tabelaRegistro.getColumnModel().getColumn(2).setResizable(false);
        tabelaRegistro.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("tabelaRegistro.columnModel.title2")); // NOI18N
        tabelaRegistro.getColumnModel().getColumn(3).setResizable(false);
        tabelaRegistro.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("tabelaRegistro.columnModel.title3")); // NOI18N
        tabelaRegistro.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("tabelaRegistro.columnModel.title4")); // NOI18N

        jLabel11.setFont(resourceMap.getFont("jLabel11.font")); // NOI18N
        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        javax.swing.GroupLayout RegistroUsoLayout = new javax.swing.GroupLayout(RegistroUso);
        RegistroUso.setLayout(RegistroUsoLayout);
        RegistroUsoLayout.setHorizontalGroup(
            RegistroUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroUsoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(RegistroUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        RegistroUsoLayout.setVerticalGroup(
            RegistroUsoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegistroUsoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        mainPanel.add(RegistroUso, "Uso");

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(sistemalanhouse.SistemaLanHouseApp.class).getContext().getActionMap(SistemaLanHouseView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        menuBar.add(jMenu1);

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        menuBar.add(jMenu2);

        jMenu3.setText(resourceMap.getString("jMenu3.text")); // NOI18N
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem6.setText(resourceMap.getString("jMenuItem6.text")); // NOI18N
        jMenuItem6.setName("jMenuItem6"); // NOI18N
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        menuBar.add(jMenu3);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 508, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    ((java.awt.CardLayout)mainPanel.getLayout()).show(mainPanel,"Principal");
    atualizaInterface();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ((java.awt.CardLayout)mainPanel.getLayout()).show(mainPanel,"Cliente");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ((java.awt.CardLayout)mainPanel.getLayout()).show(mainPanel,"PC");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
       ((java.awt.CardLayout)mainPanel.getLayout()).show(mainPanel,"Uso");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       ((java.awt.CardLayout)mainPanel.getLayout()).show(mainPanel,"Pagamento");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cadastraNovaMaquina();
    
        comboMaquinas.setModel(new javax.swing.DefaultComboBoxModel());
        for(int i=0;i<bd.getMaquinas().size();i++){
            ((javax.swing.DefaultComboBoxModel)comboMaquinas.getModel()).addElement(bd.getMaquinas().get(i));
        } 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroClienteActionPerformed
        String nome = nomeCliente.getText();
        float cpf = Float.parseFloat(cpfCliente.getText());
        String email = emailCliente.getText();
        long numero = Long.parseLong(numeroCliente.getText());
        Cliente cliente = new Cliente(nome, cpf, email, numero);
        bd.getClientes().add(cliente);
          
        insereNaTabela(cliente,tabelaListaClientes);
        javax.swing.JOptionPane.showMessageDialog(null,nome+" cadastrado com sucesso!");
        
        
    }//GEN-LAST:event_cadastroClienteActionPerformed
private void insereNaTabela(Cliente cli, javax.swing.JTable tabela){
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel(); 
        modelo.addRow(new Object[] {cli.getNome(),cli.getCpf(),cli.getEmail(),cli.getTelefone()});
        tabelaListaClientes.repaint();
    
    
}
    private void cadastroClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cadastroClienteMouseClicked

    }//GEN-LAST:event_cadastroClienteMouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    ((java.awt.CardLayout)mainPanel.getLayout()).show(mainPanel,"listarClientes");
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void comboMaquinasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboMaquinasMouseClicked
        //
    }//GEN-LAST:event_comboMaquinasMouseClicked

    private void comboMaquinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMaquinasActionPerformed

    }//GEN-LAST:event_comboMaquinasActionPerformed

    private void comboClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboClienteMousePressed
        //;
    }//GEN-LAST:event_comboClienteMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Sessao umaSessao = new Sessao(null,null);
        //umaSessao.setMaquina(null);
        //umaSessao.setCliente(null);
        umaSessao.setEntrada(new Sessao.Hora(Integer.parseInt(fHora.getText()),Integer.parseInt(fMin.getText())));
        
        DefaultTableModel emUso = (DefaultTableModel) tabelaEmUso.getModel(); 
        //emUso.addRow(new Object[] {comboMaquinas.getSelectedItem(),comboCliente.getSelectedItem(),fHora.getText()+":"+fMin.getText()});
        emUso.addRow(new Object[] {comboMaquinas.getSelectedItem(),comboCliente.getSelectedItem(),new Sessao.Hora(Integer.parseInt(fHora.getText()),Integer.parseInt(fMin.getText()))});
        tabelaEmUso.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelaEmUsoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmUsoMouseClicked
        // Ao clicar na tabela, muda o nome do usuario        
        labelUsuario.setText("Usuario: "+tabelaEmUso.getValueAt(tabelaEmUso.getSelectedRow(),1));
                
    }//GEN-LAST:event_tabelaEmUsoMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Botao SAIDA
        Cliente usuario = (Cliente) tabelaEmUso.getValueAt(tabelaEmUso.getSelectedRow(), 1);
        Object maquina =  tabelaEmUso.getValueAt(tabelaEmUso.getSelectedRow(), 0);
        System.out.println("maq  "+maquina.getClass());
        Sessao.Hora hEntrada = new Sessao.Hora(Integer.parseInt(fHora.getText()),Integer.parseInt(fMin.getText()));
        Sessao.Hora hSaida = new Sessao.Hora(Integer.parseInt(fHoraFim.getText()),Integer.parseInt(fMinFim.getText()));
        long tempo = Calculadora.calculeTempo(hEntrada, hSaida);
        
        DefaultTableModel registro = (DefaultTableModel) tabelaRegistro.getModel();
        registro.addRow(new Object[]{usuario,maquina,hEntrada,hSaida,tempo});
        javax.swing.JOptionPane.showMessageDialog(null,"Tempo total = "+tempo+" minutos\nValor total = R$ "+Calculadora.calculePreco(tempo, (float)0.50));
                tabelaEmUso.repaint();
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CadastroCliente;
    private javax.swing.JPanel CadastroPC;
    private javax.swing.JPanel ListarClientes;
    private javax.swing.JPanel Principal;
    private javax.swing.JPanel RegistroPagamento;
    private javax.swing.JPanel RegistroUso;
    private javax.swing.JButton cadastroCliente;
    private javax.swing.JTextField campoHostname;
    private javax.swing.JTextField campoIP;
    private javax.swing.JTextField campoMAC;
    private javax.swing.JTextField campoMesa;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JComboBox comboCliente;
    private javax.swing.JComboBox comboMaquinas;
    private javax.swing.JTextField cpfCliente;
    private javax.swing.JTextField emailCliente;
    private javax.swing.JFormattedTextField fHora;
    private javax.swing.JTextField fHoraFim;
    private javax.swing.JTextField fMin;
    private javax.swing.JTextField fMinFim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTextField numeroCliente;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTable tabelaEmUso;
    private javax.swing.JTable tabelaListaClientes;
    private javax.swing.JTable tabelaRegistro;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    private void cadastraNovaMaquina() {
        String hostname = campoHostname.getText();
        String ip = campoIP.getText();
        String mac = campoMAC.getText();
        short mesa = Short.parseShort(campoMesa.getText());
        short num = Short.parseShort(campoNumero.getText());
        bd.getMaquinas().add(new Maquina(hostname,ip,mac,mesa,num));
    }

    private void atualizaInterface() {
        //System.out.println("Atualizando combo");
        comboCliente.setModel(new javax.swing.DefaultComboBoxModel());
        for(int i=0;i<bd.getClientes().size();i++){
            ((javax.swing.DefaultComboBoxModel)comboCliente.getModel()).addElement(bd.getClientes().get(i));
        }
   }
}
