package structure;

import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static structure.ManageBook.showBook;

public class LoanStatus extends Subject {
    static Book book = new Book();
    static User user = new User();
    public static Scanner scan = new Scanner(System.in);
    static String FileName = "C:\\최종제출\\Status.txt";
    static String LFileName = "c:\\최종제출\\Loanable.txt";
    static ViewLoanable vl = ViewLoanable.getInstance();
    private LoanStatus(){}

    private static class InnerInstanceClazz{
        private static LoanStatus loanStatus = new LoanStatus();
    }

    public static LoanStatus getInstance(){
        return InnerInstanceClazz.loanStatus;
    }

    public static void borrowBook() throws IOException {
        System.out.println("\n-----------대출이 불가능한 도서--------------");
        vl.update();
        System.out.println("\n-----------도서 대여--------------");
        showBook();
        System.out.println("책 정보를 입력하시오");
        System.out.print("대여할 도서명을 입력하십시요: ");
        book.setBookTitle(scan.nextLine());
        System.out.print("ID를 입력하십시오:");
        user.setUserId(scan.nextLine());
        BufferedWriter bw = new BufferedWriter((new FileWriter(FileName, true)));

        bw.write(user.getUserId() + "님이 "+ book.getBookTitle() + "을(를) 대여했습니다.");
        bw.newLine();
        bw.close();

        BufferedWriter bw2 = new BufferedWriter((new FileWriter(LFileName, true)));
        bw2.write(book.getBookTitle());
        bw2.newLine();
        bw2.close();

        System.out.println("\n-----------갱신된 정보--------------");
        notifyObservers();
    }

    public void returnBook() throws IOException {
        String copyLFileName = "C:\\최종제출\\copyLoanalbe.txt";
        int count = 1;

        System.out.println("\n-----------도서 반납--------------");

        System.out.println("책 정보를 입력하시오");
        System.out.print("ID를 입력하십시오:");
        user.setUserId(scan.nextLine());
        System.out.print("반납 할 도서명을 입력하십시오: ");
        book.setBookTitle(scan.nextLine());


        System.out.println("\n-------반납 예정 도서----------");
        vl.update();
        System.out.print("\n반납할 책 번호를 입력하시오:");
        int deleteNum = scan.nextInt();

        BufferedReader br = new BufferedReader(new FileReader(LFileName));
        BufferedWriter bw2 = new BufferedWriter((new FileWriter(copyLFileName)));
        String str = " ";

        while ((str = br.readLine()) != null) {
            if (count != deleteNum) {
                bw2.write(str);
                bw2.write("\r\n");
            }
            count++;
        }
        br.close();
        bw2.close();

        FileInputStream fis = new FileInputStream(copyLFileName);
        FileOutputStream fos = new FileOutputStream(LFileName);

        int value = 0;
        while ((value = fis.read()) != -1) {
            fos.write(value);
        }
        fis.close();
        fos.close();

        File f = new File(copyLFileName);
        f.deleteOnExit();

        BufferedWriter bw = new BufferedWriter((new FileWriter(FileName, true)));

        bw.write(user.getUserId() + "님이 " + book.getBookTitle() + "을(를) 반납했습니다.");
        bw.newLine();
        bw.close();

        System.out.println("\n-----------갱신된 정보--------------");
        notifyObservers();
    }
}
