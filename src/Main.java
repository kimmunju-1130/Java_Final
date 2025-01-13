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
    private String studentPassword;
    private String studentRegist;

    Student (String name, int age, int number, ArrayList<Subject> subjects, String studentPassword, String studentRegist) {
        this.name = name;
        this.age = age;
        this.number = number;
        this.subjects = subjects;
        this.studentPassword = studentPassword;
        this.studentRegist = studentRegist;
    }

    public String getName() {return name;}
    public int getAge() {return age;}
    public int getNumber() {return number;}
    public ArrayList<Subject> getSubjects() {return subjects;}
    public String getstudentPassword() {return studentPassword;}
    public String getstudentRegist() {return studentRegist;}

    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setNumber(int number){this.number = number;}
    public void setSubjects(ArrayList<Subject> subject){this.subjects = subject;}
    public void setstudentPassword(String studentPassword) {this.studentPassword = studentPassword;}
    public void setstudentRegist(String studentRegist) {this.studentRegist = studentRegist;}

    public String toString() { // 형변환

         return "이름 : " + name +" " +"나이 : " + age +" " +"학번 : " + number + " "+ subjects;
    }

}
class Professor {
    private String professorName;
    private String professorMajor;
    private int professorNumber;
    private String professorPassword;

    Professor(String professorName, String professorMajor, int professorNumber,String professorPassword){
        this.professorName = professorName;
        this.professorMajor = professorMajor;
        this.professorNumber = professorNumber;
        this.professorPassword = professorPassword;
    }

    public String getNamepf() { return professorName;}
    public String getMajorpf() { return professorMajor;}
    public int getNumberpf() { return professorNumber;}
    public String getPfpw() { return professorPassword;}

    public void setNamepf(String professorName) { this.professorName = professorName;}
    public void setMajorpf(String professorMajor) { this.professorMajor = professorMajor;}
    public void setNumberpf(int professorNumber) { this.professorNumber = professorNumber;}
    public void setPfpw(String professorPassword) { this.professorPassword = professorPassword;}
}


public class Main {
    private static ArrayList<Student> studentArray = new ArrayList<>();
    private static ArrayList<Professor> professorArray = new ArrayList<>();
    private static ArrayList<Subject> subjectArray = new ArrayList<>();
    private static ArrayList<Subject> subjectArrayB = new ArrayList<>();
    private static ArrayList<Integer> LoaArray = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static boolean professorState = false;
    private static boolean studentState = false;

