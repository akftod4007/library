package structure;

import java.util.Scanner;

public class LoginManager extends LoginStrategy{
    public boolean login(){
        Scanner scan = new Scanner(System.in);
        int inputPW = 0;

        while(ManageBook.managerpw != inputPW){
            System.out.print("비밀번호를 입력하시오: ");
            inputPW = scan.nextInt();

            if(ManageBook.managerpw == inputPW)
                break;
        }
        return true;
    }
}
