package com.example.demo2.Check;

public class isCorrect {
    public boolean isCorrectAll(String name,String lastname,String password,String email){
        System.out.println(new emailChecker().isValid(email)+"1\n"+new nameChecker().isValid(name)+"2\n"+new nameChecker().isValid(lastname)+"3\n"+new passwordChecker().isValid(password)+"4");
        return (new emailChecker().isValid(email) && new nameChecker().isValid(name) && new nameChecker().isValid(lastname) && new passwordChecker().isValid(password));
    }
}
