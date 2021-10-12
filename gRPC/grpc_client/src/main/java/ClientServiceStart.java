import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientServiceStart {
    private ManagedChannel channel;
    private DataServiceGrpc.DataServiceBlockingStub stub;
    private Scanner sc;
    public ClientServiceStart(){
        this.channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
        this.stub = DataServiceGrpc.newBlockingStub(channel);
        this.sc = new Scanner(System.in);
    }
    public void start(){
        mainMenu: while (true){
            this.showMainMenu();
            switch (sc.next()){
                case "0":
                    break mainMenu;
                case "1":
                    studentMenu:while (true) {
                        this.showStudentMenu();
                        switch (sc.next()) {
                            case "0":
                                break studentMenu;
                            case "1":
                                this.showStudentList();
                                break;
                            case "2":
                                this.addStudent();
                                break;
                            case "3":
                                this.deleteStudent();
                                break;
                            default:
                                this.inputOutBoundary();
                                break;
                        }
                    }
                    break;
                case "2":
                    courseMenu:while (true) {
                        this.showCourseMenu();
                        switch (sc.next()) {
                            case "0":
                                break courseMenu;
                            case "1":
                                this.showCourseList();
                                break;
                            case "2":
                                this.addCourse();
                                break;
                            case "3":
                                this.deleteCourse();
                                break;
                            default:
                                this.inputOutBoundary();
                                break;
                        }
                    }
                    break;
                case "3":
                    enrollMenu:while (true) {
                        this.showEnrollmentMenu();
                        switch (sc.next()) {
                            case "0":
                                break enrollMenu;
                            case "1":
                                this.showEnrollmentList();
                                break;
                            case "2":
                                this.enroll();
                                break;
                            default:
                                this.inputOutBoundary();
                                break;
                        }
                    }
                    break;
                default:
                    this.inputOutBoundary();
                    break;
            }
        }
        System.out.println("시스템을 종료합니다.");
        this.channel.shutdown();
    }
    private void inputOutBoundary() {
        System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
    }
    private void showMainMenu(){
        System.out.println("****** 메뉴 ******");
        System.out.println("0.종료");
        System.out.println("1.학생 관리하기");
        System.out.println("2.강좌 관리하기");
        System.out.println("3.수강신청 관리하기");
        System.out.printf("원하는 메뉴를 입력해주세요 : ");
    }
    private void showStudentMenu(){
        System.out.println("\n****** 학생 메뉴 ******");
        System.out.println("0.돌아가기");
        System.out.println("1.학생 리스트 확인하기");
        System.out.println("2.학생 추가하기");
        System.out.println("3.학생 삭제하기");
        System.out.printf("원하는 메뉴를 입력해주세요 : ");
    }
    private void showCourseMenu(){
        System.out.println("\n****** 강좌 메뉴 ******");
        System.out.println("0.돌아가기");
        System.out.println("1.강좌 리스트 확인하기");
        System.out.println("2.강좌 추가하기");
        System.out.println("3.강좌 삭제하기");
        System.out.printf("원하는 메뉴를 입력해주세요 : ");
    }
    private void showEnrollmentMenu(){
        System.out.println("\n****** 강좌 메뉴 ******");
        System.out.println("0.돌아가기");
        System.out.println("1.수강신청 리스트 확인하기");
        System.out.println("2.수강신청 하기");
        System.out.printf("원하는 메뉴를 입력해주세요 : ");
    }
    private void showStudentList(){
        Data.StudentResponse responseStudent = this.stub.getStudents(Data.StudentRequest.newBuilder().build());
        if (responseStudent.getStudentListList().size() == 0){
            System.out.println("!!! 학생이 존재하지 않습니다. !!!");
        } else {
            for (int i = 0; i < responseStudent.getStudentListCount(); i++){
                System.out.println(responseStudent.getStudentList(i));
            }
        }
    }
    private void addStudent(){
        System.out.printf("\n학번을 입력해주세요 : "); String sNum = sc.next();
        System.out.printf("성을 입력해주세요 : "); String sFirstName = sc.next();
        System.out.printf("이름을 입력해주세요 : "); String sSecondName = sc.next();
        System.out.printf("학과를 입력해주세요 : "); String sDept = sc.next();
        Data.Student.Builder student = Data.Student.newBuilder();
        student.setStudentId(sNum);
        student.setFirstName(sFirstName);
        student.setSecondName(sSecondName);
        student.setDepartment(sDept);
        if (this.stub.addStudent(student.build()).getIsSuccess()){
            System.out.println("*** 학생이 추가되었습니다 ***");
        } else {
            System.out.println("!!! 학생 추가가 실패하였습니다 !!!");
        }
    }
    private void deleteStudent(){
        this.showStudentList();
        System.out.printf("삭제할 학생의 학번을 입력해주세요 : "); String sNum = sc.next();
        Data.deleteNum.Builder request = Data.deleteNum.newBuilder();
        request.setDelNum(sNum);
        if (this.stub.deleteStudent(request.build()).getIsSuccess()){
            System.out.println("*** 학생이 삭제되었습니다 ***");
        } else {
            System.out.println("!!! 학생 삭제가 실패하였습니다 !!!");
        }
    }
    private void showCourseList(){
        Data.CourseResponse responseCourse = this.stub.getCourses(Data.CourseRequest.newBuilder().build());
        if (responseCourse.getCourseListList().size() == 0){
            System.out.println("!!! 강좌가 존재하지 않습니다. !!!");
        } else {
            for (int i = 0; i < responseCourse.getCourseListCount(); i++) {
                System.out.println(responseCourse.getCourseList(i));
            }
        }
    }
    private void addCourse(){
        System.out.printf("\n강좌번호를 입력해주세요 : "); String cNum = sc.next();
        System.out.printf("교수명을 입력해주세요 : "); String cPfName = sc.next();
        System.out.printf("강좌명을 입력해주세요 : "); String cName = sc.next();
        ArrayList<String> preRequisites = new ArrayList<String>();
        while (true){
            System.out.printf("선수 과목이 존재합니까? (y/n) : ");
            String inputPre = sc.next();
            if (inputPre.equals("y")){
                System.out.printf("선수 과목으로 추가할 강좌번호를 입력해주세요 (그만두려면 0을 입력하세요) : ");
                String preReq = sc.next();
                while(!preReq.equals("0")){
                    preRequisites.add(preReq);
                    System.out.println(preReq+" 이 선수과목으로 추가됩니다.");
                    System.out.printf("선수 과목으로 추가할 강좌번호를 입력해주세요 (그만두려면 0을 입력하세요) : ");
                    preReq = sc.next();
                }
                break;
            } else if (inputPre.equals("n")){
                System.out.println("선수 과목을 설정하지 않습니다.");
                break;
            } else {
                this.inputOutBoundary();
            }
        }
        Data.Course.Builder course = Data.Course.newBuilder();
        course.setCourseId(cNum);
        course.setPfName(cPfName);
        course.setName(cName);
        course.addAllPrerequisites(preRequisites);
        if (this.stub.addCourse(course.build()).getIsSuccess()){
            System.out.println("*** 강좌가 추가되었습니다 ***");
        } else {
            System.out.println("!!! 강좌 추가 실패하였습니다 !!!");
        }
    }
    private void deleteCourse(){
        this.showCourseList();
        System.out.printf("삭제할 강좌의 강좌번호를 입력해주세요 : "); String cNum = sc.next();
        Data.deleteNum.Builder request = Data.deleteNum.newBuilder();
        request.setDelNum(cNum);
        if (this.stub.deleteCourse(request.build()).getIsSuccess()){
            System.out.println("*** 강좌가 삭제되었습니다 ***");
        } else {
            System.out.println("!!! 강좌 삭제가 실패하였습니다 !!!");
        }
    }
    private void showEnrollmentList(){
        Data.EnrollmentResponse responseEnrollment = this.stub.getEnrollment(Data.EnrollmentRequest.newBuilder().build());
        if (responseEnrollment.getEnrollmentListList().size() == 0){
            System.out.println("!!! 수강신청 내역이 존재하지 않습니다. !!!");
        } else {
            for (int i = 0; i < responseEnrollment.getEnrollmentListCount(); i++) {
                System.out.println(responseEnrollment.getEnrollmentList(i));
            }
        }
    }
    private void enroll(){
        this.showStudentList();
        this.showCourseList();
        System.out.printf("수강신청을 진행할 학생의 학번을 입력해주세요 : "); String sNum = sc.next();
        System.out.printf("수강신청할 강좌번호를 입력해주세요 : "); String cNum = sc.next();
        Data.Enrollment.Builder request = Data.Enrollment.newBuilder();
        request.setStudentId(sNum);
        request.setCourseId(cNum);
        Data.IsEnroll response = this.stub.enroll(request.build());
        if (response.getIsStudentExist()){
            if (response.getIsCourseExist()){
                if(response.getIsPrerequisitesDone()){
                    System.out.println("*** 수강 신청이 완료되었습니다. ***");
                } else {
                    System.out.println("!!! 선수 과목을 이수 하지 않았습니다. !!!");
                }
            } else {
                System.out.println("!!! 존재하지 않는 강좌입니다. !!!");
            }
        } else {
            System.out.println("!!! 존재하지 않는 학생입니다. !!!");
        }
    }
    public static void main(String args[]){
        ClientServiceStart client = new ClientServiceStart();
        client.start();
    }
}

