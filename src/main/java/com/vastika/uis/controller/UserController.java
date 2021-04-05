package com.vastika.uis.controller;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;


import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class UserController {

    public static void main(String[] args) {

        String decision = "N";
        UserService userService = new UserServiceImpl();

        do {
            String operation = JOptionPane.showInputDialog("Enter operation: save | update | delete | get | list");
            switch (operation){

                case"save":
                    User user = getUser("save");
                    int saved = userService.saveUser(user);
                    if(saved >= 1){
                        JOptionPane.showMessageDialog(null, "User info is saved in database");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case"update":
                    User updatedUser = getUser("update");
                    int updated = userService.updateUser(updatedUser);
                    if(updated >= 1){
                        JOptionPane.showMessageDialog(null, "User info is updated in database");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case"delete":
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                    int deleted = userService.deleteUser(id);
                    if(deleted >= 1){
                        JOptionPane.showMessageDialog(null, "User info is deleted from database");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error in database");
                    }
                    break;

                case"get":
                    id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
                    user = userService.getUserById(id);
                    printUserInfo(user);
                    break;

                case"list":
                    List<User> users = userService.getAllUser();
                    for (User u: users){
                        printUserInfo(u);
                    }
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Wrong selection");

            }
            decision = JOptionPane.showInputDialog("do you want to continue? Enter Y / N");
        }while(decision.equalsIgnoreCase("Y"));
        JOptionPane.showMessageDialog(null,"Bye Bye! See you later");
    }

    public static User getUser(String type){
        User user = new User();
        if (type.equals("update")){
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
            user.setId(id);
        }
        String username = JOptionPane.showInputDialog("Enter username: ");
        String password = JOptionPane.showInputDialog("Enter password: ");
        long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile no.: "));
        double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary: "));
        LocalDate dob = LocalDate.parse(JOptionPane.showInputDialog("Enter DOB: "));
        boolean active = Boolean.parseBoolean(JOptionPane.showInputDialog("Is the user active? "));

        user.setUsername(username);
        user.setPassword(password);
        user.setMobileNo(mobileNo);
        user.setDob(dob);
        user.setSalary(salary);
        user.setActive(active);

        return user;

    }

    public static void printUserInfo(User user){
        System.out.println("+++++++");
        System.out.println("USer id is: " + user.getId());
        System.out.println("Username is: " + user.getUsername());
        System.out.println("Password isL " + user.getPassword());
        System.out.println("Mobile No. is:" + user.getMobileNo());
        System.out.println("Salary is: " + user.getSalary());
        System.out.println("Date of Birth is: " + user.getDob());
        System.out.println("Is user active: " + user.isActive());
        System.out.println("+++++++");


    }
}

//CRUD  C => Create  => save
//      R => Read    => list
//      U => Update  => update
//      D => Delete  => delete

//M => Mpdel
//V => View
//C => Controller
