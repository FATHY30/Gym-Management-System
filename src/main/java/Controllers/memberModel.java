package Controllers;

public class memberModel {
    private int id;
    private String name;
    private long phone;
    private String joinDate;
    private String gender;
    private String membershipType;
    private int amount;
    private float height;
    private float weight;
    private int age;

    public memberModel(int id, String name, long phone, String joinDate, String gender, String membershipType, int amount, float height, float weight, int age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.joinDate = joinDate;
        this.gender = gender;
        this.membershipType = membershipType;
        this.amount = amount;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
