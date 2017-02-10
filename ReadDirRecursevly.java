//package com.xerox.xrce.biutee;
import java.util.*;
import java.io.*;

 
public final class ReadDirRecursevly {
private List<String> files=new ArrayList<String>();


   public   void readDirsAndWriteToAFile(String inputDir,String fileName) throws IOException {
    
    getFileListing(new File(inputDir));
    writeToFile(fileName);
  }
   
   private void writeToFile(String fileName) throws IOException
   {
	   BufferedWriter out = new BufferedWriter(new FileWriter(fileName));

	   int i=0;
	   for(String str:files)
	   {
		 
		 out.write("file://"+str+"\n");
		 //out.newLine();
		 System.out.println("Executing::"+i);
		   i++;
	   }
	   out.close();
   }
    

   
   private void getFileListing(
    File aStartingDir
  ) throws FileNotFoundException {
    
    File[] filesAndDirs = aStartingDir.listFiles();
     
    for(int i=0;i<filesAndDirs.length;i++) {
    	if(!filesAndDirs[i].isDirectory())
    	{
    		files.add(filesAndDirs[i].getAbsolutePath()); 
    	}
    	else
    	{
    		getFileListing(filesAndDirs[i]);
    	}
      
      
    }
     
  }
 public static void main(String[] str)
 {
	 ReadDirRecursevly r=new ReadDirRecursevly();
	 try {
		r.readDirsAndWriteToAFile("/home/div/nutch-0.9/test/","/home/div/nutch-0.9/urls/urlsMathsIR.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
} 
