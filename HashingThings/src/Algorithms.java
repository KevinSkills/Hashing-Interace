import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class Algorithms {
	
	
	
	
	
	public static String getMD5(String password) {
		
		try {
			//Get the messageDigest object
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			
			//Convert to bytes
		    byte[] bytesForHash = md.digest(password.getBytes());
		    
		    //convert bytes using BigInteger and return
		    return new BigInteger(1, bytesForHash).toString(16);
		    
			
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
	    
		return null;
	}
	
	
	public static void WriteHashMapToFile(HashMap<String, String> hm) {
		String filename = "C:\\Users\\kevin\\Documents\\hashMapFile2.txt";
		try {
			FileOutputStream fStream = new FileOutputStream(filename);
			OutputStreamWriter osWriter = new OutputStreamWriter(fStream);
			
			for (String i : hm.keySet()) {
				System.out.println(i + ":" + hm.get(i) + "\n");
				osWriter.write(i + ":" + hm.get(i) + "\n");
			}
			
			osWriter.close();
			
		} catch (Exception e) {
		}
	}
	
	public static HashMap<String, String> readHashMapFromFile(){
		HashMap<String, String> hm = new HashMap<String, String>();
		String filename = "C:\\Users\\kevin\\Documents\\hashMapFile2.txt";
		try {
			FileInputStream fileInput = new FileInputStream(filename);
			DataInputStream dataInput = new DataInputStream(fileInput);
			BufferedReader input = new BufferedReader( new InputStreamReader(dataInput));
			String line;
			
			while((line = input.readLine()) != null) {
				hm.put(line.split(":")[0], line.split(":")[1]);
			}
			input.close();

		} catch (Exception e) {
			
		}
		
		return hm;
	}
	
	
	
	
	

	
	
	

}
