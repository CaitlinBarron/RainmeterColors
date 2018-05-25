import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Caitlin on 5/5/2018.
 */
public class Table
{
    public String varkTitle;
    public String varkSub;
    public String dayName;
    public String dayNum;
    public String month;
    public String binary0;
    public String binaryHr1;
    public String binaryMin1;
    public String binarySec1;
    public String fountian1;
    public String fountian2;
    public String temp;
    public String weather;

    private String varkFile = "C:\\Users\\Caitlin\\Documents\\misc\\Rainmeter\\Skins\\Vark\\Resources\\Style.inc";
    private String dateFile = "C:\\Users\\Caitlin\\Documents\\misc\\Rainmeter\\Skins\\MemoDijay\\Weather+Date\\Weather+Date.ini";
    private String binaryFile = "C:\\Users\\Caitlin\\Documents\\misc\\Rainmeter\\Skins\\Binary_Clock\\Appearance.txt";
    private String fountianFile = "C:\\Users\\Caitlin\\Documents\\misc\\Rainmeter\\Skins\\Fountain of Colors\\@Resources\\Variables.inc";
    private String weatherFile = "C:\\Users\\Caitlin\\Documents\\misc\\Rainmeter\\Skins\\raleway\\Variables\\globalvariables.inc";

    private StringBuffer varkData = new StringBuffer();
    private StringBuffer dateData = new StringBuffer();
    private StringBuffer binaryData = new StringBuffer();
    private StringBuffer fountianData = new StringBuffer();
    private StringBuffer weatherData = new StringBuffer();

    public Table()
    {
        varkTitle = "";
        varkSub = "";
        dayName = "";
        dayNum = "";
        month = "";
        binary0 = "";
        binaryHr1 = "";
        binaryMin1 = "";
        binarySec1 = "";
        fountian1 = "";
        fountian2 = "";
        temp = "";
        weather = "";
    }

    public boolean readFiles(Component[][] panelHolder)
    {
        boolean retval = true;
        int i = 1;
        Scanner fileToRead = null;

        try
        {
            fileToRead = new Scanner(new File(varkFile));
            for(String line; fileToRead.hasNextLine() && ((line = fileToRead.nextLine()) != null);)
            {
                if (i == 11)
                {
                    varkTitle = line.substring(7);
                }
                else if (i == 12)
                {
                    varkSub = line.substring(7);
                }

                varkData.append(line).append("\r\n");
                i++;
            }
            fileToRead.close();

            fileToRead = new Scanner(new File(dateFile));
            i = 1;
            for(String line; fileToRead.hasNextLine() && ((line = fileToRead.nextLine()) != null);)
            {
                if (i == 48)
                {
                    dayName = line.substring(10);
                }
                else if (i == 33)
                {
                    dayNum = line.substring(10);
                }
                else if (i == 63)
                {
                    month = line.substring(10);
                }

                dateData.append(line).append("\r\n");
                i++;
            }
            fileToRead.close();

            fileToRead = new Scanner(new File(binaryFile));
            i = 1;
            for(String line; fileToRead.hasNextLine() && ((line = fileToRead.nextLine()) != null);)
            {
                if (i == 3)
                {
                    binary0 = line.substring(6);
                }
                else if (i == 4)
                {
                    binaryHr1 = line.substring(6);
                }
                else if (i == 7)
                {
                    binaryMin1 = line.substring(5);
                }
                else if (i == 10)
                {
                    binarySec1 = line.substring(5);
                }

                binaryData.append(line).append("\r\n");
                i++;
            }
            fileToRead.close();

            fileToRead = new Scanner(new File(fountianFile));
            i = 1;
            for(String line; fileToRead.hasNextLine() && ((line = fileToRead.nextLine()) != null);)
            {
                if (i == 40)
                {
                    fountian1 = line.substring(14);
                }
                else if (i == 41)
                {
                    fountian2 = line.substring(14);
                }

                fountianData.append(line).append("\r\n");
                i++;
            }
            fileToRead.close();

            fileToRead = new Scanner(new File(weatherFile));
            i = 1;
            for(String line; fileToRead.hasNextLine() && ((line = fileToRead.nextLine()) != null);)
            {
                if (i == 62)
                {
                    temp = line.substring(7);
                }
                else if (i == 63)
                {
                    weather = line.substring(7);
                }
                weatherData.append(line).append("\r\n");
                i++;
            }
            fileToRead.close();
        }
        catch (Exception ex)
        {
            System.out.println("error: " + ex.getMessage());
            retval = false;
        }

        updateGui(panelHolder);

        return retval;
    }

