package org.sist.sistproject.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authority")
@ToString
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long authId;

    @Column(nullable = false, unique = true)
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "member_id") //member_id로 fk 생성 후 Member와 연결
    private Member member; // 권한을 소유한 사용자
}