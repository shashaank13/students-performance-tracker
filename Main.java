package com.company;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

class CalculateData {

    boolean findTheRollno(String Roll,String path) throws IOException {
        try{Scanner sc = new Scanner(new File(path));
            while (sc.hasNext())
            {
                String[] check=sc.nextLine().split(",");
                if (check[0].equals(Roll))
                {
                    return (true);
                }
            }

        } catch (IOException e)
        {
            System.out.println(e);
        }
        return (false);
    }
    void individualPercentage(String roll,String path)  {
        try {
            Scanner sc = new Scanner(new File(path));

            String[] sbj=sc.nextLine().split(",");
            while (sc.hasNext()) {
                int tot = 0;
                String[] check = sc.nextLine().split(",");
                if(check[0].equals(roll))
                {
                    for (int i = 2; i < 8; i++) {
                        tot += Integer.parseInt(check[i]);
                    }
                    float per= (float) ((tot/180.0)*100);
                    System.out.println("Name :"+check[1]);
                    System.out.println(sbj[2]+":"+check[2]+" "+sbj[3]+":"+check[3]+" "+sbj[4]+":"+check[4]+" "+sbj[5]+":"+check[5]+" "+sbj[6]+":"+check[6]+" "+sbj[7]+":"+check[7]);
                    System.out.printf("PERCENTAGE :%.2f\n",per);
                }

            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void classPerformance(String path) {
        try {
            double classper=0;
            double [] subAvg=new double[6];
            subAvg[0]=0;
            subAvg[1]=0;
            subAvg[2]=0;
            subAvg[3]=0;
            subAvg[4]=0;
            subAvg[5]=0;
            Scanner sc = new Scanner(new File(path));
            String[] sp=path.split(".csv");
            String rpath=(sp[0]+"report.csv");
            BufferedWriter obj=new BufferedWriter(new FileWriter(rpath));
            int num=0;
            String [] header=sc.nextLine().split(",");
            obj.write("ROLL NO,NAME,OOPS,DATA STRUCTURES,COMPUTER ARCHITECTURE,LINEAR ALGEBRA,DISCRETE STRUCTURES,ECONOMICS,PERCENTAGE\n");
            System.out.println("ROLL.NO--OOPS--DATA STRUCTURES----COMPUTER ARCHITECTURE--LINEAR ALGEBRA--DISCRETE STRUCTURES----ECONOMICS--------PERCENTAGE------------NAME");
            while (sc.hasNext()) {
                int tot = 0;
                num++;
                String[] check = sc.nextLine().split(",");
                obj.write(check[0]+",");
                obj.write(check[1]+",");
                System.out.print(check[0]+"---");
                for (int i = 2; i < 8; i++) {
                    tot += Integer.parseInt(check[i]);
                    obj.write(check[i]+",");
                    System.out.print(check[i]+"----------------");
                }
                for(int i=0;i<6;i++) {
                    subAvg[i] += Integer.parseInt(check[i+2]);
                }

                float per= (float) ((tot/180.0)*100);
                obj.write(per+"\n");
                System.out.printf("%.2f-----------%s\n",per,check[1]);
                classper+=per;
            }
            classper=(float)(classper/(float)num);
            System.out.printf("Class average percentage :%.2f\n",classper);
            obj.write("Class average percentage :,"+classper+"\n");
            System.out.println("Subjects average :-");
            obj.write("Class subjects average:\n");
            for(int i=0;i<6;i++) {
                subAvg[i]=  subAvg[i]/(float) num;
                System.out.printf("%s:%.2f\n",header[i+2],subAvg[i]);
                obj.write(header[i+2]+","+subAvg[i]+"\n");
            }
            sc.close();
            obj.close();
            System.out.println("Class report is generated and stored in "+rpath);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
class InputException extends Exception
{
    String str="";
    InputException(String s)
    {
        str=s;
    }
    public String toString()
    {
        return (str);
    }
}
class UpdateingData extends CalculateData {

    void dataEntry(String path) throws IOException {
        try {
            BufferedWriter ob = new BufferedWriter(new FileWriter(path, true));
            Scanner in = new Scanner(System.in);
            String[] header;
            header = new String[9];
            header[0] = "Rollno:";
            header[1] = "Name:";
            header[2] = "OOPS:";
            header[3] = "DATA STRUCTURES:";
            header[4] = "COMPUTER ARCHITECTURE:";
            header[5] = "LINEAR ALGEBRA:";
            header[6] = "DISCRETE STRUCTURES:";
            header[7] = "ECONOMICS:";
            header[8] = "Type 'next' to enter a new student record or Type 'stop' to terminate :";
            String data = "";
            do {
                for (int i = 0; i < header.length; i++) {
                    System.out.println(header[i]);
                    try {
                        data=in.nextLine();
                        if ((i == 0)) {
                            if (data.charAt(0) != '1' || data.charAt(1) != '9' || data.charAt(2) != 'z' || data.charAt(3) != '3' || (Integer.parseInt(String.valueOf(data.charAt(4))) <= -1 || Integer.parseInt(String.valueOf(data.charAt(4))) >= 10) || (Integer.parseInt(String.valueOf(data.charAt(5))) <= -1 || Integer.parseInt(String.valueOf(data.charAt(5))) >= 10)) {
                                throw new InputException("Enter a valid roll number of format ie:'19z301'\nPlease Enter Again");
                            }
                        }
                        else if (i > 1 && i < 8) {

                            int mrk = Integer.parseInt(data);
                            if (mrk < 0 || mrk > 30) {
                                throw new InputException("Mark should be between  0 to 30\nPlease Enter Again ");
                            }
                        }
                    } catch (InputException e) {
                        System.out.println(e);
                        i--;
                        continue;
                    }
                    catch(NumberFormatException e)
                    {
                        i--;
                        System.out.println("String are not allowed\n Please enter a valid mark\n Mark must be in the range 0-30");
                        continue;
                    }
                    catch (Exception e) {
                        i--;
                        e.fillInStackTrace();
                        continue;
                    }
                    if (data.equals("next") || data.equals("stop")) {
                        ob.write("\n");
                        break;
                    }
                    if (i == header.length-1)
                        ob.write(data+"\n");
                    else
                        ob.write(data+",");
                }
            } while (!data.equals("stop"));
            ob.close();
        }catch (IOException e)
        {
            System.out.println(e);
        }
    }
}
class Jproject {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("---------------STUDENT PERFORMANCE TRACKER---------------");
        System.out.println("MARK LIST \n1.CA1\n2.CA2\n3.Create a new file\nEnter your choice-->");
        int f = in.nextInt();
        String fpath = "";
        UpdateingData obj = new UpdateingData();
        if (f == 1)
            fpath = "E:\\CA1.csv";
        else if(f==2)
            fpath = "E:\\CA2.csv";
        else if (f==3)
        {
            System.out.println("Enter the File Name:");
            String fname=in.next();
            fpath=fname+".csv";
            BufferedWriter file=new BufferedWriter(new FileWriter(fpath));
            file.write("ROLL NO,NAME,OOPS,DATA STRUCTURES,COMPUTER ARCHITECTURE,LINEAR ALGEBRA,DISCRETE STRUCTURES,ECONOMICS,PERCENTAGE\n");
            file.close();
            obj.dataEntry(fpath);
        }
        int ch;
        do {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("ENTER THE CHOICE\n1.View Individual Performance\n2.View Class Performance And Get Report \n3.Add New Record\n4.Exit\n-->");
            ch = in.nextInt();
            if (ch == 3) {
                System.out.println("ENTER THE DATA FOR STUDENT ENTRY");
                obj.dataEntry(fpath);

            } else if (ch == 1) {

                System.out.println("PLEASE ENTER YOUR ROLL NUMBER:");
                String Roll = in.next();
                if (obj.findTheRollno(Roll,fpath)) {
                    System.out.println("\nINDIVIDUAL PERFORMANCE");
                    obj.individualPercentage(Roll, fpath);
                } else {
                    System.out.println("ROLL NUMBER NOT FOUND");
                }
            } else if (ch == 2) {
                obj.classPerformance(fpath);
            } else {
                System.out.println();
            }
            System.out.println("Enter any value from 1- 10 to proceed");
            in.next();
        } while (ch != 4);
        System.out.println("******---------------THANK YOU FOR USING STUDENT PERFORMANCE TRACKER---------------*****");
    }
}
