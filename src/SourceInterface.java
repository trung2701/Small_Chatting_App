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
public interface SourceInterface extends Remote{
    void register(NotificationSink sink) throws RemoteException;
    void sendMessage(String message) throws RemoteException;
}
