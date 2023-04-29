/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Sarah
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mavenproject6 {

    public static void main(String[] args) {
        try {
            // Scanner x = new Scanner(System.in);
            // String filename = x.nextLine();
            String filename = "Lab6/ex.arxml";
            if(args.length != 0){
                filename = args[0];
            }
            if (!(filename.endsWith(".arxml"))) {
                throw new NotValidExtension("Invalid file Extension");
            }

            File file = new File(filename);
            FileInputStream inputStream = new FileInputStream(file);
            int d;

            StringBuilder stringBuilder = new StringBuilder();
            if (file.length() == 0) {
                throw new EmptyFileException("Empty file");
            }
            while ((d = inputStream.read()) != -1) {
                stringBuilder.append((char) d);
            }
            String data = stringBuilder.toString();
            Scanner scanner = new Scanner(data);
            ArrayList<Container> containers = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("<CONTAINER")) {
                    String containerId = line.substring(line.indexOf("UUID=\"") + 6, line.indexOf("\">"));
                    String shortNameTag = scanner.nextLine();
                    String shortName = shortNameTag.substring(shortNameTag.indexOf(">") + 1, 
                            shortNameTag.indexOf("</"));
                    String longNameTag = scanner.nextLine();
                    String longName = longNameTag.substring(longNameTag.indexOf(">") + 1, longNameTag.indexOf("</"));
                    Container container = new Container();
                    container.setUUID(containerId);
                    container.setShortName(shortName);
                    container.setLongName(longName);
                    containers.add(container);
                }

            }
            Collections.sort(containers);
            String outName = filename.substring(0, filename.indexOf(".")) + "_mod.arxml"; 

            FileOutputStream outputStream = new FileOutputStream(outName);
            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputStream.write("<AUTOSAR>\n".getBytes());
            for (int i = 0; i < containers.size(); i++) {
                outputStream.write(containers.get(i).toString().getBytes());
            }
            outputStream.write("</AUTOSAR>\n".getBytes());
		 System.out.println("mod_file is now available");
        } catch (FileNotFoundException e) {
            e = new FileNotFoundException("File not Found");
            e.printStackTrace();
        } catch (IOException f) {
            f = new IOException("IO Exception");
            f.printStackTrace();
        } catch (NotValidExtension e) {
            e.printStackTrace();
        } catch (EmptyFileException e) {
            e = new EmptyFileException("This is an empty file");
            e.printStackTrace();
        }

    }
}