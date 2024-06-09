import java.io.*;
import java.util.*;

class Employee{
    private int employeeId;
    private String name;
    private String branch;
    private double rating;
    private boolean companyTransport;
    
    Employee(int employeeId, String name, String branch, double rating, boolean companyTransport){
        this.employeeId = employeeId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.companyTransport = companyTransport;
    }
    public String getBranch(){
        return this.branch;
    }
    public boolean isTransport(){
        return this.companyTransport;
    }
    public int getId(){
        return this.employeeId;
    }
    public String getName(){
        return this.name;
    }
    public double getRating(){
        return this.rating;
    }
}

class myClass {
    public static int findCountOfEmployeesUsingCompTransport(Employee emp[], String branch){
        int cnt=0;
        for(int i=0; i<4; i++){
            if(emp[i].getBranch().equals(branch) && emp[i].isTransport() == true)
                cnt++;
        }
        return cnt;
    }
    public static Employee findEmployeeWithSecondHighestRating(Employee[] emp){
        
//         the object of the second highest rating employee from the array of Employee objects who are not using company transport.
        
        double maxi=0, secMax=0;
        Employee prev=null, res = null;
        for(int i=0; i<4; i++){
            double rating = emp[i].getRating();
            if(emp[i].isTransport()==false){
                if(rating > maxi){
                    secMax = maxi;
                    maxi = rating;
                    res = prev;
                    prev = emp[i];
                }
                if(rating>secMax && rating<maxi){
                    secMax = rating;
                    res = emp[i];
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Employee[] emp = new Employee[4];
        for(int i=0; i<4; i++){
             int employeeId = sc.nextInt();
             sc.nextLine();
             String name = sc.nextLine();
             String branch = sc.nextLine();
             double rating = sc.nextDouble();
             boolean companyTransport = sc.nextBoolean();
             Employee newEmp = new Employee(employeeId, name, branch, rating, companyTransport);
             emp[i] = newEmp;
        }
        
        sc.nextLine();
        String branch = sc.nextLine();
        int cnt = findCountOfEmployeesUsingCompTransport(emp, branch);
        Employee e = findEmployeeWithSecondHighestRating(emp);
        System.out.println(cnt);
        if(e != null){
            System.out.println(e.getId());
            System.out.println(e.getName());
        }
        else{
            System.out.println("No 2nd hightest Rating");
        }
        
    }
}
