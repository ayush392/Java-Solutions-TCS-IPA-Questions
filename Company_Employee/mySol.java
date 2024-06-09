import java.io.*;
import java.util.*;

class Employee{
    private int id;
    private String name;
    private String designation;
    private double salary;
    
    Employee(int id, String name, String designation, double salary){
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getSalary(){
        return this.salary;
    }
    public String getDesignation(){
        return this.designation;
    }
}

class Company{
    private String companyName;
    private ArrayList<Employee> employees = new ArrayList<>();
    private int numEmployees;
    
    public double getAverageSalary(ArrayList<Employee> employees){
        double sum=0;
        int count=0;
        for(int i=0; i<employees.size(); i++){
            sum += employees.get(i).getSalary();
            count++;
        }
        return (double)sum/count;
    }
    
    public double getMaxSalary(ArrayList<Employee> employees){
        double res = 0;
        for(int i=0; i<employees.size(); i++){
            res = Math.max(res, employees.get(i).getSalary());
        }
        return res;
    }
    
    public void getEmployeesByDesignation(ArrayList<Employee> employees, String d){
        for(int i=0; i<employees.size(); i++){
            if(employees.get(i).getDesignation().toLowerCase().equals(d.toLowerCase())){
                Employee e = employees.get(i);
                System.out.println(e.getId()+ " "+ e.getDesignation());
            }
        }
        return;
    }
    
    Company(String companyName, int n){
        this.companyName = companyName;
        this.numEmployees = n;
    }
    
    public ArrayList<Employee> getEmployees(){
        return this.employees;
    }
}


class Answer{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String companyName = sc.nextLine();
        int numEmployees = sc.nextInt();
        
        Company c = new Company(companyName, numEmployees);
        
        for(int i=0; i<numEmployees; i++){
            // id name, designation, salary
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String designation = sc.nextLine();
            double salary = sc.nextDouble();
            Employee e = new Employee(id, name, designation, salary);
            c.getEmployees().add(e);
        }
        
        System.out.println(c.getAverageSalary(c.getEmployees()));
        System.out.println(c.getMaxSalary(c.getEmployees()));
        c.getEmployeesByDesignation(c.getEmployees(), "engineer");
    }
}


