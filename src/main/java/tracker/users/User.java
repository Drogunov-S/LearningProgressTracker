package tracker.users;

import tracker.databese.Database;

import java.util.Objects;

public abstract class User implements Custom {
    private static int idCreate = 1;
    private int id = 0;
    private final String firstName;
    private final String lastName;
    private final String email;


    public User(String firstName, String lastName, String email) {
        id = idCreate++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        Database.add(this);
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(email, user.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "}\n";
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}


