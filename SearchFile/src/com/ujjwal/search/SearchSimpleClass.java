/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ujjwal.search;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Swatkats
 */
public class SearchSimpleClass {

    private final String myDir = "E:/";
    private File directory = new File(myDir);
    private long fileCount = 0;
    private long dir = 0;
    private String fileName = "Piku";
    private List<File> subDir = new LinkedList();

    private void fileSearch(File f) {
        String fn = f.getName();
        String[] fnArry = fn.split("\\.");
        if (fnArry[0].equalsIgnoreCase(fileName) || fn.equalsIgnoreCase(fileName)) {
            System.out.println("A match is found : " + f);
        }
    }

    private long fileCount() {
        File[] file = directory.listFiles();
        for (File f : file) {
            if (f.isFile()) {
                ++fileCount;
                fileSearch(f);
            } else if (f.isDirectory()) {
                ++dir;
                subDir.add(f);
            }
        }
        if (dir > 0) {
            directory = subDir.get(subDir.size() - 1);
            subDir.remove(subDir.size() - 1);
            --dir;
            fileCount();
        }
        return fileCount;
    }

    public static void main(String[] args) {
        long fileCount1 = new SearchSimpleClass().fileCount();
        System.out.println("file count : " + fileCount1);
    }
}
