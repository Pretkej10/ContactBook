package pl.imjustcoding.ContactBook;

public class Contact {
    private Integer cid;
    private String fName;
    private String lName;
    private String groupc;
    private String phone;
    private String email;
    private String address;
    private byte[] pic;
    private int uid;

    //alt + insert

    public Contact() {
    }
    
    public Contact(Integer cid, String fName, String lName, String groupc, String phone, String email, String address, byte[] pic, int uid) {
        this.cid = cid;
        this.fName = fName;
        this.lName = lName;
        this.groupc = groupc;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.pic = pic;
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getGroupc() {
        return groupc;
    }

    public void setGroupc(String groupc) {
        this.groupc = groupc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    
    
    
    
}
