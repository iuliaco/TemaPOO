package Company;

import java.time.LocalDate;

public class Constraint {
    private int minGrad, maxGrad;
    private int minExperience, maxExperience;
    private Double minGPA, maxGPA;

    public int getMinGrad() {
        return minGrad;
    }

    public void setMinGrad(int minGrad) {
        this.minGrad = minGrad;
    }

    public int getMaxGrad() {
        return maxGrad;
    }

    public void setMaxGrad(int maxGrad) {
        this.maxGrad = maxGrad;
    }

    public int getMinExperience() {
        return minExperience;
    }

    public void setMinExperience(int minExperience) {
        this.minExperience = minExperience;
    }

    public int getMaxExperience() {
        return maxExperience;
    }

    public void setMaxExperience(int maxExperience) {
        this.maxExperience = maxExperience;
    }

    public Double getMinGPA() {
        return minGPA;
    }

    public void setMinGPA(Double minGPA) {
        this.minGPA = minGPA;
    }

    public Double getMaxGPA() {
        return maxGPA;
    }

    public void setMaxGPA(Double maxGPA) {
        this.maxGPA = maxGPA;
    }

    public boolean checkDate(int year) {
        System.out.println("Year " + year + " minGrad " + minGrad + "maxGrad" + maxGrad);
        if(minGrad <= year) {
            return maxGrad >= year;
        }
        return false;
    }
    public boolean checkExp(int experience) {
        System.out.println("Exp " + experience + " minExp " + minExperience + "maxExp" + maxExperience);
        if(minExperience <= experience) {
            return maxExperience >= experience;
        }
        return false;
    }

    public boolean checkGPA(Double GPA) {
        System.out.println("GPA " + GPA + " minGPA " + minGPA + "maxGPA" + maxGPA);
        if(minGPA <= GPA) {
            return maxGPA >= GPA;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Constraint{" +
                "minGrad=" + minGrad +
                ", maxGrad=" + maxGrad +
                ", minExperience=" + minExperience +
                ", maxExperience=" + maxExperience +
                ", minGPA=" + minGPA +
                ", maxGPA=" + maxGPA +
                '}';
    }
}
