package main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import db.DbNewsAgency;
import db.IDbServices;

public class Server {
	private static final int PORT = 12300;

    public static void main(String args[]) throws Exception {
        DbNewsAgency services = new DbNewsAgency();
        services.connect("jdbc:sqlserver://DESKTOP-UM6VBB8\\MSSQLSERVER01;user=oksana;password=savonik-oksana;databaseName=MOOP-db;");

        IDbServices stub = (IDbServices) UnicastRemoteObject.exportObject(services, 0);

        Registry registry = LocateRegistry.createRegistry(PORT);

        registry.bind("IServices", stub);

        System.err.println("Server ready");
    }
}
