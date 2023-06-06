package play;
import structure.LoanStatus;
import structure.*;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Play {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        SearchMethod sm = new SearchMethod();
        LoginMethod ls = new LoginMethod();

        ManageBook manageBook = ManageBook.getInstance();
        ManageUser manageUser = ManageUser.getInstance();
        LoanStatus loanStatus = LoanStatus.getInstance();
        ViewLoanable vl = ViewLoanable.getInstance();
        ViewStatus vs = ViewStatus.getInstance();

        LoanStatus.attach(vl);
        LoanStatus.attach(vs);

        int choose = -1;

        Logout: while (choose != 0){
            MenuText.chooseMode();
            choose = choice();

            switch (choose){
                case 1:{
                    while(true){
                        ls.setStrategy(new LoginManager());
                        boolean bool = ls.dologin();
                        if(bool == true) {
                            do{
                                MenuText.managerMode();
                                choose = choice();

                                switch (choose)
                                {
                                    case 1:
                                        manageBook.showBook();
                                        break;
                                    case 2:
                                        manageBook.addBook();
                                        manageBook.showBook();
                                        break;
                                    case 3:
                                        manageBook.deleteBook();
                                        manageBook.showBook();
                                        break;
                                    case 4:
                                        System.out.println("로그아웃 합니다");
                                        continue Logout;
                                    case 0:
                                        exit(0);
                                        break;
                                    default:
                                        System.out.println("다시 입력해주세요.");
                                        break;
                                }
                            }while(choose != 0);
                        }
                    }
                }
                case 2:{
                    do{
                        MenuText.firstUserMode();
                        choose = choice();

                        switch (choose){
                            case 1:
                                manageUser.addId();
                                break;
                            case 2:
                                ls.setStrategy(new LoginUser());
                                boolean bool = ls.dologin();
                                do{
                                    if(bool == true){
                                        MenuText.SecondUserMode();
                                        choose = choice();

                                        switch (choose){
                                            case 1:
                                                MenuText.chooseSearch();
                                                int chooseSearch = Play.choice();

                                                if(chooseSearch == 1){
                                                    sm.setStrategy(new SearchBookTitle());
                                                    sm.dosearch();
                                                }
                                                else if(chooseSearch == 2){
                                                    sm.setStrategy(new SearchAuthor());
                                                    sm.dosearch();
                                                }
                                                else if(chooseSearch == 3){
                                                    sm.setStrategy(new SearchPublisher());
                                                    sm.dosearch();
                                                }
                                                else
                                                    System.out.println("잘못 입력하였습니다.");
                                                break;
                                            case 2:
                                                loanStatus.borrowBook();
                                                break;
                                            case 3:
                                                vs.update();
                                                loanStatus.returnBook();
                                                break;
                                            case 4:
                                                vs.update();
                                                break;
                                            case 5:
                                                manageUser.deleteId();
                                                break;
                                            case 6:
                                                System.out.println("로그아웃 합니다");
                                                continue Logout;
                                            case 0:
                                                exit(0);
                                                break;
                                            default:
                                                System.out.println("다시 입력해주세요.");
                                                break;
                                        }
                                    }
                                }while(bool != false);
                                break;
                            case 0:
                                exit(0);
                                break;
                        }
                    }while(choose != 0);
                    break;
                }
                case 0:
                    exit(0);
                    break;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }

    public static int choice() {
        System.out.print("\n번호를 선택하시오: ");
        int choose = scan.nextInt();
        System.out.println();

        return choose;
    }
}
