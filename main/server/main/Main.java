package server.main;

import server.server.Server;
import server.util.Callback;

import java.util.Scanner;

/**
 * Starting point of application.
 *
 * @author Daniel Dannewitz
 * @author Andreas Willems
 * @version 09 Dec 2015.
 */
public class Main {

	/**
	 * Entry point.
	 * Starts server and allows admin interaction.
	 *
	 * @param args not used.
     */
	public static void main(String[] args) {

		int serverPort = 9000;
		Server server = new Server();
		Callback cb = () -> System.out.println(
            "Server started, listening on port " + serverPort
        );
		server.startServer(cb);

		// Admin interaction
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("> ");
			String cmd = sc.nextLine();

			if(cmd.equalsIgnoreCase("exit")) {
				System.exit(0);
			}
		}
	}

}
