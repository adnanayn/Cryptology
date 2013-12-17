/**
 * 
 */
package com.internet.security;

/**
 * @author yasiradnan
 * 
 */
public class VigenereCipher {

	/**
	 * @param args
	 * @return
	 */

	private static String enCryption(String Message, String Key) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char getMessage = Message.charAt(i);
			char getKey = Key.charAt(j);
			/**
			 * Convert Character to ASCII Integer Value
			 */
			int valueOfMessage = (int) getMessage;
			int valueOfkey = (int) getKey;
			/**
			 * Encrypted Key = Character Position of the Message + Character
			 * Position of the Key % 26
			 */
			int value = ((valueOfMessage + valueOfkey) % 26) + 65;
			/**
			 * Convert ASCII code to Character
			 */
			char convertToChar = (char) value;
			j = ++j % Key.length();
			builder.append(convertToChar);
		}

		return builder.toString();
	}

	private static String deCryption(String HiddenMessage, String Key) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0, j = 0; i < HiddenMessage.length(); i++) {
			char getEncryptedMessage = HiddenMessage.charAt(i);
			char getKey = Key.charAt(j);
			/**
			 * Convert Character to ASCII Integer Value
			 */
			int valueOfEmcryptedMessage = (int) getEncryptedMessage;
			int valueOfkey = (int) getKey;
			/**
			 * Decryption Key = (Character Position of the Encrypted Message +
			 * Character Position of the Key +26 ) % 26
			 */
			int value = ((valueOfEmcryptedMessage - valueOfkey + 26) % 26) + 65;
			/**
			 * Convert ASCII code to Character
			 */
			char convertToChar = (char) value;
			j = ++j % Key.length();
			builder.append(convertToChar);

		}
		return builder.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String Message = "ATTACK";
		String Key = "CAT";
		/**
		 * Encryption
		 */
		String getEncryptedMessage = enCryption(Message, Key);
		System.out.println("Original Message:" + Message + "\n" + "Key:" + Key
				+ "\n" + "Encrypterd Message:" + getEncryptedMessage + "\n");
		/**
		 * Decryption
		 */
		String getDecryptedMessage = deCryption(getEncryptedMessage, Key);
		System.out.println("Encrypted Message:" + getEncryptedMessage + "\n"
				+ "Key:" + Key + "\n" + "Decrypterd Message:"
				+ getDecryptedMessage);

	}

}
