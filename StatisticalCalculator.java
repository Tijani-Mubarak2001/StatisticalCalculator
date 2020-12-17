package com.TijaniMubarak;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class StatisticalCalculator {
    public static double mean(int option){
        double Mean = 0.0;
        Scanner scanner = new Scanner(System.in);
        int data_type;
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        data_type = scanner.nextInt();
        if(data_type==1){
            int total_Fre=0;
            double total_FX = 0.0, upper_limit=0, lower_limit=0;
            int  frequency=0;
            do {
                System.out.println("Enter Class Interval With Corresponding Frequency\n\tEnter 0 To End");
                System.out.println("Enter Upper Limit");
                upper_limit = scanner.nextInt();
                System.out.println("Enter Lower Limit");
                lower_limit = scanner.nextInt();
                System.out.println("Enter Frequency");
                frequency = scanner.nextInt();
                total_Fre = total_Fre + frequency;
                double FX = ((upper_limit+lower_limit)/2.0)*frequency;
                total_FX = total_FX + FX;
            }while(upper_limit!=0||lower_limit!=0||frequency!=0);
            Mean = total_FX/total_Fre;
        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){
                double F_X, total_F_X=0.0, X, freq, total_F=0;
                System.out.println("Enter X With Corresponding Frequency \n\tEnter 0 To End");
                do{
                    System.out.println("Enter X");
                    X = scanner.nextDouble();
                    System.out.println("Enter F");
                    freq = scanner.nextDouble();
                    total_F = total_F + freq;
                    F_X = freq * X;
                    total_F_X = total_F_X+F_X;
                }while (X!=0||freq!=0);
                Mean = total_F_X/total_F;
            }else if(with_fre==2){
                double Elements = 0,  total_elements=0;
                int counter=0;
                System.out.println("Enter All Elements\n\tEnter 0 To End");
                do{
                    Elements = scanner.nextDouble();
                    total_elements = total_elements + Elements;
                    counter++;
                }while(Elements!=0);
                counter = counter-1;
                Mean = total_elements/(counter);
            }
        }
        return Mean;

    }
    public static double HarmonicMean(int option){
        double Harmonic_mean = 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1){
            double  total_denominator=0.0, frequency=0.0,total_frequency=0.0;
            int upper_limit=0, lower_limit=0, quit_now=0;
            do {
                System.out.println("Enter Class Interval With Corresponding Frequency\n\tEnter 0 To End");
                System.out.println("Enter Upper Limit");
                upper_limit = scanner.nextInt();
                System.out.println("Enter Lower Limit");
                lower_limit = scanner.nextInt();
                System.out.println("Enter Frequency");
                frequency = scanner.nextDouble();

               if(upper_limit==0||lower_limit==0||frequency==0){
                   quit_now = 1;
                   break;
               }else{
                   total_frequency = total_frequency+frequency;
                   double The_X = (upper_limit+lower_limit)/2;
                   double denominator = frequency/The_X;
                   total_denominator = total_denominator + denominator;
               }
            }while(quit_now!=1);
            Harmonic_mean = total_frequency/total_denominator;
        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){
                int quit=0;
                double denom, total_denom=0.0, X=0, freq=0, total_freq=0;
                System.out.println("Enter X With Corresponding Frequency \n\tEnter 0 To End");
                do{
                    System.out.println("Enter X");
                    X = scanner.nextDouble();
                    System.out.println("Enter F");
                    freq = scanner.nextDouble();
                    if(X==0||freq==0){
                        quit=1;
                        break;
                    }else {
                        denom = freq/X;
                        total_denom = total_denom+denom;
                        total_freq=total_freq+freq;
                    }

                }while (quit!=1);
                Harmonic_mean = total_freq/total_denom;
            }else if(with_fre==2){
                double total_elements=0.0, The_elements=0.0, Elements;
                int counter=0,quit=0;
                System.out.println("Enter All Elements\n\tEnter 0 To End");
                do{
                    Elements = scanner.nextDouble();
                    if(Elements==0){
                        quit = 1;
                        break;
                    }else if(Elements!=0){

                        The_elements = 1.0/Elements;
                        counter++;
                        total_elements = total_elements+The_elements;
                    }

                }while(quit!=1);
                Harmonic_mean = counter/total_elements;
            }
        }
        return Harmonic_mean;
    }
    public static double median(int option){
        double Median=0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1){
            System.out.println("Enter::\n\t1.Arranged\n\t2.Not Arranged");
            int arrangment = scanner.nextInt();
            if(arrangment==1){
                int mid_fre=0, total_fre = 0, total_array_fre=0, num_classes,i=0, j=0, cummulative_frequency_b4=0;
                System.out.println("Enter Number Of classes");
                num_classes = scanner.nextInt();
                int [] frequency = new int[num_classes];
                double [] upper_limit = new double[num_classes];
                double [] lower_limit = new double[num_classes];
                System.out.println("Enter All Frequency: ");
                for(i=0; i<num_classes;i++){
                    frequency[i] = scanner.nextInt();
                    total_fre = total_fre+frequency[i];
                }
                mid_fre = total_fre/2;
                do{
                    System.out.println("Enter Upper Limit");
                    upper_limit[j] = scanner.nextDouble();
                    System.out.println("Enter Lower Limit");
                    lower_limit[j] = scanner.nextDouble();
                    total_array_fre = total_array_fre + frequency[j];
                    j++;
                    if(j==1||j>1){
                        cummulative_frequency_b4 = total_array_fre - frequency[j-1];
                    }
                }while(total_array_fre<mid_fre);
                System.out.println("Median Class: " + upper_limit[j-1]+"-"+lower_limit[j-1]);
                double lower_class_boundry = upper_limit[j-1] - 0.5;
                double upper_class_boudary = lower_limit[j-1] + 0.5;
                double class_size = upper_class_boudary - lower_class_boundry;
                double top_diff = mid_fre - cummulative_frequency_b4;
                double denom = frequency[j-1];
                double in_bracket = top_diff/denom;
                Median = lower_class_boundry + (in_bracket * class_size);
                return Median;
            }else if(arrangment==2){
                System.out.println("Enter Number Of Elements(frequency)");
                int n = scanner.nextInt();
                double arr[] = new double[n];
                System.out.println("Enter All Elements");
                for(int i=0;i<n; i++)
                {
                    arr[i] = scanner.nextDouble();
                }
                Arrays.sort(arr);
                System.out.println("Enter Class Width");
                int class_width = scanner.nextInt();

            }

        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){
                int num_classes;
                System.out.println("Enter Number Of classes");
                num_classes = scanner.nextInt();
                int quit=0, i=0, j=0;
                double denom, total_denom=0.0, freq=0, total_freq=0, mid_fre, cummulative_frequency_b4=0, total_array_fre=0;
                double [] X = new double[num_classes];
                int [] F = new int[num_classes];
                System.out.println("Enter All Frequencies::");
                for(i=0; i<num_classes;i++){
                    F[i] = scanner.nextInt();
                    total_freq=total_freq+F[i];
                }
                mid_fre = total_freq/2.0;
                System.out.println("Enter X");
                do{
                    X[j] = scanner.nextDouble();
                    total_array_fre = total_array_fre + F[j];
                    j++;
                }while(total_array_fre<mid_fre);
                Median = X[j-1];

            }else if(with_fre==2){
                System.out.println("Enter Number Of Elements(frequency)");
                int n = scanner.nextInt();
                double arr[] = new double[n];
                System.out.println("Enter All Elements");
                for(int i=0;i<n; i++)
                {
                    arr[i] = scanner.nextDouble();
                }
                System.out.println();
                if(n%2==0){
                    Arrays.sort(arr);
                    for (double element: arr) {
                        System.out.print(element + ", " );
                    }
                    System.out.println("");
                    int val = arr.length/2;
                    Median = (arr[val]+arr[val-1])/2.0;
                }else if(n%2!=0){
                    n = n+1;
                    Arrays.sort(arr);
                    for (double element: arr) {
                        System.out.print(element + ", " );
                    }
                    System.out.println("");
                    int val = n/2;
                    Median = arr[val-1];

                }
            }


        }
        return Median;
    }
    public static double quartile(int option){
        double Quartile= 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1) {
            int total_array_fre = 0, num_classes, i = 0, j = 0, cummulative_frequency_b4 = 0;
            double Quartile_position = 0, total_fre = 0,The_quartile;
            System.out.println("Enter Quartile To Find (E.g 1st quartile Enter 1):");
            The_quartile = scanner.nextDouble();
            System.out.println("Enter Number Of classes");
            num_classes = scanner.nextInt();
            int[] frequency = new int[num_classes];
            int[] upper_limit = new int[num_classes];
            int[] lower_limit = new int[num_classes];
            System.out.println("Enter All Frequency: ");
            for (i = 0; i < num_classes; i++) {
                frequency[i] = scanner.nextInt();
                total_fre = total_fre + frequency[i];
            }
            Quartile_position = ((The_quartile/4)*total_fre) + 0.5;
            do {
                System.out.println("Enter Upper Limit");
                upper_limit[j] = scanner.nextInt();
                System.out.println("Enter Lower Limit");
                lower_limit[j] = scanner.nextInt();
                total_array_fre = total_array_fre + frequency[j];
                j++;
                if (j == 1 || j > 1) {
                    cummulative_frequency_b4 = total_array_fre - frequency[j - 1];
                }
            } while (total_array_fre < Quartile_position);
            System.out.println("Quartile Class: " + upper_limit[j - 1] + "-" + lower_limit[j - 1]);
            double lower_class_boundry = upper_limit[j - 1] - 0.5;
            double upper_class_boudary = lower_limit[j - 1] + 0.5;
            double class_size = upper_class_boudary - lower_class_boundry;
            double top_diff = ((The_quartile/4)*total_fre) - cummulative_frequency_b4;
            double denom = frequency[j - 1];
            double in_bracket = top_diff / denom;
            Quartile = lower_class_boundry + (in_bracket * class_size);
        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){
                int total_array_fre = 0, num_classes, i = 0, j = 0, cummulative_frequency_b4 = 0;
                double Quartile_position = 0, total_fre = 0,The_quartile;
                System.out.println("Enter Quartile To Find (E.g 1st Quartile Enter 1):");
                The_quartile = scanner.nextDouble();
                System.out.println("Enter Number Of X");
                num_classes = scanner.nextInt();
                int[] frequency = new int[num_classes];
                double[] X = new double[100000];
                System.out.println("Enter All Frequency: ");
                for (i = 0; i < num_classes; i++) {
                    frequency[i] = scanner.nextInt();
                    total_fre = total_fre + frequency[i];
                }
                Quartile_position = ((The_quartile/4)*total_fre) + 0.5;
                System.out.println("Enter X");
                do {
                    X[j] = scanner.nextDouble();
                    total_array_fre = total_array_fre + frequency[j];
                    j++;
                } while (total_array_fre < Quartile_position);
                System.out.println("Quartile Position: " + Quartile_position);
                Quartile = X[j-1];

            }else if(with_fre==2){
                int max=0, counter=0, index=0, i;
                double The_quartile, Quartile_position, total_array_fre=0, ciel_quartile=0.0, floor_quartile=0.0;
                System.out.println("Enter Number Of Elements(frequency)");
                int n = scanner.nextInt();
                double [] frequency = new double[n];
                System.out.println("Enter Quartile To Find(E.g 1st quartile Enter 1):");
                The_quartile = scanner.nextDouble();
                System.out.println("Enter All Elements");
                for(i=0;i<n; i++)
                {
                    frequency[i] = scanner.nextDouble();
                }

                Arrays.sort(frequency);
                for (double element: frequency) {
                    System.out.print(element + ", " );
                }
                System.out.println("");
                Double new_n = Double.valueOf(n);
                Quartile_position = ((The_quartile/4)*new_n) + 0.5;
                ciel_quartile = Math.ceil(Quartile_position);
                if((ciel_quartile-Quartile_position)>0.0){
                    floor_quartile = Math.floor(Quartile_position);
                    System.out.println("The Position Of The Quartile Is Between : " + floor_quartile + " And " + ciel_quartile);
                    ciel_quartile--;
                    floor_quartile--;
                    Integer ciel_qua = (int) ciel_quartile;
                    Integer floor_qua  = (int) floor_quartile;
                    Quartile = (frequency[ciel_qua] + frequency[floor_qua])/2.0;

                }else if(ciel_quartile-Quartile_position==0.0){
                    int The_Quartile_position = (int) Quartile_position;
                    System.out.println("The Position Of The Quartile Is: " + The_Quartile_position);
                    Quartile = frequency[The_Quartile_position-1];
                }

            }


        }
        return Quartile;
    }
    public static double decile(int option){
        double Decile= 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1) {
            int total_array_fre = 0, num_classes, i = 0, j = 0, cummulative_frequency_b4 = 0;
            double Quartile_position = 0, total_fre = 0,The_quartile;
            System.out.println("Enter Decile To Find (E.g 1st Decile Enter 1):");
            The_quartile = scanner.nextDouble();
            System.out.println("Enter Number Of classes");
            num_classes = scanner.nextInt();
            int[] frequency = new int[num_classes];
            double[] upper_limit = new double[num_classes];
            double[] lower_limit = new double[num_classes];
            System.out.println("Enter All Frequency: ");
            for (i = 0; i < num_classes; i++) {
                frequency[i] = scanner.nextInt();
                total_fre = total_fre + frequency[i];
            }
            Quartile_position = ((The_quartile/10)*total_fre) + 0.5;
            do {
                System.out.println("Enter Upper Limit");
                upper_limit[j] = scanner.nextDouble();
                System.out.println("Enter Lower Limit");
                lower_limit[j] = scanner.nextDouble();
                total_array_fre = total_array_fre + frequency[j];
                j++;
                if (j == 1 || j > 1) {
                    cummulative_frequency_b4 = total_array_fre - frequency[j - 1];
                }
            } while (total_array_fre < Quartile_position);
            System.out.println("Decile Class: " + upper_limit[j - 1] + "-" + lower_limit[j - 1]);
            double lower_class_boundry = upper_limit[j - 1] - 0.5;
            double upper_class_boudary = lower_limit[j - 1] + 0.5;
            double class_size = upper_class_boudary - lower_class_boundry;
            double top_diff = ((The_quartile/10)*total_fre) - cummulative_frequency_b4;
            double denom = frequency[j - 1];
            double in_bracket = top_diff / denom;
            Decile = lower_class_boundry + (in_bracket * class_size);
        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){
                int total_array_fre = 0, num_classes, i = 0, j = 0, cummulative_frequency_b4 = 0;
                double Quartile_position = 0, total_fre = 0,The_quartile;
                System.out.println("Enter Decile To Find (E.g 1st Decile Enter 1):");
                The_quartile = scanner.nextDouble();
                System.out.println("Enter Number Of X");
                num_classes = scanner.nextInt();
                int[] frequency = new int[num_classes];
                double[] X = new double[100000];
                System.out.println("Enter All Frequency: ");
                for (i = 0; i < num_classes; i++) {
                    frequency[i] = scanner.nextInt();
                    total_fre = total_fre + frequency[i];
                }
                Quartile_position = ((The_quartile/10)*total_fre) + 0.5;
                System.out.println("Enter X");
                do {
                    X[j] = scanner.nextDouble();
                    total_array_fre = total_array_fre + frequency[j];
                    j++;
                } while (total_array_fre < Quartile_position);
                System.out.println("Decile Position: " + Quartile_position);
                Decile = X[j-1];

            }else if(with_fre==2){
                int max=0, counter=0, index=0, i;
                double The_quartile, Quartile_position, total_array_fre=0, ciel_quartile=0.0, floor_quartile=0.0;
                System.out.println("Enter Number Of Elements(frequency)");
                int n = scanner.nextInt();
                double [] frequency = new double[n];
                System.out.println("Enter Decile To Find(E.g 1st Decile Enter 1):");
                The_quartile = scanner.nextDouble();
                System.out.println("Enter All Elements");
                for(i=0;i<n; i++)
                {
                    frequency[i] = scanner.nextDouble();
                }

                Arrays.sort(frequency);
                for (double element: frequency) {
                    System.out.print(element + ", " );
                }
                System.out.println("");
                Quartile_position = ((The_quartile/10)*(double) n) + 0.5;
                ciel_quartile = Math.ceil(Quartile_position);
                /*int The_Quartile_position = (int) Math.round(Quartile_position);
                System.out.println("The Position Of The Decile Is: " + The_Quartile_position);
                Decile = frequency[The_Quartile_position-1];*/


                if((ciel_quartile-Quartile_position)>0.0){
                    floor_quartile = Math.floor(Quartile_position);
                    System.out.println("The Position Of The Decile Is Between : " + floor_quartile + " And " + ciel_quartile);
                    ciel_quartile--;
                    floor_quartile--;
                    Integer ciel_qua = (int) ciel_quartile;
                    Integer floor_qua  = (int) floor_quartile;
                    Decile = (frequency[ciel_qua] + frequency[floor_qua])/2.0;

                }else if((ciel_quartile-Quartile_position)==0.0){
                    int The_Quartile_position = (int) Quartile_position;
                    System.out.println("The Position Of The Decile Is: " + The_Quartile_position);
                    Decile = frequency[The_Quartile_position-1];
                }



            }


        }
        return Decile;
    }
    public static double percentile(int option){
        double Percentile= 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1) {
            int total_array_fre = 0, num_classes, i = 0, j = 0, cummulative_frequency_b4 = 0;
            double Quartile_position = 0, total_fre = 0,The_quartile;
            System.out.println("Enter Percentile To Find (E.g 1st Percentile Enter 1):");
            The_quartile = scanner.nextDouble();
            System.out.println("Enter Number Of classes");
            num_classes = scanner.nextInt();
            int[] frequency = new int[num_classes];
            int[] upper_limit = new int[num_classes];
            int[] lower_limit = new int[num_classes];
            System.out.println("Enter All Frequency: ");
            for (i = 0; i < num_classes; i++) {
                frequency[i] = scanner.nextInt();
                total_fre = total_fre + frequency[i];
            }
            Quartile_position = ((The_quartile/100)*total_fre) + 0.5;
            do {
                System.out.println("Enter Upper Limit");
                upper_limit[j] = scanner.nextInt();
                System.out.println("Enter Lower Limit");
                lower_limit[j] = scanner.nextInt();
                total_array_fre = total_array_fre + frequency[j];
                j++;
                if (j == 1 || j > 1) {
                    cummulative_frequency_b4 = total_array_fre - frequency[j - 1];
                }
            } while (total_array_fre < Quartile_position);
            System.out.println("Percentile Class: " + upper_limit[j - 1] + "-" + lower_limit[j - 1]);
            double lower_class_boundry = upper_limit[j - 1] - 0.5;
            double upper_class_boudary = lower_limit[j - 1] + 0.5;
            double class_size = upper_class_boudary - lower_class_boundry;
            double top_diff = ((The_quartile/100)*total_fre) - cummulative_frequency_b4;
            double denom = frequency[j - 1];
            double in_bracket = top_diff / denom;
            Percentile = lower_class_boundry + (in_bracket * class_size);
        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){
                int total_array_fre = 0, num_classes, i = 0, j = 0, cummulative_frequency_b4 = 0;
                double Quartile_position = 0, total_fre = 0,The_quartile;
                System.out.println("Enter Percentile To Find (E.g 1st Percentile Enter 1):");
                The_quartile = scanner.nextDouble();
                System.out.println("Enter Number Of X");
                num_classes = scanner.nextInt();
                int[] frequency = new int[num_classes];
                double[] X = new double[100000];
                System.out.println("Enter All Frequency: ");
                for (i = 0; i < num_classes; i++) {
                    frequency[i] = scanner.nextInt();
                    total_fre = total_fre + frequency[i];
                }
                Quartile_position = ((The_quartile/100)*total_fre) + 0.5;
                System.out.println("Enter X");
                do {
                    X[j] = scanner.nextDouble();
                    total_array_fre = total_array_fre + frequency[j];
                    j++;
                } while (total_array_fre < Quartile_position);
                System.out.println("Percentile Position: " + Quartile_position);
                Percentile = X[j-1];

            }else if(with_fre==2){
                int max=0, counter=0, index=0, i;
                double The_quartile, Quartile_position, total_array_fre=0,ciel_quartile=0.0, floor_quartile=0.0;
                System.out.println("Enter Number Of Elements(frequency)");
                int n = scanner.nextInt();
                int [] frequency = new int[n];
                System.out.println("Enter Percentile To Find(E.g 1st Percentile Enter 1):");
                The_quartile = scanner.nextDouble();
                System.out.println("Enter All Elements");
                for(i=0;i<n; i++)
                {
                    frequency[i] = scanner.nextInt();
                }

                Arrays.sort(frequency);
                for (double element: frequency) {
                    System.out.print(element + ", " );
                }
                System.out.println("");

                Quartile_position = ((The_quartile/100)*(double) n) + 0.5;
                ciel_quartile = Math.ceil(Quartile_position);
                if((ciel_quartile-Quartile_position)>0.0){
                    floor_quartile = Math.floor(Quartile_position);
                    System.out.println("The Position Of The Percentile Is Between : " + floor_quartile + " And " + ciel_quartile);
                    ciel_quartile--;
                    floor_quartile--;
                    Integer ciel_qua = (int) ciel_quartile;
                    Integer floor_qua  = (int) floor_quartile;
                    Percentile = (frequency[ciel_qua] + frequency[floor_qua])/2.0;

                }else if(ciel_quartile-Quartile_position==0.0){
                    int The_Quartile_position = (int) Quartile_position;
                    System.out.println("The Position Of The Percentile Is: " + The_Quartile_position);
                    Percentile = frequency[The_Quartile_position-1];
                }

            }


        }
        return Percentile;
    }
    public static double mode(int option){
        double Mode=0.0, total_nom=0.0 ;
        long total_fre = 0;
        int max=0, counter=0, index=0, i;
        int [] frequency = new int[1000];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1){
            do{
                System.out.println("Enter All Frequencies(Enter Zero To End): ");
                frequency[counter] = scanner.nextInt();
                if(frequency[counter]>max){
                    max = frequency[counter];
                    index = counter;
                }
                counter++;
            }while(frequency[counter-1]!=0);
            System.out.println("Max: " + max);
            System.out.println("Index: " + index);
            int [] upper_limit = new int[counter];
            int [] lower_limit = new int[counter];
            int position = index + 1;
            System.out.println("Enter The Lower Limit Of Class " + position);
            upper_limit[index] = scanner.nextInt();
            System.out.println("Enter The Upper Limit Of Class " + position);
            lower_limit[index] = scanner.nextInt();
            double lower_class_boundry = upper_limit[index] - 0.5;
            double upper_class_boudary = lower_limit[index] + 0.5;
            double class_size = upper_class_boudary - lower_class_boundry;
            double D1 = frequency[index] - frequency[index-1];
            double D2 =frequency[index] - frequency[index+1];
            double denom = D1 + D2;
            double top = D1 / denom;
            Mode = lower_class_boundry + (top)*class_size;
        }else  if(data_type==2){

            double [] X = new double[counter];
            for (i=0; i<index; i++){
                System.out.println("Enter Upper Limit");
                X[i] = scanner.nextDouble();
            }
            Mode = X[i];

        }
        return  Mode;
    }
    public static double StandardDev(int option){
        double Standard_dev=0.0, total_nom=0.0, The_Standarad_Dev_Value=0.0, Coefficient_Variation=0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1){
            double total_FX = 0.0, total_Fre=0;
            int frequency=0;
            System.out.println("Enter Number Of Class:");
            int Num_class = scanner.nextInt();
            int upper_class[] = new int[Num_class];
            int lower_class[] = new int[Num_class];
            int frequency_array[] = new int[Num_class];
            double All_X[] = new double[Num_class];
            for (int i = 0; i<Num_class; i++){
                System.out.println("Enter Upper Limit");
                upper_class[i] = scanner.nextInt();
                System.out.println("Enter Lower Limit");
                lower_class[i] = scanner.nextInt();
                double X = (upper_class[i]+lower_class[i])/2;
                All_X[i] = X;
                System.out.println("Enter Frequency");
                frequency = scanner.nextInt();
                frequency_array[i] = frequency;
                total_Fre = total_Fre+frequency;
                double FX = ((upper_class[i]+lower_class[i])/2)*frequency;
                total_FX = total_FX + FX;
            }
            double Mean = total_FX/total_Fre;
            System.out.println("Mean= " + Mean);
            for(int x = 0; x<Num_class; x++){
                double nom = All_X[x] - Mean;
                double nom_squared = frequency_array[x]*nom * nom;
                total_nom = total_nom+nom_squared;
            }
            The_Standarad_Dev_Value = Math.sqrt(total_nom/total_Fre);
            Coefficient_Variation = (The_Standarad_Dev_Value/Mean)*100;
            System.out.println("The Coefficient Of Variation Is= " + Coefficient_Variation);
            Standard_dev = The_Standarad_Dev_Value;


        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){
                System.out.println("Data Is: \n\t1.Sample Data \n\t2.Not Sample Data");
                int sample = scanner.nextInt();
                int total_F=0;
                double F_X, total_F_X=0.0;
                System.out.println("Enter Number Of Elements:");
                int Num_element = scanner.nextInt();
                double X_array[] = new double[Num_element];
                double frequency_array[] = new double[Num_element];
                for(int i=0;i<Num_element; i++)
                {
                    System.out.println("Enter X:");
                    double X_values = scanner.nextDouble();
                    X_array[i] = X_values ;
                    System.out.println("Enter F");
                    int freq = scanner.nextInt();
                    frequency_array[i] = freq;
                    total_F = total_F + freq;
                    F_X = freq * X_values;
                    total_F_X = total_F_X+F_X;
                }
                double Mean = total_F_X/total_F;
                System.out.println("Mean= " + Mean);
                for(int j =0; j<Num_element; j++){
                    double nom = X_array[j] - Mean;
                    double nom_squared = frequency_array[j]*nom * nom;
                    total_nom = total_nom+nom_squared;
                }
                if(sample==1){
                    The_Standarad_Dev_Value = Math.sqrt(total_nom/(total_F-1));
                    Coefficient_Variation = (The_Standarad_Dev_Value/Mean)*100;
                    Standard_dev =  The_Standarad_Dev_Value;

                }else if(sample==2){
                    The_Standarad_Dev_Value = Math.sqrt(total_nom/total_F);
                    Standard_dev = The_Standarad_Dev_Value;
                    Coefficient_Variation = (The_Standarad_Dev_Value/Mean)*100;
                }
                System.out.println("The Coefficient Of Variation Is= " + Coefficient_Variation);
            }else if(with_fre==2){
                System.out.println("Data Is: \n\t1.Sample Data \n\t2.Not Sample Data");
                int sample = scanner.nextInt();
                double total_elements=0, Mean=0, Elements = 0;
                int counter=0;
                System.out.println("Enter Number Of Elements:");
                int Num_element = scanner.nextInt();
                double X_array[] = new double[Num_element];
                System.out.println("Enter All Elements:");
                for(int k=0; k<Num_element; k++){
                    Elements = scanner.nextDouble();
                    X_array[k] = Elements;
                    total_elements = total_elements + Elements;

                }
                Mean = total_elements/Num_element;
                System.out.println("Mean= " + Mean);
                for(int j =0; j<Num_element; j++){
                    double nom = X_array[j] - Mean;
                    double nom_squared = nom * nom;
                    total_nom = total_nom+nom_squared;
                }
                if(sample==1){
                    The_Standarad_Dev_Value = Math.sqrt(total_nom/(Num_element-1));
                    Coefficient_Variation = (The_Standarad_Dev_Value/Mean)*100;


                }else if(sample==2){
                    The_Standarad_Dev_Value = Math.sqrt(total_nom/Num_element);
                    Coefficient_Variation = (The_Standarad_Dev_Value/Mean)*100;

                }
                System.out.println("The Coefficient Of Variation Is= " + Coefficient_Variation);
                Standard_dev = The_Standarad_Dev_Value;

            }

        }
        return Standard_dev;
    }
    public static double meanDev(int option){
        double MeanDev=0.0, total_nom=0.0 ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1) {
            double total_FX = 0.0, total_Fre = 0;
            int frequency = 0;
            System.out.println("Enter Number Of Class:");
            int Num_class = scanner.nextInt();
            int upper_class[] = new int[Num_class];
            int lower_class[] = new int[Num_class];
            int frequency_array[] = new int[Num_class];
            double All_X[] = new double[Num_class];
            for (int i = 0; i < Num_class; i++) {
                System.out.println("Enter Upper Limit");
                upper_class[i] = scanner.nextInt();
                System.out.println("Enter Lower Limit");
                lower_class[i] = scanner.nextInt();
                double X = (upper_class[i] + lower_class[i]) / 2;
                All_X[i] = X;
                System.out.println("Enter Frequency");
                frequency = scanner.nextInt();
                frequency_array[i] = frequency;
                total_Fre = total_Fre + frequency;
                double FX = ((upper_class[i] + lower_class[i]) / 2) * frequency;
                total_FX = total_FX + FX;
            }
            double Mean = total_FX / total_Fre;
            for (int x = 0; x < Num_class; x++) {
                double nom = All_X[x] - Mean;
                nom = Math.abs(nom);
                double nom_squared = frequency_array[x] * nom;
                total_nom = total_nom + nom_squared;
            }
            MeanDev = total_nom / total_Fre;
        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){
                System.out.println("Data Is: \n\t1.Sample Data \n\t2.Not Sample Data");
                int sample = scanner.nextInt();
                int total_F=0;
                double F_X, total_F_X=0.0;
                System.out.println("Enter Number Of Elements:");
                int Num_element = scanner.nextInt();
                double X_array[] = new double[Num_element];
                int frequency_array[] = new int[Num_element];
                for(int i=0;i<Num_element; i++)
                {
                    System.out.println("Enter X:");
                    double X_values = scanner.nextDouble();
                    X_array[i] = X_values ;
                    System.out.println("Enter F");
                    int freq = scanner.nextInt();
                    frequency_array[i] = freq;
                    total_F = total_F + freq;
                    F_X = freq * X_values;
                    total_F_X = total_F_X+F_X;
                }
                double Mean = total_F_X/total_F;
                for(int j =0; j<Num_element; j++){
                    double nom = X_array[j] - Mean;
                    nom = Math.abs(nom);
                    double nom_squared = frequency_array[j]*nom;
                    total_nom = total_nom+nom_squared;
                }
                if(sample==1){
                    MeanDev = total_nom/(total_F-1);

                }else if(sample==2){
                    MeanDev = total_nom/total_F;

                }
            }else if(with_fre==2){
                System.out.println("Data Is: \n\t1.Sample Data \n\t2.Not Sample Data");
                int sample = scanner.nextInt();
                double total_elements=0, Mean=0;
                int counter=0, Elements = 0;
                System.out.println("Enter Number Of Elements:");
                int Num_element = scanner.nextInt();
                int X_array[] = new int[Num_element];
                System.out.println("Enter All Elements:");
                for(int k=0; k<Num_element; k++){
                    Elements = scanner.nextInt();
                    X_array[k] = Elements;
                    total_elements = total_elements + Elements;

                }
                Mean = total_elements/Num_element;
                for(int j =0; j<Num_element; j++){
                    double nom = X_array[j] - Mean;
                    nom = Math.abs(nom);
                    total_nom = total_nom+nom;
                }
                if(sample==1){
                    MeanDev = total_nom/(Num_element-1);

                }else if(sample==2){
                    MeanDev = total_nom/Num_element;

                }

            }

        }
        return MeanDev;
    }
    public static double nthRoot(long A, int N)
    {

        // intially guessing a random number between
        // 0 and 9
        double xPre = Math.random() % 10;

        // smaller eps, denotes more accuracy
        double eps = 0.001;

        // initializing difference between two
        // roots by INT_MAX
        double delX = 2147483647;

        // xK denotes current value of x
        double xK = 0.0;

        // loop untill we reach desired accuracy
        while (delX > eps)
        {
            // calculating current value from previous
            // value by newton's method
            xK = ((N - 1.0) * xPre +
                    (double)A / Math.pow(xPre, N - 1)) / (double)N;
            delX = Math.abs(xK - xPre);
            xPre = xK;
        }

        return Math.round(xK*1000.0)/1000.0;
    }
    public static double GeometricMean(int option){
        double Geometric_mean=0.0;
        double F_Log_X, total_F_Log_X=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Data Is: \n\t1.Grouped \n\t2.Ungrouped");
        int data_type = scanner.nextInt();
        if(data_type==1){
            int total_Fre=0;
            double total_FX = 0.0;
            int upper_limit=0, lower_limit=0, frequency=0;
            do {
                System.out.println("Enter Class Interval With Corresponding Frequency\n\tEnter 0 To End");
                System.out.println("Enter Upper Limit");
                upper_limit = scanner.nextInt();
                System.out.println("Enter Lower Limit");
                lower_limit = scanner.nextInt();
                System.out.println("Enter Frequency");
                frequency = scanner.nextInt();
                if(lower_limit==0||frequency==0){
                    break;
                }else{
                    total_Fre = total_Fre + frequency;
                    double X = (upper_limit+lower_limit)/2;
                    F_Log_X = Math.log10(X)*frequency;
                    total_F_Log_X = total_F_Log_X+F_Log_X;
                }
            }while(lower_limit!=0||frequency!=0);
            Geometric_mean = Math.pow(10, total_F_Log_X/total_Fre);

        }else if(data_type==2){
            System.out.println("Enter::\n\t1.Data With Frequency\n\t2.Data Without Frequency");
            int with_fre = scanner.nextInt();
            if(with_fre==1){

                int total_Fre=0;
                double total_FX = 0.0;
                int X=0, frequency=0;
                do {

                    System.out.println("Enter X");
                    X = scanner.nextInt();
                    System.out.println("Enter Frequency");
                    frequency = scanner.nextInt();
                    if(X==0||frequency==0){
                        break;
                    }else{
                        total_Fre = total_Fre + frequency;
                        F_Log_X = Math.log10(X)*frequency;
                        total_F_Log_X = total_F_Log_X+F_Log_X;
                    }
                }while(X!=0||frequency!=0);
                Geometric_mean = Math.pow(10, total_F_Log_X/total_Fre);
            }else if(with_fre==2){
                int Elements,quit=0, counter=0;
                long  The_total = 1, Overall_total=0;
                System.out.println("Enter All X \n\tEnter 0 To End");
                do{
                    Elements = scanner.nextInt();
                    if(Elements==0){
                        break;
                    }else{
                        The_total *= Elements;
                        counter++;
                    }
                }while(Elements!=0);



                Geometric_mean = nthRoot(The_total, counter);
            }

        }
        return Geometric_mean;
    }
    public static double slopeb1(int option){
        double Slopeb1=0,X_bar, Y_bar ;
        long XY, total_XY=0, total_X=0, total_Y=0, X_squared, total_X_squared=0;
        int X, Y, counter=0;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter X (Enter Zero To End)");
            X = scanner.nextInt();
            System.out.println("Enter Y");
            Y = scanner.nextInt();
            if(X!=0||Y!=0){
                X_squared = X*X;
                total_X_squared = total_X_squared + X_squared;
                total_X = total_X + X;
                total_Y = total_Y+Y;
                XY = X*Y;
                total_XY = total_XY+XY;
                counter++;
            }
        }while (X!=0||Y!=0);

        double top = (counter*total_XY) - (total_X*total_Y);
        double bottom = (counter*total_X_squared) - (total_X*total_X);
        Slopeb1 = top / bottom;
        X_bar = total_X/counter;
        Y_bar = total_Y/counter;
        System.out.println("X_bar= "+ X_bar);
        System.out.println("Y_bar= " + Y_bar);
        return Slopeb1;
    }
    public static double Pearson_Correlation(int option){
        double pearson_corellation = 0;
        long XY, total_XY=0, total_X=0, total_Y=0, X_squared, Y_squared=0, total_Y_squared = 0, total_X_squared=0;
        int X, Y, counter=0;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter X (Enter Zero To End)");
            X = scanner.nextInt();
            System.out.println("Enter Y (Enter Zero To End)");
            Y = scanner.nextInt();
            if(X!=0||Y!=0){
                X_squared = X*X;
                Y_squared = Y*Y;
                total_X_squared = total_X_squared + X_squared;
                total_Y_squared = total_Y_squared + Y_squared;
                total_X = total_X + X;
                total_Y = total_Y+Y;
                XY = X*Y;
                total_XY = total_XY+XY;
                counter++;
            }
        }while (X!=0||Y!=0);
        double top = (counter*total_XY) - (total_X*total_Y);
        double bottom_X = (counter*total_X_squared) - (total_X*total_X);
        double bottom_Y = (counter*total_Y_squared) - (total_Y*total_Y);
        double bottom = Math.sqrt(bottom_X*bottom_Y);
        pearson_corellation = top/bottom;
     return pearson_corellation;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        System.out.println("What Would You Like To Find?\n\t1.Arithmetic Mean\n\t2.Harmonic Mean\n\t3.Geometric Mean\n\t4.Median\n\t5.Standard Deviation\n\t6.Variance\n\t7.Mean Deviation\n\t8.Slope b1\n\t9.Pearson Product-moment correlation(Extent of Relationship r)\n\t10.Mode\n\t11.Quartile\n\t12.Decile\n\t13.Percentile");
        option = scanner.nextInt();
        if(option==1){
            System.out.println("The Value Of The Mean Is " + mean(1));
        }else if(option==2){
            System.out.println("The Value Of The Harmonic Mean Is " + HarmonicMean(2));
        }else if(option==3){
            System.out.println("The Value Of The Geometric Mean Is " + GeometricMean(3));
        }else if(option==4){
            System.out.println("The Value Of The Median Is " + median(4));
        }else if(option==5){
            System.out.println("The Value Of The Standard Deviation Is " + StandardDev(5));
        }else if(option==6){
            System.out.println("The value Of The Variance Is " + Math.pow(StandardDev(6), 2));
        }else if(option==7){
            System.out.println("The Value Of The Mean Deviation Is " + meanDev(7));
        }else if(option==8){
            System.out.println("The Value Of The Slope b1 Is " + slopeb1(8));
        }else if(option==9){
            System.out.println("The Value Of The Pearson Product-moment correlation Is " + Pearson_Correlation(9));
        }else  if(option==10){
            System.out.println("The Value Of The Mode Is " + mode(10));
        }else if(option==11){
            System.out.println("The Value Of The Quartile Is " + quartile(11));
        }else if(option==12){
            System.out.println("The Value Of The Decile Is " + decile(12));
        }else if(option==13){
            System.out.println("The Value Of The Percentile Is " + percentile(13));
        }
    }
}
