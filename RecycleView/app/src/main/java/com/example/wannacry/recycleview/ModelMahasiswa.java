package com.example.wannacry.recycleview;

public class ModelMahasiswa {
    private String nama;
    private String asal;
    private String jk;

    public ModelMahasiswa(String nama, String asal, String jk) {
        this.nama = nama;
        this.asal = asal;
        this.jk = jk;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public String getJk() {
        return jk;
    }
}
