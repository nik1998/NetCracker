package com.company;
import People.Library;
import Sorting.BubbleSort;
import Sorting.MergeSort;
import Sorting.QuickSort;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import java.util.Scanner;
public class Main {

    static void  request( int t,Library lib)
    {
        System.out.println("Enter name");
        Scanner sc = new Scanner(System.in);
        String name =sc.next();
        if(t==2)
        {
            lib.delete(name);
        }
        else
        {
            String name2=name;
            if(t==1) {
                System.out.println("Enter name");
                name2 =sc.next();
            }
            System.out.println("Enter sex");
            String ch=sc.next();
            System.out.println("Enter Date of birthday");
            org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.mm.yyyy");
            DateTime datetime =  formatter.parseDateTime(sc.next());
            if(t==0)
            {
                lib.add(name2,ch,datetime);
            }
            else
            {
                lib.change(name,name2,ch,datetime);
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
        Library lib =new Library(new MergeSort());
        while(true) {
            System.out.println("Enter 0-Add person, 1 - Change person, 2- Remove person,3 - Exit");
            int t = Integer.parseInt(sc.next());
            switch (t)
            {
                case 0:
                case 1:
                case 2:
                {
                    request(t,lib);
                    break;
                }
                case 3:
                {
                    return;
                }
                default:
                    continue;
            }
        }

    }
}
