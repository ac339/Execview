public class ChicagoBullsInformation {
    public int id;
    public String position;
    public int number;
    public String country;
    public String name;
    public  String height;
    public String weight;
    public String university;
    public double PPG;

    public ChicagoBullsInformation(int i,String p, int n, String c, String na,String h, String w, String u, double ppg){
        this.id=i;
        this.position=p;
        this.number=n;
        this.country=c;
        this.name=na;
        this.height=h;
        this.weight=w;
        this.university=u;
        this.PPG=ppg;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public double getPPG() {
        return PPG;
    }

    public void setPPG(double PPG) {
        this.PPG = PPG;
    }




}
