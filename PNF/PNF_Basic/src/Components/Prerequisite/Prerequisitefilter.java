package Components.Prerequisite;

import java.io.IOException;

import Framework.CommonFilterImpl;

public class Prerequisitefilter extends CommonFilterImpl{
	 @Override
	    public boolean specificComputationForFilter() throws IOException {
	    	int checkBlank = 4; 
	        int numOfBlank = 0;
	        int idx = 0;
	        byte[] buffer = new byte[64];
	        boolean is12345 = false;
	        boolean is23456 = false;
	        int byte_read = 0;
	        
	        while(true) {          
	        	// check "CS" on byte_read from student information
	            while(byte_read != '\n' && byte_read != -1) {
	            	byte_read = in.read();
	                if(byte_read == ' ') numOfBlank++;
	                if(byte_read != -1) buffer[idx++] = (byte)byte_read;
	                if(numOfBlank >= checkBlank && buffer[idx-1] == '5') {
	                	if (buffer[idx-2] == '4' && buffer[idx-3] == '3' && buffer[idx-4] == '2' && buffer[idx-5] == '1') {
	                		is12345 = true;
	                	}
	                }
	                if(numOfBlank >= checkBlank && buffer[idx-1] == '6') {
	                	if (buffer[idx-2] == '5' && buffer[idx-3] == '4' && buffer[idx-4] == '3' && buffer[idx-5] == '2') {
	                		is23456 = true;
	                	}
	                }
	            }      
	            if (byte_read != -1) {
	            	if(!is12345) {
	            		buffer[idx-2] = ' ';
	            		buffer[idx-1] = '1';
	            		buffer[idx++] = '2';
	            		buffer[idx++] = '3';
	            		buffer[idx++] = '4';
	            		buffer[idx++] = '5';
		            	buffer[idx++] = '\r';
		            	buffer[idx++] = '\n';
		            }
		            if(!is23456) {
		            	buffer[idx-2] = ' ';
	            		buffer[idx-1] = '2';
	            		buffer[idx++] = '3';
	            		buffer[idx++] = '4';
	            		buffer[idx++] = '5';
	            		buffer[idx++] = '6';
		            	buffer[idx++] = '\r';
		            	buffer[idx++] = '\n';
		            }
	            }
	            for(int i = 0; i<idx; i++) 
                    out.write((char)buffer[i]);
	            is12345 = false;
	            is23456 = false;
	            if (byte_read == -1) return true;
	            idx = 0;
	            numOfBlank = 0;
	            byte_read = '\0';
	        }
	    }  
}
