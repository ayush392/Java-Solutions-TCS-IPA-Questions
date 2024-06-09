import java.io.*;
import java.util.*;

class Course{
    private int courseId;
    private String courseName;
    private String courseAdmin;
    private int quiz;
    private int handson;
    
    Course(int courseId, String courseName, String courseAdmin, int quiz, int handson){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
        
    }
    
    public String getCourseAdmin(){
        return this.courseAdmin;
    }
    public int getQuiz(){
        return this.quiz;
    }
    public int getHandson(){
        return this.handson;
    }
    public String getName(){
        return this.courseName;
    }
    
}
class courseProgram {
    public static int findAvgOfQuizByAdmin(Course courses[], String courseAdmin){
        // find out Average (as int) of Quiz questions for given Course Admin
        
        int sum=0, cnt=0;
        for(int i=0; i<4; i++){
            // System.out.println(courses[i].getCourseAdmin() + "->> " + courseAdmin );
            if(courses[i].getCourseAdmin().equals(courseAdmin)){
                cnt++;
                sum += courses[i].getQuiz();
            }
        }
        if(cnt==0)  return 0;
        return (sum/cnt);
    }
    
    public static List<Course> sortCourseByHandsOn(Course courses[], int handson){
        // return an Array of Course objects in an ascending order of their handson which are less than the given handson
        
        List<Course> res = new ArrayList<Course>();
        for(int i=0; i<4; i++){
            if(courses[i].getHandson() < handson)
                res.add(courses[i]);
        }
        
        if(res.size()<=1) return res;
        // Collections.sort(res);
        return res;
    }
    
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Course[] courses = new Course[4];
        
        for(int i=0; i<4; i++){
            int courseId = sc.nextInt();
            sc.nextLine();
            String courseName = sc.nextLine();
            String courseAdmin = sc.nextLine();
            int quiz = sc.nextInt();
            int handson = sc.nextInt();
            
            Course c = new Course(courseId, courseName, courseAdmin, quiz, handson);
            System.out.println(courseId+" "+courseName+" "+courseAdmin+" "+quiz+" "+handson);
            courses[i] = c;
        }
        
        
        
        sc.nextLine();
        String admin = sc.nextLine();
        int handson = sc.nextInt();
        
        // System.out.println("Input: "+admin+" "+handson);
        int avg = findAvgOfQuizByAdmin(courses, admin);
        List<Course> sorted = sortCourseByHandsOn(courses, handson);
        
        if(avg==0) System.out.println("Average: No course found");
        else    System.out.println("Average: "+ avg);
        
        if(sorted.size()==0) System.out.println("SORT: No Course found with mentioned attribute.");
        else{
            for(int i=0; i<sorted.size(); i++)
                System.out.println("sort:" + sorted.get(i).getName() + " ");
        }
    }
}

// class Practice{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         String arr[] = { "practice.geeksforgeeks.org",
//                          "www.geeksforgeeks.org",
//                          "code.geeksforgeeks.org" };
 
//         // Sorts arr[] in ascending order
//         Arrays.sort(arr);
//         System.out.println("Modified arr[] : "
//                           + Arrays.toString(arr));
//     }
// }
