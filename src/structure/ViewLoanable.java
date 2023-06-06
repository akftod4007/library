package structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViewLoanable implements Observer {
    static String LFileName = "C:\\최종제출\\Loanable.txt";
    private ViewLoanable(){}

    private  static class InnerInstanceClazz{
        private  static ViewLoanable vl = new ViewLoanable();
    }

    public static ViewLoanable getInstance() {
        return InnerInstanceClazz.vl;
    }
    @Override
    public void update() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(LFileName));
        String st = "";
        int num = 1;

        try {
            while ((st = br.readLine())!= null) {
                System.out.println("(" + num +") " + st);
                num++;
            }
            br.close();
        }
        catch (IOException e) {
            System.out.println("책 정보를 읽어올 수 없습니다.");
            e.printStackTrace();
        }
    }
}
