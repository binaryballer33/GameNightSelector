package com.gamenight.client;

import com.gamenight.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GUI {
    private final JFrame frame = new JFrame();

    public GUI() {
        ArrayList<Player> playersArray = CSVParser.getPlayerInfo();
        ArrayList<Player> playersInAttendance = new ArrayList<>();
        Map<String, Player> playersMap = new HashMap<>();

        JPanel container = new JPanel();
        container.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(new JLabel("Choose Players"));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        // create JButton that we will click and this will filter out the games
        JButton chooseGameButton = new JButton("Choose Game");
        chooseGameButton.addActionListener((event) -> {
            StringBuilder popUpText = new StringBuilder();
            int i = 0;
            for (Player playerInfo : playersInAttendance) {
                if (i == playersInAttendance.size() - 1) {
                    popUpText.append(playerInfo.getPlayerName());
                } else {
                    popUpText.append(playerInfo.getPlayerName()).append(", ");
                }
                i++;
            }
            popUpText.append(" will be playing:");


            BoardGame game = GetAGame.pickAGame(playersInAttendance);
            // ternary to decide gameName
            String gameName = (game != null)
                    ? game.getGameName()
                    : "There is no compatible game for this specific combination of players";

            JDialog dialog = new JDialog(frame, String.valueOf(popUpText), true);
            dialog.setBounds(300, 300, 400, 200);
            dialog.setLocationRelativeTo(frame);
            dialog.add(new JLabel(gameName, JLabel.CENTER));
            dialog.setVisible(true);
        });

        // create all of JCheckBox objects and add them to the panel, set them to unchecked by default
        // add each playersName, Player obj reference as (k,v) pairs in a playersMap
        for (Player player : playersArray) {
            JCheckBox playerCheckbox = new JCheckBox(player.getPlayerName());
            playerCheckbox.setSelected(false);
            // create playerCheckBox Action Listener with a lambda expression
            playerCheckbox.addActionListener((event) -> {
                JCheckBox source = (JCheckBox) event.getSource();
                // if the JCheckBox isSelected, add that player to the playersInAttendance array
                // else JCheckBox isSelected is false, remove that player from the array
                if (source.isSelected()) {
                    playersInAttendance.add(playersMap.get(source.getText()));
                } else {
                    playersInAttendance.remove(playersMap.get(source.getText()));
                }
            });
            // add the completed checkbox to the gui and populate the map with it's (k,v)
            panel.add(playerCheckbox, BorderLayout.WEST);
            playersMap.put(player.getPlayerName(), player);
        }

        container.add(panel);
        String path = "src/main/resources/gameNightImage.jpeg";
        ImageIcon image = new ImageIcon(path);
        JLabel imageLabel = new JLabel(image);
        imageLabel.setPreferredSize(new Dimension(340, 160));
        container.add(imageLabel);
        container.repaint();
        container.add(chooseGameButton);

        frame.add(container, BorderLayout.CENTER);
        frame.setTitle("Game Night Selector");
        frame.pack();
        frame.setSize(400, 800);
        // places the gui in the middle of the screen when it opens
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
