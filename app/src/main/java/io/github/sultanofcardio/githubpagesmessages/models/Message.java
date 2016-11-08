package io.github.sultanofcardio.githubpagesmessages.models;

import com.orm.SugarRecord;

/**
 * @author sultanofcardio
 *
 * This class represents our only model for the application. It has
 * member variables that match the fields in our HTML form and methods
 * to access and mutate them.
 *
 * This class extends a class called SugarRecord. A SugarRecord is also
 * a model but one that is not defined in this project. It basically gives
 * us a Java representation for an entry in a database. It has convenience 
 * methods such as save, findById, delete and so on.
 *
 * We extend that class because we want our Message model to also be such a 
 * representation and have access to these methods.
 *
 * This class has been written for you
 */

public class Message extends SugarRecord {
    private String name, email, message;
    private Long id;

    public Message(){

    }

    public Message(long id, String name, String email, String message){
        setId(id);
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public Message setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Message setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Message setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
        super.setId(id);
    }
}