    public static void Inithial(){
        professorArray.add(new Professor("짱구", "코딩", 1234, "4321"));
        studentArray.add(new Student("유리", 28, 12345, subjectArray, "0987", "재학"));//어레이리스트로 넣어야함
        studentArray.add(new Student("맹구", 4, 1233, subjectArrayB, "009988", "재학"));
        subjectArray.add(new Subject("코딩", 10));
        subjectArrayB.add(new Subject("코딩", 20));
    }
    public static void runApp() {
        System.out.println("아이디와 비밀번호를 입력하시오.");
        int id = sc.nextInt();
        sc.nextLine();
        String pw = sc.nextLine();
        System.out.println(id);
        System.out.println(pw);

        for (Student s : studentArray)
            if (id == s.getNumber()) {
                if (pw.equals(s.getstudentPassword())) {
                    System.out.println("로그인이 되었습니다.");
                    studentState = true;
                    while(studentState) { studentMenu(id);}
                } else { System.out.println("아이디와 비밀번호가 틀렸습니다."); }
            }
        for (Professor p : professorArray)
            if (id == p.getNumberpf()) {
                if (pw.equals(p.getPfpw())) {
                    System.out.println("로그인이 되었습니다.");
                    
                    professorState = true;
                    while(professorState) {
                        professorMenu(id);
                    }
                } else { System.out.println("아이디와 비밀번호가 틀렸습니다.");}
            }
    }
    public static void professorMenu(int id) {
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
            case 1: studentAdd(); break;
            case 2 : studentDelete(); break;
            case 3 : studentCheck(); break;
            case 4 : allStudentCheck(); break;
            case 5 : studentChange(); break;
            case 6 : studentGradeInput(); break;
            case 7 : studentLoaCheck(); break;
            case 8 : logout(); break;
        }

    }

    public static void studentAdd() {
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
        studentArray.add(A);
        //System.out.println(studentArray);
    }
    public static void studentDelete() {
        System.out.println("삭제할 학번을 입력하시오.");
        int numb = sc.nextInt();
        for (int i = 0; i < studentArray.size(); i++) {
            if (studentArray.get(i).getNumber() == numb) {
                studentArray.remove(i);
                System.out.println("삭제되었습니다!.");
            }
        }
    }
    public static void studentCheck() {
        for (Student s : studentArray) {
            System.out.println("이름, 나이를 조회할 학번을 입력하시오.");
            int numb = sc.nextInt();
            if (s.getNumber() == numb) {
                System.out.println(s);
            }
            else { System.out.println("해당 학번의 학생이 없습니다.");}
        }
    }

    public static void allStudentCheck() {
        if (studentArray.isEmpty()) { // .isEmtpy() 비어있으면 true, 하나라도 값이 있으면 false 반환
            System.out.println("학생이 없습니다.");
        }
        else {
            for (Student s : studentArray) {
                System.out.println(s.getName());
            }
        }
    }
    public static void studentChange() {
        System.out.println("변경할 학번을 입력하시오.");
        int numb = sc.nextInt();
        for (Student s : studentArray) {
            if (s.getNumber() == numb) {
                System.out.println("변경할 이름을 입력하시오");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("변경할 나이를 입력하시오");
                int age = sc.nextInt();
                s.setName(name);
                s.setAge(age);
                //System.out.println(studentArray);
            }
        }
    }
    public static void studentGradeInput() {
        System.out.println("성적을 입력할 학번을 입력하시오.");
        int numb = sc.nextInt();
        for (Student s : studentArray) {
            if (s.getNumber() == numb) {
                System.out.println("성적을 입력하시오.");
                int scgrade = sc.nextInt();
                Subject A = new Subject("코딩", scgrade);
                if (s.getSubjects() == null) {
                    s.setSubjects(new ArrayList<>());
                }
                s.getSubjects().add(A);
                System.out.println(studentArray);
            }
        }
    }
    public static void studentLoaCheck() {
        System.out.println("휴학 신청 학생을 조회합니다.");
        for (int i = 0; i < LoaArray.size(); i++) {
            System.out.printf("[%s]\t", LoaArray.get(i));
            System.out.println();
        }
        System.out.println("숫자를 입력하시오.");
        System.out.println("1. 신청생 휴학 적용");
        int numb = sc.nextInt();
        if(numb ==1) {
            for (Student s : studentArray) {
                for (int j = 0; j < LoaArray.size(); j++) {
                    if (s.getNumber() == LoaArray.get(j)) {
                        s.setstudentRegist("휴학");
                        System.out.println("이름: " + s.getName() + " " + s.getstudentRegist() + "처리됐습니다.");
                    }
                }
            }
        }
    }
    public static void logout() {
        System.out.println("로그아웃되었습니다.");
        runApp();
    }

    public static void studentMenu(int id) {
        System.out.println("숫자를 입력하시오.");
        System.out.println("1. 성적 조회");
        System.out.println("2. 비밀번호 변경");
        System.out.println("3. 휴학신청");
        System.out.println("4. 로그아웃");
        int select = sc.nextInt();

        switch(select) {
            case 1 : gradecheck(id); break;
            case 2 : studentPasswordChange(id); break;
            case 3 : loaApply(id); break;
            case 4 : logout(); break;
        }

    }
    public static void gradecheck(int id) {
        for (Student s : studentArray) {
            if (s.getNumber() == id) {
                s.getSubjects();
                System.out.println(s.getSubjects());
            }
            else {System.out.println("해당 학번이 없습니다.");}
        }
    }
    public static void studentPasswordChange(int id) {
        for (Student s : studentArray) {
            if (s.getNumber() == id) {
                System.out.println("변경할 비밀번호를 입력하시오");
                sc.nextLine();
                String changepw = sc.nextLine();
                s.setstudentPassword(changepw);
                System.out.println("비밀번호가 " + s.getstudentPassword() + " (으)로 변경되었습니다.");
            }
        }
    }
    public static void loaApply(int id) {
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
    public static void main(String[] args) {
        Inithial();
        runApp();
        }
    }

