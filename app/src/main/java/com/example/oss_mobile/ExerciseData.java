package com.example.oss_mobile;

public class ExerciseData {
    private int image;
    private String name;
    private String bodyPart;
    private String wayExercise;
    private String reps;
    private String extraExercise;
    private boolean expanded;

    public ExerciseData(int image, String name, String bodyPart, String wayExercise, String reps, String extraExercise) {
        this.image = image;
        this.name = name;
        this.bodyPart = bodyPart;
        this.wayExercise = wayExercise;
        this.reps = reps;
        this.extraExercise = extraExercise;
    }


    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public String getWayExercise() { return wayExercise; }

    public String getReps() {
        return reps;
    }

    public String getExtraExercise() {
        return extraExercise;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isExpanded() {
        return expanded;
    }
}
