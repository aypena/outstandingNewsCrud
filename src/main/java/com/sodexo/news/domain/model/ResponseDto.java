package com.sodexo.news.domain.model;

public class ResponseDto {

    private String  code;
    private String Description;

    public ResponseDto(  String code, String description) {

        this.code = code;
        Description = description;
    }

    public ResponseDto() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "code='" + code + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
