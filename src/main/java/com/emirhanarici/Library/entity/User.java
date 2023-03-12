package com.emirhanarici.Library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Builder
@NoArgsConstructor
public class User extends BaseEntity {


}
