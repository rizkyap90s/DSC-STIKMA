package com.example.wannacry.customlistviewadapter;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String asal;

    public Mahasiswa(String nim, String nama, String asal) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }
}
