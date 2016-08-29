package com.si.util;

public class Crypto {
	/**
	 * ?�일?�호?�에 ?�이??버퍼 ?�기 �?��
	 */
	public static final int			kBufferSize			= 8192;
	public static java.security.Key	key					= null;
	public static final String		defaultkeyfileurl	= "defaultkey.key";

	/**
	 * 비�????�성메소??
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
	 * �?��??비�??��? �??�??�는 메서??
	 * 
	 * @return Key 비�????�래??
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
				throw new Exception("?�호?�객체�? ?�성?????�습?�다.");
			}
		}
		return key;
	}

	/**
	 * 문자????�� ?�호??
	 * 
	 * @param ID
	 *            비�????�호?��? ?�망?�는 문자??
	 * @return String ?�호?�된 ID
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
	 * 문자????�� 복호??
	 * 
	 * @param codedID
	 *            비�???복호?��? ?�망?�는 문자??
	 * @return String 복호?�된 ID
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
	 * ?�일 ??�� ?�호??
	 * 
	 * @param infile
	 *            ?�호?�을 ?�망?�는 ?�일�?
	 * @param outfile
	 *            ?�호?�된 ?�일�?
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
	 * ?�일 ??�� 복호??
	 * 
	 * @param infile
	 *            복호?�을 ?�망?�는 ?�일�?
	 * @param outfile
	 *            복호?�된 ?�일�?
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