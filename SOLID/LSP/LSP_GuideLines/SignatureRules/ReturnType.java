package LSP.LSP_GuideLines.SignatureRules;

/*
    Return Type Rule : 
    Subtype overridden method return type should be either identical 
    or narrower than the parent method's return type.
    This is also called return type covariance.
    Java supports this out of the box. 
*/

class Animal {
    // some common Animal methods
}

class Dog extends Animal {
    // Additional Dog methods specific to Dogs.
}

class ReturnType_Parent {
    public Animal getAnimal() {
        System.out.println("Parent : Returning Animal instance");
        return new Animal();
    }
}

class ReturnType_Child extends ReturnType_Parent {
    @Override
    public Animal getAnimal() {
        System.out.println("Child : Returning Dog instance");
        return new Dog();
    }
}

class ReturnType_Client {
    private ReturnType_Parent p;

    public ReturnType_Client(ReturnType_Parent p) {
        this.p = p;
    }

    public void takeAnimal() {
        p.getAnimal();
    }
}

public class ReturnType {
    public static void main(String[] args) {
        ReturnType_Parent parent = new ReturnType_Parent();
        ReturnType_Child child   = new ReturnType_Child();

        ReturnType_Client client = new ReturnType_Client(child);
        //Client client = new Client(parent);
        client.takeAnimal();
    }
}
