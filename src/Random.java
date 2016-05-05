import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;


public class Random {
	public static void main(String[] args) {
		int n,k,ramRead=0;
		Scanner scanner = new Scanner(System.in);
		k = scanner.nextInt();
		n= scanner.nextInt();
		// define request array and cache array
		char[] request = new char[n];
		char[] cache = new char[k];
		// get requests from user
		for(int i=0;i<n;i++)
		//	request[i]=scanner.next().charAt(0);
		request[i]=(char)((int)(Math.random()*26) + 'a');
		int cacheSize=0;
		for(int i=0;i<n;i++){
			if(hit(request[i],cache) != -1){
				
			}
			else{
				ramRead++;
				if(cacheSize== cache.length){
					//do replacement policy
					int random = (int) (Math.random()*k);
					cache[random]=request[i];
				}
				else{
					cache[cacheSize]=request[i];
					cacheSize++;
				}
			}
			System.out.print(request[i]+":");
			for(int j=0;j<cacheSize;j++){
				System.out.print(" "+cache[j]);
			}
			System.out.println();
		}
		System.out.println(ramRead);
		float miss = (float)ramRead/(float)n;
		System.out.println(1-miss);
	}
	public static int hit(char req,char[] cache){
		for(int i=0;i<cache.length;i++){
			if(cache[i]==req)
				return i;
		}
		return -1;
	}
	
}
