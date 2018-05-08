import java.io.File;
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
}
