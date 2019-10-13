package d_2019_03_30;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

class Candidate {
    protected String candidateId;
    protected String firstName;
    protected String lastName;
    protected int birthDate;
    protected String address;
    protected String phone;
    protected String email;
    protected int candidatetype; // 0 exp; 1: fresh; 2: intern

    public Candidate() {

    }

    public Candidate(String CandidateId, String FirstName, String LastName, int BirthDate, String Address, String Phone,
            String Email, int Candidatetype) {
        this.candidateId = CandidateId;
        this.firstName = FirstName;
        this.lastName = LastName;
        this.birthDate = BirthDate;
        this.address = Address;
        this.phone = Phone;
        this.email = Email;
        this.candidatetype = Candidatetype;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidatetype() {
        return candidatetype;
    }

    public void setCandidatetype(int candidatetype) {
        this.candidatetype = candidatetype;
    }

    public String toString() {
        return candidateId + "|" + firstName + "|" + lastName + "|" + birthDate + "|" + address + "|" + phone + "|"
                + email + "|" + candidatetype;
    }

    public String getType() {
        return "Candidate";
    }

    public String getInfo() {
        return firstName + " " + lastName + "|" + birthDate + "|" + address + "|" + phone + "|"
                + email + "|" + candidatetype;
    }
}

class Experience extends Candidate {
    int expInYear;
    String proSkill;

    public Experience() {
        super();
    }

    @Override
    public String toString() {
        return super.toString() + "|" + expInYear + "|" + proSkill;
    }

    @Override
    public String getType() {
        return "Experience";
    }
}

class Fresher extends Candidate {
    String graduationDate;
    String graduationRank;
    String Education; // University where std graduated

    public Fresher() {
        super();
    }

    @Override
    public String getType() {
        return "Fresher";
    }

    @Override
    public String toString() {
        return super.toString() + "|" + graduationDate + "|" + graduationRank + "|" + Education;
    }
}

class Intern extends Candidate {
    String majors;
    String semester;
    String universityName;

    public Intern() {
        super();
    }

    @Override
    public String getType() {
        return "Intern";
    }

    @Override
    public String toString() {
        return super.toString() + "|" + majors + "|" + semester + "|" + universityName;
    }
}

class Main {
    private static Scanner in = new Scanner(System.in);
    private static final String err_msg_wronginp = "\t[ERROR] Wrong input, try again!";
    private static List<Candidate> lstCandidates = new ArrayList<>();

