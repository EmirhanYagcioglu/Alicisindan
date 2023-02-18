package Classes.Objects;

import org.postgresql.util.PSQLException;

import java.time.Instant; // Used for ID creation.
import java.sql.*; // Used for Postgresql.
import Classes.Connections.Postgresql; // Used for Postgresql.


/**
 * User class.
 * Includes every user data and every manipulation method.
 *
 * While retrieving data, you can either import a whole User object and register it as an usual object and use non-static getters.
 * I can recommend this when you are going to use multiple information about an user.
 * You can also get a value without getting an object first by using the getter with an id number.
 * I don't know if using the second method when you only need 1 single data is more efficient but it probably won't matter much.
 * Setter methods also work similarly. Using the setter methods with object will update both the database value and the local object
 * Using the setter method with id number won't update the local object, if there is one!
 *
 * The things below are done for some security.
 * Password value doesn't have a getter. Instead, there is the checkPassword method working with object or id.
 * setPassword requires multiple input values to work with, please check below before usage.
 * 
 * @author cantucer2@gmail.com
 * @version 2.0 / 14.02.2023
 */
public class User {

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Private instance variables that are stored with Postgresql.
    private String id, username, name, surname, birthdate, address, email, phone;

    /**
     * Main constructor, for first time register.
     *
     * @param password Password of the user.
     * @param username Username of the user.
     * @param name Name(s) of the user.
     * @param surname Surname of the user.
     * @param birthdate Birthdate of the user in the format of epoch time in milliseconds.
     * @param address Address of the user.
     * @param email Email of the user.
     * @param phone Phone number of the user.
     */
    public User (String password, String username, String name, String surname, String birthdate, String address, String email, String phone) throws SQLException {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.address = address;
        this.email = email;
        this.phone = phone;

        this.id = this.IDGenerator();

        // Postgresql data export.
        String sql = "INSERT INTO users VALUES ('" +
                this.id + "', '" +
                this.username + "', '" +
                this.name + "', '" +
                this.surname + "', '" +
                this.birthdate + "', '" +
                this.address + "', '" +
                this.email + "', '" +
                this.phone + "');";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);

