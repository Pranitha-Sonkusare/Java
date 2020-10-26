import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;




public class FileDates {
	
	public static void main(String[] args) throws IOException {
		int[] counts = new int[12];
		String[] months = new String[] {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec" };
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please the folder: ");
		
		String f = sc.next().strip();
		
		File inboxDir = new File(f);
		if(inboxDir.isDirectory()) {
			for (File file : inboxDir.listFiles()) {
				BasicFileAttributes s = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
				FileTime x = s.creationTime();
				String[] parts = x.toString().split("-");
				int idx = Integer.parseInt(parts[1]);
				counts[idx -1]++;
				
			}
			
			for(int i = 0 ; i < 12 ; i++) {
				System.out.println(months[i] + " " + counts[i]);
			}
			
		}
		else {
			System.out.println("Directory not found or not a directory");
		}
		
		Inner a = new Inner();
		Inner c = new Inner();
		
		a.b.c = c.b.a;

	}
	
	static class Inner {
		Nested b;
		public Inner() {
			b = new Nested();
		}
	}
	
	static class Nested {
		int c;
		int a;
	}
}
