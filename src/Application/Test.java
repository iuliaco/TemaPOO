package Application;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import People.*;
import Company.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Test {
    public static void main(String[] args) {
        System.out.println("Macar ti s-a frant inima cand ai teme");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Application application = Application.getInstance();
        try {
            File myObj = new File("companies.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Company company = new Company(data);
                application.add(company);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            File myObj = new File("departaments.txt");
            DepartmentsFactory factory = new DepartmentsFactory();
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (Company company: application.getCompanies()) {
                    company.add(factory.createDepartament(data));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            Reader myObj = new FileReader("consumers.json");
            JSONParser parser = new JSONParser();
            JSONObject obj;
            obj = (JSONObject) parser.parse(myObj);
            JSONArray employees = (JSONArray) obj.get("employees");
            for (int i = 0; i < employees.size(); i++) {
                JSONObject employeeJSON = (JSONObject) employees.get(i);
                JSONArray employeeEducation = (JSONArray) employeeJSON.get("education");
                JSONArray employeeExperience = (JSONArray) employeeJSON.get("experience");
                JSONArray employeeLanguages = (JSONArray) employeeJSON.get("languages");
                JSONArray employeeLanguagesLevel = (JSONArray) employeeJSON.get("languages_level");
                HashMap<String, String> languages = new HashMap<>();
                String currCompany, department;
                currCompany = null;
                department = null;
                SortedArrayListEducation educations = new SortedArrayListEducation();
                SortedArrayListExperience experiences = new SortedArrayListExperience();
                for (int j = 0; j < employeeEducation.size(); j++) {
                    JSONObject education = (JSONObject) employeeEducation.get(j);
                    LocalDate startDate = LocalDate.parse((String)education.get("start_date"), formatter);
                    LocalDate endDate = null;
                    if (education.get("end_data") != null) {
                        endDate = LocalDate.parse((String) education.get("end_data"), formatter);
                    }
                    String educationName = (String) education.get("name");
                    String educationLevel = (String) education.get("level");
                    Double grade = 10.0;
                    if(education.get("grade") instanceof Long) {
                        grade = (Double) ((Long) education.get("grade")).doubleValue();
                    } else {
                        grade = (Double) education.get("grade");
                    }
                    educations.add(new Education(startDate, endDate, educationName, educationLevel, grade));
                }
                for (int j = 0; j < employeeExperience.size(); j++) {
                    JSONObject experience = (JSONObject) employeeExperience.get(j);
                    LocalDate startDate = LocalDate.parse((String)experience.get("start_date"), formatter);
                    LocalDate endDate = null;
                    if (experience.get("end_date") != null) {
                        endDate = LocalDate.parse((String) experience.get("end_date"), formatter);
                    } else {
                        currCompany = (String) experience.get("company");
                        department = (String) experience.get("departament");
                    }
                    String experiencePosition = (String) experience.get("position");
                    String experienceCompany = (String) experience.get("company");
                    experiences.add(new Experience(startDate, endDate, experiencePosition, experienceCompany));
                }
                for (int j = 0; j < employeeLanguages.size(); j++) {
                    languages.put((String)employeeLanguages.get(j), (String)employeeLanguagesLevel.get(j));
                }
                int salary = (int) ((Long) employeeJSON.get("salary")).intValue();
                String name = (String) employeeJSON.get("name");
                String[] names = name.split(" ");
                String email = (String) employeeJSON.get("email");
                String phone = (String) employeeJSON.get("phone");
                LocalDate birthDate = LocalDate.parse((String)employeeJSON.get("date_of_birth"), formatter);
                String sex = (String) employeeJSON.get("genre");
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder().info(names[0], names[1],email,phone,birthDate,sex).languages(languages).educations(educations).experiences(experiences).build();
                Employee employee = new Employee(resume);
                employee.setCompany(currCompany);
                employee.setSalary(salary);
                application.getCompany(currCompany).add(employee, application.getCompany(currCompany).findDepartament(department));
//                System.out.println(employees);
            }
            System.out.println(employees.size());
            // final employee
            // inceput recruiter
            JSONArray rectuiters = (JSONArray) obj.get("recruiters");
            for (int i = 0; i < rectuiters.size(); i++) {
                JSONObject rectuiterJSON = (JSONObject) rectuiters.get(i);
                JSONArray rectuiterEducation = (JSONArray) rectuiterJSON.get("education");
                JSONArray rectuiterExperience = (JSONArray) rectuiterJSON.get("experience");
                JSONArray rectuiterLanguages = (JSONArray) rectuiterJSON.get("languages");
                JSONArray rectuiterLanguagesLevel = (JSONArray) rectuiterJSON.get("languages_level");
                HashMap<String, String> languages = new HashMap<>();
                String currCompany, department;
                currCompany = null;
                department = null;
                SortedArrayListEducation educations = new SortedArrayListEducation();
                SortedArrayListExperience experiences = new SortedArrayListExperience();
                for (int j = 0; j < rectuiterEducation.size(); j++) {
                    JSONObject education = (JSONObject) rectuiterEducation.get(j);
                    LocalDate startDate = LocalDate.parse((String)education.get("start_date"), formatter);
                    LocalDate endDate = null;
                    if (education.get("end_data") != null) {
                        endDate = LocalDate.parse((String) education.get("end_data"), formatter);
                    }
                    String educationName = (String) education.get("name");
                    String educationLevel = (String) education.get("level");
                    Double grade = 10.0;
                    if(education.get("grade") instanceof Long) {
                        grade = (Double) ((Long) education.get("grade")).doubleValue();
                    } else {
                        grade = (Double) education.get("grade");
                    }
                    educations.add(new Education(startDate, endDate, educationName, educationLevel, grade));
                }
                for (int j = 0; j < rectuiterExperience.size(); j++) {
                    JSONObject experience = (JSONObject) rectuiterExperience.get(j);
                    LocalDate startDate = LocalDate.parse((String)experience.get("start_date"), formatter);
                    LocalDate endDate = null;
                    if (experience.get("end_date") != null) {
                        endDate = LocalDate.parse((String) experience.get("end_date"), formatter);
                    } else {
                        currCompany = (String) experience.get("company");
                    }
                    String experiencePosition = (String) experience.get("position");
                    String experienceCompany = (String) experience.get("company");
                    experiences.add(new Experience(startDate, endDate, experiencePosition, experienceCompany));
                }
                for (int j = 0; j < rectuiterLanguages.size(); j++) {
                    languages.put((String)rectuiterLanguages.get(j), (String)rectuiterLanguagesLevel.get(j));
                }
                int salary = (int) ((Long) rectuiterJSON.get("salary")).intValue();
                String name = (String) rectuiterJSON.get("name");
                String[] names = name.split(" ");
                String email = (String) rectuiterJSON.get("email");
                String phone = (String) rectuiterJSON.get("phone");
                LocalDate birthDate = LocalDate.parse((String)rectuiterJSON.get("date_of_birth"), formatter);
                String sex = (String) rectuiterJSON.get("genre");
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder().info(names[0], names[1], email,phone,birthDate,sex).languages(languages).educations(educations).experiences(experiences).build();
                Recruiter rectuiter = new Recruiter(resume);
                Employee employee = new Employee(resume);
                rectuiter.setCompany(currCompany);
                rectuiter.setSalary(salary);
                employee.setCompany(currCompany);
                employee.setSalary(salary);
                application.getCompany(currCompany).add(rectuiter);
                application.getCompany(currCompany).add(employee, application.getCompany(currCompany).findDepartament("IT"));
//                System.out.println(employee);

            }
            System.out.println(rectuiters.size());
            //sfarsit recruiter
            // inceput user
            JSONArray users = (JSONArray) obj.get("users");
            for (int i = 0; i < users.size(); i++) {
                JSONObject userJSON = (JSONObject) users.get(i);
                JSONArray userEducation = (JSONArray) userJSON.get("education");
                JSONArray userExperience = (JSONArray) userJSON.get("experience");
                JSONArray userLanguages = (JSONArray) userJSON.get("languages");
                JSONArray userLanguagesLevel = (JSONArray) userJSON.get("languages_level");
                HashMap<String, String> languages = new HashMap<>();
                SortedArrayListEducation educations = new SortedArrayListEducation();
                SortedArrayListExperience experiences = new SortedArrayListExperience();
                ArrayList<String> userCompanies = new ArrayList<>();
                JSONArray userCompaniesIntersted = (JSONArray) userJSON.get("interested_companies");
                for (int j = 0; j < userEducation.size(); j++) {
                    JSONObject education = (JSONObject) userEducation.get(j);
                    LocalDate startDate = LocalDate.parse((String)education.get("start_date"), formatter);
                    LocalDate endDate = null;
                    if (education.get("end_data") != null) {
                        endDate = LocalDate.parse((String) education.get("end_data"), formatter);
                    }
                    String educationName = (String) education.get("name");
                    String educationLevel = (String) education.get("level");
                    Double grade = 10.0;
                    if(education.get("grade") instanceof Long) {
                        grade = (Double) ((Long) education.get("grade")).doubleValue();
                    } else {
                        grade = (Double) education.get("grade");
                    }
                    educations.add(new Education(startDate, endDate, educationName, educationLevel, grade));
                }
                for (int j = 0; j < userExperience.size(); j++) {
                    JSONObject experience = (JSONObject) userExperience.get(j);
                    LocalDate startDate = LocalDate.parse((String)experience.get("start_date"), formatter);
                    LocalDate endDate = null;
                    if (experience.get("end_date") != null) {
                        endDate = LocalDate.parse((String) experience.get("end_date"), formatter);
                    }
                    String experiencePosition = (String) experience.get("position");
                    String experienceCompany = (String) experience.get("company");
                    experiences.add(new Experience(startDate, endDate, experiencePosition, experienceCompany));
                }
                for (int j = 0; j < userLanguages.size(); j++) {
                    languages.put((String)userLanguages.get(j), (String)userLanguagesLevel.get(j));
                }
                for (int j = 0; j < userCompaniesIntersted.size(); j++) {
                    userCompanies.add((String) userCompaniesIntersted.get(j));
                }
                String name = (String) userJSON.get("name");
                String[] names = name.split(" ");
                String email = (String) userJSON.get("email");
                String phone = (String) userJSON.get("phone");
                LocalDate birthDate = LocalDate.parse((String)userJSON.get("date_of_birth"), formatter);
                String sex = (String) userJSON.get("genre");
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder().info(names[0], names[1],email,phone,birthDate,sex).languages(languages).educations(educations).experiences(experiences).build();
                User user = new User(resume);
                user.setCompanies(userCompanies);
                application.add(user);
//                System.out.println(employee);

            }
            System.out.println(users.size());

            //final user

            //inceput manager
            JSONArray managers = (JSONArray) obj.get("managers");
            for (int i = 0; i < managers.size(); i++) {
                JSONObject managerJSON = (JSONObject) managers.get(i);
                JSONArray managerEducation = (JSONArray) managerJSON.get("education");
                JSONArray managerExperience = (JSONArray) managerJSON.get("experience");
                JSONArray managerLanguages = (JSONArray) managerJSON.get("languages");
                JSONArray managerLanguagesLevel = (JSONArray) managerJSON.get("languages_level");
                HashMap<String, String> languages = new HashMap<>();
                String currCompany;
                currCompany = null;
                SortedArrayListEducation educations = new SortedArrayListEducation();
                SortedArrayListExperience experiences = new SortedArrayListExperience();
                for (int j = 0; j < managerEducation.size(); j++) {
                    JSONObject education = (JSONObject) managerEducation.get(j);
                    LocalDate startDate = LocalDate.parse((String)education.get("start_date"), formatter);
                    LocalDate endDate = null;
                    if (education.get("end_data") != null) {
                        endDate = LocalDate.parse((String) education.get("end_data"), formatter);
                    }
                    String educationName = (String) education.get("name");
                    String educationLevel = (String) education.get("level");
                    Double grade = 10.0;
                    if(education.get("grade") instanceof Long) {
                        grade = (Double) ((Long) education.get("grade")).doubleValue();
                    } else {
                        grade = (Double) education.get("grade");
                    }
                    educations.add(new Education(startDate, endDate, educationName, educationLevel, grade));
                }
                for (int j = 0; j < managerExperience.size(); j++) {
                    JSONObject experience = (JSONObject) managerExperience.get(j);
                    LocalDate startDate = LocalDate.parse((String)experience.get("start_date"), formatter);
                    LocalDate endDate = null;
                    if (experience.get("end_date") != null) {
                        endDate = LocalDate.parse((String) experience.get("end_date"), formatter);
                    } else {
                        currCompany = (String) experience.get("company");
                    }
                    String experiencePosition = (String) experience.get("position");
                    String experienceCompany = (String) experience.get("company");
                    experiences.add(new Experience(startDate, endDate, experiencePosition, experienceCompany));
                }
                for (int j = 0; j < managerLanguages.size(); j++) {
                    languages.put((String)managerLanguages.get(j), (String)managerLanguagesLevel.get(j));
                }
                int salary = (int) ((Long) managerJSON.get("salary")).intValue();
                String name = (String) managerJSON.get("name");
                String[] names = name.split(" ");
                String email = (String) managerJSON.get("email");
                String phone = (String) managerJSON.get("phone");
                LocalDate birthDate = LocalDate.parse((String)managerJSON.get("date_of_birth"), formatter);
                String sex = (String) managerJSON.get("genre");
                Consumer.Resume resume = new Consumer.Resume.ResumeBuilder().info(names[0], names[1], email, phone, birthDate, sex).languages(languages).educations(educations).experiences(experiences).build();
                Manager manager = new Manager(resume);
                manager.setCompany(currCompany);
                manager.setSalary(salary);
                application.getCompany(currCompany).setManager(manager);
//                System.out.println(employee);

            }
            System.out.println(rectuiters.size());

            //sfarsit manager
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }catch (InvalidDatesException e) {
            e.printStackTrace();
        } catch (ResumeIncompleteException e) {
            e.printStackTrace();
        }

        try {
            File myObj = new File("jobs.txt");
            Scanner myReader = new Scanner(myObj);
            for (int i = 0; i < 4; i++) {
                String jobName = myReader.nextLine();
                String jobCompany = myReader.nextLine();
                boolean isOpen = Boolean.valueOf(myReader.nextLine());
                String[] gradConstraint = myReader.nextLine().split(" ");
                String[] experienceConstraint = myReader.nextLine().split(" ");
                String[] avgConstraint = myReader.nextLine().split(" ");
                int noPlaces = Integer.valueOf(myReader.nextLine());
                int salary = Integer.valueOf(myReader.nextLine());
                int gradMin = "null".equals(gradConstraint[0])?0: Integer.valueOf(gradConstraint[0]);
                int gradMax = "null".equals(gradConstraint[1])?0: Integer.valueOf(gradConstraint[1]);
                Constraint grad = new Constraint();
                grad.setMinGrad(gradMin);
                grad.setMaxGrad(gradMax);
                Constraint experience = new Constraint();
                int minExp = "null".equals(experienceConstraint[0])?0: Integer.valueOf(experienceConstraint[0]);
                int maxEXP = "null".equals(experienceConstraint[1])?0: Integer.valueOf(experienceConstraint[1]);
                experience.setMaxExperience(maxEXP);
                experience.setMinExperience(minExp);
                Double minGPA = "null".equals(avgConstraint[0])?0.0: Double.valueOf(avgConstraint[0]);
                Double maxGPA = "null".equals(avgConstraint[1])?0.0: Double.valueOf(avgConstraint[1]);
                Constraint avg = new Constraint();
                avg.setMinGPA(minGPA);
                avg.setMaxGPA(maxGPA);
                Job job = new Job(jobName, jobCompany, isOpen, grad, experience, avg, noPlaces, salary);
                application.getCompany(jobCompany).findDepartament("IT").add(job);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myObj = new File("friendships.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] names = data.split(" ");
                Consumer person = application.getPerson(names[0], names[1]);
                for (int i = 2; i < names.length; i=i+2) {
                    Consumer friend = application.getPerson(names[i], names[i+1]);
                    person.add(friend);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Consumer U1 = application.users.get(1);
        Consumer R4= application.getPerson("Jonie", "Phillip");
        System.out.println(R4.getDegreeInFriendship(U1));
        System.out.println(R4.getDegreeInFriendship(U1));

//        System.out.println(U1.getAcquaintances());
        for (User user: application.getUsers()) {
            System.out.println("Isi cauta job" + user.resume.getInfo().getLastName());
            for (Job job : application.getJobs(user.getCompanies())) {
                job.apply(user);
            }
        }
//        for (int i = 0; i < application.getCompany("Amazon").getJobs().size(); i++) {
//            Job job = application.getCompany("Amazon").getJobs().get(i);
//            application.getCompany("Amazon").getManager().process(job);
//        }
//        for (int i = 0; i < application.getCompany("Google").getJobs().size(); i++) {
//            Job job = application.getCompany("Google").getJobs().get(i);
//            application.getCompany("Google").getManager().process(job);
//        }

//        System.out.println(application.getCompany("Google").getManager());
//        System.out.println(application.getCompany("Google").findDepartament("IT"));
    }
}
