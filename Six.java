import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Six{
    public static void main(String[] args) {

        Scanner scan = null;
        try {
            scan = new Scanner(new File("Input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = scan.nextLine();


        String[] split = line.trim().split(",");

        //Array holds total of each number 0-8
        long[] numbers = new long[9];


        for(int i = 0; i< split.length; i++) {
            numbers[Integer.valueOf(split[i])]++;
        }

        for(int i = 0; i <256 ; i++){
            //Current total on 0
            long temp = numbers[0];

            //Shift array left
            for(int z = 0; z < 8; z ++){
                numbers[z] = numbers[z+1];
            }

            numbers[8] = temp;
            numbers[6] += temp;
        }
        long answer = 0;
        for(int i = 0; i < 9; i++){
            answer += numbers[i];
        }
        System.out.println(answer);
    }
}