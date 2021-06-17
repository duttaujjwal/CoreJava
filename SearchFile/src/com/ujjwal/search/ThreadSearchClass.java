/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ujjwal.search;

import java.io.File;

/**
 *
 * @author Swatkats
 */
public class ThreadSearchClass implements Runnable {

    // enter directory where you want to search
    private String fileDir = "E:/";
    private File directory = new File(fileDir);
    // enter file name you want to search
    private String fileName = "cv".toLowerCase();
    private String splitFileName[] = fileName.split("\\s+");
    private int splitFileNameLen = splitFileName.length;
    private long fileCount = 0;
    private long totMatchCount = 0;
    private long fleMatchCount = 0;
    private long dirMatchCount = 0;

    @Override
    public void run() {
        fileCountHelp();
    }

    private void fileCountHelp() {
        try {
            File[] file = new File(Thread.currentThread().getName()).listFiles();
            if (file != null) {
                for (File f : file) {
                    if (f.isFile()) {
                        ++fileCount;
                        fileSearch(f);
                    } else if (f.isDirectory()) {
                        //String[] parent1 = fileDir.split("\\/");
                        dirSearch(f);
                        Thread t = new Thread(this, f.toString());
                        t.start();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
    }

    private void fileSearch(File f) {
        String fn = f.getName();
        if (isContains(fn)) {
            ++totMatchCount;
            ++fleMatchCount;
            System.out.println("A match is found : File : " + f);
        }
    }

    private void dirSearch(File f) {
        String fn = f.getName();
        if (isContains(fn)) {
            ++totMatchCount;
            ++dirMatchCount;
            System.out.println("A match is found : Directory : " + f);
        }
    }

    public boolean isContains(String s) {
        // index
        int point = 0;
        int j = 0;

        String tempLower = s.toLowerCase();
        // split for spaces 
        String split[] = tempLower.split("\\s+");
        for (String temp : split) {

            // split for underscores
            String split2[] = temp.split("_");
            for (String temp2 : split2) {
                // split for dots
                String split3[] = temp2.split("\\.");
                for (String temp3 : split3) {
                    if (temp3.startsWith(splitFileName[j])) {
                        if (splitFileNameLen > (j + 1)) {
                            j++;
                            point++;
                        } else {
                            return true;
                        }
                    } else {
                        if (point >= 2) {
                            point = 0;
                            continue;
                        }
                        j = 0;
                        point = 0;
                    }
                }
                /*
                 * if (temp2.startsWith(splitFileName[i])) {
                 *
                 * if (splitFileNameLen > (i + 1)) { i++; } else { return true;
                 * } } else { i = 0; }
                 */
            }
            /*
             * // split for dots String split3[] = temp.split("\\."); for
             * (String temp3 : split3) { if (temp3.startsWith(splitFileName[j]))
             * { if (splitFileNameLen > (j + 1)) { j++; } else { return true; }
             * } else { j = 0; } }
             */
        }
        return false;
        /*
         * if (tempLower.contains(fileName)) { return true; } return false;
         */
    }

    private long fileCount() {
        File[] file = directory.listFiles();

        if (file != null) {
            for (File f : file) {
                if (f.isFile()) {
                    ++fileCount;
                    fileSearch(f);
                } else if (f.isDirectory()) {
                    dirSearch(f);
                    Thread t = new Thread(this, f.toString());
                    t.start();
                }
            }
        }

        int activeCount = Thread.activeCount();
        while (activeCount > 1) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            activeCount = Thread.activeCount();
        }

        return fileCount;
    }

    private void fileCountResult() {
        long fileCount1 = fileCount();
        System.out.println("Total Match Found     : " + totMatchCount);
        System.out.println("Total File Found      : " + fleMatchCount);
        System.out.println("Total Directory Found : " + dirMatchCount);
        System.out.println("Total File Searched   : " + fileCount1);
    }

    public static void main(String[] args) {
        new ThreadSearchClass().fileCountResult();
    }
}
