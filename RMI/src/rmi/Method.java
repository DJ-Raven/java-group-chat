package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Method extends Remote {

    public boolean checkName(String name) throws RemoteException;
}