    public void updateGui(Component[][] panelHolder)
    {
        JTextField editBox = null;
        for (int i = 0; i < 13; i++)
        {
            if(panelHolder[i][1] instanceof JTextField)
            {
                editBox = (JTextField) panelHolder[i][1];
            }
            switch (i)
            {
                case 0:
                    editBox.setText(varkTitle);
                    break;

                case 1:
                    editBox.setText(varkSub);
                    break;

                case 2:
                    editBox.setText(dayName);
                    break;

                case 3:
                    editBox.setText(dayNum);
                    break;

                case 4:
                    editBox.setText(month);
                    break;

                case 5:
                    editBox.setText(binary0);
                    break;

                case 6:
                    editBox.setText(binaryHr1);
                    break;

                case 7:
                    editBox.setText(binaryMin1);
                    break;

                case 8:
                    editBox.setText(binarySec1);
                    break;

                case 9:
                    editBox.setText(fountian1);
                    break;

                case 10:
                    editBox.setText(fountian2);
                    break;

                case 11:
                    editBox.setText(temp);
                    break;

                case 12:
                    editBox.setText(weather);
                    break;
            }
        }
    }

    public void writeFiles(Component[][] panelHolder, Boolean newVold)
    {
        int i = 1;
        BufferedWriter writer = null;

        if (newVold == true)
        {
            replace(panelHolder);
        }


        try
        {
            writer = new BufferedWriter(new FileWriter(varkFile));
            writer.write(varkData.toString());
            writer.close();
        }
        catch (Exception ex)
        {
            System.out.println("error: " + ex.getMessage());
        }
    }

    public void replace(Component[][] panelHolder)
    {
        int start, stop;
        String oldText = null;
        JTextField editBox = null;
        StringBuffer data = null;

        for (int i = 0; i < 13; i++)
        {
            if(panelHolder[i][1] instanceof JTextField)
            {
                editBox = (JTextField) panelHolder[i][1];
            }

            switch (i)
            {
                case 0:
                    oldText = varkTitle;
                    data = varkData;
                    break;

                case 1:
                    oldText = varkSub;
                    data = varkData;
                    break;

                case 2:
                    oldText = dayName;
                    data = dateData;
                    break;

                case 3:
                    oldText = dayNum;
                    data = dateData;
                    break;

                case 4:
                    oldText = month;
                    data = dateData;
                    break;

                case 5:
                    oldText = binary0;
                    data = binaryData;
                    break;

                case 6:
                    oldText = binaryHr1;
                    data = binaryData;
                    break;

                case 7:
                    oldText = binaryMin1;
                    data = binaryData;
                    break;

                case 8:
                    oldText = binarySec1;
                    data = binaryData;
                    break;

                case 9:
                    oldText = fountian1;
                    data = fountianData;
                    break;

                case 10:
                    oldText = fountian2;
                    data = fountianData;
                    break;

                case 11:
                    oldText = temp;
                    data = weatherData;
                    break;

                case 12:
                    oldText = weather;
                    data = weatherData;
                    break;
            }

            start = data.indexOf(oldText);
            stop = start + oldText.length();
            data.replace(start, stop, editBox.getText());
        }
    }

}
