package ru.burytia.cft;


import java.io.*;

public class MergeSortFile {


    private boolean comporatorASC(String line1, String line2, DataType dataType)
    {
        if (dataType==DataType.STRING) return (line2.compareTo(line1) > 0);
        else if (dataType==DataType.INT) return (Integer.parseInt(line1) <= Integer.parseInt(line2));
        else return false;
    }

       private boolean comporatorDES(String line1, String line2, DataType dataType)
    {
        if (dataType==DataType.STRING) return (line2.compareTo(line1) > 0);
        else if (dataType==DataType.INT) return (Integer.parseInt(line1) <= Integer.parseInt(line2));
        else return false;
    }




    void margeSortFile(InputFileParametres inputFileParametres)
    {
        try {

            var inReader1 = new BufferedReader(new FileReader(inputFileParametres.getInFiles().get(0)));
            var inReader2 = new BufferedReader(new FileReader(inputFileParametres.getInFiles().get(1)));
            var outWriter = new BufferedWriter(new FileWriter(inputFileParametres.getOutFile()));

            String line1, line2;
            line1 = inReader1.readLine();
            line2 = inReader2.readLine();

            while ((line1!=null) && (line2!=null))
            {
                if (inputFileParametres.getSortDirection()==SortDirection.ASC) { comporatorASC(line1, line2, inputFileParametres.getDataType());}
                else if (inputFileParametres.getSortDirection()==SortDirection.DESC) {comporatorDES(line1,line2,inputFileParametres.getDataType());}
                else System.out.println("error");
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//    void margeSortFileAsc(String fileInWay1, String fileInWay2, String fileOutWay, int type) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        try (
//                BufferedReader reader1 = new BufferedReader(new FileReader(fileInWay1));
//                BufferedReader reader2 = new BufferedReader(new FileReader(fileInWay2));
//                BufferedWriter writer3 = new BufferedWriter(new FileWriter(fileOutWay))) {
//            String intLine1, intLine2;
//            intLine1 = reader1.readLine();
//            intLine2 = reader2.readLine();
//
//            switch (type) {
//                case 0: {
//                    while ((intLine1 != null) && (intLine2 != null))
//                        if (Integer.parseInt(intLine1) <= Integer.parseInt(intLine2)) {
//                            arrayList.add(Integer.parseInt(intLine1));
//                            writer3.write(intLine1);
//                            intLine1 = reader1.readLine();
//                        } else {
//                            arrayList.add(Integer.parseInt(intLine2));
//                            writer3.write(intLine2 );
//                            intLine2 = reader2.readLine();
//                        }
//                    while (intLine1 != null || intLine2 != null) {
//                        if (intLine1 != null) {
//                            arrayList.add(Integer.parseInt(intLine1));
//                            writer3.write(intLine1);
//                            intLine1 = reader1.readLine();
//                        }
//                        if (intLine2 != null) {
//                            arrayList.add(Integer.parseInt(intLine2));
//                            writer3.write(intLine2);
//                            intLine2 = reader2.readLine();
//                        }
//                    }
//                }
//                case 1:
//                    while ((intLine1 != null) && (intLine2 != null))
//                        if (intLine2.compareTo(intLine1) > 0) {
//                            writer3.write(intLine1);
//                            intLine1 = reader1.readLine();
//                        } else {
//                            writer3.write(intLine2 );
//                            intLine2 = reader2.readLine();
//                        }
//                    while (intLine1 != null || intLine2 != null) {
//                        if (intLine1 != null) {
//                            writer3.write(intLine1);
//                            intLine1 = reader1.readLine();
//                        }
//                        if (intLine2 != null) {
//                            writer3.write(intLine2);
//                            intLine2 = reader2.readLine();
//                        }
//                    }
//            }
//
//        } catch ( IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(arrayList);
//    }
//
//    void margeSortFileDes(String fileInWay1, String fileInWay2, String fileOutWay, int type) {
//
//        try (
//                BufferedReader file1 = new BufferedReader(new FileReader(fileInWay1));
//                BufferedReader file2 = new BufferedReader(new FileReader(fileInWay2));
//                BufferedWriter file3 = new BufferedWriter(new FileWriter(fileOutWay))) {
//            String intLine1, intLine2;
//            intLine1 = file1.readLine();
//            intLine2 = file2.readLine();
//            switch (type) {
//                case 0:
//                    while ((intLine1 != null) && (intLine2 != null))
//                        if (Integer.parseInt(intLine1) >= Integer.parseInt(intLine2)) {
//                            file3.write(intLine1 + "\n");
//                            intLine1 = file1.readLine();
//                        } else {
//                            file3.write(intLine2 + "\n");
//                            intLine2 = file2.readLine();
//                        }
//                    while (intLine1 != null || intLine2 != null) {
//                        if (intLine1 != null) {
//                            file3.write(intLine1 + "\n");
//                            intLine1 = file1.readLine();
//                        }
//                        if (intLine2 != null) {
//                            file3.write(intLine2 + "\n");
//                            intLine2 = file2.readLine();
//                        }
//                    }
//                    break;
//                case 1:
//                    while ((intLine1 != null) && (intLine2 != null))
//                        if (intLine1.compareTo(intLine2) > 0) {
//                            file3.write(intLine1 + "\n");
//                            intLine1 = file1.readLine();
//                        } else {
//                            file3.write(intLine2 + "\n");
//                            intLine2 = file2.readLine();
//                        }
//                    while (intLine1 != null || intLine2 != null) {
//                        if (intLine1 != null) {
//                            file3.write(intLine1 + "\n");
//                            intLine1 = file1.readLine();
//                        }
//                        if (intLine2 != null) {
//                            file3.write(intLine2 + "\n");
//                            intLine2 = file2.readLine();
//                        }
//                    }
//                    break;
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//        private void mergeSortTail(BufferedReader file1, BufferedReader file2, BufferedWriter file3, String intLine1, String intLine2) throws IOException {
//            while (intLine1 != null || intLine2 != null) {
//            if (intLine1 != null) {
//                arrayList.add(Integer.parseInt(intLine1));
//                file3.write(intLine1 + "\n");
//                intLine1 = file1.readLine();
//            }
//            if (intLine2 != null) {
//                arrayList.add(Integer.parseInt(intLine2));
//                file3.write(intLine2 + "\n");
//                intLine2 = file2.readLine();
//            }
//        }
//    }
}

