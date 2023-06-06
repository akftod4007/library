package structure;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class ManageUser {
    static User user = new User();
    public static Scanner scan = new Scanner(System.in);
    static String FileName = "C:\\최종제출\\user.txt";

    private ManageUser(){}

    private static class InnerInstanceClazz{
        private static final ManageUser manageUser = new ManageUser();
    }

    public static ManageUser getInstance(){
        return InnerInstanceClazz.manageUser;
    }

    public static void addId() throws IOException {
        System.out.println("\n------------회원 가입--------------");
        System.out.println("유저 정보를 입력하시오");

        System.out.print("ID를 입력하세요: ");
        user.setUserId(scan.nextLine());
        System.out.print("비밀번호를 입력하세요: ");
        user.setUserPw(scan.nextLine());

        BufferedWriter bw = new BufferedWriter((new FileWriter(FileName, true)));
        bw.write(user.getUserId() + "\t" + user.getUserPw());
        bw.newLine();
        bw.close();
    }

    public static void showId() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        String st = "";
        int num=1;

        System.out.println("\n유저 정보는 다음과 같습니다.");
        try{
            while((st = br.readLine())!= null){
                System.out.println("(" + num +") " + st);
                num++;
            }
            br.close();

        }catch (IOException e){
            System.out.println("유저 정보를 읽어올 수 없습니다.");
            e.printStackTrace();
        }
    }

    public static void deleteId() throws IOException {
        String copyFileName = "C:\\최종제출\\copyuser.txt";
        int count = 1;

        System.out.println("\n-------------계정 탈퇴-------------");
        showId();

        System.out.print("\n유저 번호를 입력하시오: ");
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