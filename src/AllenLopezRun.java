import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AllenLopezRun implements Serializable {

    public static void main(String[] args) throws IOException {
        DimaSerial ds_empty_src = new DimaSerial();
        System.out.println("ds_empty_src, count of departments: " + ds_empty_src.departmentCount() + ", count of employees: "  + ds_empty_src.employeeCount());
        
        DimaSerial ds_small_src = new DimaSerial();
        ds_small_src.initSmall();
        System.out.println("ds_small_src, count of departments: " + ds_small_src.departmentCount() + ", count of employees: "  + ds_small_src.employeeCount());
        
        DimaSerial ds_middle_src = new DimaSerial();
        ds_middle_src.initMiddle();
        System.out.println("ds_middle_src, count of departments: " + ds_middle_src.departmentCount() + ", count of employees: "  + ds_middle_src.employeeCount());
        
        DimaSerial ds_large_src = new DimaSerial();
        ds_large_src.initLarge();
        System.out.println("ds_large_src, count of departments: " + ds_large_src.departmentCount() + ", count of employees: "  + ds_large_src.employeeCount());
        
        System.out.println("ds_large_src, transientStr: " + ds_large_src.transientStr);
                        
        try{                
            doSeraial("seri_empty.bin", ds_empty_src);
            doSeraial("seri_small.bin", ds_small_src);
            doSeraial("seri_middle.bin", ds_middle_src);
            doSeraial("seri_large.bin", ds_large_src);
        } 
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("I/O error");
        }
        
        DimaSerial ds_empty_dst = new DimaSerial();
        DimaSerial ds_small_dst = new DimaSerial();
        DimaSerial ds_middle_dst = new DimaSerial();
        DimaSerial ds_large_dst = new DimaSerial();
       
        try{                
            ds_empty_dst = doUnseraial("seri_empty.bin");
            ds_small_dst = doUnseraial("seri_small.bin");
            ds_middle_dst = doUnseraial("seri_middle.bin");
            ds_large_dst = doUnseraial("seri_large.bin");
        } 
        catch(ClassNotFoundException e){
            System.out.println("Class not found");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        catch(IOException e){
            System.out.println("I/O error");
        }
        System.out.println("ds_empty_dst, count of departments: " + ds_empty_dst.departmentCount() + ", count of employees: "  + ds_empty_dst.employeeCount());
        System.out.println("ds_small_dst, count of departments: " + ds_small_dst.departmentCount() + ", count of employees: "  + ds_small_dst.employeeCount());
        System.out.println("ds_middle_dst, count of departments: " + ds_middle_dst.departmentCount() + ", count of employees: "  + ds_middle_dst.employeeCount());
        System.out.println("ds_large_dst, count of departments: " + ds_large_dst.departmentCount() + ", count of employees: "  + ds_large_dst.employeeCount());
        System.out.println("ds_large_dst, transientStr: " + ds_large_dst.transientStr);
    }        
    
    public static void doSeraial(String fileName, DimaSerial dimaSerial) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(dimaSerial);
            oos.flush();
        }        
    }
    
    public static DimaSerial doUnseraial(String fileName) throws IOException, ClassNotFoundException {
        DimaSerial dimaSerial = null;
        FileInputStream fis = new FileInputStream(fileName);
        try (ObjectInputStream ois = new ObjectInputStream(fis)) {
            dimaSerial = (DimaSerial)ois.readObject();
            ois.close();
        } 
        return dimaSerial;
    }    
}
