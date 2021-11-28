package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import db.DbExamples;
import db.IDbServices;

public class Client {
	private static final int PORT = 12300;

    public static void main(String[] args) throws Exception {
        DbExamples examples = new DbExamples(getServicesInstance());
        examples.runAll();
    }

    public static IDbServices getServicesInstance() throws Exception {
        Registry registry = LocateRegistry.getRegistry(PORT);
        IDbServices stub = (IDbServices) registry.lookup("IServices");
        return stub;
    }
}
