package main;

import function.FileChooser;
import function.Method;
import function.Scrolling;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import message.Message;
import my_swing.Emoji;
import my_swing.Emoji_Group;
import my_swing.Get_Box;
import my_swing.Friend_Box;
import my_swing.Get_Box_New;
import my_swing.Get_Emoji;
import my_swing.Get_Emoji_New;
import my_swing.Get_File;
import my_swing.Get_File_New;
import my_swing.Get_Photo_Box;
import my_swing.Get_Photo_Box_New;
import my_swing.Get_Sound;
import my_swing.Get_Sound_New;
import my_swing.Send_Box;
import my_swing.Send_Box_New;
import my_swing.Send_Emoji;
import my_swing.Send_Emoji_New;
import my_swing.Send_File;
import my_swing.Send_File_New;
import my_swing.Send_Photo_Box;
import my_swing.Send_Photo_Box_New;
import my_swing.Send_Sound;
import my_swing.Send_Sound_New;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        open();
    }

    private void open() {
        setIconImage(new ImageIcon(getClass().getResource("/icon/icon.png")).getImage());
        popUp.add(panel);
        popUp_emoji.add(panel_emoji);
        popMix.add(panelMix);
        popMix.setBackground(new Color(0, 0, 0, 0));
        Method.setFram(this);
        new Scrolling(panelChat);
        new Scrolling(panelFriend);
        Method.setTextFieldSyle(txt, "Type a message here ...");
        for (int i = 0; i < 10; i++) {
            cmdSendActionPerformed(null);
        }
        Emoji_Group eg1 = new Emoji_Group("emoji_green.png", 28);
        eg1.setName("emoji_green");
        eg1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setEmoji(eg1);
            }
        });
        panelGroup.add(eg1);
        Emoji_Group eg2 = new Emoji_Group("emoji_yellow.png", 28);
        eg2.setName("emoji_yellow");
        eg2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelEmoji.removeAll();
                for (int i = 1; i <= eg2.getIcons(); i++) {
                    Emoji emo = new Emoji(eg2.getName() + " (" + i + ").png");
                    emo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            setEmoji(emo.getName());
                        }
                    });
                    panelEmoji.add(emo);
                }
                panelEmoji.revalidate();
                panelEmoji.repaint();
            }
        });
        panelGroup.add(eg2);
        setEmoji(eg1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUp = new javax.swing.JPopupMenu();
        panel = new my_swing.Panel();
        cmdPhoto = new my_swing.Button();
        cmdEmoji = new my_swing.Button();
        cmdFile = new my_swing.Button();
        cmdMicro = new my_swing.Button();
        popUp_emoji = new javax.swing.JPopupMenu();
        panel_emoji = new my_swing.Panel();
        panel1 = new my_swing.Panel();
        panelEmoji = new javax.swing.JLayeredPane();
        spGroup = new javax.swing.JScrollPane();
        panelGroup = new javax.swing.JPanel();
        popMix = new javax.swing.JPopupMenu();
        panelMix = new my_swing.Panel();
        panel2 = new my_swing.Panel();
        cmdMix = new javax.swing.JButton();
        panel_bg = new javax.swing.JPanel();
        spChat = new javax.swing.JScrollPane();
        panelChat = new javax.swing.JDesktopPane(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        spFriend = new javax.swing.JScrollPane();
        panelFriend = new javax.swing.JPanel();
        txt = new javax.swing.JTextField(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(195, 191, 191));
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 0, 0);
            }
        };
        cmdSend = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmdMore = new javax.swing.JButton();
        cmdLogOut = new my_swing.Button();
        lbStatus = new javax.swing.JLabel();

        popUp.setBackground(new java.awt.Color(0,0,0,0));

        panel.setBackground(new java.awt.Color(255, 255, 255));

        cmdPhoto.setBackground(new java.awt.Color(255, 255, 255));
        cmdPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/photo.png"))); // NOI18N
        cmdPhoto.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/photo_click.png"))); // NOI18N
        cmdPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPhotoActionPerformed(evt);
            }
        });

        cmdEmoji.setBackground(new java.awt.Color(255, 255, 255));
        cmdEmoji.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/emoji.png"))); // NOI18N
        cmdEmoji.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/emoji_click.png"))); // NOI18N
        cmdEmoji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdEmojiActionPerformed(evt);
            }
        });

        cmdFile.setBackground(new java.awt.Color(255, 255, 255));
        cmdFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file.png"))); // NOI18N
        cmdFile.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/file_click.png"))); // NOI18N
        cmdFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdFileActionPerformed(evt);
            }
        });

        cmdMicro.setBackground(new java.awt.Color(255, 255, 255));
        cmdMicro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/microphone.png"))); // NOI18N
        cmdMicro.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/microphone_click.png"))); // NOI18N
        cmdMicro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMicroActionPerformed(evt);
            }
        });

        panel.setLayer(cmdPhoto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(cmdEmoji, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(cmdFile, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(cmdMicro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmdFile, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmdPhoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmdEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdEmoji, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdFile, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmdMicro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        popUp_emoji.setBackground(new java.awt.Color(0,0,0,0));
        popUp_emoji.setMaximumSize(new java.awt.Dimension(504, 355));
        popUp_emoji.setMinimumSize(new java.awt.Dimension(504, 355));
        popUp_emoji.setPreferredSize(new java.awt.Dimension(504, 355));

        panel_emoji.setBackground(new java.awt.Color(153, 153, 153));
        panel_emoji.setMaximumSize(new java.awt.Dimension(502, 349));
        panel_emoji.setMinimumSize(new java.awt.Dimension(502, 349));

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        panelEmoji.setMaximumSize(new java.awt.Dimension(488, 291));
        panelEmoji.setMinimumSize(new java.awt.Dimension(488, 291));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        panelEmoji.setLayout(flowLayout1);

        spGroup.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spGroup.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panelGroup.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 0);
        flowLayout2.setAlignOnBaseline(true);
        panelGroup.setLayout(flowLayout2);
        spGroup.setViewportView(panelGroup);

        panel1.setLayer(panelEmoji, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel1.setLayer(spGroup, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spGroup)
                    .addComponent(panelEmoji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(spGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEmoji, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_emoji.setLayer(panel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel_emojiLayout = new javax.swing.GroupLayout(panel_emoji);
        panel_emoji.setLayout(panel_emojiLayout);
        panel_emojiLayout.setHorizontalGroup(
            panel_emojiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_emojiLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        panel_emojiLayout.setVerticalGroup(
            panel_emojiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_emojiLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        popUp.setBackground(new java.awt.Color(0,0,0,0));

        panelMix.setBackground(new java.awt.Color(102, 102, 102));

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        cmdMix.setBackground(new java.awt.Color(242, 67, 67));
        cmdMix.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        cmdMix.setForeground(new java.awt.Color(255, 255, 255));
        cmdMix.setText("Start");
        cmdMix.setContentAreaFilled(false);
        cmdMix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdMix.setOpaque(true);
        cmdMix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmdMixMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmdMixMouseReleased(evt);
            }
        });

        panel2.setLayer(cmdMix, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMix, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMix, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMix.setLayer(panel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelMixLayout = new javax.swing.GroupLayout(panelMix);
        panelMix.setLayout(panelMixLayout);
        panelMixLayout.setHorizontalGroup(
            panelMixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMixLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        panelMixLayout.setVerticalGroup(
            panelMixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMixLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Khmer Chat");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_bg.setBackground(new java.awt.Color(255, 255, 255));

        spChat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        spChat.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spChat.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panelChat.setBackground(new java.awt.Color(255, 255, 255));
        panelChat.setLayout(new javax.swing.BoxLayout(panelChat, javax.swing.BoxLayout.Y_AXIS));
        spChat.setViewportView(panelChat);

        spFriend.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        spFriend.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spFriend.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panelFriend.setBackground(new java.awt.Color(255, 255, 255));
        panelFriend.setLayout(new javax.swing.BoxLayout(panelFriend, javax.swing.BoxLayout.Y_AXIS));
        spFriend.setViewportView(panelFriend);

        txt.setFont(new java.awt.Font("Khmer SBBIC Serif", 0, 14)); // NOI18N
        txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5));
        txt.setSelectionColor(new java.awt.Color(131, 188, 227));
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeyTyped(evt);
            }
        });

        cmdSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/send.png"))); // NOI18N
        cmdSend.setBorder(null);
        cmdSend.setContentAreaFilled(false);
        cmdSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdSend.setFocusable(false);
        cmdSend.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/send_click.png"))); // NOI18N
        cmdSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSendActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Khmer SBBIC Serif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("List Friend");

        jLabel2.setFont(new java.awt.Font("Khmer SBBIC Serif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Real Chat");

        cmdMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/more.png"))); // NOI18N
        cmdMore.setBorder(null);
        cmdMore.setContentAreaFilled(false);
        cmdMore.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdMore.setFocusable(false);
        cmdMore.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/more_click.png"))); // NOI18N
        cmdMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMoreActionPerformed(evt);
            }
        });

        cmdLogOut.setBackground(new java.awt.Color(255, 255, 255));
        cmdLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        cmdLogOut.setForeground(new java.awt.Color(51, 51, 51));
        cmdLogOut.setText("Sign out");
        cmdLogOut.setColorClick(new java.awt.Color(255, 255, 255));
        cmdLogOut.setColorOver(new java.awt.Color(243, 243, 243));
        cmdLogOut.setFocusable(false);
        cmdLogOut.setFont(new java.awt.Font("Khmer SBBIC Serif", 1, 12)); // NOI18N
        cmdLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogOutActionPerformed(evt);
            }
        });

        lbStatus.setFont(new java.awt.Font("Khmer SBBIC Serif", 0, 14)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 0, 51));
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout panel_bgLayout = new javax.swing.GroupLayout(panel_bg);
        panel_bg.setLayout(panel_bgLayout);
        panel_bgLayout.setHorizontalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spFriend)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bgLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_bgLayout.createSequentialGroup()
                        .addComponent(txt, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdMore)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdSend, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(spChat, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addGroup(panel_bgLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        panel_bgLayout.setVerticalGroup(
            panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(lbStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spFriend, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spChat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt)
                    .addComponent(cmdMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel_bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void setEmoji(Emoji_Group eg1) {
        panelEmoji.removeAll();
        for (int i = 1; i <= eg1.getIcons(); i++) {
            Emoji emo = new Emoji(eg1.getName() + " (" + i + ").png");
            emo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    setEmoji(emo.getName());
                }
            });
            panelEmoji.add(emo);
        }
        panelEmoji.revalidate();
        panelEmoji.repaint();
    }
    private void cmdSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSendActionPerformed
        if (txt.getName().equals("have") && !txt.getText().equals("")) {
            try {
                Method.sendMessage(txt.getText().trim());
                txt.setText("");
                txt.grabFocus();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_cmdSendActionPerformed

    private void cmdMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMoreActionPerformed
        popUp.show(cmdMore, -10, -155);
    }//GEN-LAST:event_cmdMoreActionPerformed

    private void txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyTyped
        if (evt.getKeyChar() == 10) {
            cmdSendActionPerformed(null);
        }
    }//GEN-LAST:event_txtKeyTyped

    private Thread th;
    private int currentID = 0;

    private void start() {
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println("waiting message ...");
                        Message ms = (Message) Method.getIn().readObject();
                        String status = ms.getStatus();
                        if (status.equals("Message")) {
                            getMessage(ms.getID(), ms.getMessage());
                        } else if (status.equals("New")) {
                            newFriend(ms.getImage(), ms.getID(), ms.getName().split("!")[0], ms.getName().split("!")[1]);
                        } else if (status.equals("Photo")) {
                            getPhoto(ms.getID(), ms.getImage());
                        } else if (status.equals("File")) {
                            getFile(ms.getID(), ms.getName(), ms.getImage());
                        } else if (status.equals("Error")) {
                            errorFrient(ms.getID());
                        } else if (status.equals("Emoji")) {
                            getEmoji(ms.getID(), ms.getMessage());
                        } else if (status.equals("GetFile")) {
                            download(ms);
                        } else if (status.equals("Sound")) {
                            getSound(ms.getID(), ms.getData(), ms.getMessage());
                        }
                    }
                } catch (Exception e) {
                    String ms = e.getMessage();
                    if (ms.equals("Socket closed")) {
                        signOut("Sign out");
                    } else if (ms.equals("Connection reset")) {
                        signOut("Server has error");
                    } else {
                        signOut("Error : " + ms);
                    }

                }
            }
        });
        th.start();
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        start();
    }//GEN-LAST:event_formWindowOpened

    private void cmdPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPhotoActionPerformed
        popUp.setVisible(false);
        setImage();
    }//GEN-LAST:event_cmdPhotoActionPerformed

    private void cmdEmojiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdEmojiActionPerformed
        popUp.setVisible(false);
        popUp_emoji.show(txt, 5, -365);
    }//GEN-LAST:event_cmdEmojiActionPerformed

    private void cmdFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdFileActionPerformed
        try {
            popUp.setVisible(false);
            setFile();
        } catch (Exception e) {
            showStatus("Error : " + e.getMessage());
        }
    }//GEN-LAST:event_cmdFileActionPerformed

    private void cmdMicroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMicroActionPerformed
        popMix.show(txt, 170, -90);
    }//GEN-LAST:event_cmdMicroActionPerformed

    private void cmdMixMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMixMousePressed
        cmdMix.setBackground(new Color(94, 197, 95));
        cmdMix.setText("Starting");
        Method.getRecoder().captureAudio();
    }//GEN-LAST:event_cmdMixMousePressed

    private void cmdMixMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdMixMouseReleased
        try {
            cmdMix.setBackground(new Color(242, 67, 67));
            cmdMix.setText("Start");
            Method.sendSound(Method.getRecoder().stop(), Method.getRecoder().getTime());
            popMix.setVisible(false);
        } catch (Exception e) {
            showStatus("Error : " + e.getMessage());
        }
    }//GEN-LAST:event_cmdMixMouseReleased

    private void cmdLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogOutActionPerformed
        int c = JOptionPane.showConfirmDialog(this, "Are you sure you want to sign out ?", "Sign out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (c == JOptionPane.YES_OPTION) {
            try {
                Method.getClient().close();
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_cmdLogOutActionPerformed

    private void signOut(String ms) {
        try {
            this.dispose();
            String[] v = {ms};
            Login.main(v);
        } catch (Exception e) {
        }
    }

    private void getMessage(int ID, String ms) {
        if (ID == Method.getMyID()) {
            if (ID == currentID) {
                Send_Box box = new Send_Box();
                box.setMessage(ms);
                panelChat.add(box);
            } else {
                Send_Box_New box = new Send_Box_New();
                box.setMessage(ID, ms);
                panelChat.add(box);
            }
        } else {
            if (ID == currentID) {
                Get_Box box = new Get_Box();
                box.setMessage(ms);
                panelChat.add(box);
            } else {
                Get_Box_New box = new Get_Box_New();
                box.setMessage(ID, ms);
                panelChat.add(box);
            }
            playSound();
        }
        currentID = ID;
        refresh(panelChat);
        scrollToBottom(spChat);
    }

    private void getPhoto(int ID, ImageIcon image) {
        if (ID == Method.getMyID()) {
            if (ID == currentID) {
                Send_Photo_Box box = new Send_Photo_Box();
                box.setPhoto(image);
                panelChat.add(box);
            } else {
                Send_Photo_Box_New box = new Send_Photo_Box_New();
                box.setPhoto(ID, image);
                panelChat.add(box);
            }
        } else {
            if (ID == currentID) {
                Get_Photo_Box box = new Get_Photo_Box();
                box.setPhoto(image);
                panelChat.add(box);
            } else {
                Get_Photo_Box_New box = new Get_Photo_Box_New();
                box.setPhoto(ID, image);
                panelChat.add(box);
            }
            playSound();
        }
        currentID = ID;
        refresh(panelChat);
        scrollToBottom(spChat);
    }

    private void getEmoji(int ID, String emoji) {
        if (ID == Method.getMyID()) {
            if (ID == currentID) {
                Send_Emoji box = new Send_Emoji();
                box.setPhoto(emoji);
                panelChat.add(box);
            } else {
                Send_Emoji_New box = new Send_Emoji_New();
                box.setPhoto(ID, emoji);
                panelChat.add(box);
            }
        } else {
            if (ID == currentID) {
                Get_Emoji box = new Get_Emoji();
                box.setPhoto(emoji);
                panelChat.add(box);
            } else {
                Get_Emoji_New box = new Get_Emoji_New();
                box.setPhoto(ID, emoji);
                panelChat.add(box);
            }
            playSound();
        }
        currentID = ID;
        refresh(panelChat);
        scrollToBottom(spChat);
    }

    private void getFile(int ID, String ms, ImageIcon icon) {
        if (ID == Method.getMyID()) {
            if (ID == currentID) {
                Send_File box = new Send_File();
                box.set(ms, icon);
                panelChat.add(box);
            } else {
                Send_File_New box = new Send_File_New();
                box.set(ID, ms, icon);
                panelChat.add(box);
            }
        } else {
            if (ID == currentID) {
                Get_File box = new Get_File();
                box.set(ms, icon);
                panelChat.add(box);
            } else {
                Get_File_New box = new Get_File_New();
                box.set(ID, ms, icon);
                panelChat.add(box);
            }
            playSound();
        }
        currentID = ID;
        refresh(panelChat);
        scrollToBottom(spChat);
    }

    private void getSound(int ID, byte[] sound, String time) {
        if (ID == Method.getMyID()) {
            if (ID == currentID) {
                Send_Sound box = new Send_Sound();
                box.set(sound, time);
                panelChat.add(box);
            } else {
                Send_Sound_New box = new Send_Sound_New();
                box.set(ID, sound, time);
                panelChat.add(box);
            }
        } else {
            if (ID == currentID) {
                Get_Sound box = new Get_Sound();
                box.set(sound, time);
                panelChat.add(box);
            } else {
                Get_Sound_New box = new Get_Sound_New();
                box.set(ID, sound, time);
                panelChat.add(box);
            }
            playSound();
        }
        currentID = ID;
        refresh(panelChat);
        scrollToBottom(spChat);
    }

    private void download(Message ms) {
        try {
            File file = new File(ms.getName());
            FileOutputStream out = new FileOutputStream(file);
            out.write(ms.getData());
            out.close();
        } catch (Exception e) {
            showStatus("Error : can't download");
        }
    }

    private void newFriend(ImageIcon image, int ID, String name, String time) {
        Friend_Box friend = new Friend_Box();
        friend.set(image, ID, name, time);
        Method.getFriends().put(ID, friend);
        if (Method.getMyName().equalsIgnoreCase(name)) {
            Method.setMyID(ID);
            friend.itMe();
        }
        panelFriend.add(friend);
        refresh(panelFriend);
    }

    private void errorFrient(int ID) {
        panelFriend.remove((Component) Method.getFriends().get(ID));
        Method.getFriends().remove(ID);
        refresh(panelFriend);
    }

    private void refresh(Component obj) {
        obj.revalidate();
        obj.repaint();
    }

    private void setImage() {
        JFileChooser ch = new JFileChooser();
        FileChooser preview = new FileChooser();
        ch.setAccessory(preview);
        ch.addPropertyChangeListener(preview);
        ch.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                String name = file.getName();
                return file.isDirectory() || name.endsWith(".png") || name.endsWith(".PNG") || name.endsWith("jpg") || name.endsWith("JPG");
            }

            @Override
            public String getDescription() {
                return "png,jpg";
            }
        });
        int c = ch.showOpenDialog(this);
        if (c == JFileChooser.APPROVE_OPTION) {
            ImageIcon image = new ImageIcon(ch.getSelectedFile().getAbsolutePath());
            try {
                Method.sendPhoto(image);
            } catch (Exception e) {
                showStatus("Error : Can't send photo");
            }
        }
    }

    private void setFile() throws Exception {
        JFileChooser ch = new JFileChooser();
        FileChooser preview = new FileChooser();
        ch.setAccessory(preview);
        ch.addPropertyChangeListener(preview);
        int c = ch.showOpenDialog(this);
        if (c == JFileChooser.APPROVE_OPTION) {
            Method.sendFile(ch.getSelectedFile());
        }
    }

    private void scrollToBottom(JScrollPane scrollPane) {
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }

    private void setEmoji(String emoji) {
        try {
            Method.sendEmoji(emoji);
        } catch (Exception e) {
            showStatus("Error : " + e.getMessage());
        }
    }

    private void playSound() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = this.getClass().getClassLoader().getResource("sound/sound.wav");
                    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioIn);
                    clip.start();
                } catch (Exception e) {
                }
            }
        }).start();
    }
    private Timer timer = new Timer(5000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lbStatus.setText("");
            timer.stop();
        }
    });

    private void showStatus(String error) {
        if (timer.isRunning()) {
            lbStatus.setText("");
            timer.stop();
        }
        timer.start();
        lbStatus.setText(error);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private my_swing.Button cmdEmoji;
    private my_swing.Button cmdFile;
    private my_swing.Button cmdLogOut;
    private my_swing.Button cmdMicro;
    private javax.swing.JButton cmdMix;
    private javax.swing.JButton cmdMore;
    private my_swing.Button cmdPhoto;
    private javax.swing.JButton cmdSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbStatus;
    private my_swing.Panel panel;
    private my_swing.Panel panel1;
    private my_swing.Panel panel2;
    private javax.swing.JDesktopPane panelChat;
    private javax.swing.JLayeredPane panelEmoji;
    private javax.swing.JPanel panelFriend;
    private javax.swing.JPanel panelGroup;
    private my_swing.Panel panelMix;
    private javax.swing.JPanel panel_bg;
    private my_swing.Panel panel_emoji;
    private javax.swing.JPopupMenu popMix;
    private javax.swing.JPopupMenu popUp;
    private javax.swing.JPopupMenu popUp_emoji;
    private javax.swing.JScrollPane spChat;
    private javax.swing.JScrollPane spFriend;
    private javax.swing.JScrollPane spGroup;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}
