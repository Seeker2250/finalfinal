package org.sist.sistproject.member;

public enum Status {

    ACTIVE("회원"),
    DEACTIVE("탈퇴");

    private final String description; 


    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}