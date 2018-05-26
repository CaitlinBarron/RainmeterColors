import javafx.scene.control.Tab;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Caitlin on 5/5/2018.
 */
public class RainmeterColors extends JFrame
{
    private static RainmeterColors _instance;

    private Container pane;
    private Table originalSettings;
    private Table newSettings;
    private Table currentSettings;
    private Component[][] panelHolder;

    private JButton saveButton = new JButton("Save");
    private JButton cancelButton = new JButton("Cancel");
    private JTextField varkTitleBox = new JTextField(" - ");
    private JTextField varkSubBox = new JTextField(" - ");
    private JTextField dayNameBox = new JTextField(" - ");
    private JTextField dayNumBox = new JTextField(" - ");
    private JTextField monthBox = new JTextField(" - ");
    private JTextField binary0Box = new JTextField(" - ");
    private JTextField binaryHr1Box = new JTextField(" - ");
    private JTextField binaryMin1Box = new JTextField(" - ");
    private JTextField binarySec1Box = new JTextField(" - ");
    private JTextField fountian1Box = new JTextField(" - ");
    private JTextField fountian2Box = new JTextField(" - ");
    private JTextField tempBox = new JTextField(" - ");
    private JTextField weatherBox = new JTextField(" - ");

    public RainmeterColors()
    {
        super("Rainmeter colors");
        pane = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int i = 14;
        int j = 2;
        panelHolder = new Component[i][j];
        pane.setLayout(new GridLayout(i, j, 5, 5));

        panelHolder[0][0] = new JLabel("Vark Title", SwingConstants.CENTER);
        panelHolder[1][0] = new JLabel("Vark Subtitle", SwingConstants.CENTER);
        panelHolder[2][0] = new JLabel("Day Name", SwingConstants.CENTER);
        panelHolder[3][0] = new JLabel("Day Number", SwingConstants.CENTER);
        panelHolder[4][0] = new JLabel("Month", SwingConstants.CENTER);
        panelHolder[5][0] = new JLabel("Binary Clock 0", SwingConstants.CENTER);
        panelHolder[6][0] = new JLabel("Binary Clock Hour 1", SwingConstants.CENTER);
        panelHolder[7][0] = new JLabel("Binary Clock Minute 1", SwingConstants.CENTER);
        panelHolder[8][0] = new JLabel("Binary Clock Second 1", SwingConstants.CENTER);
        panelHolder[9][0] = new JLabel("Fountian 1", SwingConstants.CENTER);
        panelHolder[10][0] = new JLabel("Fountian 2", SwingConstants.CENTER);
        panelHolder[11][0] = new JLabel("Temperature", SwingConstants.CENTER);
        panelHolder[12][0] = new JLabel("Weather", SwingConstants.CENTER);
        panelHolder[13][0] = saveButton;

        varkTitleBox.setHorizontalAlignment(SwingConstants.CENTER);
        varkSubBox.setHorizontalAlignment(SwingConstants.CENTER);
        dayNameBox.setHorizontalAlignment(SwingConstants.CENTER);
        dayNumBox.setHorizontalAlignment(SwingConstants.CENTER);
        monthBox.setHorizontalAlignment(SwingConstants.CENTER);
        binary0Box.setHorizontalAlignment(SwingConstants.CENTER);
        binaryHr1Box.setHorizontalAlignment(SwingConstants.CENTER);
        binaryMin1Box.setHorizontalAlignment(SwingConstants.CENTER);
        binarySec1Box.setHorizontalAlignment(SwingConstants.CENTER);
        fountian1Box.setHorizontalAlignment(SwingConstants.CENTER);
        fountian2Box.setHorizontalAlignment(SwingConstants.CENTER);
        tempBox.setHorizontalAlignment(SwingConstants.CENTER);
        weatherBox.setHorizontalAlignment(SwingConstants.CENTER);

        panelHolder[0][1] = varkTitleBox;
        panelHolder[1][1] = varkSubBox;
        panelHolder[2][1] = dayNameBox;
        panelHolder[3][1] = dayNumBox;
        panelHolder[4][1] = monthBox;
        panelHolder[5][1] = binary0Box;
        panelHolder[6][1] = binaryHr1Box;
        panelHolder[7][1] = binaryMin1Box;
        panelHolder[8][1] = binarySec1Box;
        panelHolder[9][1] = fountian1Box;
        panelHolder[10][1] = fountian2Box;
        panelHolder[11][1] = tempBox;
        panelHolder[12][1] = weatherBox;
        panelHolder[13][1] = cancelButton;

        originalSettings = new Table();
        originalSettings.readFiles();
        originalSettings.writeFiles(originalSettings);

        newSettings = new Table(originalSettings);
        currentSettings = new Table(originalSettings);

        originalSettings.updateGui(panelHolder);

        newSettings.readGui(panelHolder);
        currentSettings.readGui(panelHolder);


        //add action listeners for buttons
        saveButton.addActionListener(e->
        {
            newSettings.readGui(panelHolder);
            newSettings.writeFiles(currentSettings);
            currentSettings.readGui(panelHolder);
            currentSettings.setData(newSettings.varkData, newSettings.dateData,
                        newSettings.binaryData, newSettings.fountianData,
                        newSettings.weatherData);
            currentSettings.updateGui(panelHolder);
        });

        cancelButton.addActionListener(e->
        {
            originalSettings.writeFiles(currentSettings);
            currentSettings.readGui(panelHolder);
            currentSettings.setData(originalSettings.varkData, originalSettings.dateData,
                        originalSettings.binaryData, originalSettings.fountianData,
                        originalSettings.weatherData);
            originalSettings.updateGui(panelHolder);
        });


        for (int m = 0; m < i; m++)
        {
            for (int n = 0; n < j; n++)
            {
                pane.add(panelHolder[m][n]);
            }
        }

        updateUI();
        this.setContentPane(pane);
        this.setSize(850, 600);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void updateUI()
    {
        this.revalidate();
        this.repaint();
    }

    private static RainmeterColors getInstance()
    {
        if (_instance == null)
        {
            _instance = new RainmeterColors();
        }
        return _instance;
    }

    public static void main(String[] args)
    {
        RainmeterColors.getInstance();
    }
}
