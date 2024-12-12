package org.sist.sistproject.member;

public enum Gender {

	    MALE("남자"),
	    FEMALE("여자");

	    private final String description;

	    Gender(String description) {
	        this.description = description;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public static Gender fromValue(String value) {
	        if ("1".equals(value)) {
	            return MALE;
	        } else if ("2".equals(value)) {
	            return FEMALE;
	        }
	        throw new IllegalArgumentException("잘못된 성별 값: " + value);
	    }
	
}//class


/*
<input type="radio" name="gender" value="1" />남자
<input type="radio" name="gender" value="2" />여자
*/

/*
Gender gender = Gender.MALE;
System.out.println("선택된 성별: " + gender.getDescription());
선택된 성별: 남자
*/