    public static void main(String[] args) {
        String main_select;
        boolean isContinue;
        do {
            System.out.println("======= CANDIDATE MANAGEMENT SYSTEM =======");
            System.out.println("1. Experience");
            System.out.println("2. Fresher");
            System.out.println("3. Internship");
            System.out.println("4. Searching");
            System.out.println("5. Exit");
            do {
                System.out.print("Your choice (1-5): ");
                main_select = in.nextLine();
                isContinue = false;
                try {
                    switch (Integer.parseInt(main_select)) {
                    case 1:
                        addExperience();
                        break;
                    case 2:
                        addFresher();
                        break;
                    case 3:
                        addInternship();
                        break;
                    case 4:
                        funcSearching();
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

    private static void funcSearching() {
        System.out.println("List of candidate:");

        boolean check = false;
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate e : lstCandidates) {
            if (e.getCandidatetype() == 0) {
                System.out.println(e.firstName + " " + e.lastName);
                check = true;
            }
        }
        if (!check)
            System.out.println("Experience empty");

        check = false;
        System.out.println("===========FRESHER CANDIDATE============");
        for (Candidate e : lstCandidates) {
            if (e.getCandidatetype() == 1) {
                System.out.println(e.firstName + " " + e.lastName);
                check = true;
            }
        }
        if (!check)
            System.out.println("Fresher empty");

        check = false;
        System.out.println("===========INTERN CANDIDATE============");
        for (Candidate e : lstCandidates) {
            if (e.getCandidatetype() == 2) {
                System.out.println(e.firstName + " " + e.lastName);
                check = true;
            }
        }
        if (!check)
            System.out.println("Inter empty");

        System.out.print("\n\nInput Candidate name (First name or Last name): ");
        String name = in.nextLine();

        check = false;
        System.out.println("The candidates found:");
        for (Candidate e : lstCandidates) {
            if ((e.firstName + e.lastName).toUpperCase().contains(name.toUpperCase())) {
                System.out.println(e.getInfo());
                check = true;
            }
        }
        if (!check)
            System.out.println("Nothing!");
    }

    private static void enterBasicInfo(Candidate candidate) {
        System.out.print("Enter Candidate ID: ");
        String candidateId = in.nextLine();

        System.out.print("Enter FirstName: ");
        String firstName = in.nextLine();

        System.out.print("Enter LastName: ");
        String lastName = in.nextLine();

        int birthDate;
        do {
            birthDate = (int) Enter_num("Enter BirthDate: ", err_msg_wronginp);
            if (!(birthDate > 1900 && birthDate < Calendar.getInstance().get(Calendar.YEAR))) {
                System.out.println("\t[ERROR] Enter year from 1900 till now.");
            }
        } while (!(birthDate > 1900 && birthDate < Calendar.getInstance().get(Calendar.YEAR)));

        System.out.print("Enter Address: ");
        String address = in.nextLine();

        String phone;
        do {
            System.out.print("Enter phone number: ");
            phone = in.nextLine();
            if (phone.length() < 10 && !phone.matches("^[0][1-9]\\d{9}$|^[1-9]\\d{9}$")) {
                System.out.println("\t[ERROR] Enter phone atleast 10 number!");
            }
        } while (phone.length() < 10 && !phone.matches("^[0][1-9]\\d{9}$|^[1-9]\\d{9}$"));

        String email;
        do {
            System.out.print("Enter Email: ");
            email = in.nextLine();
            if (!isValidMail(email))
                System.out.println("\t[ERROR] Enter correct email!");
        } while (!isValidMail(email));

        candidate.setCandidateId(candidateId);
        candidate.setFirstName(firstName);
        candidate.setLastName(lastName);
        candidate.setBirthDate(birthDate);
        candidate.setAddress(address);
        candidate.setPhone(phone);
        candidate.setEmail(email);
    }

    private static void addExperience() {
        Experience candidate = new Experience();
        enterBasicInfo(candidate);
        candidate.candidatetype = 0;
        do {
            candidate.expInYear = (int) Enter_num("Enter year of Experience: ", err_msg_wronginp);
            if (!(candidate.expInYear < 101 && candidate.expInYear >= 0)) {
                System.out.println("\t[ERROR] Enter year of Experience from 0-100!");
            }
        } while (!(candidate.expInYear < 101 && candidate.expInYear >= 0));

        System.out.print("Enter Pro Skill: ");
        candidate.proSkill = in.nextLine();

        lstCandidates.add(candidate);
    }

    private static void addFresher() {
        Fresher candidate = new Fresher();
        enterBasicInfo(candidate);
        candidate.candidatetype = 1;

        System.out.print("Enter graduation date: ");
        candidate.graduationDate = in.nextLine();

        do {
            System.out.print("Enter graduation rank: ");
            candidate.graduationDate = in.nextLine();
            if (!(candidate.graduationDate.toUpperCase().equals("EXCELLENCE")
                    || candidate.graduationDate.toUpperCase().equals("GOOD")
                    || candidate.graduationDate.toUpperCase().equals("FAIR")
                    || candidate.graduationDate.equals("POOR"))) {
                System.out.println("\t[ERROR] Enter year of Experience from 0-100!");
            }
        } while (!(candidate.graduationDate.toUpperCase().equals("EXCELLENCE")
                || candidate.graduationDate.toUpperCase().equals("GOOD")
                || candidate.graduationDate.toUpperCase().equals("FAIR") || candidate.graduationDate.equals("POOR")));

        System.out.print("Enter Education: ");
        candidate.Education = in.nextLine();

        lstCandidates.add(candidate);
    }

    private static void addInternship() {
        Intern candidate = new Intern();
        enterBasicInfo(candidate);
        candidate.candidatetype = 2;

        System.out.print("Enter majors: ");
        candidate.majors = in.nextLine();

        System.out.print("Enter semester: ");
        candidate.semester = in.nextLine();

        System.out.print("Enter University Name: ");
        candidate.universityName = in.nextLine();

        lstCandidates.add(candidate);
    }

    // #region others method

    public static boolean isValidMail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    private static double Enter_num(String str_show, String err_msg) {
        String entered;
        do {
            System.out.print(str_show);
            entered = in.nextLine();
            try {
                return Double.parseDouble(entered);
            } catch (NumberFormatException e) {
                System.out.println(err_msg);
            }
        } while (true);
    }
    // #endregion
}