package in.reqres.model;

public class Pojo {
    private String name;
    private String job;
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;

    }
    public static Pojo getpojo(String name,String job,String email,String password){
        Pojo pojo=new Pojo();
        pojo.setName(name);
        pojo.setJob(job);
        pojo.setEmail(email);
        pojo.setPassword(password);
        return pojo;

    }
}
