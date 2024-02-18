package com.example.ListTasks.model;

import jakarta.persistence.*;
import lombok.Data;

@Data                                                           // автогенерация геттеров, сеттеров, toString
@Entity                                                         // определяет сущность проекта
// @Table(name = "Tasks")                                          // явно указываем на название таблицы в БД
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)      //авто генерация ID-шника
    private Long id;
    @Column(nullable = false, length = 500)                  // поле обязательно должно быть заполнено
    private String titleTask;
    @Column(nullable = false)                                // аннотация позволяет настраивать способ сохранения и загрузки enum-значений из базы данных при использовании JPA
    private String status;
    @Column//(nullable = false)
    private String dateTimeCreateTask;


    public Task() {
    }

    public Task(String titleTask, String status, String dateTimeCreateTask) {
        this.titleTask = titleTask;
        this.status = status;
        this.dateTimeCreateTask = dateTimeCreateTask;
    }
}