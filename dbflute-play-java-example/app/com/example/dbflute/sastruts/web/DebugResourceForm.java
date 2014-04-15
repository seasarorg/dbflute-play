package com.example.dbflute.sastruts.web;

public class DebugResourceForm {

    /*
     * 短い名前にしてみる
     * "resourceName"
     */
    public String p;

    /*
     * sort
     */
    public String s;

    public boolean isSort() {
        return "t".equals(s);
    }

}