        // TODO: password set.
    }

    /**
     * Second constructor, for object import from database.
     *
     * @param id ID number of the user.
     */
    public User (String id) throws SQLException {
        // Postgresql data import.
        String sql = "SELECT * FROM users WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            this.id = rs.getString(1);
            this.username = rs.getString(2);
            this.name = rs.getString(3);
            this.surname = rs.getString(4);
            this.birthdate = rs.getString(5);
            this.address = rs.getString(6);
            this.email = rs.getString(7);
            this.phone = rs.getString(8);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * ID Generator, uses first 2 letters of names and surnames AND current epoch time in miliseconds to create an ID.
     */
    private String IDGenerator() {
      String code_name = (name + "00").substring(0, 2);
      String code_surname = (surname + "00").substring(0, 2);
    
      String timestamp = String.valueOf(Instant.now().toEpochMilli());
    
      return code_name+timestamp+code_surname;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Getter methods for data other than passwords.

    /**
     * Object update method. Use to update / set values for an object before using non-static getter methods.
     */
    public static User getUser(String id) throws SQLException {
        return new User (id);
    }


    // Non-static getter methods. Can be used with Objects rather than IDs.
    public String getID() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getBirthdate() {
        return birthdate;
    }
    public String getAddress() {
        return address;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }


    // Static getter methods. Can be used with IDs.
    public static String getUsername(String id) throws SQLException {
        // Postgresql data import.
        String sql = "SELECT user_username FROM users WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            return rs.getString(1);
        }
        throw new RuntimeException();
    }
    public static String getName(String id) throws SQLException {
        // Postgresql data import.
        String sql = "SELECT user_name FROM users WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            return rs.getString(1);
        }
        throw new RuntimeException();
    }
    public static String getSurname(String id) throws SQLException {
        // Postgresql data import.
        String sql = "SELECT user_surname FROM users WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            return rs.getString(1);
        }
        throw new RuntimeException();
    }
    public static String getBirthdate(String id) throws SQLException {
        // Postgresql data import.
        String sql = "SELECT user_birthdate FROM users WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            return rs.getString(1);
        }
        throw new RuntimeException();
    }
    public static String getAddress(String id) throws SQLException {
        // Postgresql data import.
        String sql = "SELECT user_address FROM users WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            return rs.getString(1);
        }
        throw new RuntimeException();
    }
    public static String getEmail(String id) throws SQLException {
        // Postgresql data import.
        String sql = "SELECT user_email FROM users WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            return rs.getString(1);
        }
        throw new RuntimeException();
    }
    public static String getPhone(String id) throws SQLException {
        // Postgresql data import.
        String sql = "SELECT user_phone FROM users WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            return rs.getString(1);
        }
        throw new RuntimeException();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Setter methods for data other than passwords.

    /**
     * Object update method. Changes the old object with the information of new object.
     * Also updates the object on Postgresql.
     * Won't change the password on database, can't change the password on database.
     * This is something you most likely will never need.
     *
     * @param newData New user object.
     */
    public void updateUser(User newData) throws SQLException {
        if (!this.id.equals(newData.getID())) {
            return;
        }

        this.username = newData.username;
        this.name = newData.name;
        this.surname = newData.surname;
        this.birthdate = newData.birthdate;
        this.address = newData.address;
        this.email = newData.email;
        this.phone = newData.phone;

        // Postgresql data export.
        String sql = "INSERT INTO users VALUES ('" +
                this.id + "', '" +
                this.username + "', '" +
                this.name + "', '" +
                this.surname + "', '" +
                this.birthdate + "', '" +
                this.address + "', '" +
                this.email + "', '" +
                this.phone + "')" +
                "ON CONFLICT (user_id) DO UPDATE users SET" +
                "user_id='"+this.id+
                "', user_username='"+this.username+
                "', user_name='"+this.name+
                "', user_surname='"+this.surname+
                "', user_birthdate='"+this.birthdate+
                "', user_address='"+this.address+
                "', user_email='"+this.email+
                "', user_phone='"+this.phone+
                "'";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }


    // Non-static setter methods.
    public void setUsername(String newData) throws SQLException {
        this.username = newData;

        String sql = "UPDATE users SET user_username = '" + this.username + "' WHERE user_id='" + this.id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public void setName(String newData) throws SQLException {
        this.name = newData;

        String sql = "UPDATE users SET user_name = '" + this.name + "' WHERE user_id='" + this.id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public void setSurname(String newData) throws SQLException {
        this.surname = newData;

        String sql = "UPDATE users SET user_surname = '" + this.surname + "' WHERE user_id='" + this.id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public void setBirthdate(String newData) throws SQLException {
        this.birthdate = newData;

        String sql = "UPDATE users SET user_birthdate = '" + this.birthdate + "' WHERE user_id='" + this.id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public void setAddress(String newData) throws SQLException {
        this.address = newData;

        String sql = "UPDATE users SET user_address = '" + this.address + "' WHERE user_id='" + this.id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public void setEmail(String newData) throws SQLException {
        this.email = newData;

        String sql = "UPDATE users SET user_email = '" + this.email + "' WHERE user_id='" + this.id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public void setPhone(String newData) throws SQLException {
        this.phone = newData;

        String sql = "UPDATE users SET user_phone = '" + this.phone + "' WHERE user_id='" + this.id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }


    // Static setter methods.
    public static void setUsername(String id, String newData) throws SQLException {
        String sql = "UPDATE users SET user_username = '" + newData + "' WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public static void setName(String id, String newData) throws SQLException {
        String sql = "UPDATE users SET user_name = '" + newData + "' WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public static void setSurname(String id, String newData) throws SQLException {
        String sql = "UPDATE users SET user_surname = '" + newData + "' WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public static void setBirthdate(String id, String newData) throws SQLException {
        String sql = "UPDATE users SET user_birthdate = '" + newData + "' WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public static void setAddress(String id, String newData) throws SQLException {
        String sql = "UPDATE users SET user_address = '" + newData + "' WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public static void setEmail(String id, String newData) throws SQLException {
        String sql = "UPDATE users SET user_email = '" + newData + "' WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }
    public static void setPhone(String id, String newData) throws SQLException {
        String sql = "UPDATE users SET user_phone = '" + newData + "' WHERE user_id='" + id + "' LIMIT 1";
        Statement st = Postgresql.connect().createStatement();
        st.executeUpdate(sql);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Password methods.
    //TODO!!!





    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Existence check methods.
    // TODO

}