package com.journaldev.csv.opencsv.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import com.opencsv.CSVWriter;

public class ReadCSV {
    public static void main(String... args) throws IOException{
        List<Enrollee> enrollees = readFromCSV("tester4.csv");

        Iterator<Enrollee> it = enrollees.iterator(); 
        Enrollee e = it.next();
        Enrollee en = e;
        boolean keep = false;
        boolean copied = true;

        boolean flag = false;;
        List<Enrollee> copy = new ArrayList<>();

        while(it.hasNext()){

           if(!keep)
                copy = new ArrayList<>();
                
                if(e.getInsCo().equals(en.getInsCo())){

                    copy.add(en);

                    it.remove();
                    en = it.next();
                    keep = true;

                    copied = true;
                    flag =true;
                }

                if(!flag)
                    en = it.next();
                flag = false;
        }
        saveCSV("testing.csv", copy);
        
    }

    private static void saveCSV(String filename, List<Enrollee> listEnrollee) throws IOException {

         StringWriter writer = new StringWriter();

         CSVWriter cvsWriter = new CSVWriter(new FileWriter("C:\\Users\\00ror\\Documents\\trying.csv"));
     
         List<Enrollee> enr = listEnrollee;
         List<String[]> data = toStringArray(enr);
     
         cvsWriter.writeAll(data);
         cvsWriter.close();
         System.out.println(writer);
         }

    private static List<Enrollee> readFromCSV(String fileName) {
        List<Enrollee> enrollees = new ArrayList<>();
        Path pathToFile = Paths.get("C:\\Users\\00ror\\Documents\\tester4.csv");

        try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();

            while(line != null) {
                String attr[] = line.split(",");

                Enrollee enrollee = createEnrollee(attr);

                enrollees.add(enrollee);

                line = br.readLine();
            }
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return enrollees;
    }

    private static Enrollee createEnrollee(String[] eachData) {
        String id = eachData[0];
        String firstName = eachData[1];
        String lastName = eachData[2];
        String version = eachData[3];
        String insCo = eachData[4];

        return new Enrollee(id, firstName, lastName, version, insCo);

    }  

private static List<String[]> toStringArray(List<Enrollee> enroll) {
    List<String[]> records = new ArrayList<String[]>();
    Iterator<Enrollee> it = enroll.iterator();

    while(it.hasNext()){
        Enrollee enrolls = it.next();
        records.add(new String[] { enrolls.getId(), enrolls.getFirstName(), 
                enrolls.getLastName(), enrolls.getVersion(), enrolls.getInsCo()});
    
         
        }
        return records;
}


}

class Enrollee implements Comparable<Enrollee> {
    private String id;
    private String firstName;
    private String lastName;
    private String version;
    private String insCo;

    public Enrollee(String id, String firstName, String lastName, String version, String insCo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
        this.insCo = insCo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInsCo() {
        return insCo;
    }

    public void setInsCo(String insCo) {
        this.insCo = insCo;
    }

    @Override
    public String toString() {
        return "Enrollee [id=" + id + ", First Name=" + firstName + ", Last Name=" + lastName + 
                            ", Version=" + version + ", Insurance Company=" + insCo + "]";
    }

    @Override
    public int compareTo(Enrollee o) {
        return Comparator.comparing(Enrollee::getLastName)
                            .thenComparing(Enrollee::getFirstName)
                            .compare(this, o);
    }

    
}

