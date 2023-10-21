public class Neo4J extends DBManagement{

    public Neo4J(DBType dbType) {
        super(dbType);
    }

    @Override
    public void addData() {
        System.out.println("Adding data to the database");
        dbType.useDB();
    }

    @Override
    public void updateData() {
        System.out.println("Updating database data");
        dbType.useDB();
    }

    @Override
    public void deleteData() {
        System.out.println("Deleting data from the database");
        dbType.useDB();
    }
}
