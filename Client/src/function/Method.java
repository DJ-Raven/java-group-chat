package function;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import main.Main;
import message.Message;
import model.Friend;
import my_swing.ImageViewer;

public class Method {

    public static Recoder getRecoder() {
        return recoder;
    }

    public static void setRecoder(Recoder aRecoder) {
        recoder = aRecoder;
    }

    private static HashMap<Integer, Friend> friends = new HashMap<>();
    private static Socket client;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private static int myID;
    private static String myName;
    private static String time;
    private static JFrame fram;
    private static Recoder recoder = new Recoder();

    public static void setTextFieldSyle(JTextField txt, String style) {
        txt.setName("");
        txt.setForeground(new Color(186, 186, 186));
        txt.setText(style);
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                if (txt.getName().equals("")) {
                    txt.setForeground(new Color(51, 51, 51));
                    txt.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent fe) {
                if (txt.getText().trim().equals("")) {
                    txt.setForeground(new Color(186, 186, 186));
                    txt.setText(style);
                    txt.setName("");
                } else {
                    txt.setName("have");
                }
            }
        });
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                if (txt.getText().trim().equals("")) {
                    txt.setName("");
                } else {
                    txt.setName("have");
                }
            }
        });
    }

    public static void connect(ImageIcon icon, String userName, String IP) throws Exception {
        client = new Socket(IP, 5000);
        out = new ObjectOutputStream(client.getOutputStream());
        in = new ObjectInputStream(client.getInputStream());
        SimpleDateFormat df = new SimpleDateFormat("hh:mm aa");
        String t = df.format(new Date());
        Message ms = new Message();
        ms.setStatus("New");
        ms.setImage(icon);
        ms.setName(userName + "!" + t);
        out.writeObject(ms);
        out.flush();
        myName = userName;
        time = t;
    }

    public static void sendMessage(String text) throws Exception {
        Message ms = new Message();
        ms.setStatus("Message");
        ms.setID(Method.getMyID());
        ms.setMessage(text);
        out.writeObject(ms);
        out.flush();
    }

    public static void sendPhoto(ImageIcon photo) throws Exception {
        Message ms = new Message();
        ms.setStatus("Photo");
        ms.setID(Method.getMyID());
        ms.setImage(photo);
        out.writeObject(ms);
        out.flush();
    }

    public static void sendFile(File file) throws Exception {
        FileInputStream in = new FileInputStream(file);
        byte data[] = new byte[in.available()];
        in.read(data);
        in.close();
        String fileSize = convertSize(file.length());
        Message ms = new Message();
        ms.setStatus("File");
        ms.setID(Method.getMyID());
        ms.setData(data);
        ms.setName(file.getName() + "!" + fileSize);
        out.writeObject(ms);
        out.flush();
    }

    public static void sendEmoji(String emoji) throws Exception {
        Message ms = new Message();
        ms.setStatus("Emoji");
        ms.setID(Method.getMyID());
        ms.setMessage(emoji);
        out.writeObject(ms);
        out.flush();
    }

    private static String getDurationString(int seconds) {
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        return oneDigitString(minutes) + ":" + twoDigitString(seconds);
    }

    private static String twoDigitString(int number) {
        if (number == 0) {
            return "00";
        }
        if (number / 10 == 0) {
            return "0" + number;
        }
        return String.valueOf(number);
    }

    private static String oneDigitString(int number) {
        if (number == 0) {
            return "0";
        }
        if (number / 10 == 0) {
            return "" + number;
        }
        return String.valueOf(number);
    }

    public static void sendSound(ByteArrayOutputStream sount, int time) throws Exception {
        Message ms = new Message();
        ms.setStatus("Sound");
        ms.setID(Method.getMyID());
        ms.setMessage(getDurationString(time) + "!" + time);
        ms.setData(sount.toByteArray());
        out.writeObject(ms);
        out.flush();
    }

    public static void downloadFile(int ID, String name) {
        try {
            String ex[] = name.split("\\.");
            String x = ex[ex.length - 1];
            JFileChooser ch = new JFileChooser();
            ch.setSelectedFile(new File(name));
            int c = ch.showSaveDialog(Main.getFrames()[0]);
            if (c == JFileChooser.APPROVE_OPTION) {
                File f = ch.getSelectedFile();
                if (f.exists()) {
                    int click = JOptionPane.showConfirmDialog(Main.getFrames()[0], "This file name has already do you want to replace", "Save File", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (click != JOptionPane.YES_OPTION) {
                        return;
                    }
                }
                String parth = f.getAbsolutePath();
                if (!parth.endsWith("." + x)) {
                    parth += "." + x;
                }
                Message ms = new Message();
                ms.setStatus("download");
                ms.setID(Method.getMyID());
                ms.setName(parth);
                ms.setMessage(ID + "");
                out.writeObject(ms);
                out.flush();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fram, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void showImage(ImageIcon image) {
        JPopupMenu pop = new JPopupMenu();
        pop.setBackground(new Color(0, 0, 0, 0));
        ImageViewer obj = new ImageViewer();
        obj.setImage(image);
        pop.add(obj);
        int w = (int) obj.getPreferredSize().getWidth();
        int h = (int) obj.getPreferredSize().getHeight();
        pop.show(fram, fram.getWidth() / 2 - w / 2, fram.getHeight() / 2 - h / 2);
    }
    private static final String[] fileSizeUnits = {"bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};

    private static String convertSize(double bytes) {
        String sizeToReturn;
        DecimalFormat df = new DecimalFormat("0.#");
        int index;
        for (index = 0; index < fileSizeUnits.length; index++) {
            if (bytes < 1024) {
                break;
            }
            bytes = bytes / 1024;
        }
        System.out.println("Systematic file size: " + bytes + " " + fileSizeUnits[index]);
        sizeToReturn = df.format(bytes) + " " + fileSizeUnits[index];
        return sizeToReturn;
    }

    public static Font getFount() {
        return new java.awt.Font("Khmer SBBIC Serif", 0, 12);
    }

    public static Font getFountBold() {
        return new java.awt.Font("Khmer SBBIC Serif", 1, 12);
    }

    public static HashMap<Integer, Friend> getFriends() {
        return friends;
    }

    public static void setFriends(HashMap<Integer, Friend> aFriends) {
        friends = aFriends;
    }

    public static ObjectOutputStream getOut() {
        return out;
    }

    public static void setOut(ObjectOutputStream aOut) {
        out = aOut;
    }

    public static ObjectInputStream getIn() {
        return in;
    }

    public static void setIn(ObjectInputStream aIn) {
        in = aIn;
    }

    public static int getMyID() {
        return myID;
    }

    public static void setMyID(int aMyID) {
        myID = aMyID;
    }

    public static String getMyName() {
        return myName;
    }

    public static void setMyName(String aMyName) {
        myName = aMyName;
    }

    public static Socket getClient() {
        return client;
    }

    public static void setClient(Socket aClient) {
        client = aClient;
    }

    public static String getTime() {
        return time;
    }

    public static void setTime(String aTime) {
        time = aTime;
    }

    public static JFrame getFram() {
        return fram;
    }

    public static void setFram(JFrame aFram) {
        fram = aFram;
    }
}
