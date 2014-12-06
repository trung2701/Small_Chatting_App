/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.util.Date;
/**
 *
 * @author Shine
 */
public class NotificationSink implements SinkInterface, Serializable{
    private int port1 = 9999;
    private String name, message = (new Date()).toString();
    private Registry registry;
    private SourceInterface source;

    public NotificationSink(){
        super();
    }

    public void initClient(){
        Toolbox tool = new Toolbox();
        try{
            registry = LocateRegistry.getRegistry(port1);

            source = (SourceInterface) registry.lookup("server");
            while(true){
                message = tool.readStringFromCmd();
                if (message == "Quit"){
                    break;
                }
                source.sendMessage(message + " "+(new Date()).toString());
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public void notifySink(String message){
        System.out.println(message);
    }

    public static void main(String [] args){
        try{
            NotificationSink client = new NotificationSink();
            client.initClient();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
