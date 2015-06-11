public class DepartmentNotSerial {
    private Integer departmentId;
    private String departmentName;

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public DepartmentNotSerial(Integer departmentId,
            String departmentName) {
       this.departmentId = departmentId;
       this.departmentName = departmentName;
    }  

}


