/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Shine
 */
public interface SinkInterface extends Remote{
    String getName() throws RemoteException;
    void notifySink(String message) throws RemoteException;
}
