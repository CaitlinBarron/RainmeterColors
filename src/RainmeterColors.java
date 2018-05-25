import javax.swing.*;
import java.awt.*;

/**
 * Created by Caitlin on 5/5/2018.
 */
public class RainmeterColors extends JFrame
{
    private static RainmeterColors _instance;

    public Container pane;
    public Table oldSettings;
    public Table newSettings;
    public Component[][] panelHolder;

    public JButton saveButton = new JButton("Save");
    public JButton cancelButton = new JButton("Cancel");
    public JTextField varkTitleBox = new JTextField(" - ");
    public JTextField varkSubBox = new JTextField(" - ");
    public JTextField dayNameBox = new JTextField(" - ");
    public JTextField dayNumBox = new JTextField(" - ");
    public JTextField monthBox = new JTextField(" - ");
    public JTextField binary0Box = new JTextField(" - ");
    public JTextField binaryHr1Box = new JTextField(" - ");
    public JTextField binaryMin1Box = new JTextField(" - ");
    public JTextField binarySec1Box = new JTextField(" - ");
    public JTextField fountian1Box = new JTextField(" - ");
    public JTextField fountian2Box = new JTextField(" - ");
    public JTextField tempBox = new JTextField(" - ");
    public JTextField weatherBox = new JTextField(" - ");

    public RainmeterColors()
    {
        super("Rainmeter colors");
        pane = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int i = 14;
        int j = 2;
        panelHolder = new Component[i][j];
        pane.setLayout(new GridLayout(i, j, 5,5));

        panelHolder[0][0] = new JLabel("Vark Title");
        panelHolder[1][0] = new JLabel("Vark Subtitle");
        panelHolder[2][0] = new JLabel("Day Name");
        panelHolder[3][0] = new JLabel("Day Number");
        panelHolder[4][0] = new JLabel("Month");
        panelHolder[5][0] = new JLabel("Binary Clock 0");
        panelHolder[6][0] = new JLabel("Binary Clock Hour 1");
        panelHolder[7][0] = new JLabel("Binary Clock Minute 1");
        panelHolder[8][0] = new JLabel("Binary Clock Second 1");
        panelHolder[9][0] = new JLabel("Fountian 1");
        panelHolder[10][0] = new JLabel("Fountian 2");
        panelHolder[11][0] = new JLabel("Temperature");
        panelHolder[12][0] = new JLabel("Weather");
        panelHolder[13][0] = saveButton;

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

        oldSettings = new Table();
        newSettings = new Table();
        oldSettings.readFiles(panelHolder);

        //add action listeners for buttons?
        saveButton.addActionListener(e->{newSettings.writeFiles(panelHolder, true);});
        cancelButton.addActionListener(e->{oldSettings.writeFiles(panelHolder, false);});


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
