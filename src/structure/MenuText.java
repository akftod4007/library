package structure;

public class MenuText {

    public static void chooseMode(){
        System.out.println("\n[모드 선택]");
        System.out.println("1. 관리자");
        System.out.println("2. 사용자");
        System.out.println("0. 종료");
    }

    public static void managerMode(){
        System.out.println("\n[관리자 모드]");
        System.out.println("1. 책 정보 보기");
        System.out.println("2. 책 등록");
        System.out.println("3. 책 삭제");
        System.out.println("4. 로그아웃");
        System.out.println("0. 종료");
    }

    public static void firstUserMode(){
        System.out.println("\n[사용자 모드]");
        System.out.println("1. 회원가입");
        System.out.println("2. 로그인");
        System.out.println("0. 종료");
    }

    public static void SecondUserMode(){
        System.out.println("\n[회원 모드]");
        System.out.println("1. 책 검색");
        System.out.println("2. 책 대출");
        System.out.println("3. 책 반납");
        System.out.println("4. 대출현황");
        System.out.println("5. 본인 정보 삭제");
        System.out.println("6. 로그아웃");
        System.out.println("0. 종료");
    }

    public static void chooseSearch(){
        System.out.println("\n무엇으로 책을 찾길 원하십니까?");
        System.out.println("1. 책 제목");
        System.out.println("2. 지은이");
        System.out.println("3. 출판사");
    }
}
