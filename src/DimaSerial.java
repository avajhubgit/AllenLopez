import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DimaSerial implements Serializable {
    int serialVersionUID = 5;
    //collection of departments
    private transient List<DepartmentNotSerial> departments = new ArrayList<>();
    //collection of employees
    private List<EmployeeSerial> employees = employees = new ArrayList<>();
   
    public transient String transientStr = "test";

    public DimaSerial() {
        departments = new ArrayList<>();
    }

    private void writeObject(ObjectOutputStream out) throws IOException{
        out.defaultWriteObject();
        //count of departments
        out.writeObject(departmentCount());
        //for all departments
        for(DepartmentNotSerial d: departments){
            out.writeObject(d.getDepartmentId());
            out.writeObject(d.getDepartmentName());
        }
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException{
        in.defaultReadObject();
        
        //department count
        Integer i;
        //id of department
        Integer departmentId;
        //name of department
        String departmentName;
        
        departments = new ArrayList<>();
        //count of departments
        i = (Integer)in.readObject();
        //reead all departments
        for(; i>0; i--){
            departmentId = (Integer)in.readObject();
            departmentName = (String)in.readObject();
            //create departments and add to list
            departments.add(new DepartmentNotSerial(departmentId, departmentName));
        }
    }
    
    //count of departments
    public int departmentCount(){
      return departments.size();
    }

    //count of employees
    public int employeeCount(){
      return employees.size();
    }
    
    public void initSmall(){
        //create one department and add to list
        departments.add(new DepartmentNotSerial(1, "Information and technology department"));
     
        //create one employee and add to list
        employees.add(new EmployeeSerial(1, "John", "Smith", "novus", "hwejj23948293fj", "fox@gmail.com", 1, "673-91-03", "Programmer"));
    }

    public void initMiddle(){
        //create departments and add to list
        departments.add(new DepartmentNotSerial(1, "Information and technology department"));
        departments.add(new DepartmentNotSerial(2, "Sales department"));
        departments.add(new DepartmentNotSerial(3, "Accounting department"));
        departments.add(new DepartmentNotSerial(4, "Purchasing department"));
        departments.add(new DepartmentNotSerial(5, "Human resources department"));

        //create employees and add to list
        employees.add(new EmployeeSerial(1, "John", "Smith", "novus", "hwejj23948293fj", "fox@gmail.com", 1, "673-91-03", "Programmer"));
        employees.add(new EmployeeSerial(2, "Williams", "Antony", "opke", "jhwqi78r487h1o3jfhhqwf", "qwop@aol.com", 2, "740-58-23", "Accountant"));
        employees.add(new EmployeeSerial(3, "Brown", "Mary", "djoerk", "qioqh2t8hteurhfgowjer", "klas@tns.org", 5, "582-93-72", "Manager"));
        employees.add(new EmployeeSerial(4, "Davis", "Peter", "pet930", "ghw87y2u3rhfqeufu8", "wbom@gmail.com", 5, "930-93-76", "Driver"));
        employees.add(new EmployeeSerial(5, "Miller", "Cristine", "knu", "jkqt4h283uhtuiqhfwdwerg", "dfa@hotmail.com", 9, "346-87-39", "Seller"));
    }
  
    public void initLarge(){
        //create departments and add to list
        departments.add(new DepartmentNotSerial(1, "Information and technology department"));
        departments.add(new DepartmentNotSerial(2, "Sales department"));
        departments.add(new DepartmentNotSerial(3, "Accounting department"));
        departments.add(new DepartmentNotSerial(4, "Purchasing department"));
        departments.add(new DepartmentNotSerial(5, "Human resources department"));
        departments.add(new DepartmentNotSerial(6, "Department of orders"));
        departments.add(new DepartmentNotSerial(7, "Wholesale department"));
        departments.add(new DepartmentNotSerial(8, "Corporate department"));
        departments.add(new DepartmentNotSerial(9, "Customer care department"));
        departments.add(new DepartmentNotSerial(10, "Production department"));

        //create employees and add to list
        employees.add(new EmployeeSerial(1, "John", "Smith", "novus", "hwejj23948293fj", "fox@gmail.com", 1, "673-91-03", "Programmer"));
        employees.add(new EmployeeSerial(2, "Williams", "Antony", "opke", "jhwqi78r487h1o3jfhhqwf", "qwop@aol.com", 2, "740-58-23", "Accountant"));
        employees.add(new EmployeeSerial(3, "Brown", "Mary", "djoerk", "qioqh2t8hteurhfgowjer", "klas@tns.org", 5, "582-93-72", "Manager"));
        employees.add(new EmployeeSerial(4, "Davis", "Peter", "pet930", "ghw87y2u3rhfqeufu8", "wbom@gmail.com", 5, "930-93-76", "Driver"));
        employees.add(new EmployeeSerial(5, "Miller", "Cristine", "knu", "jkqt4h283uhtuiqhfwdwerg", "dfa@hotmail.com", 9, "346-87-39", "Seller"));
        employees.add(new EmployeeSerial(6, "Taylor", "Ann", "an70", "q3th9rfiqwfherwg", "aswn_hop@gmail.com", 3, "234-49-90", "Seller"));
        employees.add(new EmployeeSerial(7, "Anderson", "Tom", "tommy", "13io4jtu0934hgui3trg", "cro@aol.com", 2, "456-34-54", "Programmer"));
        employees.add(new EmployeeSerial(8, "Thomas", "Lee", "lee", "h2t982hr3ofuhwerufh2374t", "hjak@uk.org", 5, "345-39-09", "Consultant"));
        employees.add(new EmployeeSerial(9,"Jackson", "Bill", "jer", "4iouht24gfwwergwerg", "wep@hotmail.com", 5, "384-73-89", "Executive director"));
        employees.add(new EmployeeSerial(10, "White", "Aprile", "ape", "2jihf247hfui2rhguerhgrt", "apq@yahoo.com", 3, "345-43-90", "Manager"));
    }  
}