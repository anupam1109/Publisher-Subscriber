import java.net.*; 
import java.io.*; 
import java.util.*; 

import java.io.*;
import java.net.*;

class Broker implements Runnable {
  int port, publisher_port = 0;
  String publisher_ip = "127.0.0.1";
  public Broker (int Port) {
	  port = Port;
  }
  public void run ()
  {
	  try { 
		  ServerSocket server = new ServerSocket(port); 
	      System.out.println("Server started on port " + port); 
	      
	      Socket socket = server.accept(); 
	      System.out.println("Client accepted on port " + port); 
	      
	      if(port == 5000) {
	    	  publisher_port = 6000;
	      }
	      
	      if (port == 5001) {
	    	 DataOutputStream out;
	    	 out = new DataOutputStream(socket.getOutputStream());
	    	 while(publisher_port == 0) {
	    		 try {
	    			 Thread.sleep(1000);
	    		 } catch (Exception e) {
	    			 
	    		 }
	    		 String line = Integer.toString(publisher_port); 
	             out.writeUTF(line); 
	    	 }
	    		 
	      }
	  } catch(IOException i) 
      { 
          System.out.println(i); 
      } 
  }
}

class Main{
	  public static void main(String[] args) throws IOException{
	    Broker broker1 = new Broker(5000);
	    System.out.println("1");
	    new Thread(broker1).start();
	    System.out.println("2"); 
	    Broker broker2 = new Broker(5001);
	    new Thread(broker2).start();
	    System.out.println("3");
	    
	    Publisher p1 = new Publisher ("127.0.0.1", 5000, 6000);
	    System.out.println("4");
	    Subscriber s1 = new Subscriber("127.0.0.1", 5001);
	    System.out.println("5");
	  }
	}
