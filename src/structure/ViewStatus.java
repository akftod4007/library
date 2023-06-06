package structure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViewStatus implements Observer  {
    static String FileName = "C:\\최종제출\\Status.txt";

    private ViewStatus(){}

    private  static class InnerInstanceClazz{
        private  static ViewStatus vs = new ViewStatus();
    }

    public static ViewStatus getInstance() {
        return InnerInstanceClazz.vs;
    }
    @Override
    public void update() throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader(FileName));
        String st = "";
        int num = 1;

        System.out.println("\n대여 정보는 다음과 같습니다.");
        try {
            while ((st = br.readLine()) != null) {
                System.out.println("(" + num + ") " + st);
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