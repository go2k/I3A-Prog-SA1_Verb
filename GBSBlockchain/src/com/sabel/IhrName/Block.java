package com.sabel.IhrName;

public class Block {

    private int index;
    private long timestamp;
    private String data;
    private String prev_hash;
    private String self_hash;

    public static void main(String[] args) {
        Block block = new Block(13, 1512457369, "Start:", "0");

    }

    public Block() {

    }

    public Block(int index, long timestamp, String data, String prev_hash) {
        this.index = index;
        this.timestamp = timestamp;
        this.data = data;
        this.prev_hash = prev_hash;
        this.self_hash = hashBlock();
    }

    private String hashBlock() {
        String toHash = String.valueOf(index) + String.valueOf(timestamp) + data + prev_hash;
        return Util.hashFunction(toHash);
    }


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPrev_hash() {
        return prev_hash;
    }

    public void setPrev_hash(String prev_hash) {
        this.prev_hash = prev_hash;
    }

    public String getSelf_hash() {
        return self_hash;
    }

    public void setSelf_hash(String self_hash) {
        this.self_hash = self_hash;
    }
}
