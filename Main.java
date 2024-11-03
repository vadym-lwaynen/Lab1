import java.io.*;
import java.util.*;


/**
 * Клас Lab1 реалізує приклад програми до лабораторної роботи №1
 *
 *
 * @version 1.0
 * @since version 1.0
 *
 */


public class Main {

    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args
     * @throws FileNotFoundException
     *
     */


    public static void main(String[] args) throws FileNotFoundException {

        int nRows;
        char[][] arr;
        String filler;
        Scanner in = new Scanner(System.in);
        File dataFile = new File("MyFile.txt");
        PrintWriter fout = new PrintWriter(dataFile);

        System.out.print("Введiть розмiр квадратної матрицi: ");
        nRows = in.nextInt();
        in.nextLine();
        arr = new char[nRows][];

        /**
         * Перевірка на довжину сторони квадрата
         * 6 10 14 18 22 26 30 ... повертає  1
         * 5 7  9  11 13 15 17 ... повертає  1
         * 8 12 16 20 24 28 32 ... повертає  0
         */
        int type = (nRows / 2) % 2;

        switch(type)
        {
            case 0:
                int first_layer = nRows / 4;
                int three_leyer = nRows - first_layer - 1;
                for (int i = 0; i < nRows; ++i)
                {
                    if(i < first_layer)
                        arr[i] = new char[nRows];
                    else if(i == first_layer)
                        arr[i] = new char[first_layer * 2];
                    else if(i > first_layer && i < three_leyer)
                        arr[i] = new char[nRows - 2];
                    else if(i == three_leyer)
                        arr[i] = new char [first_layer * 2];
                    else if(i > three_leyer && i < nRows)
                        arr[i] = new char [nRows];
                }
                System.out.print("\nВведiть символ-заповнювач: ");
                filler = in.nextLine();
                in.close();

                if(filler.length() == 0)
                {
                    System.out.print("\nНе введено символ заповнювач");
                    break;
                }else if(filler.length() > 1) {
                    System.out.print("\nЗабагато символів заповнювачів");
                    break;
                }

                for(int i = 0; i < nRows; ++i){
                    for(int j =0; j < arr[i].length; ++j){
                        arr[i][j] = (char)filler.charAt(0);
                    }
                }
                for(int i = 0; i < nRows; ++i){
                    for(int j = 0; j < arr[i].length; ++j){
                        if(i < first_layer) {
                            System.out.print(arr[i][j] + " ");
                            fout.print(arr[i][j] + " ");
                        }
                        else if(i == first_layer || i == three_leyer){
                            if(j == (arr[i].length / 2)){
                                int length_s = (nRows - (arr[i].length)) * 2;
                                boolean run = true;
                                while (run)
                                {
                                    if(length_s == 0)
                                        break;
                                    System.out.print(" ");
                                    fout.print(" ");
                                    --length_s;
                                }
                            }
                            System.out.print(arr[i][j] + " ");
                            fout.print(arr[i][j] + " ");
                        }
                        else if(i > first_layer && i < three_leyer)
                        {
                            if(j == first_layer || j == (nRows - first_layer - 2)) {
                                System.out.print("  ");
                                fout.print("  ");
                            }
                            System.out.print(arr[i][j] + " ");
                            fout.print(arr[i][j] + " ");
                        }
                        else if(i > three_leyer && i < nRows) {
                            System.out.print(arr[i][j] + " ");
                            fout.print(arr[i][j] + " ");
                        }
                    }
                    System.out.print("\n");
                    fout.print("\n");
                }
                fout.flush();
                fout.close();
                break;

            case 1:
                int yellow_length = (nRows / 2) - 1;
                int size_yell = nRows / 4; // границя першого слою
                int seredina = nRows / 2 - 1; // кількість жовтих квадратиків між якими пусто другий слой

                int tritina = nRows / 3;              //
                int next_chastina = nRows - tritina;  // третій слой границя жовтих

                int yellow_square_in_the_chenter = nRows - 2; // центральні жовті штуки
                for (int i = 0; i < nRows; ++i)
                {
                    if (i < size_yell)
                        arr[i] = new char[nRows];
                    else if (i == size_yell)
                        arr[i] = new char[seredina];
                    else if (i > size_yell && i < next_chastina)
                        arr[i] = new char[yellow_square_in_the_chenter];
                    else if (i == next_chastina)
                        arr[i] = new char[seredina];
                    else if ( i > next_chastina && i < nRows)
                        arr[i] = new char[nRows];
                }
                System.out.print("\nВведiть символ-заповнювач: ");
                filler = in.nextLine();
                in.close();

                if(filler.length() == 0)
                {
                    System.out.print("\nНе введено символ заповнювач");
                    break;
                }else if(filler.length() > 1) {
                    System.out.print("\nЗабагато символів заповнювачів");
                    break;
                }

                for(int i = 0; i < nRows; ++i){
                    for(int j =0; j < arr[i].length; ++j){
                        arr[i][j] = (char)filler.charAt(0);
                    }
                }

                for(int i = 0; i < nRows; ++i){
                    for(int j =0; j < arr[i].length; ++j){
                        if(i < size_yell) {
                            System.out.print(arr[i][j] + " ");
                            fout.print(arr[i][j] + " ");
                        }
                        else if(i == size_yell || i == next_chastina){
                            if(j == (arr[i].length / 2 )){
                                int length_s = (nRows - seredina) * 2;
                                boolean run = true;
                                while (run)
                                {
                                    if(length_s == 0)
                                        break;
                                    System.out.print(" ");
                                    fout.print(" ");
                                    --length_s;
                                }
                            }
                            System.out.print(arr[i][j] + " ");
                            fout.print(arr[i][j] + " ");
                        }
                        else if((i > size_yell && i < next_chastina)){
                            int inducator = seredina / 2;
                            if (j == inducator || j == (nRows - inducator - 2)) {
                                System.out.print("  ");
                                fout.print("  ");
                            }
                            System.out.print(arr[i][j] + " ");
                            fout.print(arr[i][j] + " ");
                        }
                        else if (i > next_chastina && i < nRows) {
                            System.out.print(arr[i][j] + " ");
                            fout.print(arr[i][j] + " ");
                        }
                    }
                    System.out.print("\n");
                    fout.print("\n");
                }
                fout.flush();
                fout.close();
                break;

            default:
                break;
        }

    }
}
