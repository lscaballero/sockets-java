package socketserver;

import java.net.*;
import java.io.*;
import java.util.*;



public class Main {
    
	static ServerSocket server;
	static Socket socket;
	static int puerto =3001;
	static Scanner entrada;
	static PrintStream salida;

	

	public static void main(String[] args) throws IOException {


		ConMysql con = new ConMysql();

		try {

			server = new ServerSocket(puerto);

			socket = new Socket();

			socket = server.accept();

			System.out.println("Esperando mensaje");

			entrada = new Scanner(socket.getInputStream());

			salida = new PrintStream(socket.getOutputStream());

			salida.println("Conexion exitosa");

			
			socket.close();

		}

		catch (Exception ex) {

			System.out.println(ex.getMessage());

		}

	}



}

