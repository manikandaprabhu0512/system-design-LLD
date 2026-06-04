package LSP.LSP_GuideLines.SignatureRules;


// Exception Rule:
// A subclass should throw fewer or narrower exceptions 
// (but not additional or broader exceptions) than the parent.
// Java enforces this only for checked Exceptions.

/* 
└── java.lang.Exception                        // Conditions your application might want to catch
    ├── java.io.IOException                    // Checked I/O failures
    │   ├── java.io.FileNotFoundException
    │   ├── java.io.EOFException
    │   └── java.net.MalformedURLException
    ├── java.lang.ClassNotFoundException       // Checked reflect/… failures
    ├── java.lang.InterruptedException         // Checked thread interruption
    ├── java.sql.SQLException                  // Checked SQL/database errors
    ├── java.text.ParseException               // Checked parsing errors
    └── java.lang.RuntimeException             // Unchecked; subclasses may be thrown anywhere
        ├── java.lang.ArithmeticException      // e.g. divide by zero
        ├── java.lang.NullPointerException
        ├── java.lang.ArrayIndexOutOfBoundsException
        ├── java.lang.StringIndexOutOfBoundsException
        ├── java.lang.IllegalArgumentException
        │    └── java.lang.NumberFormatException
        ├── java.lang.IllegalStateException
        ├── java.lang.UnsupportedOperationException
        └── java.lang.IndexOutOfBoundsException // parent of the two “…OutOfBounds” above
*/

class Exception_Parent {
    public void getValue() throws RuntimeException {
        throw new RuntimeException("Parent error");
    }
}

// Subclass overrides getValue and throws the narrower ChildException
class Exception_Child extends Exception_Parent {
    @Override
    public void getValue() throws ArithmeticException {
        throw new ArithmeticException("Child error");
        //throw new Exception("Child error"); // This is wrong & not allowed
    }
}

// Client that invokes getValue and catches the parent exception type
class Exception_Client {
    private Exception_Parent p;

    public Exception_Client(Exception_Parent p) {
        this.p = p;
    }

    public void takeValue() {
        try {
            p.getValue();
        } catch (RuntimeException e) {
            System.out.println("RuntimeException occurred: " + e.getMessage());
        }
    }
}

public class Exception {
    public static void main(String[] args) {
        Exception_Parent parent = new Exception_Parent();
        Exception_Parent child   = new Exception_Child();

        // Client client = new Client(parent);
        Exception_Client client = new Exception_Client(child);
        
        client.takeValue();  
    }
}
