package com.respace.util;

public class Crypto {
	/**
	 * ?Œì¼?”í˜¸?”ì— ?°ì´??ë²„í¼ ?¬ê¸° ì§? •
	 */
	public static final int			kBufferSize			= 8192;
	public static java.security.Key	key					= null;
	public static final String		defaultkeyfileurl	= "defaultkey.key";

	/**
	 * ë¹„ë????ì„±ë©”ì†Œ??
	 * 
	 * @return void
	 * @exception java.io.IOException
	 *                ,java.security.NoSuchAlgorithmException
	 */
	public static java.io.File makekey() throws java.io.IOException,
			java.security.NoSuchAlgorithmException {
		return makekey(defaultkeyfileurl);
	}

	public static java.io.File makekey(String filename) throws java.io.IOException,
			java.security.NoSuchAlgorithmException {
		java.io.File tempfile = new java.io.File(".", filename);
		javax.crypto.KeyGenerator generator = javax.crypto.KeyGenerator.getInstance("DES");
		generator.init(new java.security.SecureRandom());
		java.security.Key key = generator.generateKey();
		java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(
				new java.io.FileOutputStream(tempfile));
		out.writeObject(key);
		out.close();
		return tempfile;
	}

	/**
	 * ì§? •??ë¹„ë??¤ë? ê°??ê³??¤ëŠ” ë©”ì„œ??
	 * 
	 * @return Key ë¹„ë????´ë˜??
	 * @exception Exception
	 */
	private static java.security.Key getKey() throws Exception {
		if (key != null) {
			return key;
		} else {
			return getKey(defaultkeyfileurl);
		}
	}

	private static java.security.Key getKey(String fileurl) throws Exception {
		if (key == null) {
			java.io.File file = new java.io.File(fileurl);
			if (!file.exists()) {
				file = makekey();
			}
			if (file.exists()) {
				java.io.ObjectInputStream in = new java.io.ObjectInputStream(
						new java.io.FileInputStream(fileurl));
				key = (java.security.Key) in.readObject();
				in.close();
			} else {
				throw new Exception("?”í˜¸?¤ê°ì²´ë? ?ì„±?????†ìŠµ?ˆë‹¤.");
			}
		}
		return key;
	}

	/**
	 * ë¬¸ì????¹­ ?”í˜¸??
	 * 
	 * @param ID
	 *            ë¹„ë????”í˜¸?”ë? ?¬ë§?˜ëŠ” ë¬¸ì??
	 * @return String ?”í˜¸?”ëœ ID
	 * @exception Exception
	 */
	public static String encrypt(String ID) throws Exception {
		if (ID == null || ID.length() == 0)
			return "";
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, getKey());
		String amalgam = ID;

		byte[] inputBytes1 = amalgam.getBytes("UTF8");
		byte[] outputBytes1 = cipher.doFinal(inputBytes1);
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		String outputStr1 = encoder.encode(outputBytes1);
		return outputStr1;
	}

	/**
	 * ë¬¸ì????¹­ ë³µí˜¸??
	 * 
	 * @param codedID
	 *            ë¹„ë???ë³µí˜¸?”ë? ?¬ë§?˜ëŠ” ë¬¸ì??
	 * @return String ë³µí˜¸?”ëœ ID
	 * @exception Exception
	 */
	public static String decrypt(String codedID) throws Exception {
		if (codedID == null || codedID.length() == 0)
			return "";
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, getKey());
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

		byte[] inputBytes1 = decoder.decodeBuffer(codedID);
		byte[] outputBytes2 = cipher.doFinal(inputBytes1);

		String strResult = new String(outputBytes2, "UTF8");
		return strResult;
	}

	/**
	 * ?Œì¼ ??¹­ ?”í˜¸??
	 * 
	 * @param infile
	 *            ?”í˜¸?”ì„ ?¬ë§?˜ëŠ” ?Œì¼ëª?
	 * @param outfile
	 *            ?”í˜¸?”ëœ ?Œì¼ëª?
	 * @exception Exception
	 */
	public static void encryptFile(String infile, String outfile) throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, getKey());

		java.io.FileInputStream in = new java.io.FileInputStream(infile);
		java.io.FileOutputStream fileOut = new java.io.FileOutputStream(outfile);

		javax.crypto.CipherOutputStream out = new javax.crypto.CipherOutputStream(fileOut, cipher);
		byte[] buffer = new byte[kBufferSize];
		int length;
		while ((length = in.read(buffer)) != -1)
			out.write(buffer, 0, length);
		in.close();
		out.close();
	}

	/**
	 * ?Œì¼ ??¹­ ë³µí˜¸??
	 * 
	 * @param infile
	 *            ë³µí˜¸?”ì„ ?¬ë§?˜ëŠ” ?Œì¼ëª?
	 * @param outfile
	 *            ë³µí˜¸?”ëœ ?Œì¼ëª?
	 * @exception Exception
	 */
	public static void decryptFile(String infile, String outfile) throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, getKey());

		java.io.FileInputStream in = new java.io.FileInputStream(infile);
		java.io.FileOutputStream fileOut = new java.io.FileOutputStream(outfile);

		javax.crypto.CipherOutputStream out = new javax.crypto.CipherOutputStream(fileOut, cipher);
		byte[] buffer = new byte[kBufferSize];
		int length;
		while ((length = in.read(buffer)) != -1)
			out.write(buffer, 0, length);
		in.close();
		out.close();
	}

	public static void main(String[] ars) throws Exception {
		String password = "a123411112312";
		password = Crypto.encrypt(password);
		System.out.println("Encrypted : "+password);
		password = Crypto.decrypt(password);
		System.out.println("Decrypted : "+password);
		
//		
//		if (ars.length < 2) {
//			System.out
//					.println("USE : java com.crypto.Crypto [-d | -e | -fd | -fe] [text | inputfilename outputfilename]");
//			System.exit(0);
//		}
//		if (ars[0].equals("-d"))
//			System.out.println(Crypto.decrypt(ars[1]));
//
//		if (ars[0].equals("-e"))
//			System.out.println(Crypto.encrypt(ars[1]));
//
//		if (ars[0].equals("-fd"))
//			Crypto.decryptFile(ars[1], ars[2]);
//
//		if (ars[0].equals("-fe"))
//			Crypto.encryptFile(ars[1], ars[2]);

	}
}