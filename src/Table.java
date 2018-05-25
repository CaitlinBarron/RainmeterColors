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

    public StringBuffer varkData = new StringBuffer();
    public StringBuffer dateData = new StringBuffer();
    public StringBuffer binaryData = new StringBuffer();
    public StringBuffer fountianData = new StringBuffer();
    public StringBuffer weatherData = new StringBuffer();

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

    public Table(Table old)
    {
        this.varkData = old.varkData;
        this.dateData = old.dateData;
        this.binaryData = old.binaryData;
        this.fountianData = old.fountianData;
        this.weatherData = old.weatherData;

        this.varkTitle = old.varkTitle;
        this.varkSub = old.varkSub;

        this.dayName = old.dayName;
        this.dayNum = old.dayNum;
        this.month = old.month;

        this.binary0 = old.binary0;
        this.binaryHr1 = old.binaryHr1;
        this.binaryMin1 = old.binaryMin1;
        this.binarySec1 = old.binarySec1;

        this.fountian1 = old.fountian1;
        this.fountian2 = old.fountian2;

        this.temp = old.temp;
        this.weather = old.weather;
    }

    public boolean readFiles()
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

        return retval;
    }

    public void readGui(Component[][] panelHolder)
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
                    varkTitle = editBox.getText();
                    break;

                case 1:
                    varkSub = editBox.getText();
                    break;

                case 2:
                    dayName = editBox.getText();
                    break;

                case 3:
                    dayNum = editBox.getText();
                    break;

                case 4:
                    month = editBox.getText();
                    break;

                case 5:
                    binary0 = editBox.getText();
                    break;

                case 6:
                    binaryHr1 = editBox.getText();
                    break;

                case 7:
                    binaryMin1 = editBox.getText();
                    break;

                case 8:
                    binarySec1 = editBox.getText();
                    break;

                case 9:
                    fountian1 = editBox.getText();
                    break;

                case 10:
                    fountian2 = editBox.getText();
                    break;

                case 11:
                    temp = editBox.getText();
                    break;

                case 12:
                    weather = editBox.getText();
                    break;
            }
        }
    }

    public void setData (StringBuffer vark, StringBuffer date,
                         StringBuffer binary, StringBuffer fountian, StringBuffer weather)
    {
        this.varkData = vark;
        this.dateData = date;
        this.binaryData = binary;
        this.fountianData = fountian;
        this.weatherData = weather;
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
                    editBox.setText(this.varkTitle);
                    break;

                case 1:
                    editBox.setText(this.varkSub);
                    break;

                case 2:
                    editBox.setText(this.dayName);
                    break;

                case 3:
                    editBox.setText(this.dayNum);
                    break;

                case 4:
                    editBox.setText(this.month);
                    break;

                case 5:
                    editBox.setText(this.binary0);
                    break;

                case 6:
                    editBox.setText(this.binaryHr1);
                    break;

                case 7:
                    editBox.setText(this.binaryMin1);
                    break;

                case 8:
                    editBox.setText(this.binarySec1);
                    break;

                case 9:
                    editBox.setText(this.fountian1);
                    break;

                case 10:
                    editBox.setText(this.fountian2);
                    break;

                case 11:
                    editBox.setText(this.temp);
                    break;

                case 12:
                    editBox.setText(this.weather);
                    break;
            }
        }
    }

    public void writeFiles(Table currentSettings)
    {
        int i = 1;
        BufferedWriter writer = null;

        replace(currentSettings);

        try
        {
            writer = new BufferedWriter(new FileWriter(varkFile));
            writer.write(varkData.toString());
            writer.close();

            writer = new BufferedWriter(new FileWriter(dateFile));
            writer.write(dateData.toString());
            writer.close();

            writer = new BufferedWriter(new FileWriter(binaryFile));
            writer.write(binaryData.toString());
            writer.close();

            writer = new BufferedWriter(new FileWriter(fountianFile));
            writer.write(fountianData.toString());
            writer.close();

            writer = new BufferedWriter(new FileWriter(weatherFile));
            writer.write(weatherData.toString());
            writer.close();
        }
        catch (Exception ex)
        {
            System.out.println("error: " + ex.getMessage());
        }
    }

    public void replace(Table currentSettings)
    {
        int start = 0;
        int stop = 0;
        String oldText = null;
        String newText = null;
        StringBuffer data = null;

        for (int i = 0; i < 13; i++)
        {
            switch (i)
            {
                case 0:
                    oldText = currentSettings.varkTitle;
                    newText = this.varkTitle;
                    data = this.varkData;
                    //start and stop values set below after switch
                    break;

                case 1:
                    oldText = currentSettings.varkSub;
                    newText = this.varkSub;
                    data = this.varkData;
                    start = data.indexOf("Color2=") + 7;
                    stop = start + oldText.length();
                    break;

                case 2:
                    oldText = currentSettings.dayName;
                    newText = this.dayName;
                    data = this.dateData;
                    start = data.indexOf("Y=130\r\nFontColor=") + 17;
                    stop = start + oldText.length();
                    break;

                case 3:
                    oldText = currentSettings.dayNum;
                    newText = this.dayNum;
                    data = this.dateData;
                    start = data.indexOf("Y=80\r\nFontColor=") + 16;
                    stop = start + oldText.length();
                    break;

                case 4:
                    oldText = currentSettings.month;
                    newText = this.month;
                    data = this.dateData;
                    start = data.indexOf("Y=60\r\nFontColor=") + 16;
                    stop = start + oldText.length();
                    break;

                case 5:
                    oldText = currentSettings.binary0;
                    newText = this.binary0;
                    data = this.binaryData;
                    //start and stop values set below after switch
                    break;

                case 6:
                    oldText = currentSettings.binaryHr1;
                    newText = this.binaryHr1;
                    data = this.binaryData;
                    start = data.indexOf("Hour1=") + 6;
                    stop = start + oldText.length();
                    break;

                case 7:
                    oldText = currentSettings.binaryMin1;
                    newText = this.binaryMin1;
                    data = this.binaryData;
                    start = data.indexOf("Min1=") + 5;
                    stop = start + oldText.length();
                    break;

                case 8:
                    oldText = currentSettings.binarySec1;
                    newText = this.binarySec1;
                    data = this.binaryData;
                    start = data.indexOf("Sec1=") + 5;
                    stop = start + oldText.length();
                    break;

                case 9:
                    oldText = currentSettings.fountian1;
                    newText = this.fountian1;
                    data = this.fountianData;
                    start = data.indexOf("PaletteColor1=") + 14;
                    stop = start + oldText.length();
                    break;

                case 10:
                    oldText = currentSettings.fountian2;
                    newText = this.fountian2;
                    data = this.fountianData;
                    start = data.indexOf("PaletteColor2=") + 14;
                    stop = start + oldText.length();
                    break;

                case 11:
                    oldText = currentSettings.temp;
                    newText = this.temp;
                    data = this.weatherData;
                    start = data.indexOf("Color1=") + 7;
                    stop = start + oldText.length();
                    break;

                case 12:
                    oldText = currentSettings.weather;
                    newText = this.weather;
                    data = this.weatherData;
                    start = data.indexOf("Color2=") + 7;
                    stop = start + oldText.length();
                    break;
            }

            if (i == 0)
            {
                start = data.indexOf("Color1=") + 7;
                stop = start + oldText.length();
                System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, newText);
                System.out.print(data.substring(start, stop) + "\n");

                start = data.indexOf("Color3=") + 7;
                stop = start + oldText.length();
                System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, newText);
                System.out.print(data.substring(start, stop) + "\n");
            }
            else if (i == 5)
            {
                start = data.indexOf("Hour0=") + 6;
                stop = start + oldText.length();
                System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, newText);
                System.out.print(data.substring(start, stop) + "\n");

                start = data.indexOf("Min0=") + 5;
                stop = start + oldText.length();
                System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, newText);
                System.out.print(data.substring(start, stop) + "\n");

                start = data.indexOf("Sec0=") + 5;
                stop = start + oldText.length();
                System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, newText);
                System.out.print(data.substring(start, stop) + "\n");
            }
            else
            {
                System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, newText);
                System.out.print(data.substring(start, stop) + "\n");
            }

        }
        System.out.print("\n\n");
        //System.out.println("\n" + varkData.toString() + "\n");
        //System.out.println("\n" + dateData.toString() + "\n");
        //System.out.println("\n" + binaryData.toString() + "\n");
        //System.out.println("\n" + fountianData.toString() + "\n");
        //System.out.println("\n" + weatherData.toString() + "\n");
    }
}
