package io.agileintelligence.ppmtool.exceptions;

public class ProjectIdExceptionResponse {

    private String identifier;

    public ProjectIdExceptionResponse(String identifier){
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
