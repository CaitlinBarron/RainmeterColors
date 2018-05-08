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
    public JPanel[][] panelHolder;
    public JButton saveButton = new JButton("Save");
    public JButton applyButton = new JButton("Apply");

    public RainmeterColors()
    {
        super("Rainmeter colors");
        pane = this.getContentPane();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int i = 14;
        int j = 2;
        panelHolder = new JPanel[i][j];
        pane.setLayout(new GridLayout(i, j, 5,5));
        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                pane.add(panelHolder[m][n]);
            }
        }
        panelHolder[0][0].add(new JLabel("Vark Title"));
        panelHolder[1][0].add(new JLabel("Vark Subtitle"));
        panelHolder[2][0].add(new JLabel("Day Name"));
        panelHolder[3][0].add(new JLabel("Day Number"));
        panelHolder[4][0].add(new JLabel("Month"));
        panelHolder[5][0].add(new JLabel("Binary Clock 0"));
        panelHolder[6][0].add(new JLabel("Binary Clock Hour 1"));
        panelHolder[7][0].add(new JLabel("Binary Clock Minute 1"));
        panelHolder[8][0].add(new JLabel("Binary Clock Second 1"));
        panelHolder[9][0].add(new JLabel("Fountian 1"));
        panelHolder[10][0].add(new JLabel("Fountian 2"));
        panelHolder[11][0].add(new JLabel("Temperature"));
        panelHolder[12][0].add(new JLabel("Weather"));
        panelHolder[13][0].add(saveButton);
        panelHolder[13][1].add(applyButton);

        oldSettings = new Table();
        oldSettings.readFiles();

        //add action listeners for buttons?

        updateUI();
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
