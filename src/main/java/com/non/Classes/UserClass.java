package com.non.Classes;

public class UserClass {
    private long id;
    private String name;
    private Integer ques;

    public UserClass(long id, String name, Integer ques) {
        this.id = id;
        this.name = name;
        this.ques = ques;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQues() {
        return ques;
    }

    public void setQues(Integer ques) {
        this.ques = ques;
    }

}
