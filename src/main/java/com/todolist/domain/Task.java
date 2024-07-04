package com.todolist.domain;


import com.todolist.domain.common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task extends AbstractEntity {

    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    private String category;

    @Column(name = "is_completed")
    private boolean completed;

}
