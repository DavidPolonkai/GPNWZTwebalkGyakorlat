package CRUD;

import storedProcedure.InParameters;
import storedProcedure.InResultSet;

public class Runner {
    public static void main(String[] args){
        Select s = new Select();
        Delete d = new Delete();
        Insert i = new Insert();
        Update u=new Update();
        

        s.getFullTable();
        System.out.println("insert:\n");
        i.InsertToTable(new Cats(10,"macskanev","jó",20,"tulajdonosnev"));
        s.getOlderThan(15);
        System.out.println("delete:\n");
        d.Delete("macskanev", "tulajdonosnev");
        s.getFullTable();
        //s.getFullTable();
        //s.getOlderThan(0);
        u.Update();
        new InResultSet().Call("Gal Dora");
        new InParameters().Call("perzsa", "Gal Dora");
    }
}
