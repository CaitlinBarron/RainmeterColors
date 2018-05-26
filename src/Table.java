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
                    varkTitle = threeDigitClean(line.substring(7));
                    line = line.substring(0, 7) + varkTitle;
                }
                else if (i == 12)
                {
                    varkSub = threeDigitClean(line.substring(7));
                    line = line.substring(0, 7) + varkSub;
                }
                else if (i == 13)
                {
                    line = line.substring(0, 7) + varkTitle;
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
                    dayName = threeDigitClean(line.substring(10));
                    line = line.substring(0, 10) + dayName;
                }
                else if (i == 33)
                {
                    dayNum = threeDigitClean(line.substring(10));
                    line = line.substring(0, 10) + dayNum;
                }
                else if (i == 63)
                {
                    month = threeDigitClean(line.substring(10));
                    line = line.substring(0, 10) + month;
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
                    binary0 = threeDigitClean(line.substring(6));
                    line = line.substring(0, 6) + binary0;
                }
                else if (i == 4)
                {
                    binaryHr1 = threeDigitClean(line.substring(6));
                    line = line.substring(0, 6) + binaryHr1;
                }
                else if (i == 6)
                {
                    line = line.substring(0, 5) + binary0;
                }
                else if (i == 7)
                {
                    binaryMin1 = threeDigitClean(line.substring(5));
                    line = line.substring(0, 5) + binaryMin1;
                }
                else if (i == 9)
                {
                    line = line.substring(0, 5) + binary0;
                }
                else if (i == 10)
                {
                    binarySec1 = threeDigitClean(line.substring(5));
                    line = line.substring(0, 5) + binarySec1;
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
                    fountian1 = threeDigitClean(line.substring(14));
                    line = line.substring(0, 14) + fountian1;
                }
                else if (i == 41)
                {
                    fountian2 = threeDigitClean(line.substring(14));
                    line = line.substring(0, 14) + fountian2;
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
                    temp = threeDigitClean(line.substring(7));
                    line = line.substring(0, 7) + temp;
                }
                else if (i == 63)
                {
                    weather = threeDigitClean(line.substring(7));
                    line = line.substring(0, 7) + weather;
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
                    varkTitle = threeDigitClean(editBox.getText());
                    break;

                case 1:
                    varkSub = threeDigitClean(editBox.getText());
                    break;

                case 2:
                    dayName = threeDigitClean(editBox.getText());
                    break;

                case 3:
                    dayNum = threeDigitClean(editBox.getText());
                    break;

                case 4:
                    month = threeDigitClean(editBox.getText());
                    break;

                case 5:
                    binary0 = threeDigitClean(editBox.getText());
                    break;

                case 6:
                    binaryHr1 = threeDigitClean(editBox.getText());
                    break;

                case 7:
                    binaryMin1 = threeDigitClean(editBox.getText());
                    break;

                case 8:
                    binarySec1 = threeDigitClean(editBox.getText());
                    break;

                case 9:
                    fountian1 = threeDigitClean(editBox.getText());
                    break;

                case 10:
                    fountian2 = threeDigitClean(editBox.getText());
                    break;

                case 11:
                    temp = threeDigitClean(editBox.getText());
                    break;

                case 12:
                    weather = threeDigitClean(editBox.getText());
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
                    editBox.setText(threeDigitClean(this.varkTitle));
                    break;

                case 1:
                    editBox.setText(threeDigitClean(this.varkSub));
                    break;

                case 2:
                    editBox.setText(threeDigitClean(this.dayName));
                    break;

                case 3:
                    editBox.setText(threeDigitClean(this.dayNum));
                    break;

                case 4:
                    editBox.setText(threeDigitClean(this.month));
                    break;

                case 5:
                    editBox.setText(threeDigitClean(this.binary0));
                    break;

                case 6:
                    editBox.setText(threeDigitClean(this.binaryHr1));
                    break;

                case 7:
                    editBox.setText(threeDigitClean(this.binaryMin1));
                    break;

                case 8:
                    editBox.setText(threeDigitClean(this.binarySec1));
                    break;

                case 9:
                    editBox.setText(threeDigitClean(this.fountian1));
                    break;

                case 10:
                    editBox.setText(threeDigitClean(this.fountian2));
                    break;

                case 11:
                    editBox.setText(threeDigitClean(this.temp));
                    break;

                case 12:
                    editBox.setText(threeDigitClean(this.weather));
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
                //System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, threeDigitClean(newText));
                //System.out.print(data.substring(start, stop) + "\n");

                start = data.indexOf("Color3=") + 7;
                stop = start + oldText.length();
                //System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, threeDigitClean(newText));
                //System.out.print(data.substring(start, stop) + "\n");
            }
            else if (i == 5)
            {
                start = data.indexOf("Hour0=") + 6;
                stop = start + oldText.length();
                //System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, threeDigitClean(newText));
                //System.out.print(data.substring(start, stop) + "\n");

                start = data.indexOf("Min0=") + 5;
                stop = start + oldText.length();
                //System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, threeDigitClean(newText));
                //System.out.print(data.substring(start, stop) + "\n");

                start = data.indexOf("Sec0=") + 5;
                stop = start + oldText.length();
                //System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, threeDigitClean(newText));
                //System.out.print(data.substring(start, stop) + "\n");
            }
            else
            {
                //System.out.print("before: " + data.substring(start, stop) + " after: ");
                data.replace(start, stop, threeDigitClean(newText));
                //System.out.print(data.substring(start, stop) + "\n");
            }

        }
        //System.out.print("\n\n");
        //System.out.println("\n" + varkData.toString() + "\n");
        //System.out.println("\n" + dateData.toString() + "\n");
        //System.out.println("\n" + binaryData.toString() + "\n");
        //System.out.println("\n" + fountianData.toString() + "\n");
        //System.out.println("\n" + weatherData.toString() + "\n");
    }

    public String threeDigitClean (String original)
    {
        String retval = "";
        int temp = 0;
        String val = "";

        val = original.replace(" ", "");
        String[] splitStr = val.split(",");
        for (int i = 0; i < splitStr.length; i++)
        {
            val = splitStr[i];
            temp = val.length();

            if (Integer.parseInt(val) > 255)
            {
                val = "255";
            }

            if (temp == 0)
            {
                val = "000";
            }
            else if (temp == 1)
            {
                val = ("00" + val);
            }
            else if (temp == 2)
            {
                val = ("0" + val);
            }
            else if (temp > 3)
            {
                val = val.substring(temp-3, temp);
            }

            splitStr[i] = val;
        }

        retval = splitStr[0] + ", " + splitStr[1] + ", " + splitStr[2] + ", " + splitStr[3];

        return retval;
    }
}
