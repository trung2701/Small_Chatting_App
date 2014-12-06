/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Shine
 */
public class NotificationSource extends UnicastRemoteObject implements SourceInterface{
    private ArrayList registered_Client = new ArrayList();
    private Registry registry;
    private SinkInterface client;
    private int port = 9999;

    public NotificationSource() throws RemoteException{
        super();
    }

    public void initServer(){
        try{
            registry = LocateRegistry.createRegistry(port);
            registry.rebind("server", this);

        }catch(RemoteException e){
            e.printStackTrace();
        }
    }

    public ArrayList getClient(){
        return registered_Client;
    }

    @Override
    public void register(NotificationSink sink){
        registered_Client.add(sink);
    }

    @Override
    public void sendMessage(String message){
        System.out.println("Server: "+message);
    }

    public static void main(String[] args) {
        try{
            NotificationSource s = new NotificationSource();
            s.initServer();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
