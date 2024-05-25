package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            AdderImpl obj = new AdderImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // RMI port
            registry.rebind("AdderService", obj);
            System.out.println("AdderService bound in registry.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
