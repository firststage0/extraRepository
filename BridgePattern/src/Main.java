public class Main {


    public static void main(String[] args) {
        SQLDB SQLDB = new SQLDB();
        DBManagement dbManagement = new MySQLWorkbench(SQLDB);
        dbManagement.addData();
        dbManagement.updateData();
        dbManagement.deleteData();
    }
}