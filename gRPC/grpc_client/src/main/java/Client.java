import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class Client {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091)
                .usePlaintext().build();
        DataServiceGrpc.DataServiceBlockingStub stub = DataServiceGrpc.newBlockingStub(channel);

        menu: while (true){
            System.out.println("****** 메뉴 ******");
            System.out.println("0.종료");
            System.out.println("1.학생 리스트 확인하기");
            System.out.println("2.강좌 리스트 확인하기");
            System.out.printf("\n원하는 메뉴를 입력해주세요 : ");

            String input = sc.next();
            switch (input){
                case "0":
                    System.out.println("프로그램을 종료합니다.");
                    break menu;
                case "1":
                    Data.StudentResponse responseStudent = stub.getStudents(Data.StudentRequest.newBuilder().build());
                    for (int i = 0; i < responseStudent.getStudentListCount(); i++){
                        System.out.println(responseStudent.getStudentList(i));
                    }
                    break;
                case "2":
                    Data.CourseResponse responseCourse = stub.getCourses(Data.CourseRequest.newBuilder().build());
                    for (int i = 0; i < responseCourse.getCourseListCount(); i++){
                        System.out.println(responseCourse.getCourseList(i));
                    }
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");
                    break;
            }
        }
        channel.shutdown();
    }
}

