package DIP;

// Abstraction (Interface)
interface Database {
    void save(String data);
}

// MySQL implementation (Low-level module)
class DMySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println(
            "Executing SQL Query: INSERT INTO users VALUES('" 
            + data + "');"
        );
    }
}

// MongoDB implementation (Low-level module)
class DMongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println(
            "Executing MongoDB Function: db.users.insert({name: '" 
            + data + "'})"
        );
    }
}

// High-level module (Now loosely coupled via Dependency Injection)
class DUserService {
    private final Database db;

    public DUserService(Database database) {
        this.db = database;
    }

    public void storeUser(String user) {
        db.save(user);
    }
}

public class DIP_Followed {
    public static void main(String[] args) {
        DMySQLDatabase mysql = new DMySQLDatabase();
        DMongoDBDatabase mongodb = new DMongoDBDatabase();

        DUserService service1 = new DUserService(mysql);
        service1.storeUser("Aditya");

        DUserService service2 = new DUserService(mongodb);
        service2.storeUser("Rohit");
    }
}
