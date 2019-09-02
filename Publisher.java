// A Java program for a Client 
import java.net.*; 
import java.io.*; 
  
public class Publisher 
{ 
    // initialize socket and input output streams 
    private Socket socket            = null; 
    private DataInputStream  input   = null; 
    private DataOutputStream out     = null; 
  
    // constructor to put ip address and port 
    public Publisher(String address, int port, int port_to_connect_with_sub) 
    { 
        // establish a connection 
    	
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected on port " + port); 
  
            // takes input from terminal 
//            input  = new DataInputStream(System.in); 
  
            // sends output to the socket 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
  
        // string to read message from input 
        String line = ""; 
        try {
        	ServerSocket server = new ServerSocket(port); 
  	      	System.out.println("Publisher started listenning on port " + port_to_connect_with_sub); 
  	      	Socket socket = server.accept(); 
  	      	System.out.println("Subscriber accepted on port " + port_to_connect_with_sub);
        } catch (Exception e) {
        	
        }
    } 
  
} 
