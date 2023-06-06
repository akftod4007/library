package structure;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class ManageBook {
    static Book book = new Book();
    public static Scanner scan = new Scanner(System.in);
    static String FileName = "C:\\최종제출\\book.txt";
    public static int managerpw = 1111;

    private ManageBook(){}

    private static class InnerInstanceClazz{
        private static ManageBook managebook = new ManageBook();
    }

    public static ManageBook getInstance(){
        return InnerInstanceClazz.managebook;
    }

    public static void addBook() throws IOException {
        System.out.println("\n-------------책 추가--------------");
        System.out.println("책 정보를 입력하시오");

        System.out.print("책 제목: ");
        book.setBookTitle(scan.nextLine());
        System.out.print("지은이: ");
        book.setAuthor(scan.nextLine());
        System.out.print("출판사: ");
        book.setPublisher(scan.nextLine());

        BufferedWriter bw = new BufferedWriter((new FileWriter(FileName, true)));
        bw.write(book.getBookTitle() + "\t" + book.getAuthor() + "\t" + book.getPublisher());
        bw.newLine();
        bw.close();
    }

    public static void showBook() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        String st = "";
        int num=1;

        System.out.println("\n책 정보는 다음과 같습니다.");
        try{
            while((st = br.readLine())!= null){
                System.out.println("(" + num +") " + st);
                num++;
            }
            br.close();

        }catch (IOException e){
            System.out.println("책 정보를 읽어올 수 없습니다.");
            e.printStackTrace();
        }
    }

    public static void deleteBook() throws IOException {
        String copyFileName = "C:\\최종제출\\copybook.txt";
        int count = 1;

        System.out.println("\n-------------책 삭제--------------");
        showBook();

        System.out.print("\n삭제할 책 번호를 입력하시오: ");
        int deleteNum = scan.nextInt();

        BufferedReader br = new BufferedReader(new FileReader(FileName));
        BufferedWriter bw = new BufferedWriter((new FileWriter(copyFileName)));
        String str = " ";

        while((str = br.readLine()) != null){
            if(count != deleteNum){
                bw.write(str);
                bw.write("\r\n");
            }
            count++;
        }
        br.close();
        bw.close();

        FileInputStream fis = new FileInputStream(copyFileName);
        FileOutputStream fos = new FileOutputStream(FileName);

        int value = 0;
        while((value = fis.read()) != -1){
            fos.write(value);
        }
        fis.close();
        fos.close();

        File f = new File(copyFileName);
        f.deleteOnExit();
    }
}
