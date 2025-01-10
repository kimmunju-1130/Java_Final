import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Subject {
    private String subjects; //과목
    private int grade; //점수

    Subject (String subjects, int grade) {
        this.subjects = subjects;
        this.grade = grade;
    }

    public String getSubject() {return subjects;}
    public int getGrade() {return grade;}

    public void setSbject() {this.subjects = subjects;}
    public void setGrade() {this.grade = grade;}
    public String toString() { return "과목 : " + subjects + " 점수 : " + grade; }
}



class Student {
    private String name;
    private int age;
    private int number;
    private ArrayList<Subject> subjects;
    private String St_pw;
    private String St_regist;

    Student (String name, int age, int number, ArrayList<Subject> subjects, String St_pw, String St_regist) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.subjects = subjects;
        this.St_pw = St_pw;
        this.St_regist = St_regist;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getNumber() {return number;}
    public ArrayList<Subject> getSubjects() {return subjects;}
    public String getStpw() {return St_pw;}
    public String getSt_regist() {return St_regist;}

    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setNumber(int number){this.number = number;}
    public void setSubjects(ArrayList<Subject> subject){this.subjects = subject;}
    public void setStpw(String St_pw) {this.St_pw = St_pw;}
    public void setSt_regist(String St_regist) {this.St_regist = St_regist;}

    public String toString() { // 형변환

         return "이름 : " + name +" " +"나이 : " + age +" " +"학번 : " + number + " "+ subjects;
    }

}

class professor {
    private String pf_name;
    private String pf_major;
    private int pf_number;
    private String pf_pw;

    professor(String pf_name, String pf_major, int pf_number,String pf_pw){
        this.pf_name = pf_name;
        this.pf_major = pf_major;
        this.pf_number = pf_number;
        this.pf_pw = pf_pw;
    }

    public String getNamepf() { return pf_name;}
    public String getMajorpf() { return pf_major;}
    public int getNumberpf() { return pf_number;}
    public String getPfpw() { return pf_pw;}

    public void setNamepf(String pf_name) { this.pf_name = pf_name;}
    public void setMajorpf(String pf_major) { this.pf_major = pf_major;}
    public void setNumberpf(int pf_number) { this.pf_number = pf_number;}
    public void setPfpw(String pf_pw) { this.pf_pw = pf_pw;}
}


public class Main {
    private static ArrayList<Student> StudentArray = new ArrayList<>();
    private static ArrayList<professor> professorArray = new ArrayList<>();
    private static ArrayList<Subject> SubjectArray = new ArrayList<>();
    private static ArrayList<Subject> SubjectArrayB = new ArrayList<>();
    private static ArrayList<Integer> LoaArray = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static boolean pf_state = false;
    private static boolean st_state = false;

    public static void Inithial(){
        professorArray.add(new professor("짱구", "코딩", 1234, "4321"));
        StudentArray.add(new Student("유리", 28, 12345, SubjectArray, "0987", "재학"));//어레이리스트로 넣어야함
        StudentArray.add(new Student("맹구", 4, 1233, SubjectArrayB, "009988", "재학"));
        SubjectArray.add(new Subject("코딩", 10));
        SubjectArrayB.add(new Subject("코딩", 20));
    }
    public static void RunApp() {
        System.out.println("아이디와 비밀번호를 입력하시오.");
        int id = sc.nextInt();
        sc.nextLine();
        String pw = sc.nextLine();
        System.out.println(id);
        System.out.println(pw);

        for (Student s : StudentArray)
            if (id == s.getNumber()) {
                if (pw.equals(s.getStpw())) {
                    System.out.println("로그인이 되었습니다.");
                    st_state = true;
                    while(st_state) { Student_menu(id);}
                } else { System.out.println("아이디와 비밀번호가 틀렸습니다."); }
            }
        for (professor p : professorArray)
            if (id == p.getNumberpf()) {
                if (pw.equals(p.getPfpw())) {
                    System.out.println("로그인이 되었습니다.");
                    pf_state = true;
                    while(pf_state) {
                        ProfessorMenu(id);
                    }
                } else { System.out.println("아이디와 비밀번호가 틀렸습니다.");}
            }
    }
    public static void ProfessorMenu(int id) {
        System.out.println("숫자를 입력하시오.");
        System.out.println("1. 학생추가"); //스캔받아서 추가 하고
        System.out.println("2. 학생삭제");
        System.out.println("3. 학생조회"); //학번을 누르면 이름, 나이 조회
        System.out.println("4.전체 학생 조회");
        System.out.println("5. 학생 변경");
        System.out.println("6. 성적 입력");
        System.out.println("7. 휴학생 조회");
        System.out.println("8. 로그아웃");
        int select = sc.nextInt();
        switch(select) {
            case 1: StudentAdd(); break;
            case 2 : StudentDelete(); break;
            case 3 : StudentCheck(); break;
            case 4 : AllstudentCheck(); break;
            case 5 : StudentChange(); break;
            case 6 : StudentgradeInput(); break;
            case 7 : StudentloaCheck(); break;
            case 8 : ProfessorLogout(); break;
        }
        RunApp();
    }

