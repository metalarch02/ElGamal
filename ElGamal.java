
/*
 * Authors : David Dorneau & Jammy Jean
 * 10/21/2018
 * CIS_5371
 * El Gamal  Implementation
 */

import java.security.*;
import java.util.Scanner;
import javax.crypto.*;
public class ElGamal{


	public static void main(String[] args) throws InvalidKeyException, 
											NoSuchAlgorithmException, 
											NoSuchPaddingException, 
											IllegalBlockSizeException, 
											BadPaddingException, 
											NoSuchProviderException 
	{
		// TODO Auto-generated method stub

		int yourKeyLength;
		String yourPlainText;
		String OriginalText;
		Scanner myIn = new Scanner(System.in);
		// use this to store the cipher text created from the encryption
		byte [] yourCipherText;
		Key yourPrivateKey;

		//create encryption object
		Encryption myEncryption = new Encryption() ;

		//create decryption object
		Decryption myDecryption = new Decryption();

		//get the key size from user
		do {

			System.out.println("please enter your key size, making sure it is "
					+ "256 byte(32 characters) or 512 byte(64 characters) ");

			yourKeyLength = myIn.nextInt();

		}while(yourKeyLength != 256 && yourKeyLength != 512);

		myIn.nextLine();
		//get the plaintext from user
		System.out.println("please enter your plaintext");
		yourPlainText = myIn.nextLine();

		//set the plaintext and the key length
		myEncryption.setThePlainText(yourPlainText);
		myEncryption.setTheKeyLength(yourKeyLength);

		//perform the encryption
		//returns the private key needed to do the decryption
		yourPrivateKey = myEncryption.encryptThePlainText();

		//the cipher text
		yourCipherText = myEncryption.getTheCipherText();

		System.out.println("the resulting cipher text is: " + new String(yourCipherText));

		//do decryption and output plain text here 
		// set the the private Key
		myDecryption.setThePrivateKey(yourPrivateKey);
		
		//set the cipher text
		myDecryption.setCipherText(yourCipherText);
		
		//get decrypted text
		OriginalText = myDecryption.decryptThePlainText();
		System.out.println("the Original cipher text is: " + OriginalText);
		myIn.close();

	}

}
