package io.kimo.base.example.data;

import java.io.Serializable;

/**
 * Student
 */
public class Student implements Serializable {
    private String name;
    private String description;
    private String course;
    private String imageUrl;

    /**
     * Student
     *
     * @param name String
     * @param description String
     * @param imageUrl String
     * @param course String
     */
    public Student(String name, String description, String imageUrl, String course) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.course = course;
    }

    /**
     * getName
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * getCourse
     *
     * @return course
     */
    public String getCourse() {
        return course;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }
}
