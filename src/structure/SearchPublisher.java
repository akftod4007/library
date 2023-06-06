package structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchPublisher extends SearchStrategy {
    public static String FileName = "C:\\최종제출\\book.txt";
    static ArrayList<Book> booklist = new ArrayList<Book>();
    static Scanner scan = new Scanner(System.in);

    public void search() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        System.out.print("검색할 출판사를 쓰시오: ");
        String searchWord = scan.nextLine();
        String str = "";

        try {
            while ((str = br.readLine()) != null){
                String[] strArray = str.split("\t");
                booklist.add(new Book());

                if(strArray[2].contains(searchWord)){
                    System.out.println(strArray[2] + " - " +"책 제목:"+ strArray[0] +" 지은이:" + strArray[1]);
                }
            }
            br.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}