package com.g.whoscall3;

public class Person {
        private  String personId;
    private String personName;
    private String personNumberId;
    private String personGender;
    private String personage;

        public Person()
        {
         super();
        }

        public Person(String personId,String personName,String personNumberId,String personGender,String personage){
            this.personId=personId;
            this.personName=personName;
            this.personNumberId=personNumberId;
            this.personage=personage;
            this.personGender=personGender;
        }
//        public Person(String personGender,String personId,String personName,String personNumberIdString, String personage){
//        this.personId=personId;
//        this.PersonName=personName;
//        this.personNumberId=personNumberId;
//        this.personage=personage;
//        this.personGender=personGender;
//    }


    public String getPersonId() {
        return personId;
    }

    public String getPersonName() {
        return personName;
    }
    public String getPersonNumberId() {
            return personNumberId;
        }

    public String getPersonage() {
        return personage;
    }


    public String getPersonGender() {
        return personGender;
    }


}


