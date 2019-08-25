package com.fyl.house.utils;

import java.io.File;

public class UploadFiles {
    private static final String Path = "e:\\imgs\\";
    private UploadFiles(){};
    public  static File UploadFile( String oldName ){
        String expname=oldName.substring(oldName.lastIndexOf("."));
        String filename=System.currentTimeMillis()+expname;
        File file=new File(Path+filename);
       return file;
    }

    public  static  String getPath(){
        return Path;
    }

}
