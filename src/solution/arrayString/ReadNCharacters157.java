package solution.arrayString;

import library.Reader4;

public class ReadNCharacters157 extends Reader4{

	/**
	 * An array of size 4 to store date returned by read4 temporarily
	 */
	private char[] buffer = new char[4];
	
	/**
	 * Use to keep track of the offset index where the data begins in the 
	 * next read call
	 */
	private int offset = 0;
	
	/**
	 * the real buffer size that stores the real data
	 */
	private int bufSize = 0;
	
	public ReadNCharacters157() {
		// TODO Auto-generated constructor stub
	}

    /**
     * Notice the end of file
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
    	boolean eof = false;
    	int readBytes = 0;
    	char[] buffer = new char[4];
    	// while we don't reach the end of file
    	while(!eof && readBytes<n){
    		int size = read4(buffer);
    		if (size<4) eof = true;
    		int bytes = Math.min(size, n-readBytes);
//    		System.arraycopy(src, srcPos, dest, destPos, length);
    		System.arraycopy(buffer, 0, buf, readBytes, bytes);
    		readBytes += bytes;
    	}
		return readBytes;
        
    }
	
    /**
     * If read() can be called multiple times
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int readN(char[] buf, int n) {
    	int readBytes =0;
    	boolean eof = false;
    	while(!eof && readBytes<n){
    		// if bufSize>0, it means there is some data left
    		// on the last read call
    		int sz = (bufSize > 0)? bufSize : read4(buffer);
    		if (bufSize==0 && sz<4) eof = true;
    		int bytes = Math.min(sz, n-readBytes);
//    		System.arraycopy(src, srcPos, dest, destPos, length);
    		System.arraycopy(buffer, offset, buf, readBytes, bytes);
    		offset = (offset+bytes)%4;
    		bufSize = sz - bytes;
    		readBytes += bytes;
    	}
		return readBytes;
        
    }    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
