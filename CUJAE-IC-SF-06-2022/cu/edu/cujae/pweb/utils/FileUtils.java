package cu.edu.cujae.pweb.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class FileUtils {
	public static void copyFolder(File source, File destination){
	    if (source.isDirectory()) {
	        if (!destination.exists()) {
	            destination.mkdirs();
	        }

	        String files[] = source.list();

	        for (String file : files) {
	            File srcFile = new File(source, file);
	            File destFile = new File(destination, file);

	            copyFolder(srcFile, destFile);
	        }
	    }
	    else {
	        InputStream in = null;
	        OutputStream out = null;

	        try {
	            in = new FileInputStream(source);
	            out = new FileOutputStream(destination);

	            byte[] buffer = new byte[1024];

	            int length;
	            while ((length = in.read(buffer)) > 0) {
	                out.write(buffer, 0, length);
	            }
	        }
	        catch (Exception e) {
	            try {
	                in.close();
	            }
	            catch (IOException e1) {
	                e1.printStackTrace();
	            }

	            try {
	                out.close();
	            }
	            catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	}
}
