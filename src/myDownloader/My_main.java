package myDownloader;

import java.io.PrintWriter;
import java.util.Scanner;
public class My_main {
	static String url;
	public static void main(String[] args) {
		String curent_dir = "\""+System.getProperty("user.dir")+"\"";
		//ArrayList<String>options = new ArrayList<>();
		String download_path = curent_dir+"\"\\downloads\"";
		Scanner input = new Scanner(System.in);
		
		//String url="https://www.youtube.com/watch?v=s34CqtrUS0A";
		//String url="youtube-dl -i -f mp4 --yes-playlist https://www.youtube.com/watch?v=7Vy8970q0Xc&list=PLwJ2VKmefmxpUJEGB1ff6yUZ5Zd7Gegn2";
		//url="https://www.youtube.com/watch?v=DL0T-luGlOw&list=PLgH5QX0i9K3p9xzYLFGdfYliIRBLVDRV5&index=2";
		//url = JOptionPane.showInputDialog(null,"Enter the url");
		System.out.print("Enter the url here:");
		url = input.nextLine();
		input.close();
		
		String optionCommand = prepareOptionCommand();
		
		
		String[] command =  
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command); 
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("cd \""+download_path+"\"");
	                stdin.println(download_path+"\\youtube-dl "+optionCommand+url);
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
	}

	private static String prepareOptionCommand() {
		String str = " ";
		if(url.indexOf("playlist?list=") != -1) return " -i -f mp4 --yes-playlist ";
		else if(url.indexOf("watch?v=") != -1){
			//url = url.split("&")[0];
			System.out.println("splitted Link:"+url.split("&")[0]);
			url = url.split("&")[0];
		}
		
		return str;
	}

}	