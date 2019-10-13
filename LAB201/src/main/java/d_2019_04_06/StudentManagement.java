package d_2019_04_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    protected String id;
    protected String studentName;
    protected String semester;
    protected String courseName;

    public Student() {

    }

    public Student(String id, String studentName, String semester, String courseName) {
        this.id = id.toUpperCase();
        this.studentName = studentName;
        this.semester = semester;
        this.courseName = courseName;
    }

    public String toString() {
        return id + " - " + studentName + " - " + semester + " - " + courseName;
    }
}

class Main {
    private static Scanner in = new Scanner(System.in);
    private static final String err_msg_wronginp = "[ERROR] Wrong input, try again!";
    private static List<Student> lStudents = new ArrayList<>();

    public static void main(String[] args) {
        String main_select;
        boolean isContinue;
        do {
            System.out.println("======= WELCOME TO STUDENT MANAGEMENT =======");
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            do {
                System.out.print("Your choice (1-5): ");
                main_select = in.nextLine();
                isContinue = false;
                try {
                    switch (Integer.parseInt(main_select)) {
                    case 1:
                        mainCreateStudents();
                        break;
                    case 2:
                        mainFindAndSort();
                        break;
                    case 3:
                        // addInternship();
                        break;
                    case 4:
                        // funcSearching();
                        break;
                    case 5:
                        in.close();
                        System.out.println("Exit program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println(err_msg_wronginp);
                        isContinue = true;
                    }
                } catch (NumberFormatException e) {
                    // e.printStackTrace();
                    System.out.println(err_msg_wronginp);
                    isContinue = true;
                }
            } while (isContinue);

            System.out.print("Press Enter key to continue...");
            in.nextLine();
            System.out.println();
        } while (true);
    }

    private static void mainFindAndSort() {
        List<Student> lSearch = new ArrayList<>();

        System.out.print("Enter a string to search by name: ");
        String key = in.nextLine();

        for (Student e : lStudents) {
            if (e.studentName.toUpperCase().contains(key.toUpperCase())) {
                lSearch.add(e);
            }
        }

        // Collections.sort(lStudents, new Comparator<Student>() {
        Collections.sort(lSearch, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (o1.studentName.compareTo(o2.studentName) < 0 ? -1 : 1);
            }
        });

        for (Student e : lSearch) {
            System.out.println(e.toString());
        }
    }

    private static void mainCreateStudents() {
        String id;
        String studentName;
        String semester;
        String courseName;

        int count = 0;
        String choice = "";

        System.out.println("------- Create Students -------");
        do {
            count++;
            System.out.println("[Student " + count + "]");

            System.out.print("Enter student id: ");
            id = in.nextLine();

            System.out.print("Enter student name: ");
            studentName = in.nextLine();

            System.out.print("Enter semester: ");
            semester = in.nextLine();

            System.out.print("Enter course name: ");
            courseName = in.nextLine();

            lStudents.add(new Student(id, studentName, semester, courseName));

            if (count > 2) {
                System.out.print("You have entered more than 3 students, do you want to continue? (Y/N) ");
                do {
                    choice = in.nextLine();
                    if (!(choice.toUpperCase().equals("Y") || choice.toUpperCase().equals("N"))) {
                        System.out.println("[ERROR] You must enter Y/N: ");
                    }
                } while (!(choice.toUpperCase().equals("Y") || choice.toUpperCase().equals("N")));
            }

            System.out.println("");
        } while (choice.toUpperCase().equals("Y") || count < 3);
    }
}