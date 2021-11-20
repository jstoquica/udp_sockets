import java.net.*;
import java.io.*;
public class client{
	public static void main(String args[]){
		// args give message contents and server hostname
		// In this case the message and server was defined
		DatagramSocket aSocket = null;
		String messagem = "teste UDP";
		String ip = "127.0.0.1";
		try {
			aSocket = new DatagramSocket();
			byte [] m = messagem.getBytes();
			InetAddress aHost = InetAddress.getByName(ip);
			int serverPort = 6789;
			DatagramPacket request =
			new DatagramPacket(m, m.length, aHost, serverPort);
			aSocket.send(request);
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			System.out.println("Reply from server -> " + new String(reply.getData()));
		} catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		} catch (IOException e){System.out.println("IO: " + e.getMessage());
		} finally { if(aSocket != null) aSocket.close();}
	}
}

/************************************************
 * Modified from:								*
 * Coulouris, G. et al. (2011).					*
 * Distributed Systems: Concepts and Design.	*
 * 5th. USA: Addison-Wesley.					*
 ***********************************************/