    public static void StudentAdd() {
        System.out.println("이름을 입력해주세요");
        sc.nextLine();
        String nam = sc.nextLine();
        System.out.println("나이를 입력해주세요");
        int ag = sc.nextInt();
        System.out.println("학번을 입력해주세요");
        sc.nextLine();
        int number = sc.nextInt();
        System.out.println("비밀번호를 입력해주세요");
        sc.nextLine();
        String sp = sc.nextLine();
        Student A = new Student(nam, ag, number, null, sp, "재학");
        StudentArray.add(A);
        //System.out.println(StudentArray);
    }
    public static void StudentDelete() {
        System.out.println("삭제할 학번을 입력하시오.");
        int numb = sc.nextInt();
        for (int i = 0; i < StudentArray.size(); i++) {
            if (StudentArray.get(i).getNumber() == numb) {
                StudentArray.remove(i);
                System.out.println("삭제되었습니다!.");
            }
        }
    }
    public static void StudentCheck() {
        for (Student s : StudentArray) {
            System.out.println("이름, 나이를 조회할 학번을 입력하시오.");
            int numb = sc.nextInt();
            if (s.getNumber() == numb) {
                System.out.println(s);
            }
            else { System.out.println("해당 학번의 학생이 없습니다.");}
        }
    }

    public static void AllstudentCheck() {
        if (StudentArray.isEmpty()) { // .isEmtpy() 비어있으면 true, 하나라도 값이 있으면 false 반환
            System.out.println("학생이 없습니다.");
        }
        else {
            for (Student s : StudentArray) {
                System.out.println(s.getName());
            }
        }
    }
    public static void StudentChange() {
        System.out.println("변경할 학번을 입력하시오.");
        int numb = sc.nextInt();
        for (Student s : StudentArray) {
            if (s.getNumber() == numb) {
                System.out.println("변경할 이름을 입력하시오");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("변경할 나이를 입력하시오");
                int age = sc.nextInt();
                s.setName(name);
                s.setAge(age);
                //System.out.println(StudentArray);
            }
        }
    }
    public static void StudentgradeInput() {
        System.out.println("성적을 입력할 학번을 입력하시오.");
        int numb = sc.nextInt();
        for (Student s : StudentArray) {
            if (s.getNumber() == numb) {
                System.out.println("성적을 입력하시오.");
                int scgrade = sc.nextInt();
                Subject A = new Subject("코딩", scgrade);
                if (s.getSubjects() == null) {
                    s.setSubjects(new ArrayList<>());
                }
                s.getSubjects().add(A);
                System.out.println(StudentArray);
            }
        }
    }
    public static void StudentloaCheck() {
        System.out.println("휴학 신청 학생을 조회합니다.");
        for (int i = 0; i < LoaArray.size(); i++) {
            System.out.printf("[%s]\t", LoaArray.get(i));
            System.out.println();
        }
        System.out.println("숫자를 입력하시오.");
        System.out.println("1. 신청생 휴학 적용");
        int numb = sc.nextInt();
        if(numb ==1) {
            for (Student s : StudentArray) {
                for (int j = 0; j < LoaArray.size(); j++) {
                    if (s.getNumber() == LoaArray.get(j)) {
                        s.setSt_regist("휴학");
                        System.out.println("이름: " + s.getName() + " " + s.getSt_regist() + "처리됐습니다.");
                    }
                }
            }
        }
    }
    public static void ProfessorLogout() {
        pf_state = false;
        System.out.println("로그아웃되었습니다.");
    }

    public static void Student_menu(int id) {
        System.out.println("숫자를 입력하시오.");
        System.out.println("1. 성적 조회");
        System.out.println("2. 비밀번호 변경");
        System.out.println("3. 휴학신청");
        System.out.println("4. 로그아웃");
        int select = sc.nextInt();

        switch(select) {
            case 1 : Gradecheck(id); break;
            case 2 : StpwChange(id); break;
            case 3 : LoaApply(id); break;
            case 4 : StudentLogout(); break;
        }
        RunApp();

    }
    public static void Gradecheck(int id) {
        for (Student s : StudentArray) {
            if (s.getNumber() == id) {
                s.getSubjects();
                System.out.println(s.getSubjects());
            }
            else {System.out.println("해당 학번이 없습니다.");}
        }
    }
    public static void StpwChange(int id) {
        for (Student s : StudentArray) {
            if (s.getNumber() == id) {
                System.out.println("변경할 비밀번호를 입력하시오");
                sc.nextLine();
                String changepw = sc.nextLine();
                s.setStpw(changepw);
                System.out.println("비밀번호가 " + s.getStpw() + " (으)로 변경되었습니다.");
            }
        }
    }
    public static void LoaApply(int id) {
        System.out.println("휴학신청 하시겠습니까? 1.예 2.메뉴로 돌아가기 ");
        int LoaSelect = sc.nextInt();
        if(LoaSelect==1) {
            LoaArray.add(id);
            System.out.println(LoaArray);
            System.out.println("휴학신청되었습니다");
        }
        else if(LoaSelect==2){
            System.out.println("메뉴로 돌아갑니다.");
        }
    }
    public static void StudentLogout() {
        st_state = false;
        System.out.println("로그아웃되었습니다.");
    }
    public static void main(String[] args) {
        Inithial();
        RunApp();
        }
    }

