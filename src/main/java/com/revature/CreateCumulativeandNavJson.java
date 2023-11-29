package com.revature;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.simple.*;
import javax.json.*;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonGenerator;

public class CreateCumulativeandNavJson {

    public String getUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        System.out.println("Random UUID[1]: " + uuidStr);

        return uuidStr;
    }

    public void deleteCumulativeFileFromDirectory(String p_sUnitPath) {
        File dirName = new File(
                p_sUnitPath);
        File[] listFiles = dirName.listFiles();

        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
            } else if (listFiles[i].isDirectory()) {
                File subDirName = new File(listFiles[i].getAbsolutePath());
                File[] subdirlistFiles = subDirName.listFiles();
                for (int j = 0; j < subdirlistFiles.length; j++) {
                    if (subdirlistFiles[j].isFile()) {
                    } else if (subdirlistFiles[j].isDirectory()) {
                        File childDirName = new File(subdirlistFiles[j].getAbsolutePath());
                        File[] childdirlistFiles = childDirName.listFiles();
                        for (int k = 0; k < childdirlistFiles.length; k++) {
                            if (childdirlistFiles[k].isFile()) {
                                if (childdirlistFiles[k].getName().equals("Cumulative.md")) {
                                    childdirlistFiles[k].delete();
                                }
                            } else if (childdirlistFiles[k].isDirectory()) {
                                //System.out.println("child Directory: " + childdirlistFiles[k].getName());
                                // System.out.println("child Path: " + childdirlistFiles[k].getAbsolutePath());

                            }
                        }
                    }
                }
            }
        }
    }


    public void CreateNavigationJsonfromRootDirectory(String p_sUnitPath,String p_sUnitName) {

        File dirName = new File(
                p_sUnitPath);
        File[] listFiles = dirName.listFiles();
        StringBuffer sb_example=new StringBuffer("");
        List l_sbmodules=new ArrayList();
        List l_sbtopics=new ArrayList();
        List l_sbtopicnames=new ArrayList();

        sb_example.append(" generator.writeStartObject() \n ");
        sb_example.append("  .write(\"id\", getUUID()) \n ");
        sb_example.append(".write(\"title\", \"Next-Gen Foundation "+p_sUnitName+"\") \n ");
        sb_example.append(".write(\"description\", \" "+p_sUnitName +"\") \n ");
        sb_example.append(".writeStartObject(\"prerequisites\") \n ");
        sb_example.append(".write(\"url\", \"README\") \n ");
        sb_example.append(".write(\"title\", \"Prerequisites and Learning Objectives\") \n ");
        sb_example.append(".write(\"tooltip\", \"Prerequisites and Learning Objectives\") \n ");
        sb_example.append(".writeEnd() \n ");
        sb_example.append(".writeStartObject(\"studyGuide\")\n");
        sb_example.append(".write(\"url\", \"study-guide\") \n");
        sb_example.append(".write(\"title\", \"study-guide\") \n");
        sb_example.append(".write(\"tooltip\", \"study-guide\") \n");
        sb_example.append(".writeEnd() \n");
        sb_example.append(".writeStartArray(\"modules\") \n");

        sb_example.append("");


        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                //System.out.println("File: " + listFiles[i].getName());
            } else if (listFiles[i].isDirectory()) {
                //System.out.println("Directory: " + listFiles[i].getName());
                l_sbmodules.add(listFiles[i].getName().toString().substring(4));

                sb_example.append(".writeStartObject() \n");
                sb_example.append(".write(\"id\", getUUID()) \n");
                sb_example.append(".write(\"title\", \""+listFiles[i].getName().toString().substring(4)+"\") \n");
                sb_example.append(".write(\"url\", \"modules/"+listFiles[i].getName().toString().substring(4)+"\") \n");
                sb_example.append(".write(\"description\",\" "+listFiles[i].getName().toString().substring(4)+"\") \n");
                sb_example.append(".write(\"tooltip\",\" "+listFiles[i].getName().toString().substring(4)+"\") \n");
                sb_example.append(".writeStartObject(\"prerequisites\") \n");
                sb_example.append(".write(\"url\", \"README\") \n");
                sb_example.append(".write(\"title\", \"Prerequisites and Learning Objectives\") \n");
                sb_example.append(".write(\"tooltip\", \"Prerequisites and Learning Objectives\") \n");
                sb_example.append(".writeEnd()\n");


                // System.out.println("Path: " + listFiles[i].getAbsolutePath());
                File subDirName = new File(listFiles[i].getAbsolutePath());
                File[] subdirlistFiles = subDirName.listFiles();
                sb_example.append(".writeStartArray(\"topics\") \n");
                for (int j = 0; j < subdirlistFiles.length; j++) {
                    if (subdirlistFiles[j].isFile()) {
                        //System.out.println("sub dir File: " + subdirlistFiles[j].getName());
                    } else if (subdirlistFiles[j].isDirectory()) {
                        //System.out.println("Sub Directory: " + subdirlistFiles[j].getName());
                        // System.out.println("Sub Path: " + subdirlistFiles[j].getAbsolutePath());
                        File childDirName = new File(subdirlistFiles[j].getAbsolutePath());
                        l_sbtopicnames.add(childDirName.getName().substring(4));

                        sb_example.append(".writeStartObject() \n");
                        sb_example.append(".write(\"id\", getUUID())\n");
                        sb_example.append(".write(\"url\", \"modules/"+listFiles[i].getName().toString()+"/"+childDirName.getName().toString()+"/Cumulative.md\") \n");
                        //sb_example.append(".write(\"title\",\" "+childDirName.getName().toString().substring(4)+"\") \n");
                        sb_example.append(".write(\"title\",\" "+toCamelCase(childDirName.getName().toString().substring(4))+"\") \n");

                        sb_example.append(".write(\"tooltip\",\" "+childDirName.getName().toString().substring(4)+"\") \n");
                        sb_example.append(".writeEnd() \n");


                        File[] childdirlistFiles = childDirName.listFiles();
                        for (int k = 0; k < childdirlistFiles.length; k++) {
                            if (childdirlistFiles[k].isFile()) {
                                //System.out.println("child File: " + childdirlistFiles[k].getName());
                                if (childdirlistFiles[k].getName().equals("Cumulative.md")) {

                                    l_sbtopics.add(childdirlistFiles[k].getPath());
                                }
                            } else if (childdirlistFiles[k].isDirectory()) {
                                //System.out.println("child Directory: " + childdirlistFiles[k].getName());
                                // System.out.println("child Path: " + childdirlistFiles[k].getAbsolutePath());

                            }
                        }
                    }
                }sb_example.append(".writeEnd() \n");
                sb_example.append(".writeEnd() \n");
            }
        }

        //System.out.println(l_sbmodules+"----"+l_sbtopics);
        //System.out.println(l_sbtopicnames);
        sb_example.append(".writeEnd() \n");
        //sb_example.append(".writeEnd()\n");
        sb_example.append(".writeEnd(); \n");
        sb_example.append(" generator.close(); \n");
        System.out.println(sb_example.toString());


    }

    public void createCumulativeFileinTopicsFolder(String p_sUnitPath) throws Exception {
        File dirName = new File(
                p_sUnitPath);
        File[] listFiles = dirName.listFiles();

        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                //System.out.println("File: " + listFiles[i].getName());
            } else if (listFiles[i].isDirectory()) {
                //System.out.println("Directory: " + listFiles[i].getName());
                // System.out.println("Path: " + listFiles[i].getAbsolutePath());
                File subDirName = new File(listFiles[i].getAbsolutePath());
                File[] subdirlistFiles = subDirName.listFiles();
                for (int j = 0; j < subdirlistFiles.length; j++) {
                    if (subdirlistFiles[j].isFile()) {
                        //System.out.println("sub dir File: " + subdirlistFiles[j].getName());
                    } else if (subdirlistFiles[j].isDirectory()) {
                        //System.out.println("Sub Directory: " + subdirlistFiles[j].getName());
                        // System.out.println("Sub Path: " + subdirlistFiles[j].getAbsolutePath());
                        File childDirName = new File(subdirlistFiles[j].getAbsolutePath());
                        File[] childdirlistFiles = childDirName.listFiles();
                        String getchilddirpath = childDirName.getCanonicalPath();
                        // String getchildirpath=childDirName.getAbsolutePath();
                        File lobjnewCumulativefile = new File(getchilddirpath + "\\" + "Cumulative.md");
                        lobjnewCumulativefile.createNewFile();
                        FileOutputStream l_objCumulative = new FileOutputStream(
                                getchilddirpath + "\\" + "Cumulative.md", true); // true for append mode
                        String l_sHeading = subdirlistFiles[j].getName();
                        l_sHeading = l_sHeading.replace("-", " ").substring(3);
                        // System.out.println(l_sHeading);
                        writeContentinFile("# Cumulative for the " + l_sHeading, l_objCumulative);
                        for (int k = 0; k < childdirlistFiles.length; k++) {
                            if (childdirlistFiles[k].isFile()) {
                                // System.out.println("child File: " + childdirlistFiles[k].getName());
                                if (childdirlistFiles[k].getName()
                                        .equals("001-Prerequisites-and-Learning-Objectives.md")||childdirlistFiles[k].getName()
                                        .equals("001-Prerequisites-And-Learning-Objectives.md")
                                ) {
                                    writeContentinFile(
                                            "<details><summary>Prerequisites and Learning Objectives</summary>\n",
                                            l_objCumulative);
                                    readAndWriteFileContent(getchilddirpath + "\\" + childdirlistFiles[k].getName(),
                                            l_objCumulative);
                                    writeContentinFile("</details>", l_objCumulative);
                                }
                                if (childdirlistFiles[k].getName().equals("002-Description.md")) {
                                    writeContentinFile("<details><summary>Description</summary>\n", l_objCumulative);
                                    readAndWriteFileContent(getchilddirpath + "\\" + childdirlistFiles[k].getName(),
                                            l_objCumulative);
                                    writeContentinFile("</details>", l_objCumulative);

                                }
                                if (childdirlistFiles[k].getName().equals("003-Real-World-Application.md")) {
                                    writeContentinFile("<details><summary>Real World Application</summary>\n",
                                            l_objCumulative);
                                    readAndWriteFileContent(getchilddirpath + "\\" + childdirlistFiles[k].getName(),
                                            l_objCumulative);
                                    writeContentinFile("</details>", l_objCumulative);

                                }
                                if (childdirlistFiles[k].getName().equals("004-Implementation.md")) {
                                    writeContentinFile("<details><summary>Implementation</summary> \n", l_objCumulative);
                                    readAndWriteFileContent(getchilddirpath + "\\" + childdirlistFiles[k].getName(),
                                            l_objCumulative);
                                    writeContentinFile("</details>", l_objCumulative);

                                }
                                if (childdirlistFiles[k].getName().equals("005-Summary.md")) {
                                    writeContentinFile("<details><summary>Summary</summary> \n", l_objCumulative);
                                    readAndWriteFileContent(getchilddirpath + "\\" + childdirlistFiles[k].getName(),
                                            l_objCumulative);
                                    writeContentinFile("</details>", l_objCumulative);

                                }
                                if (childdirlistFiles[k].getName().equals("Quiz.gift")) {

                                    writeContentinFile("<details><summary>Practice Questions</summary>\n", l_objCumulative);

                                    writeContentinFile("[Practice Questions](./Quiz.gift)</details>", l_objCumulative);

                                    //System.out.println("[Practice Questions](./Quiz.gift)");
                                }
                            } else if (childdirlistFiles[k].isDirectory()) {
                                // System.out.println("child Path: " + childdirlistFiles[k].getAbsolutePath());

                            }
                        }
                        l_objCumulative.close();

                    }
                }
            }
        }
    }

    public void writeContentinFile(String name, FileOutputStream output) {

        try {

            String str = name + "\n";
            byte[] b = str.getBytes(); // converts string into bytes
            output.write(b); // writes bytes into file
            // output.write("\n");

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void readAndWriteFileContent(String fname, FileOutputStream output) {

        String line = null;
        try {
            FileReader fileReader = new FileReader(fname);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                writeContentinFile(line, output);
            }

            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("\nError occurred");
            System.out.println("Exception Name: " + ex);
        }
    }


    public static void main(String arg[]) {

        ///The-Modern-Microsoft-Workplace
        String l_spath="C:\\Users\\CarolynRehm\\Documents\\Content\\The-Modern-Microsoft-Workplace\\modules";
        String l_sUnitName="The-Modern-Microsoft-Workplace";

        CreateCumulativeandNavJson l_objCreateNavigation = new CreateCumulativeandNavJson();

        try {
            l_objCreateNavigation.deleteCumulativeFileFromDirectory(l_spath);
            l_objCreateNavigation.createCumulativeFileinTopicsFolder(l_spath);
            l_objCreateNavigation.CreateNavigationJsonfromRootDirectory(l_spath,l_sUnitName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String toCamelCase(final String init) {
        if (init == null)
            return null;

        final StringBuilder ret = new StringBuilder(init.length());

        for (final String word : init.split("-")) {
            if (!word.isEmpty()) {
                ret.append(Character.toUpperCase(word.charAt(0)));
                ret.append(word.substring(1).toLowerCase());
            }
            if (!(ret.length() == init.length()))
                ret.append(" ");
        }

        return ret.toString();
    }


}
