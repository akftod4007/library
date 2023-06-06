package structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginUser extends LoginStrategy {
    static Scanner scan = new Scanner(System.in);
    public static String FileName = "C:\\최종제출\\user.txt";
    static ArrayList<User> userlist = new ArrayList<User>();

    public boolean login() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));

        System.out.print("아이디를 입력하시오: ");
        String inputID = scan.nextLine();
        System.out.print("비밀번호를 입력하시오: ");
        String inputPW = scan.nextLine();
        String str = "";

        try {
            while ((str = br.readLine()) != null){
                String[] strArray = str.split("\t");
                userlist.add(new User());

                if(strArray[0].equals(inputID) && strArray[1].equals(inputPW)){
                    return true;
                }
            }
            br.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
