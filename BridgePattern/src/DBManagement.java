public abstract class DBManagement {

    protected DBType dbType;

    public DBManagement(DBType dbType){
        this.dbType = dbType;
    }

    public abstract void addData();
    public abstract void updateData();
    public abstract void deleteData();

}
